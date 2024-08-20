import logging
import os
import sys
import traceback
import argparse
import requests
import json
import pyodbc
from datetime import date

# Global connection variables
firm_connection = None
im_connection = None

# Get connection info from environment and create connection
def create_firm_connection():
    global firm_connection
    firm_connection = None
    
    db_instance = os.environ['FIRM_DBSERVER']
    db_name = os.environ['FIRM_DB_NAME']
    db_user = os.environ['FIRM_USERNAME']
    db_password = os.environ['FIRM_PASSWORD']

    firm_connection = pyodbc.connect(
        f"DSN={db_instance};DATABASE={db_name};UID={db_user};PWD={db_password}",
        autocommit=True
    )
    return firm_connection

def create_im_connection():
    global im_connection
    im_connection = None
    
    db_instance = os.environ['IM_DBSERVER']
    db_name = os.environ['IM_DB_NAME']
    db_user = os.environ['IM_USERNAME']
    db_password = os.environ['IM_PASSWORD']

    im_connection = pyodbc.connect(
        f"DSN={db_instance};DATABASE={db_name};UID={db_user};PWD={db_password}",
        autocommit=True
    )
    return im_connection

def execute_query(connection, query, params=None):
    cursor = connection.cursor()
    try:
        cursor.execute(query, params)
        connection.commit()
        print("Query executed successfully")
    except Exception as e:  # Catch all exceptions
        print(f"The error '{e}' occurred")

def fetch_data(connection, query, params=None):
    """Fetch data from the database."""
    cursor = connection.cursor()
    cursor.execute(query, params)  # Pass params to cursor.execute
    return cursor.fetchall()

def update_fr_rpt_asset_pgim_sector(asset_id_pgim_sector_map):
    """Update fr_rpt_asset based on the asset_id_pgim_sector_map."""
    for asset_id, pgim_sector in asset_id_pgim_sector_map.items():
        update_fr_rpt_asset_query = """
        UPDATE student
        SET pgim_sector = ?
        WHERE cusip = ?;
        """
        execute_query(firm_connection, update_fr_rpt_asset_query, (pgim_sector, asset_id))

def get_dn_security_ts_map(asof_dt):
    """Fetch asset_id and pgim_sector from dn_security_ts based on asof_dt."""
    dn_security_ts_query = """
    SELECT asset_id, pgim_sector 
    FROM teacher WITH (NOLOCK) 
    WHERE asof_dt = (
        SELECT MAX(asof_dt) 
        FROM teacher WITH (NOLOCK) 
        WHERE asof_dt <= ?
    );
    """
    teachers = fetch_data(im_connection, dn_security_ts_query, (asof_dt,))  # Pass params here
    return {teacher[0]: teacher[1] for teacher in teachers}  # Corrected dictionary comprehension

def get_fr_rpt_asset(asof_dt):
    """Fetch fr_rpt_assets based on asof_dt."""
    fr_rpt_asset_query = "SELECT cusip FROM student WHERE asof_dt = ? AND cusip = 'ZS8968829';"
    return fetch_data(firm_connection, fr_rpt_asset_query, (asof_dt,))  # Pass params here

def main():
    # Specify the asof_dt for filtering
    asof_dt = '2024-08-19'  # Adjust this date as needed

    # Get asset_id_pgim_sector_map
    asset_id_pgim_sector_map = get_dn_security_ts_map(asof_dt)

    # Get fr_rpt_asset data
    fr_rpt_asset_data = get_fr_rpt_asset(asof_dt)

    # Update fr_rpt_asset based on the asset_id_pgim_sector_map
    update_fr_rpt_asset_pgim_sector(asset_id_pgim_sector_map)

    # Fetch updated fr_rpt_asset data
    updated_assets = get_fr_rpt_asset(asof_dt)

    # Close the connections
    if im_connection:
        im_connection.close()
    if firm_connection:
        firm_connection.close()

if __name__ == "__main__":
    create_firm_connection()
    create_im_connection()
    main()
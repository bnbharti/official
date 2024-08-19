import pyodbc

# Connection details for 'im'
im_connection_string = (
    "Driver={SQL Server};"
    "Server=imga,1533;"
    "Database=DM InvMomt QA;"
    "UID=imropidq1;"
    "PWD=13r0pidq1;"
)

# Connection details for 'firm'
firm_connection_string = (
    "Driver={SQL Server};"
    "Server=firmdevdb;"
    "Database=db firmdev;"
    "UID=crptpidd1;"
    "PWD=hqm&2&CSNw%A!e9W;"
)

# Query for 'im'
im_query = """
SELECT asset_id, pgim_sector 
FROM dn_security_ts WITH (NOLOCK) 
WHERE asof_dt = (SELECT MAX(asof_dt) FROM dn_security_ts WITH (NOLOCK) WHERE asof_dt <= '2024-07-31');
"""

# Query for 'firm'
firm_query = """
SELECT cusip, pgim_sector 
FROM fr_rpt_asset 
WHERE asof_dt <= '2024-06-30';
"""

# Function to execute a query and fetch results
def fetch_data(connection_string, query):
    with pyodbc.connect(connection_string) as conn:
        cursor = conn.cursor()
        cursor.execute(query)
        return cursor.fetchall()

# Fetch data from 'im'
im_data = fetch_data(im_connection_string, im_query)

# Fetch data from 'firm'
firm_data = fetch_data(firm_connection_string, firm_query)

# Display the results
print("Data from 'im':")
for row in im_data:
    print(row)

print("\nData from 'firm':")
for row in firm_data:
    print(row)
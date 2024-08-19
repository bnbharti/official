import pyodbc

# Connection details for 'im'
im_connection_string = ( 
)

# Connection details for ' '
firm_connection_string = ( 
)

# Query for ' '
im_query =  

# Query for ' '
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
import os
import mysql.connector
from mysql.connector import Error

def fetch_student_data():
    connection = None  # Initialize connection variable
    try:
        # Get database credentials from environment variables
        host = os.getenv('DB_HOST')
        user = os.getenv('DB_USER')
        password = os.getenv('DB_PASSWORD')
        database = os.getenv('DB_NAME')
        port = os.getenv('DB_PORT')  # Get port as a string

        # Print all environment variables for debugging
        print(f"DB_HOST: {host}")
        print(f"DB_USER: {user}")
        print(f"DB_PASSWORD: {password}")
        print(f"DB_NAME: {database}")
        print(f"DB_PORT: {port}")  # Check the value of DB_PORT

        # Check if port is None and set a default or raise an error
        if port is None:
            raise ValueError("DB_PORT environment variable is not set.")

        port = int(port)  # Convert port to integer

        # Establish a connection to the MariaDB database
        connection = mysql.connector.connect(
            host=host,
            user=user,
            password=password,
            database=database,
            port=port
        )

        # Check if the connection was successful
        if connection.is_connected():
            print("Successfully connected to the database")

            # Create a cursor object
            cursor = connection.cursor()

            # Define the query to select id, name, and age from the student table
            query = "SELECT id, name, age FROM student"

            # Execute the query
            cursor.execute(query)

            # Fetch all results
            records = cursor.fetchall()

            # Print the results
            print("Students:")
            for row in records:
                print(f"ID: {row[0]}, Name: {row[1]}, Age: {row[2]}")

    except Error as e:
        print(f"Error: {e}")
    finally:
        # Close the cursor and connection if they were created
        if connection and connection.is_connected():
            cursor.close()
            connection.close()
            print("MySQL connection is closed")

# Run the function
fetch_student_data()
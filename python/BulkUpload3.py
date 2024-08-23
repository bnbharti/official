import csv
import mysql.connector
from mysql.connector import Error

# Global connection variables
imdb_connection = None
python_connection = None

def create_imdb_connection(host_name, user_name, user_password, db_name):
    """Create a connection to the IMDb database."""
    global imdb_connection
    imdb_connection = None
    try:
        imdb_connection = mysql.connector.connect(
            host=host_name,
            user=user_name,
            password=user_password,
            database=db_name
        )
        print(f"Connection to MySQL DB '{db_name}' successful")
    except Error as e:
        print(f"The error '{e}' occurred")

def create_python_connection(host_name, user_name, user_password, db_name):
    """Create a connection to the Python database."""
    global python_connection
    python_connection = None
    try:
        python_connection = mysql.connector.connect(
            host=host_name,
            user=user_name,
            password=user_password,
            database=db_name
        )
        print(f"Connection to MySQL DB '{db_name}' successful")
    except Error as e:
        print(f"The error '{e}' occurred")

def execute_query(connection, query, params=None):
    """Execute a single query with optional parameters."""
    cursor = connection.cursor()
    try:
        cursor.execute(query, params)
        connection.commit()
        return True  # Indicate success
    except Error as e:
        print(f"The error '{e}' occurred")
        return False  # Indicate failure

def fetch_data(connection, query, params=None):
    """Fetch data from the database."""
    cursor = connection.cursor()
    cursor.execute(query, params)  # Pass params to cursor.execute
    return cursor.fetchall()

def bulk_update_from_csv(file_path):
    print("bluk upload")
    """Bulk update student salaries from a CSV file using a temporary table."""
    # Create a temporary table
    create_temp_table_query = """
    CREATE TEMPORARY TABLE temp_salaries (
        id INT,
        salary DECIMAL(10, 2),
        joiningDate DATE,
        PRIMARY KEY (id, joiningDate)  -- Ensure composite primary key
    );
    """

    # Update the main student table
    update_query = """
    UPDATE student
    JOIN temp_salaries ON student.id = temp_salaries.id AND student.joiningDate = temp_salaries.joiningDate
    SET student.salary = temp_salaries.salary;
    """

    cursor = None
    try:
        cursor = imdb_connection.cursor()
        
        # Create the temporary table
        cursor.execute(create_temp_table_query)
        print("Temporary table created successfully.")

        # Read the CSV file and insert data into the temporary table
        with open(file_path, mode='r') as file:
            reader = csv.reader(file)
            records_loaded = 0
            
            # Check if the file has at least one row (header row)
            if sum(1 for row in reader) > 0:
                file.seek(0)  # Reset the file pointer to the beginning
                reader = csv.reader(file)
                next(reader)  # Skip the header row
                
                for row in reader:
                    # Prepare the insert statement
                    insert_query = """
                    INSERT INTO temp_salaries (id, salary, joiningDate)
                    VALUES (%s, %s, %s);
                    """
                    try:
                        # Execute the insert statement
                        cursor.execute(insert_query, (row[0], row[1], row[2]))
                        records_loaded += 1
                    except Error as e:
                        print(f"Error inserting row {row}: {e}")

        print(f"Total records loaded into temporary table: {records_loaded}")

        # Update the student table based on the temporary table
        cursor.execute(update_query)
        updated_rows = cursor.rowcount
        imdb_connection.commit()  # Commit the transaction
        print(f"Updated {updated_rows} student salaries successfully.")

    except FileNotFoundError:
        print(f"Error: The file '{file_path}' was not found.")
    except Error as e:
        print(f"The error '{e}' occurred during bulk update")
        imdb_connection.rollback()  # Rollback in case of error
    finally:
        if cursor:
            cursor.close()

def get_teacher_salary_map(joining_date):
    """Fetch teacher salaries and create a mapping based on joining date."""
    teachers_query = "SELECT id, salary, joiningDate FROM teacher WHERE joiningDate = %s;"
    teachers = fetch_data(python_connection, teachers_query, (joining_date,))  # Pass params here
    return teachers  # Return the entire teacher data

def get_students(joining_date):
    """Fetch students based on joining date."""
    students_query = "SELECT id FROM student WHERE joiningDate = %s;"
    return fetch_data(imdb_connection, students_query, (joining_date,))  # Pass params here
def write_teacher_data_to_csv(file_path, teacher_data):
    """Write teacher data to the CSV file."""
    with open(file_path, mode='w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['ID', 'Salary', 'Joining Date'])  # Write header
        writer.writerows(teacher_data)  # Write teacher data
    print(f"Teacher data written to {file_path} successfully.")
def main():
    # Database connection details
    host = "localhost"
    port = "3306"  # Default MySQL port

    # Connect to the 'imdb' database for student data
    username_imdb = "bharti"
    password_imdb = "bharti"
    imdb_db_name = "imdb"
    create_imdb_connection(host, username_imdb, password_imdb, imdb_db_name)

    # Connect to the 'python' database for teacher data
    username_python = "narendra"
    password_python = "narendra"
    db_name_python = "python"
    create_python_connection(host, username_python, password_python, db_name_python)

    # Specify the joining date for filtering
    joining_date = '2024-08-19'  # Adjust this date as needed

    # Get teacher salary map
    teacher_salary_map = get_teacher_salary_map(joining_date)

    # Get students
    students = get_students(joining_date)
    print("Students: ", students)

    # Path to the CSV file containing updates
    file_path = "D:/interview/file.csv"   # Adjust this path as needed
    write_teacher_data_to_csv(file_path, teacher_salary_map)
    # Perform bulk update from CSV
    bulk_update_from_csv(file_path)

    # Close the connections
    if python_connection:
        python_connection.close()
    if imdb_connection:
        imdb_connection.close()

if __name__ == "__main__":
    main()
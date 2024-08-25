import mysql.connector
from mysql.connector import Error
from contextlib import contextmanager
import time

@contextmanager
def create_connection(host_name, user_name, user_password, db_name):
    """Context manager to create and yield a database connection."""
    connection = None
    try:
        connection = mysql.connector.connect(
            host=host_name,
            user=user_name,
            password=user_password,
            database=db_name
        )
        print(f"Connection to {db_name} database successful")
        yield connection
    except Error as e:
        print(f"The error '{e}' occurred")
    finally:
        if connection:
            connection.close()
            print(f"Connection to {db_name} database closed.")

def fetch_students(connection):
    """Fetch all students from the student table."""
    cursor = connection.cursor(dictionary=True)
    cursor.execute("SELECT * FROM student")
    return cursor.fetchall()

def fetch_teachers_by_joining_date(connection, joining_date):
    """Fetch teachers based on joining date."""
    cursor = connection.cursor(dictionary=True)
    query = "SELECT id, salary FROM teacher WHERE joiningDate = %s "
    cursor.execute(query, (joining_date,))
    return cursor.fetchall()

def update_student_salary(connection, teacher_data, joining_date):
    """Update student salary based on teacher salary."""
    cursor = connection.cursor()
    
    # Prepare bulk update query
    update_query = """
    UPDATE student
    SET salary = CASE id
    {}
    END
    WHERE joiningDate = %s
    """
    
    # Create a list of when clauses for the case statement
    when_clauses = []
    student_ids = []

    # Create a mapping of teacher IDs to salaries
    for teacher in teacher_data:
        when_clauses.append(f"WHEN {teacher['id']} THEN {teacher['salary']}")
        student_ids.append(teacher['id'])
    
    # Join the when clauses into a single string
    when_clause_str = " ".join(when_clauses)

    # Check if there are any when clauses to execute
    if when_clause_str:
        # Print the constructed SQL for debugging
        print(f"Executing update with query: {update_query.format(when_clause_str)}")
        cursor.execute(update_query.format(when_clause_str), (joining_date,))
        print(f"Executed update for student IDs: {student_ids}")
    else:
        print("No matching teacher data found for update.")

    # Set salaries to NULL for students not in teacher data
    if student_ids:
        # Create a parameterized query for the NOT IN clause
        placeholders = ', '.join(['%s'] * len(student_ids))
        cursor.execute(f"""
        UPDATE student
        SET salary = NULL
        WHERE id NOT IN ({placeholders}) AND joiningDate = %s
        """, (*student_ids, joining_date))
    
    connection.commit()
    return cursor.rowcount

def display_updated_students(connection):
    """Display updated student table data."""
    updated_students = fetch_students(connection)
    print("Updated Student Table Data:")
    for row in updated_students:
        print(row)

# Connection details
host = "localhost"
port = "3307"

# Specify the joining date for filtering teachers
joining_date = '2024-08-19'  # Example date, change as needed

start_time = time.time()

# Connect to the 'python' database for teacher data
with create_connection(host, "narendra", "narendra", "python") as connection_python:
    if connection_python:
        # Fetch teacher data based on joining date
        teacher_data = fetch_teachers_by_joining_date(connection_python, joining_date)
        print(f"Teacher data: {teacher_data}")

        # Connect to the 'imdb' database for student data
        with create_connection(host, "bharti", "bharti", "imdb") as connection_imdb:
            # Update student salaries based on fetched teacher data
            if teacher_data:
                updated_rows = update_student_salary(connection_imdb, teacher_data, joining_date)
                print(f"Updated salaries for {updated_rows} students.")
                
                # Display updated student table data
                display_updated_students(connection_imdb)
            else:
                print("No teacher data found for the specified joining date.")

end_time = time.time()
total_time = end_time - start_time
print(f"Total time: {total_time:.2f} seconds")
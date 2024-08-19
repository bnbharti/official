import mysql.connector
from mysql.connector import Error

def create_connection(host_name, user_name, user_password, db_name):
    """Create a database connection."""
    connection = None
    try:
        connection = mysql.connector.connect(
            host=host_name,
            user=user_name,
            password=user_password,
            database=db_name
        )
        print(f"Connection to MySQL DB '{db_name}' successful")
    except Error as e:
        print(f"The error '{e}' occurred")
    return connection

def execute_query(connection, query, params=None):
    """Execute a single query with optional parameters."""
    cursor = connection.cursor()
    try:
        cursor.execute(query, params)
        connection.commit()
        print("Query executed successfully")
    except Error as e:
        print(f"The error '{e}' occurred")

def fetch_data(connection, query):
    """Fetch data from the database."""
    cursor = connection.cursor()
    cursor.execute(query)
    return cursor.fetchall()

def update_student_salaries(imdb_connection, teacher_salary_map):
    """Update student salaries based on the teacher salary map."""
    for student_id in teacher_salary_map.keys():
        new_salary = teacher_salary_map.get(student_id, None)  # Get salary or None if not found
        update_salary_query = """
        UPDATE student
        SET salary = %s
        WHERE id = %s;
        """
        execute_query(imdb_connection, update_salary_query, (new_salary, student_id))

# Database connection details
host = "localhost"
port = "3307"

# Connect to the 'phython' database for teacher data
username_python = "narendra"
password_python = "narendra"
db_name_python = "python"

connection_python = create_connection(host, username_python, password_python, db_name_python)

# Connect to the 'imdb' database for student data
username_imdb = "bharti"
password_imdb = "bharti"
imdb_db_name = "imdb"

imdb_connection = create_connection(host, username_imdb, password_imdb, imdb_db_name)

# Fetch and display data from teacher table
print("\nTeacher Table Data:")
teachers_query = "SELECT * FROM teacher;"
teachers = fetch_data(connection_python, teachers_query)

# Create a mapping from teacher ID to salary
teacher_salary_map = {teacher[0]: teacher[2] for teacher in teachers}  # Assuming teacher[0] is ID and teacher[2] is salary

# Fetch and display data from student table
print("\nStudent Table Data:")
students_query = "SELECT * FROM student;"
students = fetch_data(imdb_connection, students_query)
for student in students:
    print(student)

# Update student salaries based on the teacher salary map
update_student_salaries(imdb_connection, teacher_salary_map)

# Fetch and display updated student table data
print("\nUpdated Student Table Data:")
students_updated = fetch_data(imdb_connection, students_query)
for student in students_updated:
    print(student)

# Close the connections
if connection_python:
    connection_python.close()
if imdb_connection:
    imdb_connection.close()
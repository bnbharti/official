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
        print("Query executed successfully")
    except Error as e:
        print(f"The error '{e}' occurred")

def fetch_data(connection, query, params=None):
    """Fetch data from the database."""
    cursor = connection.cursor()
    cursor.execute(query, params)  # Pass params to cursor.execute
    return cursor.fetchall()

def update_student_salaries(teacher_salary_map):
    """Update student salaries based on the teacher salary map."""
    for student_id, new_salary in teacher_salary_map.items():
        update_salary_query = """
        UPDATE student
        SET salary = %s
        WHERE id = %s;
        """
        execute_query(imdb_connection, update_salary_query, (new_salary, student_id))

def get_teacher_salary_map(joining_date):
    """Fetch teacher salaries and create a mapping based on joining date."""
    teachers_query = "SELECT id, salary FROM teacher WHERE joiningDate = %s;"
    teachers = fetch_data(python_connection, teachers_query, (joining_date,))  # Pass params here
    return {teacher[0]: teacher[1] for teacher in teachers}  # Assuming teacher[0] is ID and teacher[1] is salary

def get_students(joining_date):
    """Fetch students based on joining date."""
    students_query = "SELECT id FROM student WHERE joiningDate = %s;"
    return fetch_data(imdb_connection, students_query, (joining_date,))  # Pass params here

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

    # Update student salaries based on the teacher salary map
    update_student_salaries(teacher_salary_map)

    # Fetch updated student table data
    updated_students = get_students(joining_date)

    # Close the connections
    if python_connection:
        python_connection.close()
    if imdb_connection:
        imdb_connection.close()

if __name__ == "__main__":
    main()
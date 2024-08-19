#f-student
#i= teacher
def fetch_data(asof_dt):
     
    # Fetch data from 'teacher'
    with pyodbc.connect(teacher_connection_string) as conn:
        cursor = conn.cursor()
        cursor.execute(teacher_query)
        teacher_data = cursor.fetchall()

    # Fetch data from 'student'
    with pyodbc.connect(student_connection_string) as conn:
        cursor = conn.cursor()
        cursor.execute(student_query)
        student_data = cursor.fetchall()

    return teacher_data, student_data

# Main execution
if __name__ == "__main__":
    # Example usage with a dynamic date
    asof_date = '2024-06-30'  # You can change this date as needed
    teacher_data, student_data = fetch_data(asof_date)

    # Display the results from 'teacher'
    print("Top 10 Records from 'teacher':")
    for row in teacher_data:
        print(row)

    # Display the results from 'student'
    print("\nTop 10 Records from 'student':")
    for row in student_data:
        print(row)
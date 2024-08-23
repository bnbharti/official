def update_student_salaries(teacher_salary_map, asof_dt):
    cursor = imdb_connection.cursor()
    
    # Fetch student IDs in batches
    batch_size = 1000
    start = 0
    end = batch_size
    
    while True:
        student_ids_query = """
        SELECT id
        FROM student
        WHERE id BETWEEN %s AND %s
        AND asof_dt = %s
        LIMIT %s;
        """
        cursor.execute(student_ids_query, (start, end, asof_dt, batch_size))
        student_ids = [row[0] for row in cursor.fetchall()]
        
        if not student_ids:
            break
        
        # Update salaries for the current batch
        update_salary_query = """
        UPDATE student
        SET salary = CASE id
        {}
        END
        WHERE id IN ({}) AND asof_dt = %s;
        """.format(
            ', '.join(f"WHEN {student_id} THEN {new_salary}" for student_id, new_salary in teacher_salary_map.items()),
            ', '.join(str(student_id) for student_id in student_ids)
        )
        cursor.execute(update_salary_query, (asof_dt,))
        
        start += batch_size
        end += batch_size
    
    imdb_connection.commit()
    cursor.close()
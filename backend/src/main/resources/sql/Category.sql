    -- File: Category.sql

    -- Xóa dữ liệu trong bảng categories nếu đã tồn tại để tránh trùng lặp


    -- Thêm dữ liệu cho bảng categories
    INSERT INTO categories ( categories.id, category_name, difficulty_level,exam_id)
    VALUES
        ( 1,'Listening', 'Easy',1),
        ( 2,'Listening', 'Medium',1),
        ( 3,'Listening', 'Hard',2),
        (4,'Reading', 'Easy',1),
        ( 5,'Reading', 'Medium',1),
        (6, 'Reading', 'Hard',2),
        (7, 'Writing', 'Easy',1),
        (8, 'Writing', 'Medium',1),
        (9, 'Writing', 'Hard',2),
        ( 10,'Speaking', 'Easy',1),
        (11,'Speaking', 'Medium',1),
        (12,'Speaking', 'Hard',2);

    -- File: Category.sql

    -- Xóa dữ liệu trong bảng categories nếu đã tồn tại để tránh trùng lặp
    DELETE FROM categories;

    -- Thêm dữ liệu cho bảng categories
    INSERT INTO categories ( category_name, difficulty_level)
    VALUES
        ( 'Listening', 'Easy'),
        ( 'Listening', 'Medium'),
        ( 'Listening', 'Hard'),
        ('Reading', 'Easy'),
        ( 'Reading', 'Medium'),
        ('Reading', 'Hard'),
        ('Writing', 'Easy'),
        ('Writing', 'Medium'),
        ('Writing', 'Hard'),
        ( 'Speaking', 'Easy'),
        ('Speaking', 'Medium'),
        ('Speaking', 'Hard');

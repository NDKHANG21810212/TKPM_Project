import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CategoryList = () => {
    // State để lưu trữ danh sách các danh mục
    const [categories, setCategories] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // Gọi API khi component được render
    useEffect(() => {
        axios.get('http://localhost:8080/api/categories')
            .then(response => {
                if (Array.isArray(response.data)) {
                    setCategories(response.data);  // Trường hợp API trả về danh sách (mảng)
                } else {
                    setCategories([response.data]);  // Trường hợp API trả về một đối tượng duy nhất, đặt nó thành mảng
                }
                setLoading(false);
            })
            .catch(error => {
                setError(error);
                setLoading(false);
            });
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error.message}</div>;
    }

    return (
        <div>
            <h2>Danh sách Danh Mục</h2>
            <ul>
                {categories.map((category) => (
                    // Sử dụng `category.id` làm key duy nhất
                    <li key={category.id}>
                        {category.categoryName} - {category.difficultyLevel}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default CategoryList;

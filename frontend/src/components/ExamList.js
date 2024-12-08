import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ExamList = () => {
    const [exams, setExams] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // Gọi API khi component được render
    useEffect(() => {
        axios.get('http://localhost:8080/api/exams')
            .then(response => {
                setExams(response.data);  // Lưu dữ liệu bài thi vào state
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
            <h2>Danh sách các bài thi</h2>
            <ul>
                {exams.map((exam) => (
                    <li key={exam.id}>
                        <strong>{exam.title}</strong> (ID: {exam.id}) - {exam.description}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ExamList;

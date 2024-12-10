    import logo from './logo.svg';
    import React from 'react';
    import './App.css';
    import CategoryList from './components/CategoryList';
    import ExamList from  './components/ExamList';
    function App() {
        return (
        <div className="App">
            <h1>VSTEP Exam Management</h1>
            <ExamList/> {/* Hiển thị danh sách bài thi */}
        <hr/>
            <h1>Welcome to VSTEP App</h1>
            <CategoryList/>
        </div>
        );
    }

    export default App;
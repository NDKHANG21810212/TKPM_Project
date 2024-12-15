import React, { useState, useEffect } from "react";
import QuizQuestion from "./QuizQuestion";

const QuizListening = () => {
  const [question, setQuestion] = useState(null);

  useEffect(() => {
    // Lấy câu hỏi từ API
    fetch("http://localhost:8080/api/questions/1")  // URL API của bạn
        .then((response) => response.json())
        .then((data) => {
          setQuestion(data);
        })
        .catch((error) => console.error("Error fetching question:", error));
  }, []);

  if (!question) {
    return <div>Loading...</div>;
  }

  return (
      <div>
        <QuizQuestion
            question={question}
            audioPath={question.audioPath}  // Truyền đường dẫn audio
        />
      </div>
  );
};

export default QuizListening;

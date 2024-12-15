import React from "react";

const QuizQuestion = ({ question, audioPath }) => {
    console.log("Rendering question:", question);

    return (
        <div className="quiz-question">
            <h3>{question.questionText}</h3> {/* Hiển thị câu hỏi */}

            {/* Nếu có audioPath, hiển thị player để phát âm thanh */}
            {audioPath && (
                <div>
                    <audio controls src={`http://localhost:8080/audio/listening/${audioPath}`}></audio> {/* Phát âm thanh từ URL */}
                </div>
            )}
        </div>
    );
};

export default QuizQuestion;

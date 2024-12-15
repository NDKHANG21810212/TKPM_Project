import React from 'react';
import Quiz from '../../components/quiz/Quiz';
import QuizListening from "../../components/quiz1/QuizListening";
import Quiz2 from "../../components/quiz2/Quiz2";
function QuizPage() {
  return (
      <div className="quiz-page">
          <div>
              <label> Part 1</label>
              <QuizListening/>
          </div>
          <div>
              <label> Part 2</label>
              <Quiz/>
          </div>
          <div>
              <label> Part 3</label>
              <Quiz2/>
          </div>

      </div>
  );
}

export default QuizPage;

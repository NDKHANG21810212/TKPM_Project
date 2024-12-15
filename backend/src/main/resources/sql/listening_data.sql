-- Sử dụng cơ sở dữ liệu phù hợp
USE vstep_exam_db;
START TRANSACTION;
-- Thêm câu hỏi cho từng phần (categories và audio)
-- Phần 1: Câu hỏi 1-8
INSERT INTO questions (audio_path, question_text, category_id,exam_id) VALUES
               ('/audio/T1-Part1.mp3', 'What is the purpose of the message?', 1,1),
               ('/audio/T1-Part1.mp3', 'What is being advertised?', 1,1),
               ('/audio/T1-Part1.mp3', 'According to the announcement, what will be built near Berryville?', 1,1),
               ('/audio/T1-Part1.mp3', 'Who is this announcement probably for?', 1,1),
                ('/audio/T1-Part1.mp3', 'What is the purpose of the message?', 1,1),
               ('/audio/T1-Part1.mp3', 'What is this message about?', 1,1),
               ('/audio/T1-Part1.mp3', 'What is the purpose of the message?', 1,1),
               ('/audio/T1-Part1.mp3', 'Who is the speaker?', 1,1);
-- Phần 2: Câu hỏi 9-20
INSERT INTO questions (audio_path, passage_text, question_text, category_id,exam_id) VALUES
                   ('T1-Part 2', 'Questions 9 to 12 refer to the following conversation.', 'Why is the woman calling?', 1,1),
                   ('T1-Part 2', 'Questions 9 to 12 refer to the following conversation.', 'What is probably true about the man?', 1,1),
                   ('T1-Part 2',  'Questions 9 to 12 refer to the following conversation.', 'What does the woman ask the man to do?', 1,1),
                   ('T1-Part 2', 'Questions 9 to 12 refer to the following conversation.', 'What will the man likely take to his appointment?', 1,1),
                   ('T1-Part 2',  'Questions 13 to 16 refer to the following conversation.', 'Who most likely are they?', 1,1),
                   ('T1-Part 2',  'Questions 13 to 16 refer to the following conversation.', 'Who has been mentioning the study to the woman?', 1,1),
                   ('T1-Part 2', 'Questions 13 to 16 refer to the following conversation.', 'When will they likely attend the conference?', 1,1),
                   ('T1-Part 2',  'Questions 13 to 16 refer to the following conversation.', 'Who is going to visit the woman?', 1,1),
                   ('T1-Part 2',  'Questions 17 to 20 refer to the following conversation.', 'What are they talking about?', 1,1),
                   ('T1-Part 2',  'Questions 17 to 20 refer to the following conversation.', 'According to the man, what was the customer most satisfied with?', 1,1),
                   ('T1-Part 2',  'Questions 17 to 20 refer to the following conversation.', 'What do the speakers feel makes customers happy?', 1,1),
                   ('T1-Part 2', 'Questions 17 to 20 refer to the following conversation.', 'What is true about the customer?', 1,1);
-- Phần 3: Câu hỏi 21-35
INSERT INTO questions (audio_path, question_text, category_id,exam_id) VALUES
                    (3, 'Why is the woman visiting this office?', 1,1),
                    (3, 'Why are there few people in the honors program?', 1,1),
                    (3, 'What subject is NOT included if the woman chooses Political Science?', 1,1),
                    (3, 'Which is one of the requirements if the woman chooses International Relation program?', 1,1),
                    (3, 'What is NOT a reason for the Political Science Department\'s elaborate registration process?', 1,1),
                    (3, 'What happened to the debate club meeting?', 1,1),
                    (3, 'Why couldn\'t the man receive the email?', 1,1),
                    (3, 'What is going to happen with the debate club\'s meeting room?', 1,1),
                    (3, 'What is true about the debate club\'s meeting room?', 1,1),
                    (3, 'What can be inferred about the man?', 1,1),
                    (3, 'What is the professor mainly talking about?', 1,1),
                    (3, 'According to the lecture, what is wrong with space travel in most science fiction?', 1,1),
                    (3, 'According to the professor, how long does it take to travel to the closest star to Earth?', 1,1),
                    (3, 'What does the professor NOT say about the movie 2001: A Space Odyssey?', 1,1),
                    (3, 'What can be inferred about science fiction?', 1,1);
-- Thêm các lựa chọn đáp án cho từng câu hỏi
-- Choices và đáp án cho Phần 1 (câu 1-8)

INSERT INTO choices (question_id, choice_text, is_correct) VALUES
-- Câu 1
(1, 'To schedule a checkup', FALSE),
(1, 'To delay a meeting', FALSE),
(1, 'To confirm an appointment', TRUE),
(1, 'To request some files', FALSE),
-- Câu 2
(2, 'A city tour', FALSE),
(2, 'A spa package', TRUE),
(2, 'A hotel', FALSE),
(2, 'A hospital', FALSE),
-- Câu 3
(3, 'A university', FALSE),
(3, 'A high school', FALSE),
(3, 'A new hospital wing', FALSE),
(3, 'An airport terminal', TRUE),
-- Câu 4
(4, 'Factory employees', TRUE),
(4, 'Office managers', FALSE),
(4, 'Safety supervisors', FALSE),
(4, 'Hotel workers', FALSE)
-- Các câu còn lại tương tự cho Phần 1
;
-- Choices và đáp án cho Phần 2 (câu 9-20)
INSERT INTO choices (question_id, choice_text,is_correct) VALUES
-- Câu hỏi 9
(9, 'To make an appointment', TRUE),
(9, 'To speak with Dr. Johnson', FALSE),
(9, 'To confirm an appointment', TRUE),
(9, 'To receive some medical advice',FALSE),
-- Câu hỏi 10
(10, 'He is a doctor.',FALSE),
(10, 'He is very busy these days.',FALSE),
(10, 'He is the woman''s friend.',FALSE),
(10, 'He will be late for the appointment.',TRUE),
-- Câu hỏi 11
(11, 'Show up to his appointment a little early', TRUE),
(11, 'Get more medical insurance',FALSE),
(11, 'Wait 10 minutes in the waiting area',FALSE),
(11, 'Always arrange his appointments a day early',FALSE),
-- Câu hỏi 12
(12, 'His past medical records',FALSE),
(12, 'Some insurance documents',FALSE),
(12, 'His appointment book', TRUE),
(12, 'An application form',FALSE),
-- Câu hỏi 13
(13, 'Journalists', TRUE),
(13, 'Physicians',FALSE),
(13, 'Lawyers',FALSE),
(13, 'Restaurant owners',FALSE),
-- Câu hỏi 14
(14, 'Her patients',FALSE),
(14, 'Her mother-in-law',FALSE),
(14, 'Her doctor', TRUE),
(14, 'Her friends',FALSE),
-- Câu hỏi 15
(15, 'Today',FALSE),
(15, 'Friday',FALSE),
(15, 'Saturday', TRUE),
(15, 'Sunday',FALSE),
-- Câu hỏi 16
(16, 'Her friends',FALSE),
(16, 'Her husband',FALSE),
(16, 'Her mother-in-law',FALSE),
(16, 'Her patients',FALSE),
-- Câu hỏi 17
(17, 'The duration of the warranty',FALSE),
(17, 'A customer they helped',TRUE),
(17, 'A vehicle the man recently fixed',FALSE),
-- Câu hỏi 18
(18, 'The low cost of the repair work',FALSE),
(18, 'The free service they provided',FALSE),
(18, 'The competitive price of their products', TRUE),
(18, 'The length of the warranty period',FALSE),
-- Câu hỏi 19
(19, 'The low price',FALSE),
(19, 'The great service',FALSE),
(19, 'The free gifts',FALSE),
(19, 'The store hours', TRUE),
-- Câu hỏi 20
(20, 'He is a loyal one.', TRUE),
(20, 'He thought the warranty had expired.',FALSE),
(20, 'He will definitely come back to the store.',FALSE),
(20, 'He will recommend the store to his friend.',FALSE);
-- Choices và đáp án cho Phần 3 (câu 21-35)
    INSERT INTO choices (question_id, choice_text, is_correct) VALUES
-- Câu 21
    (21, 'She wants to be a science major.', FALSE),
(21, 'She wants to learn about politics.', FALSE),
(21, 'She is interested in registering for a course.', TRUE),
(21, 'She is interested in Political Science.', FALSE),
-- Câu 22
(22, 'It is not considered a prestigious program.', FALSE),
(22, 'The requirements are difficult to meet.', TRUE),
(22, 'No one likes the economics requirement.', FALSE),
(22, 'It is an unpopular program.', FALSE),
-- Câu 23
(23, 'Political Science I', FALSE),
(23, 'Political Science II', FALSE),
(23, 'Writing seminar', FALSE),
(23, 'Economics', TRUE)
-- Các câu còn lại cho Phần 3
;COMMIT;
-- Thêm đáp án đúng vào bảng answers
INSERT INTO answers (selected_choice, question_id, user_id) VALUES
-- Câu 1
('To confirm an appointment', 1, 1),
-- Câu 2
('A spa package', 2, 1),
-- Câu 3
('An airport terminal', 3, 1),
-- Câu 4
('Factory employees', 4, 1),
-- Câu 5
('To confirm an appointment', 5, 1),
-- Câu 6
('About the weather', 6, 1),
-- Câu 7
('To confirm an appointment', 7, 1),
-- Câu 8
('The manager', 8, 1);

-- Phần 2: Câu hỏi 9-20
INSERT INTO answers (selected_choice, question_id, user_id) VALUES
-- Câu 9
('To reschedule a meeting', 9, 1),
-- Câu 10
('He is the manager', 10, 1),
-- Câu 11
('Send a report', 11, 1),
-- Câu 12
('A briefcase', 12, 1),
-- Câu 13
('Factory workers', 13, 1),
-- Câu 14
('The department head', 14, 1),
-- Câu 15
('On Friday', 15, 1),
-- Câu 16
('Her supervisor', 16, 1),
-- Câu 17
('An upcoming event', 17, 1),
-- Câu 18
('Quality service', 18, 1),
-- Câu 19
('Customer satisfaction', 19, 1),
-- Câu 20
('New client', 20, 1);

-- Phần 3: Câu hỏi 21-35
INSERT INTO answers (selected_choice, question_id, user_id) VALUES
-- Câu 21
('Job application', 21, 1),
-- Câu 22
('Few applicants', 22, 1),
-- Câu 23
('Economics', 23, 1),
-- Câu 24
('Research project', 24, 1),
-- Câu 25
('High standards', 25, 1),
-- Câu 26
('It was postponed', 26, 1),
-- Câu 27
('Server issue', 27, 1),
-- Câu 28
('Room change', 28, 1),
-- Câu 29
('New location', 29, 1),
-- Câu 30
('Highly involved', 30, 1),
-- Câu 31
('Space exploration', 31, 1),
-- Câu 32
('Unrealistic timelines', 32, 1),
-- Câu 33
('Several decades', 33, 1),
-- Câu 34
('Not mentioned', 34, 1),
-- Câu 35
('Lacks realism', 35, 1);
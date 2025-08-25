# Write your MySQL query statement below
SELECT s.student_id,s.student_name,s1.subject_name,count(e.subject_name) as attended_exams
FROM Students s
CROSS JOIN Subjects s1
LEFT JOIN Examinations e ON e.student_id = s.student_id AND s1.subject_name = e.subject_name
GROUP BY s1.subject_name,s.student_id,s.student_name
ORDER BY s.student_id,s1.subject_name;
# Write your MySQL query statement below
SELECT p.project_id,
ROUND(
    IFNULL(AVG(e.experience_years),0),2) as average_years
FROM Project p
JOIN Employee e ON e.employee_id = p.employee_id
GROUP BY p.project_id;
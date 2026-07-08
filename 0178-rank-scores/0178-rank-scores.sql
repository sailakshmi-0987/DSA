# Write your MySQL query statement below
SELECT 
    ROUND(score,2) AS score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM Scores
ORDER BY score DESC;
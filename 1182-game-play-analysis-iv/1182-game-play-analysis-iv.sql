SELECT
  ROUND(
    SUM(CASE WHEN a.event_date IS NOT NULL THEN 1 ELSE 0 END) * 1.0 / COUNT(*),
    2
  ) AS fraction
FROM (
  SELECT player_id, MIN(event_date) AS first_login
  FROM Activity
  GROUP BY player_id
) t
LEFT JOIN Activity a
  ON a.player_id = t.player_id
  AND DATEDIFF(a.event_date, t.first_login) = 1;

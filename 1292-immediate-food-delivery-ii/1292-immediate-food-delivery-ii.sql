# Write your MySQL query statement below
SELECT 
    ROUND(100 * SUM(order_date = customer_pref_delivery_date) / COUNT(*), 2) AS immediate_percentage
FROM Delivery d
WHERE order_date = (
    SELECT MIN(order_date)
    FROM Delivery
    WHERE customer_id = d.customer_id
);


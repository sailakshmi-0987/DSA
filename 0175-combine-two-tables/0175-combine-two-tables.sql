# Write your MySQL query statement below
SELECT Person.firstName,Person.lastName,Address.city,Address.state
FROM Person
left join Address ON Person.personId = Address.personId;

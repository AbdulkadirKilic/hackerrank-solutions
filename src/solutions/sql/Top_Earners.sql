-- HackerRank Question: https://www.hackerrank.com/challenges/earnings-of-employees/problem

WITH Earnings AS (
    SELECT
        employee_id,
        name,
        (salary * months) AS total_earnings
    FROM Employee
)
SELECT
    MAX(total_earnings) AS MaxEarnings,
    COUNT(*) AS EmployeeCount
FROM Earnings
WHERE total_earnings = (
    SELECT MAX(total_earnings)
    FROM Earnings
);

-- HackerRank Question: https://www.hackerrank.com/challenges/the-blunder/problem

SELECT CEIL(AVG(Salary) - AVG(TO_NUMBER(REPLACE(Salary, '0', '')))) AS ErrorDifference
FROM EMPLOYEES;



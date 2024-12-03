-- HackerRank Question: https://www.hackerrank.com/challenges/revising-the-select-query/problem

SELECT *
FROM CITY
WHERE Population > 100000
  AND CountryCode = 'USA';

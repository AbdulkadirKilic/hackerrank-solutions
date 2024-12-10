-- HackerRank Question: https://www.hackerrank.com/challenges/asian-population/problem

SELECT
    SUM(C.population) AS total_population
FROM
    CITY C
JOIN
    COUNTRY CO ON C.CountryCode = CO.Code
WHERE
    CO.Continent = 'Asia';



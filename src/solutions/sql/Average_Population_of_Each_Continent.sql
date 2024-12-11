-- HackerRank Question: https://www.hackerrank.com/challenges/average-population-of-each-continent/problem

SELECT
    COUNTRY.Continent,
    FLOOR(AVG(CITY.Population)) AS AveragePopulation
FROM
    CITY
JOIN
    COUNTRY
ON
    CITY.CountryCode = COUNTRY.Code
GROUP BY
    COUNTRY.Continent;

-- HackerRank Question: https://www.hackerrank.com/challenges/weather-observation-station-14/problem

SELECT TRUNC(MAX(LAT_N), 4) AS MaxLatN
FROM STATION
WHERE LAT_N < 137.2345;

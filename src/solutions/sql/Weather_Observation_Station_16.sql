-- HackerRank Question: https://www.hackerrank.com/challenges/weather-observation-station-16/problem

SELECT
    ROUND(MIN(LAT_N), 4) AS SmallestLatN
FROM STATION
WHERE LAT_N > 38.7780;

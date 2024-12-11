-- HackerRank Question: https://www.hackerrank.com/challenges/draw-the-triangle-1/problem

SELECT RPAD('*', 2 * (21 - LEVEL) - 1, ' *') AS pattern
FROM dual
CONNECT BY LEVEL <= 20;


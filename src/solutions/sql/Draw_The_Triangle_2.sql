-- HackerRank Question: https://www.hackerrank.com/challenges/draw-the-triangle-2/problem

SELECT RPAD('*', LEVEL * 2 - 1, ' *') AS pattern
FROM dual
CONNECT BY LEVEL <= 20;


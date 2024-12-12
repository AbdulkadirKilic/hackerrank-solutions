-- HackerRank Question: https://www.hackerrank.com/challenges/print-prime-numbers/problem

WITH Numbers AS (
    SELECT LEVEL AS num
    FROM DUAL
    CONNECT BY LEVEL <= 1000
),
PrimeNumbers AS (
    SELECT num
    FROM Numbers
    WHERE num > 1
    AND NOT EXISTS (
        SELECT 1
        FROM Numbers n
        WHERE n.num > 1 AND n.num < Numbers.num
        AND MOD(Numbers.num, n.num) = 0
    )
)
SELECT LISTAGG(num, '&') WITHIN GROUP (ORDER BY num) AS prime_numbers
FROM PrimeNumbers;


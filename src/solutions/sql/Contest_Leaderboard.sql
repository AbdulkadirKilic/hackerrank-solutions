-- HackerRank Question: https://www.hackerrank.com/challenges/contest-leaderboard/problem

SELECT
    h.hacker_id,
    h.name,
    SUM(t.max_score) AS total_score
FROM
    Hackers h
JOIN (
    SELECT
        hacker_id,
        MAX(score) AS max_score
    FROM
        Submissions
    GROUP BY
        hacker_id, challenge_id
) t
ON
    h.hacker_id = t.hacker_id
GROUP BY
    h.hacker_id, h.name
HAVING
    SUM(t.max_score) > 0
ORDER BY
    total_score DESC, h.hacker_id;


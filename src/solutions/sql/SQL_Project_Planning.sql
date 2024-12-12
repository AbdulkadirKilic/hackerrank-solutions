-- HackerRank Question: https://www.hackerrank.com/challenges/sql-projects/problem

WITH ProjectGroups AS (
    SELECT
        Task_ID,
        Start_Date,
        End_Date,
        Start_Date - ROW_NUMBER() OVER (ORDER BY Start_Date) AS Group_ID
    FROM
        Projects
),
ProjectBoundaries AS (
    SELECT
        Group_ID,
        MIN(Start_Date) AS Project_Start,
        MAX(End_Date) AS Project_End
    FROM
        ProjectGroups
    GROUP BY
        Group_ID
)
SELECT
    Project_Start,
    Project_End
FROM
    ProjectBoundaries
ORDER BY
    (Project_End - Project_Start), Project_Start;


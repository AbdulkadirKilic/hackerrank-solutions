-- HackerRank Question: https://www.hackerrank.com/challenges/the-company/problem

SELECT
    C.company_code,
    C.founder,
    COUNT(DISTINCT LM.lead_manager_code) AS lead_manager_count,
    COUNT(DISTINCT SM.senior_manager_code) AS senior_manager_count,
    COUNT(DISTINCT M.manager_code) AS manager_count,
    COUNT(DISTINCT E.employee_code) AS employee_count
FROM
    Company C
LEFT JOIN
    Lead_Manager LM ON C.company_code = LM.company_code
LEFT JOIN
    Senior_Manager SM ON LM.lead_manager_code = SM.lead_manager_code
LEFT JOIN
    Manager M ON SM.senior_manager_code = M.senior_manager_code
LEFT JOIN
    Employee E ON M.manager_code = E.manager_code
GROUP BY
    C.company_code, C.founder
ORDER BY
    C.company_code;


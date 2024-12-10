-- HackerRank Question: https://www.hackerrank.com/challenges/binary-search-tree-1/problem

SELECT
    N,
    CASE
        WHEN P IS NULL THEN 'Root' -- Root node: No parent
        WHEN N NOT IN (SELECT P FROM BST WHERE P IS NOT NULL) THEN 'Leaf' -- Leaf node: No children
        ELSE 'Inner' -- Inner node: Has both parent and children
    END AS NodeType
FROM BST
ORDER BY N;

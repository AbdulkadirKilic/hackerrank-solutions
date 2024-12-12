-- HackerRank Question: https://www.hackerrank.com/challenges/placements/problem

SELECT s.Name
FROM Students s
JOIN Friends f
  ON s.ID = f.ID
JOIN Packages p_friend
  ON f.Friend_ID = p_friend.ID
JOIN Packages p_self
  ON s.ID = p_self.ID
WHERE p_friend.Salary > p_self.Salary
ORDER BY p_friend.Salary;



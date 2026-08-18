# Write your MySQL query statement below
SELECT today.id
FROM Weather AS Today
JOIN Weather AS Yesterday
  ON DATE_SUB(Today.recordDate, INTERVAL 1 DAY) = Yesterday.recordDate
WHERE Today.temperature > Yesterday.temperature;

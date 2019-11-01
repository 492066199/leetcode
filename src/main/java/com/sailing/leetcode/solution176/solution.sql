# Write your MySQL query statement below
select max(Salary) as SecondHighestSalary from Employee where id not in (select id from Employee where Salary = (select max(Salary) from Employee));
# Write your MySQL query statement below
select FirstName, LastName, City, State from  Address a right join Person b on a.PersonId = b.PersonId;
# Write your MySQL query statement below
select p.email as Email 
from person p
group by p.email
having count(p.email)>1;

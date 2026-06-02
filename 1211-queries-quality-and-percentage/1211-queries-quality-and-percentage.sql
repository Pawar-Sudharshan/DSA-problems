# Write your MySQL query statement below
select q.query_name ,round(avg(q.rating/q.position),2) as quality ,round((select count(*) from queries where rating < 3 and q.query_name =query_name )*100/(select count(*) from queries where q.query_name= query_name ),2) as poor_query_percentage 
from queries q
group by q.query_name;
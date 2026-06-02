# Write your MySQL query statement below
select e.machine_id ,Round(avg(e.timestamp -s.timestamp  ),3) as processing_time  from activity s join activity 
 e on s.machine_id = e.machine_id
 and s.process_id = e.process_id 
 where s.activity_type = 'start'
 ANd e.activity_type = 'end'
group by e.machine_id;
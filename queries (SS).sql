--attendees with status 2
select Name
from Attendees
where status = '2';

--display the total amt for each item
select *, quantity * rate As total_amt
from expense;

--count the number of attendees
select count(party_id)
from attendees;

--display the details of vendors left to be paid
select *
from vendor;
where paid != Total_cost;

--display the details of the vendors who are left to be paid more than 1000
select *
from vendor
where Total_cost - paid > 1000;

--display the total cost of the items left to be paid
select name, Total_cost - paid As amt_left
from vendor
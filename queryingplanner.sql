--count the number of attendees
select distinct partyID from party_activity
where role = 1
--show the total expense

select sum (quantity * rate) from expense

--show the expenses above 100 rs
select (quantity * rate) from expense
where (quantity*rate) >100

--show the names and contact details of all the vendors

select distinct Party.id , Party.name, Party.email, Party.phoneno, Party_activity.role, party_activity.activityid
from Party, party_activity
where Party.id= party_activity.partyid AND party_activity.role=3
order by Party.id

--show how many attendees are there for a particular activity

select Party.name, Activity.title, party_activity.activityid, party_activity.role from Party, Activity, party_activity
where Party.id = party_activity.partyid AND Activity.id = party_activity.activityid AND party_activity.role=1 AND Activity.id =1

--count the number of activities
select count(*) from Activity

--count the total amount of money left to be paid
select sum (amount - amountpaid) from vendor
use todojdbc;

insert into user_details values (2,"Daryl","Martin","countyadmin","password1","COUNTRYADMINISTRATOR");
insert into user_details values (1,"Clay","Jenkins","countyjudge","password2","COUNTYJUDGE");
insert into user_details values (3,"Felicia","Pitre","countyAdmin","password3","DISTRICTCLERK");

insert into todo_daily values(-1,"Look into details of summons", "8:30:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Decide number of cases you can serve", "9:00:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Sequential call of cases", "9:15:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Hear arguments from respondents", "10:15:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Hear arguments from petitioner", "11:15:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Analyze the arguments", "12:30:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Provide dates if necessary", "13:00:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Analyze evidence", "13:30:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Provide revolution based on evidences", "14:00:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Provide judgement", "15:00:00", "IMPORTANT", "PENDING", 1);
insert into todo_daily values(-1,"Finish", "17:00:00", "IMPORTANT", "PENDING", 1);

insert into todo_daily values(-1,"Attend the meetings of the board consisting of Clerk and Judge", "8:30:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Decide the number of cases which he can serve", "9:00:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Record in a book provided for the purpose", "10:00:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Submit to board recommendations concerning the affairs of the county", "10:30:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Prepare to submit to the board a proposed annual budget for the county", "11:00:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Audit all claims against the county", "12:00:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Supervision of day-to-day operations of all county departments and staff, directly an through department heads", "12:15:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Oversight of hiring, firing, discipliing and suspensions of all county employees", "13:45:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Main technical advisor to the council on overall governmental operations", "14:30:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Attend all council meetings", "15:15:00", "IMPORTANT", "PENDING", 2);
insert into todo_daily values(-1,"Finish", "16:00:00", "IMPORTANT", "PENDING", 2);

insert into todo_daily values(-1,"Record the acts of the proceedings of the district court", "8:30:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Enter all judgements of the court under the direction of the judge", "9:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Record all executions issued and the reutrns thereof", "9:30:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Process passport applications", "10:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Adminstrer child support payments", "11:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Administer trust accounts for minors ordered by the courts", "12:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Keep an index of the parties to all suits files in the court", "13:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Make Reference to any judgement made in the case", "14:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Keep an account of all funds collected by the office by way of fees, and the amount due jurors in district courts for service", "15:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Manage records so they are easily retrieved for public information, preserved for permanent storage, dispose according to law", "15:30:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Gather data and report to state and local agencies.", "16:00:00", "IMPORTANT", "PENDING", 3);
insert into todo_daily values(-1,"Finish", "17:00:00", "IMPORTANT", "PENDING", 3);

insert into todo_task values(null, "test", "2020-01-20", "10:20:00", "IMPORTANT", "PENDING", 1);
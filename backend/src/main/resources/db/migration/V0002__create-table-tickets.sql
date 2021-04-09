create table tickets (
	id SERIAL not null, 
	creation_date timestamp NOT NULL, 
	numbers_fifth int4, 
	numbers_first int4, 
	numbers_fourth int4, 
	numbers_second int4, 
	numbers_sixth int4, 
	numbers_third int4, 
	user_email varchar(255),
	
	primary key (id)
	);

alter table tickets add constraint FK_tickets_user foreign key (user_email) references users;
	



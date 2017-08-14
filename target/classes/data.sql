insert into user (user_name, password, password_confirm) values ('admin', 'admin', 'admin');
insert into user (user_name, password, password_confirm) values ('tuser', 'tuser', 'tuser');
insert into user (user_name, password, password_confirm) values ('user', 'user', 'user');

insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_TECHNICAL_USER');
insert into role (name) values ('ROLE_USER');

insert into user_role (user_id , role_id) values (1, 1);
insert into user_role (user_id , role_id) values (1, 2);
insert into user_role (user_id , role_id) values (1, 3);
insert into user_role (user_id , role_id) values (2, 2);
insert into user_role (user_id , role_id) values (2, 3);
insert into user_role (user_id , role_id) values (3, 3);
	
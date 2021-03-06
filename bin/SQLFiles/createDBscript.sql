--drop DATABASE IF EXISTS cbscalendar;
CREATE DATABASE IF NOT EXISTS cbscalendar;
use cbscalendar;
--select * from users;
SET SESSION FOREIGN_KEY_CHECKS=0;

/* Create Tables */

CREATE TABLE IF NOT EXISTS Calendar
(
	CalendarID int NOT NULL AUTO_INCREMENT,
	type tinyint NOT NULL COMMENT '1 = HA IT 2 = brugerdefineret. kun type 2 kan slettes.',
	Name varchar(255) NOT NULL UNIQUE,
	Active tinyint not null comment '1 = active 2 = notActive' ,
	CreatedBy varchar(255) NOT NULL,
	PrivatePublic tinyint NOT NULL COMMENT '1 = public 2 = private',
	PRIMARY KEY (CalendarID)
);

CREATE TABLE IF NOT EXISTS Forecast
(
	ForecastID int NOT NULL AUTO_INCREMENT,
	date varchar(114) NOT NULL,
	celcius varchar(255) NOT NULL,
	description varchar(234) not null,
	count varchar (10) not null unique,
	PRIMARY KEY (ForecastID)
);


CREATE TABLE IF NOT EXISTS dailyupdate
(
	qotd varchar(300) NOT NULL,
	author varchar(100) not null ,
	topic varchar(80) not null ,
	msg_type varchar (100) NOT NULL unique,
	LastUpdateTime Bigint(50),
	PRIMARY KEY (qotd)
);


CREATE TABLE IF NOT EXISTS events
(
	ID int NOT NULL,
	activityID varchar(500),
	eventID varchar(500) not null,
	type varchar(200) NOT NULL COMMENT 'Lecture or exercise',
	title varchar(500) NOT NULL,
	description varchar(200) NOT NULL,
	start datetime NOT NULL,
	end datetime NOT NULL,
	location varchar(500) NOT NULL,	
	note varchar(200),
	superID int not null AUTO_INCREMENT,
	PRIMARY KEY (superID)
);

CREATE TABLE IF NOT EXISTS users
(
	userID int NOT NULL AUTO_INCREMENT,
	email varchar(40) NOT NULL,
	Active tinyint,
	password varchar(30) NOT NULL,
	CPR varchar(11) not null,
	UpdatedCbsEvents varchar(24) not null comment 'Updated, notUpdated.', 
	
	PRIMARY KEY (userID)
);
use cbscalendar;
insert into dailyupdate (qotd, author, topic, msg_type, LastUpdateTime)
values ('afa', 'fa', 'faf', 'hej', 1416351614539);


use cbscalendar;
insert into users (userID, email, Active, password, CPR, UpdatedCbsEvents)
values (2, 'kabj13ab', 1, 'hej', '111111-1111', 'notUpdated');



use cbscalendar;
insert into forecast (date, celcius, description, count)
values ('2014-11-11 14:20:00', '1', '1','0'),
('2014-11-11 14:20:00', '1', '1','1'),
('2014-11-11 14:20:00', '1', '1','2'),
('2014-11-11 14:20:00', '1', '1','3'),
('2014-11-11 14:20:00', '1', '1','4'),
('2014-11-11 14:20:00', '1', '1','5'),
('2014-11-11 14:20:00', '1', '1','6');
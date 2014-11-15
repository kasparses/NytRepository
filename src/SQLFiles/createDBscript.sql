--drop DATABASE IF EXISTS cbscalendar;
CREATE DATABASE IF NOT EXISTS cbscalendar;
use cbscalendar;
--select * from events;
SET SESSION FOREIGN_KEY_CHECKS=0;

/* Create Tables */

CREATE TABLE IF NOT EXISTS Calendar
(
	CalendarID int NOT NULL AUTO_INCREMENT,
	type tinyint NOT NULL COMMENT '1 = HA IT 2 = brugerdefineret. kun type 2 kan slettes.',
	Name varchar(255) NOT NULL UNIQUE,
	Active tinyint, 
	CreatedBy varchar(255) NOT NULL,
	-- 1 = public
	-- 2 = private
	PrivatePublic tinyint NOT NULL COMMENT '1 = public
	2 = private',
	PRIMARY KEY (CalendarID)
);


CREATE TABLE IF NOT EXISTS dailyupdate
(
	date datetime NOT NULL UNIQUE,
	apparentTemperature double,
	summary text,
	qotd varchar(300) NOT NULL,
	msg_type varchar (100) NOT NULL COMMENT 'Hvad er dette?',
	update_timestamp TIMESTAMP DEFAULT NOW() ON UPDATE NOW(),
	PRIMARY KEY (date)
);


CREATE TABLE IF NOT EXISTS events
(
	ID int NOT NULL AUTO_INCREMENT,
	activityID varchar(20) NOT NULL,
	eventID varchar(200) NOT NULL,
	type varchar(20) NOT NULL COMMENT 'Lecture or exercise',
	title varchar(50) NOT NULL,
	description varchar(30) NOT NULL,
	start datetime NOT NULL,
	end datetime NOT NULL,
	location varchar(50) NOT NULL,	
	--name varchar(30) NOT NULL UNIQUE,
	--text text NOT NULL,
	--calendarID int Not Null,
	-- Decides wether the event is an import-event or user created
	-- 
	PRIMARY KEY (ID)
);


CREATE TABLE IF NOT EXISTS locationdata
(
	locationdataID int NOT NULL AUTO_INCREMENT,
	longitude int NOT NULL,
	latitude int Not null,
	PRIMARY KEY (locationdataid)
);

CREATE TABLE IF NOT EXISTS notes
(
	noteID int NOT NULL AUTO_INCREMENT,
	eventID int NOT NULL,
	createdBy varchar(255) NOT NULL,
	text text,
	dateTime datetime NOT NULL,
	PRIMARY KEY (noteID)
);

CREATE TABLE IF NOT EXISTS users
(
	userID int NOT NULL AUTO_INCREMENT,
	email varchar(40) NOT NULL,
	Active tinyint, 
	created datetime NOT NULL,
	type varchar(20) not null,
	password varchar(30) NOT NULL,
	CPR varchar(11) not null,
	PRIMARY KEY (userID)
);


/* Create Dummy Account */
INSERT INTO `cbscalendar`.`users`
(email,
Active,
created,
type,
password,
CPR)
VALUES
('1234',
'1',
'2014-11-13 14:38:00',
'user',
'hej',
'111111-1111');



/* Create Foreign Keys */

--ALTER TABLE events
	--ADD FOREIGN KEY (ID)
	--REFERENCES Calendar (CalendarID)
	--ON UPDATE RESTRICT
--;

--ALTER TABLE notes
	--ADD FOREIGN KEY (noteID)
	--REFERENCES events (ID)
	--ON UPDATE RESTRICT
--;
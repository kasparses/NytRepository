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
	-- 1 = public
	-- 2 = private
	PrivatePublic tinyint NOT NULL COMMENT '1 = public 2 = private',
	PRIMARY KEY (CalendarID)
);

CREATE TABLE IF NOT EXISTS Forecast
(
	ForecastID int NOT NULL AUTO_INCREMENT,
	date varchar(114) NOT NULL,
	celcius varchar(255) NOT NULL,
	description varchar(234) not null,
	PRIMARY KEY (ForecastID)
);


CREATE TABLE IF NOT EXISTS dailyupdate
(
	date varchar(50) NOT NULL UNIQUE,
	apparentTemperature double,
	summary text,
	qotd varchar(300) NOT NULL,
	author varchar(100) not null ,
	topic varchar(80) not null ,
	msg_type varchar (100) NOT NULL COMMENT 'Hvad er dette?',
	LastUpdateTime Bigint(50),
	PRIMARY KEY (date)
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
	superID int not null AUTO_INCREMENT,
	--name varchar(30) NOT NULL UNIQUE,
	--text text NOT NULL,
	--calendarID int Not Null,
	-- Decides wether the event is an import-event or user created
	-- 
	PRIMARY KEY (superID)
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
	created varchar(30) NOT NULL COMMENT '--TIMESTAMP DEFAULT CURRENT_TIMESTAMP,',
	type varchar(20) not null COMMENT '1 = admin 2 = bruger',
	password varchar(30) NOT NULL,
	CPR varchar(11) not null,
	
	PRIMARY KEY (userID)
);


--ALTER TABLE events
	--ADD FOREIGN KEY (ID)
	--REFERENCES Calendar (CalendarID)
	--ON UPDATE RESTRICT
--;

ALTER TABLE notes
	ADD FOREIGN KEY (noteID)
	REFERENCES events (superID)
	ON UPDATE RESTRICT
;
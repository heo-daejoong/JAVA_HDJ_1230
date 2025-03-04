DROP DATABASE IF EXISTS BROAD;

CREATE DATABASE BROAD;

USE BROAD;

DROP TABLE IF EXISTS `VIEW`;

CREATE TABLE `VIEW` (
	`VW_KEY`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`VW_PG_KEY`	CHAR(6)	NOT NULL,
	`VW_WE_KEY`	INT	NOT NULL
);

DROP TABLE IF EXISTS `BROADTIME`;

CREATE TABLE `BROADTIME` (
	`BT_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`BT_VW_KEY`	INT	NOT NULL,
	`BT_DATE`	DATETIME NOT	NULL,
	`BT_TIMETABLE`	DATETIME NOT	NULL
);

DROP TABLE IF EXISTS `WEEK`;

CREATE TABLE `WEEK` (
	`WE_KEY`	INT PRIMARY KEY	NOT NULL,
	`WE_NAME`	CHAR(3) NOT NULL
);

DROP TABLE IF EXISTS `PROGRAM`;

CREATE TABLE `PROGRAM` (
	`PG_KEY`	VARCHAR(6) PRIMARY KEY	NOT NULL,
	`PG_NAME`	VARCHAR(20) NOT	NULL,
	`PG_AGE`	ENUM("ALL","12세","15세","19세") DEFAULT "ALL" NOT	NULL,
	`PG_CH_NUM`	INT	NOT NULL,
	`PG_TIME`	VARCHAR(6) NOT	NULL
);

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
	`US_KEY`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`US_ID`	VARCHAR(20) UNIQUE NOT NULL,
	`US_PW`	VARCHAR(20) NOT NULL,
	`US_NAME`	VARCHAR(10) NOT NULL,
	`US_AUTHORITY`	ENUM("ADMIN","USER") DEFAULT "USER" NOT	NULL
);

DROP TABLE IF EXISTS `GENRE`;

CREATE TABLE `GENRE` (
	`GR_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`GR_NAME`	VARCHAR(10) NOT	NULL
);

DROP TABLE IF EXISTS `INDEX`;

CREATE TABLE `INDEX` (
	`IN_KEY`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`IN_PG_KEY`	CHAR(6)	NOT NULL,
	`IN_US_KEY`	INT NOT NULL
);

DROP TABLE IF EXISTS `PROGRAMGENRE`;

CREATE TABLE `PROGRAMGENRE` (
	`PR_KEY`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`PR_GR_NUM`	INT	NOT NULL,
	`PR_PG_KEY`	VARCHAR(6)	NOT NULL
);

DROP TABLE IF EXISTS `CHANNEL`;

CREATE TABLE `CHANNEL` (
	`CH_NUM`	INT PRIMARY KEY	NOT NULL,
	`CH_NAME`	VARCHAR(10) NOT NULL
);

ALTER TABLE `VIEW` ADD CONSTRAINT `FK_PROGRAM_TO_VIEW_1` FOREIGN KEY (
	`VW_PG_KEY`
)
REFERENCES `PROGRAM` (
	`PG_KEY`
);

ALTER TABLE `VIEW` ADD CONSTRAINT `FK_WEEK_TO_VIEW_1` FOREIGN KEY (
	`VW_WE_KEY`
)
REFERENCES `WEEK` (
	`WE_KEY`
);

ALTER TABLE `BROADTIME` ADD CONSTRAINT `FK_VIEW_TO_BROADTIME_1` FOREIGN KEY (
	`BT_VW_KEY`
)
REFERENCES `VIEW` (
	`VW_KEY`
);

ALTER TABLE `PROGRAM` ADD CONSTRAINT `FK_CHANNEL_TO_PROGRAM_1` FOREIGN KEY (
	`PG_CH_NUM`
)
REFERENCES `CHANNEL` (
	`CH_NUM`
);

ALTER TABLE `INDEX` ADD CONSTRAINT `FK_PROGRAM_TO_INDEX_1` FOREIGN KEY (
	`IN_PG_KEY`
)
REFERENCES `PROGRAM` (
	`PG_KEY`
);

ALTER TABLE `INDEX` ADD CONSTRAINT `FK_USER_TO_INDEX_1` FOREIGN KEY (
	`IN_US_KEY`
)
REFERENCES `USER` (
	`US_KEY`
);

ALTER TABLE `PROGRAMGENRE` ADD CONSTRAINT `FK_GENRE_TO_PROGRAMGENRE_1` FOREIGN KEY (
	`PR_GR_NUM`
)
REFERENCES `GENRE` (
	`GR_NUM`
);

ALTER TABLE `PROGRAMGENRE` ADD CONSTRAINT `FK_PROGRAM_TO_PROGRAMGENRE_1` FOREIGN KEY (
	`PR_PG_KEY`
)
REFERENCES `PROGRAM` (
	`PG_KEY`
);


DROP DATABASE IF EXISTS class101;
create database class101;
USE CLASS101;
DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER` (
	`ME_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`ME_NAME`	VARCHAR(50) NOT	NULL,
	`ME_ID`	VARCHAR(13) NOT	NULL unique,
	`ME_PW`	VARCHAR(255) NOT	NULL,
	`ME_NICK`	VARCHAR(10) NOT	NULL unique,
	`ME_EMAIL`	VARCHAR(100) NOT	NULL,
	`ME_NUMBER`	VARCHAR(20) NOT	NULL,
	`ME_AUTHORITY`	ENUM("USER", "ADMIN", "TEACHER") DEFAULT "USER"	NULL,
	`ME_ONLINE`	ENUM("Y", "N") DEFAULT "N"	NULL,
	`ME_DEL`	ENUM("Y", "N") DEFAULT "N"	NULL,
	`ME_PROFILE`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `THUMBNAIL`;

CREATE TABLE `THUMBNAIL` (
	`TH_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`TH_NAME`	VARCHAR(50) NOT	NULL,
	`TH_PICTURE`	VARCHAR(255) NOT	NULL,
	`TH_CL_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `CATEGORY`;

CREATE TABLE `CATEGORY` (
	`CA_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`CA_NAME`	VARCHAR(20) NOT	NULL
);

DROP TABLE IF EXISTS `SUBSCRIBE`;

CREATE TABLE `SUBSCRIBE` (
	`SU_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SU_DATE`	DATETIME  DEFAULT CURRENT_TIMESTAMP NOT NULL,
	`SU_ME_NUM`	INT	NOT NULL,
	`SU_CL_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `VIDEO`;

CREATE TABLE `VIDEO` (
	`VD_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`VD_NAME`	VARCHAR(20) NOT	NULL,
	`VD_VIDOE`	VARCHAR(255) NOT	NULL,
	`VD_CR_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `TEACHER`;

CREATE TABLE `TEACHER` (
	`TC_ME_NUM`	INT	NOT NULL,
	`TC_INTRO`	LONGTEXT NOT	NULL
);

DROP TABLE IF EXISTS `SUBCATEGORY`;

CREATE TABLE `SUBCATEGORY` (
	`SC_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SC_NAME`	VARCHAR(20) NOT	NULL,
	`SC_CA_NUM`	INT	NOT NULL,
	`SC_CL_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `COMMENT`;

CREATE TABLE `COMMENT` (
	`CO_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`CO_CONTENT`	VARCHAR(255) NOT	NULL,
	`CO_DATE`	DATETIME DEFAULT CURRENT_TIMESTAMP NOT	NULL,
	`CO_ME_NUM`	INT	NOT NULL,
	`CO_CL_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `CLASS`;

CREATE TABLE `CLASS` (
	`CL_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`CL_TITLE`	VARCHAR(50) NOT	NULL,
	`CL_ITEM`	LONGTEXT NOT	NULL,
	`CL_INTRO`	LONGTEXT NOT	NULL,
	`CL_MONEY`	INT NOT	NULL,
	`CL_DATE`	DATETIME DEFAULT CURRENT_TIMESTAMP NOT	NULL,
	`CL_LEVEL`	ENUM("상","중","하")	NULL,
	`CL_ABLE`	ENUM("Y","N","요청") DEFAULT "요청"	NULL,
	`CL_TC_ME_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `CURRICULUM`;

CREATE TABLE `CURRICULUM` (
	`CR_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`CR_TITLE`	VARCHAR(30) NOT	NULL,
	`CR_CL_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `REQUEST`;

CREATE TABLE `REQUEST` (
	`RQ_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`RQ_STATE`	ENUM("Y","N") DEFAULT "N"	NULL,
	`RQ_DATE`	DATETIME DEFAULT CURRENT_TIMESTAMP NOT	NULL,
	`RQ_CONTENT`	VARCHAR(100) NOT	NULL,
	`RQ_ME_NUM`	INT	NOT NULL
);

ALTER TABLE `THUMBNAIL` ADD CONSTRAINT `FK_CLASS_TO_THUMBNAIL_1` FOREIGN KEY (
	`TH_CL_NUM`
)
REFERENCES `CLASS` (
	`CL_NUM`
);

ALTER TABLE `SUBSCRIBE` ADD CONSTRAINT `FK_MEMBER_TO_SUBSCRIBE_1` FOREIGN KEY (
	`SU_ME_NUM`
)
REFERENCES `MEMBER` (
	`ME_NUM`
);

ALTER TABLE `SUBSCRIBE` ADD CONSTRAINT `FK_CLASS_TO_SUBSCRIBE_1` FOREIGN KEY (
	`SU_CL_NUM`
)
REFERENCES `CLASS` (
	`CL_NUM`
);

ALTER TABLE `VIDEO` ADD CONSTRAINT `FK_CURRICULUM_TO_VIDEO_1` FOREIGN KEY (
	`VD_CR_NUM`
)
REFERENCES `CURRICULUM` (
	`CR_NUM`
);

ALTER TABLE `TEACHER` ADD CONSTRAINT `FK_MEMBER_TO_TEACHER_1` FOREIGN KEY (
	`TC_ME_NUM`
)
REFERENCES `MEMBER` (
	`ME_NUM`
);

ALTER TABLE `SUBCATEGORY` ADD CONSTRAINT `FK_CATEGORY_TO_SUBCATEGORY_1` FOREIGN KEY (
	`SC_CA_NUM`
)
REFERENCES `CATEGORY` (
	`CA_NUM`
);

ALTER TABLE `SUBCATEGORY` ADD CONSTRAINT `FK_CLASS_TO_SUBCATEGORY_1` FOREIGN KEY (
	`SC_CL_NUM`
)
REFERENCES `CLASS` (
	`CL_NUM`
);

ALTER TABLE `COMMENT` ADD CONSTRAINT `FK_MEMBER_TO_COMMENT_1` FOREIGN KEY (
	`CO_ME_NUM`
)
REFERENCES `MEMBER` (
	`ME_NUM`
);

ALTER TABLE `COMMENT` ADD CONSTRAINT `FK_CLASS_TO_COMMENT_1` FOREIGN KEY (
	`CO_CL_NUM`
)
REFERENCES `CLASS` (
	`CL_NUM`
);

ALTER TABLE `CLASS` ADD CONSTRAINT `FK_TEACHER_TO_CLASS_1` FOREIGN KEY (
	`CL_TC_ME_NUM`
)
REFERENCES `TEACHER` (
	`TC_ME_NUM`
);

ALTER TABLE `CURRICULUM` ADD CONSTRAINT `FK_CLASS_TO_CURRICULUM_1` FOREIGN KEY (
	`CR_CL_NUM`
)
REFERENCES `CLASS` (
	`CL_NUM`
);

ALTER TABLE `REQUEST` ADD CONSTRAINT `FK_MEMBER_TO_REQUEST_1` FOREIGN KEY (
	`RQ_ME_NUM`
)
REFERENCES `MEMBER` (
	`ME_NUM`
);
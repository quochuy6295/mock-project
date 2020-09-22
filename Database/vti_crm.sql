-- create database vti_crm
DROP DATABASE IF EXISTS vti_crm;
CREATE DATABASE IF NOT EXISTS vti_crm;
USE vti_crm;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`team_id`		INT UNSIGNED,
`email`			VARCHAR(50) NOT NULL UNIQUE,
`password`		VARCHAR(60) NOT NULL ,
`name` 			NVARCHAR(50) NOT NULL,
`role` 			ENUM('ADMIN', 'TL', 'TV') NOT NULL
);

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
`id`			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
`name` 			NVARCHAR(50) NOT NULL UNIQUE,
`team_lead_id`	INT UNSIGNED NOT NULL UNIQUE,
FOREIGN KEY(`team_lead_id`) REFERENCES `user`(`id`) 
);

ALTER TABLE `user` ADD FOREIGN KEY (`team_id`) REFERENCES `team`(`id`); -- ON UPDATE CASCADE ON DELETE CASCADE(^^ đọc tài liệu cho chắc ko là toang ngay!!!)

DROP TABLE IF EXISTS 	`student` ;
CREATE TABLE `student` (
	`id`					BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`full_name`				NVARCHAR(30) NOT NULL,
	`gender`				ENUM('MALE', 'FEMALE', 'OTHER'),
	`phone_number`			VARCHAR(15) NOT NULL UNIQUE,
	`email`					VARCHAR(50) NOT NULL UNIQUE,
    `birthday`				DATE ,
    `school`				NVARCHAR(50),
	`address`				NVARCHAR(50),
    `social_info`			VARCHAR(50),
    `target`				ENUM('IT', 'NON_IT', 'TESTER'),
    `status`				ENUM('INTERESTING', 'NON_INTERESTING', 'OTHER'),
    `history_transaction`	NVARCHAR(100),
    `source`				ENUM('ONLINE', 'OFFLINE', 'EVENT'),
    `team_id`				INT UNSIGNED,
    `user_id`				INT UNSIGNED,
    `created_date`			DATETIME DEFAULT NOW(),
    FOREIGN KEY (`team_id`) REFERENCES `team`(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);


-- ------------------ INSERT DATA USE FOR TEST---------------------------
-- ----------------------------------------------------------------------

-- -- insert into user table
-- INSERT INTO `user` (`team_id`, `email`, `password`, `name`, `role`) VALUES (NULL, 'newton@gmail.com', 	'12345', 'newton', 	'ADMIN' );
-- INSERT INTO `user` (`team_id`, `email`, `password`, `name`, `role`) VALUES (NULL, 'bush@gmail.com', 	'12345', 'bush', 	'TL'	);
-- INSERT INTO `user` (`team_id`, `email`, `password`, `name`, `role`) VALUES (NULL, 'beckam@gmail.com', 	'12345', 'beckham', 'TL'	);
-- INSERT INTO `user` (`team_id`, `email`, `password`, `name`, `role`) VALUES (NULL, 'ronaldo@gmail.com', 	'12345', 'ronaldo', 'TV'	);
-- INSERT INTO `user` (`team_id`, `email`, `password`, `name`, `role`) VALUES (NULL, 'messi@gmail.com', 	'12345', 'messi', 	'TV'	);

-- -- insert into team table
-- INSERT INTO	`team` (`name`, `team_lead_id`) VALUES ('developer', 1);
-- INSERT INTO `team` (`name`, `team_lead_id`) VALUES ('java advance', 2);
-- INSERT INTO `team` (`name`, `team_lead_id`) VALUES ('CRM System', 3);
-- INSERT INTO `team` (`name`, `team_lead_id`) VALUES ('VTI Web', 4);
-- INSERT INTO `team` (`name`, `team_lead_id`) VALUES ('FrontEnd-Angular', 5); 


--  -- insert into student table
--  INSERT INTO `student` ( `full_name`, `gender`, `phone_number`, `email`, `birthday`, `school`, `address`, `social_info`, `target`, `status`, `history_transaction`, `source`, `team_id`, `user_id`, `created_date` ) 
--  VALUES ('nguyen hung manh', 'MALE', 0942103707, 'manhnh0903@gmail.com', '1986-09-03', 'Bach Khoa', 'Ha Noi', 'manh@facebook.com', 'NON_IT', 'INTERESTING', 'khai giang T4/2020', 'ONLINE', '', '', '2020-01-01');

--  INSERT INTO `student` ( `full_name`, `gender`, `phone_number`, `email`, `birthday`, `school`, `address`, `social_info`, `target`, `status`, `history_transaction`, `source`, `team_id`, `user_id`, `created_date` ) 
--  VALUES ( 'bui thu loan', 'FEMALE', 09861231234, 'thuloan0903@gmail.com', '1992-5-14', 'Ba Dinh', 'Ha Noi', 'loan@facebook.com', 'IT', 'NON_INTERESTING', 'khai giang T5/2020', 'ONLINE', '', '', '2020-02-02' );

--  INSERT INTO `student` (`full_name`, `gender`, `phone_number`, `email`, `birthday`, `school`, `address`, `social_info`, `target`, `status`, `history_transaction`, `source`, `team_id`, `user_id`, `created_date` ) 
--  VALUES ( 'tran quoc huy', 'MALE', 0123176873, 'quochuy@gmail.com', '1991-11-22', 'Hoang Mai', 'Ha Noi', 'huy@facebook.com', 'TESTER', 'NON_INTERESTING', 'Da lien he', 'OFFLINE', '', '', '2020-03-03');

--  INSERT INTO `student` ( `full_name`, `gender`, `phone_number`, `email`, `birthday`, `school`, `address`, `social_info`, `target`, `status`, `history_transaction`, `source`, `team_id`, `user_id`, `created_date` ) 
--  VALUES ( 'ha van hanh', 'MALE', 0988765342, 'hanhhv@gmail.com', '1994-9-13', 'Ha Dong', 'Ha Noi', 'hanh@facebook.com', 'IT', 'OTHER', 'hen lien lac lai sau', 'EVENT', '', '', '2020-04-04' );

--  INSERT INTO `student` ( `full_name`, `gender`, `phone_number`, `email`, `birthday`, `school`, `address`, `social_info`, `target`, `status`, `history_transaction`, `source`, `team_id`, `user_id`, `created_date` ) 
--  VALUES ( 'chau tinh tri', 'MALE', 0943876345, 'trict@gmail.com', '1995-7-18', 'Quoc Te', 'Dai Loan', 'tri@facebook.com', 'NON_IT', 'INTERESTING', 'Muon tim hieu them', 'EVENT', '', '', '2020-05-05');




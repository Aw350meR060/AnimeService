CREATE TABLE `directors` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `studios` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `animes` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`studio_id` BIGINT(20) NULL DEFAULT NULL,
	`director_id` BIGINT(20) NULL DEFAULT NULL,
	`air_date` DATE NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_animes_studios` (`studio_id`),
	INDEX `FK_animes_directors` (`director_id`),
	CONSTRAINT `FK_animes_directors` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `FK_animes_studios` FOREIGN KEY (`studio_id`) REFERENCES `studios` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)

CREATE TABLE `users` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NULL DEFAULT NULL,
	`password` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)

CREATE TABLE `roles` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`role` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)

CREATE TABLE `user_role` (
	`user_id` BIGINT(20) NOT NULL,
	`role_id` BIGINT(20) NOT NULL,
	INDEX `user_id` (`user_id`),
	INDEX `role_id` (`role_id`),
	CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
)
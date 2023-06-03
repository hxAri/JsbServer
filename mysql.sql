-- Adminer 4.8.1 MySQL 10.11.3-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `spring`;
CREATE DATABASE `spring` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `spring`;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

TRUNCATE `products`;
INSERT INTO `products` (`id`, `name`, `price`, `amount`) VALUES
(1,	'Processor Core I7 11TH Gen',	8.5,	10),
(2,	'Asus ROG Strix Gaming Motherboard B550-F',	3.475,	10),
(3,	'Asus ROG Phone 6 8/256 RAM 8GB ROM 256GB',	10.999,	8);

-- 2023-06-03 08:26:51

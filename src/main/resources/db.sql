# --------------------------------------------------------
# Host:                         127.0.0.1
# Server version:               5.6.18-enterprise-commercial-advanced
# Server OS:                    Win64
# HeidiSQL version:             6.0.0.3603
# Date/time:                    2015-04-15 00:48:48
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

# Dumping database structure for bestore
DROP DATABASE IF EXISTS `bestore`;
CREATE DATABASE IF NOT EXISTS `bestore` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bestore`;


# Dumping structure for table bestore.highmodule
DROP TABLE IF EXISTS `highmodule`;
CREATE TABLE IF NOT EXISTS `highmodule` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `layout_id` int(10) DEFAULT NULL,
  `order` int(10) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table bestore.highmodule_products
DROP TABLE IF EXISTS `highmodule_products`;
CREATE TABLE IF NOT EXISTS `highmodule_products` (
  `highmodule` int(10) DEFAULT NULL,
  `products` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

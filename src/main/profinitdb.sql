-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 08, 2016 at 11:44 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `profinitdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `addresstype`
--

CREATE TABLE IF NOT EXISTS `addresstype` (
  `county` varchar(50) NOT NULL,
  `streetnum` varchar(50) NOT NULL,
  `streetname` varchar(50) NOT NULL,
  `postalcode` varchar(50) NOT NULL,
  `citypart` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  PRIMARY KEY (`county`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `createcustomerchangeorder`
--

CREATE TABLE IF NOT EXISTS `createcustomerchangeorder` (
  `customer_birthnum` varchar(50) NOT NULL,
  `requestType` varchar(50) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customerdetailtype`
--

CREATE TABLE IF NOT EXISTS `customerdetailtype` (
  `countryoforigin` varchar(50) NOT NULL,
  `birthnum` varchar(50) NOT NULL,
  PRIMARY KEY (`birthnum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customerdetailtype_addresstype`
--

CREATE TABLE IF NOT EXISTS `customerdetailtype_addresstype` (
  `customerdetailtype_birthnum` varchar(50) NOT NULL,
  `address_county` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customerdetailtype_firstname`
--

CREATE TABLE IF NOT EXISTS `customerdetailtype_firstname` (
  `customerdetailtype_birthnum` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customerdetailtype_phonetype`
--

CREATE TABLE IF NOT EXISTS `customerdetailtype_phonetype` (
  `phonenum_phonenum` varchar(50) NOT NULL,
  `customerdetailtype_birthnum` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customerdetailtype_surname`
--

CREATE TABLE IF NOT EXISTS `customerdetailtype_surname` (
  `customerdetailtype_birthnum` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phonetype`
--

CREATE TABLE IF NOT EXISTS `phonetype` (
  `citycode` varchar(50) DEFAULT NULL,
  `countrycode` varchar(50) DEFAULT NULL,
  `phonenumbertype` bigint(20) NOT NULL,
  `phonenum` varchar(50) NOT NULL,
  PRIMARY KEY (`phonenum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

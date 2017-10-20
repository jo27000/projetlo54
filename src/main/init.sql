-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 06, 2017 at 10:48 AM
-- Server version: 5.5.55-0+deb8u1
-- PHP Version: 5.6.30-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `LO54`
--

-- --------------------------------------------------------

--
-- Table structure for table `CLIENT`
--

CREATE TABLE IF NOT EXISTS `CLIENT` (
`CLI_ID` int(10) NOT NULL,
  `CLI_LASTNAME` varchar(255) NOT NULL,
  `CLI_FIRSTNAME` varchar(255) NOT NULL,
  `CLI_ADDRESS` varchar(255) NOT NULL,
  `CLI_PHONE` varchar(10) NOT NULL,
  `CLI_EMAIL` varchar(255) DEFAULT NULL,
  `CS_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `COURSE`
--

CREATE TABLE IF NOT EXISTS `COURSE` (
  `COU_CODE` varchar(10) NOT NULL,
  `COU_TITLE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `COURSE_SESSION`
--

CREATE TABLE IF NOT EXISTS `COURSE_SESSION` (
`CS_ID` int(10) NOT NULL,
  `CS_START_DATE` datetime NOT NULL,
  `CS_END_DATE` datetime NOT NULL,
  `COU_CODE` varchar(10) NOT NULL,
  `LOC_ID` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `LOCATION`
--

CREATE TABLE IF NOT EXISTS `LOCATION` (
`LOC_ID` int(5) NOT NULL,
  `LOC_CITY` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CLIENT`
--
ALTER TABLE `CLIENT`
 ADD PRIMARY KEY (`CLI_ID`), ADD KEY `CS_ID` (`CS_ID`);

--
-- Indexes for table `COURSE`
--
ALTER TABLE `COURSE`
 ADD PRIMARY KEY (`COU_CODE`);

--
-- Indexes for table `COURSE_SESSION`
--
ALTER TABLE `COURSE_SESSION`
 ADD PRIMARY KEY (`CS_ID`), ADD KEY `COU_CODE` (`COU_CODE`), ADD KEY `LOC_ID` (`LOC_ID`);

--
-- Indexes for table `LOCATION`
--
ALTER TABLE `LOCATION`
 ADD PRIMARY KEY (`LOC_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CLIENT`
--
ALTER TABLE `CLIENT`
MODIFY `CLI_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `COURSE_SESSION`
--
ALTER TABLE `COURSE_SESSION`
MODIFY `CS_ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LOCATION`
--
ALTER TABLE `LOCATION`
MODIFY `LOC_ID` int(5) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `CLIENT`
--
ALTER TABLE `CLIENT`
ADD CONSTRAINT `CLIENT_ibfk_1` FOREIGN KEY (`CS_ID`) REFERENCES `COURSE_SESSION` (`CS_ID`);

--
-- Constraints for table `COURSE_SESSION`
--
ALTER TABLE `COURSE_SESSION`
ADD CONSTRAINT `COURSE_SESSION_ibfk_2` FOREIGN KEY (`LOC_ID`) REFERENCES `LOCATION` (`LOC_ID`),
ADD CONSTRAINT `COURSE_SESSION_ibfk_1` FOREIGN KEY (`COU_CODE`) REFERENCES `COURSE` (`COU_CODE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

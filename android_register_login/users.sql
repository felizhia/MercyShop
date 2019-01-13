-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2018 at 02:41 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_table`
--

CREATE TABLE `admin_table` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_table`
--

INSERT INTO `admin_table` (`id`, `name`, `email`, `password`) VALUES
(1, 'admin', 'admin@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `komen_table`
--

CREATE TABLE `komen_table` (
  `id` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `komen` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `komen_table`
--

INSERT INTO `komen_table` (`id`, `nama`, `komen`) VALUES
(6, 'velice', 'bagus sekali app ini sangat membantu pengguna'),
(7, 'Sasha', 'Fiturnya Bagus Semua'),
(8, 'Sasha', 'Fiturnya Bagus Semua'),
(9, 'Sasha', 'Fiturnya Bagus Semua'),
(10, 'Sasha', 'Fiturnya Bagus Semua');

-- --------------------------------------------------------

--
-- Table structure for table `pesan_tabel`
--

CREATE TABLE `pesan_tabel` (
  `id` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `no` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jne` varchar(10) NOT NULL,
  `jmlh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `refund_table`
--

CREATE TABLE `refund_table` (
  `id` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `no` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `kode` varchar(10) NOT NULL,
  `alasan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `refund_table`
--

INSERT INTO `refund_table` (`id`, `nama`, `no`, `alamat`, `kode`, `alasan`) VALUES
(1, 'verish', '0819726354', 'jl wono giri 1/4, jakarta barat', 'bg-5643', 'cacat fisik tidak lengkap, warna salah tidak hijau tua tetapi hijau muda');

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`id`, `name`, `email`, `password`) VALUES
(1, 'claudy', 'necroxclaudy@gmail.com', '$2y$10$fKW/fiWhAp0tsTKMAHg7U.bzWhu0w9Lzm5gchpbHyInf5NvIJJ9ze');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_table`
--
ALTER TABLE `admin_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `komen_table`
--
ALTER TABLE `komen_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pesan_tabel`
--
ALTER TABLE `pesan_tabel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `refund_table`
--
ALTER TABLE `refund_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_table`
--
ALTER TABLE `admin_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `komen_table`
--
ALTER TABLE `komen_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pesan_tabel`
--
ALTER TABLE `pesan_tabel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `refund_table`
--
ALTER TABLE `refund_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

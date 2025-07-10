-- phpMyAdmin SQL Dump
-- version 5.2.1deb3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 10, 2025 at 08:16 AM
-- Server version: 10.11.13-MariaDB-0ubuntu0.24.04.1
-- PHP Version: 8.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `UAS_JWP`
--

-- --------------------------------------------------------

--
-- Table structure for table `Barang`
--

CREATE TABLE `Barang` (
  `ID_barang` int(10) UNSIGNED NOT NULL,
  `Nama_barang` varchar(100) NOT NULL,
  `Jenis_barang` varchar(50) NOT NULL,
  `Stok` bigint(20) UNSIGNED NOT NULL,
  `Harga_barang` decimal(12,3) UNSIGNED NOT NULL,
  `Lama_garansi` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Barang`
--

INSERT INTO `Barang` (`ID_barang`, `Nama_barang`, `Jenis_barang`, `Stok`, `Harga_barang`, `Lama_garansi`) VALUES
(1, 'AMD Radion 5 5500U', 'Kartu Grafik', 500, 5000000.123, 12);

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE `Customer` (
  `ID_customer` int(10) UNSIGNED NOT NULL,
  `Nama_customer` varchar(100) NOT NULL,
  `Alamat_penagihan` text NOT NULL,
  `Telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`ID_customer`, `Nama_customer`, `Alamat_penagihan`, `Telepon`) VALUES
(1, 'Ananda Reynal', 'Ruko Mutiara Palem Indah blok C8 no 39', '087738881757');

-- --------------------------------------------------------

--
-- Table structure for table `Transaksi`
--

CREATE TABLE `Transaksi` (
  `ID_transaksi` bigint(20) UNSIGNED NOT NULL,
  `ID_customer` int(10) UNSIGNED NOT NULL,
  `Alamat_pengiriman` text NOT NULL,
  `Telepon` varchar(15) NOT NULL,
  `Lunas` tinyint(1) NOT NULL,
  `Tanggal_pembelian` date NOT NULL,
  `Tanggal_pengiriman` date NOT NULL,
  `Tabggal_pelunasan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Transaksi`
--

INSERT INTO `Transaksi` (`ID_transaksi`, `ID_customer`, `Alamat_pengiriman`, `Telepon`, `Lunas`, `Tanggal_pembelian`, `Tanggal_pengiriman`, `Tabggal_pelunasan`) VALUES
(1, 1, 'Ruko Mutiara Palem Indah blok C8 no 39', '087878402264', 0, '2025-03-23', '2025-09-05', '0000-00-00'),
(38, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(39, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(40, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(41, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(42, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(43, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(44, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(45, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(46, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(47, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(48, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(49, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(50, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(51, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(52, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(53, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(54, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(55, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(56, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(57, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(58, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(59, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(60, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(61, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(62, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(63, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(64, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(65, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(66, 1, 'Cengkareng', '087878402264', 0, '2025-06-28', '2025-03-25', NULL),
(67, 1, 'Cengkareng', '087878402264', 0, '2025-07-09', '2025-03-25', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Transaksi_barang`
--

CREATE TABLE `Transaksi_barang` (
  `ID_barang` int(10) NOT NULL,
  `ID_transaksi` int(10) NOT NULL,
  `Lama_garansi` int(10) UNSIGNED NOT NULL,
  `Jumlah_pembelian` int(10) NOT NULL,
  `Harga_satuan` decimal(12,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Transaksi_barang`
--

INSERT INTO `Transaksi_barang` (`ID_barang`, `ID_transaksi`, `Lama_garansi`, `Jumlah_pembelian`, `Harga_satuan`) VALUES
(1, 1, 12, 30, 5000000.123),
(1, 30, 12, 10, 5000000.123),
(1, 40, 12, 10, 5000000.123),
(1, 49, 12, 10, 5000000.123),
(1, 50, 12, 10, 5000000.123),
(1, 63, 12, 10, 5000000.123),
(1, 64, 12, 10, 5000000.123),
(1, 66, 12, 10, 5000000.123),
(1, 67, 12, 10, 5000000.123),
(1, 100, 12, 10, 5000000.123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Barang`
--
ALTER TABLE `Barang`
  ADD PRIMARY KEY (`ID_barang`);

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`ID_customer`);

--
-- Indexes for table `Transaksi`
--
ALTER TABLE `Transaksi`
  ADD PRIMARY KEY (`ID_transaksi`);

--
-- Indexes for table `Transaksi_barang`
--
ALTER TABLE `Transaksi_barang`
  ADD PRIMARY KEY (`ID_barang`,`ID_transaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Barang`
--
ALTER TABLE `Barang`
  MODIFY `ID_barang` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Customer`
--
ALTER TABLE `Customer`
  MODIFY `ID_customer` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Transaksi`
--
ALTER TABLE `Transaksi`
  MODIFY `ID_transaksi` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

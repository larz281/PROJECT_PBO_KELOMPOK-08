-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 29, 2023 at 05:37 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kantinkampus`
--

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` char(15) NOT NULL,
  `nama_karyawan` char(30) NOT NULL,
  `jenis_kelamin` char(10) NOT NULL,
  `alamat` char(50) NOT NULL,
  `passwordd` char(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `jenis_kelamin`, `alamat`, `passwordd`) VALUES
('aku', 'dadang', 'Laki-Laki', 'jl.kelurahan', 'kua'),
('kemal123', 'Kemal Fiqri Handoko', 'Laki-Laki', 'jl.sukaraja rt03/rw01 desa cijambe', 'mal123');

-- --------------------------------------------------------

--
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `id_makanan` char(15) NOT NULL,
  `nama_makanan` char(15) NOT NULL,
  `harga_makanan` int(10) NOT NULL,
  `id_pelanggan` char(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`id_makanan`, `nama_makanan`, `harga_makanan`, `id_pelanggan`) VALUES
('Cau', 'Pisang', 2000, 'P003'),
('MK01', 'Bakso', 12000, 'P002'),
('MK02', 'Mie Ayam', 15000, 'P002');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` char(15) NOT NULL,
  `nama_pelanggan` char(30) NOT NULL,
  `alamat` char(50) NOT NULL,
  `jenis_kelamin` char(15) NOT NULL,
  `id_karyawan` char(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `alamat`, `jenis_kelamin`, `id_karyawan`) VALUES
('P001', 'Teguh Gumelar', 'jl.dayeuh', 'Laki-Laki', 'kemal123'),
('P002', 'Vikri Razvi Alfa Rizi', 'jl.parkud', 'Laki-Laki', 'kemal123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`id_makanan`),
  ADD KEY `INDEX` (`id_pelanggan`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`),
  ADD KEY `INDEX` (`id_karyawan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

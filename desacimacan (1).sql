-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2022 at 05:27 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `desacimacan`
--

-- --------------------------------------------------------

--
-- Table structure for table `agama`
--

CREATE TABLE `agama` (
  `id_agama` int(11) NOT NULL,
  `agama` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `agama`
--

INSERT INTO `agama` (`id_agama`, `agama`) VALUES
(0, 'Pilih Agama'),
(1, 'Islam'),
(2, 'Kristen'),
(3, 'Katholik'),
(4, 'Hindu'),
(5, 'Budha'),
(6, 'Khonghuchu');

-- --------------------------------------------------------

--
-- Table structure for table `kedatangan`
--

CREATE TABLE `kedatangan` (
  `no` int(11) NOT NULL,
  `no_kk` varchar(30) DEFAULT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_entry` date DEFAULT NULL,
  `ket` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kedatangan`
--

INSERT INTO `kedatangan` (`no`, `no_kk`, `nik`, `nama`, `jk`, `tl`, `tgl_lahir`, `gol_dar`, `no_agama`, `no_shdrt`, `ayah`, `ibu`, `tgl_entry`, `ket`) VALUES
(1, '1420023820952', '3204254101950053', 'NINA HARTATI', 2, 'BANDUNG', '1995-03-27', 'B', 1, 3, 'IBAH', 'EUIS HALIMAH', '2023-08-03', ''),
(2, '1420026820827', '3211145601010011', 'MAESAROH', 2, 'SUMEDANG', '2001-01-16', 'O', 1, 3, 'AJANG', 'HASANAH', '2020-08-06', ''),
(4, '14200224820115', '3273052207900001', 'DANI RISNANDAR', 1, 'BANDUNG', '1990-07-22', 'O', 1, 1, 'EVA HARIS', 'SURYANI', '2020-08-24', ''),
(5, '142002248201349', '3211145707590003', 'ANI', 2, 'SUMEDANG', '1959-07-17', 'A', 1, 1, 'AHMAD', 'ANAH', '2022-08-18', ''),
(6, '3211142112100111', '3205274506020001', 'VIA APIANI R', 2, 'GARUT', '2002-06-05', 'B', 1, 4, 'ADE SOPAN SOPIAN', 'WINDA WATI', '2018-08-16', ''),
(9, '32121312', '22323', 'helmi', 1, 'cianjur', '2022-01-17', 'A', 1, 2, 'ayahh', 'dimah', '2022-01-17', 'asdas');

-- --------------------------------------------------------

--
-- Table structure for table `kelahiran`
--

CREATE TABLE `kelahiran` (
  `no` int(11) NOT NULL,
  `no_kk` varchar(30) DEFAULT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_entry` date DEFAULT NULL,
  `ket` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelahiran`
--

INSERT INTO `kelahiran` (`no`, `no_kk`, `nik`, `nama`, `jk`, `tl`, `tgl_lahir`, `gol_dar`, `no_agama`, `no_shdrt`, `ayah`, `ibu`, `tgl_entry`, `ket`) VALUES
(1, '3211142807100016', '142002882093', 'MUHAMAD RASYA ADITYA', 1, 'SUMEDANG', '2020-08-08', '', 1, 4, 'HERMANSYAH', 'ERNI KURNIAWATI', '2020-08-31', ''),
(12, '3213213', '31231232', 'Fawwaz ahmad', 1, 'Cianjur', '2022-01-17', 'A', 1, 2, 'subardiman', 'Yanti', '2022-01-17', 'pindah'),
(13, '2312', '1321', 'asd', 1, 'asd', '2022-01-12', 'AB', 2, 2, 'asdas', 'asdas', '2022-01-11', 'asdsas'),
(14, '3213124', '321312', 'Sule', 1, 'cjr', '2022-01-12', 'A', 1, 4, 'Diman', 'Yanti', '2022-01-20', 'Lahir');

-- --------------------------------------------------------

--
-- Table structure for table `kematian`
--

CREATE TABLE `kematian` (
  `no` int(11) NOT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `no_pekerjaan` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_kematian` date DEFAULT NULL,
  `tgl_lapor` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kematian`
--

INSERT INTO `kematian` (`no`, `nik`, `nama`, `jk`, `tl`, `tgl_lahir`, `gol_dar`, `no_agama`, `no_shdrt`, `no_pekerjaan`, `ayah`, `ibu`, `tgl_kematian`, `tgl_lapor`) VALUES
(1, '3211141208630006', 'WAHYU', 1, 'SUMEDANG', '1963-08-12', 'B', 1, 1, 80, '', 'ATING', '2020-07-31', '2020-08-03'),
(2, '3211144711190001', 'SHAKAILA YUMNA', 2, 'BANDUNG', '2019-11-07', 'AB', 1, 4, 1, 'ARI YUNIAR', 'HANA FAUZIAH', '2018-08-06', '2020-08-10'),
(3, '3273151112830001', 'IYOS KOSWARA', 1, 'SUMEDANG', '1983-12-11', 'A', 1, 1, 19, 'UYE', 'SITI KHODIJAH', '2019-08-06', '2021-08-10'),
(4, '3211145505650013', 'ACAH', 2, 'SUMEDANG', '1965-05-15', 'O', 1, 1, 2, 'USUP', 'EDOH', '2020-08-11', '2020-08-12'),
(6, '3203041306000002', 'Helmi Sulaeman', 1, 'Cianjur', '2022-01-13', 'A', 1, 1, 1, 'Subardiman', 'Yanti Rohayati', '2022-01-15', '2022-01-14'),
(10, '321321312', 'asep', 1, 'cjr', '2022-01-11', 'B', 1, 1, 1, 'as', 'ds', '2022-01-11', '2022-01-10');

-- --------------------------------------------------------

--
-- Table structure for table `pekerjaan`
--

CREATE TABLE `pekerjaan` (
  `id_pekerjaan` int(11) NOT NULL,
  `pekerjaan` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pekerjaan`
--

INSERT INTO `pekerjaan` (`id_pekerjaan`, `pekerjaan`) VALUES
(0, 'Pilih Pekerjaan'),
(1, 'Belum/Tidak bekerja'),
(2, 'Mengurus Rumah Tangga'),
(3, 'Pelajar/Mahasiswa'),
(4, 'Pensiunan'),
(5, 'Pegawai Negri Sipil'),
(6, 'TNI'),
(7, 'POLRI'),
(8, 'Perdagangan'),
(9, 'Petani/Pekebun'),
(10, 'Peternak'),
(11, 'Nelayan/Perikanan'),
(12, 'Industri'),
(13, 'Konstruksi'),
(14, 'Transportasi'),
(15, 'Karyawan Swasta'),
(16, 'Karyawan BUMN'),
(17, 'Karyawan BUMD'),
(18, 'Karyawan Honorer'),
(19, 'Buruh Harian Lepas'),
(20, 'Buruh Tani/Pekebunan'),
(21, 'Buruh Nelayan/Perikanan'),
(22, 'Buruh Pertenakan'),
(23, 'Pembantu Rumah Tangga'),
(24, 'Tukang Cukur'),
(25, 'Tukang Listrik'),
(26, 'Tukang Batu'),
(65, 'Dosen'),
(66, 'Pilot'),
(67, 'Pengacara'),
(68, 'Notaris'),
(69, 'Arsitek'),
(70, 'Akuntan'),
(71, 'Konsultan'),
(72, 'Dokter'),
(73, 'Bidan'),
(74, 'Perawat'),
(79, 'Pelaut'),
(80, 'Wiraswasta'),
(81, 'Sopir'),
(84, 'Pedagang'),
(85, 'Perangkat Desa'),
(86, 'Kepala Desa'),
(89, 'Jasa Lainnya');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `nip` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`nip`, `nama`, `jabatan`, `username`, `password`) VALUES
(32131231, 'Aden Deden S.Pd', 'Kepala Desa Cimacan', NULL, NULL),
(321312313, 'Helmi Sulaemann', 'Petugas Registrasi', 'admin1', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `pindah`
--

CREATE TABLE `pindah` (
  `no` int(11) NOT NULL,
  `no_kk` varchar(30) DEFAULT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jk` int(1) DEFAULT NULL,
  `tl` varchar(255) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `gol_dar` varchar(2) DEFAULT NULL,
  `no_agama` int(11) DEFAULT NULL,
  `no_shdrt` int(11) DEFAULT NULL,
  `no_pekerjaan` int(11) DEFAULT NULL,
  `ayah` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `tgl_pindah` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pindah`
--

INSERT INTO `pindah` (`no`, `no_kk`, `nik`, `nama`, `jk`, `tl`, `tgl_lahir`, `gol_dar`, `no_agama`, `no_shdrt`, `no_pekerjaan`, `ayah`, `ibu`, `tgl_pindah`, `tgl_update`) VALUES
(1, '3211141803064434', '3211146601950002', 'RISMAYANI LIDRIYANTY', 2, 'BANDUNG', '1995-01-26', 'O', 1, 4, 15, 'AGUS KOSWARA', 'EUIS SETIAWATI', '2022-08-12', '1000-01-01'),
(2, '3211141008110008', '3211141606880008', 'TARYANA', 1, 'BOJONG', '1980-06-16', 'AB', 1, 1, 80, 'SAIM', 'MINAH', '2019-08-10', '1000-01-02'),
(4, '3211142210150008', '3211142307710001', 'DEDE SUHERMAN', 1, 'cipanas', '1971-07-24', 'B', 1, 1, 80, 'IA KARSA', 'WOWOH', '2019-08-07', '1000-01-01'),
(6, '3211141703063497', '3211145605930008', 'RIZKA NURUL ZAJIAH', 2, 'SUMEDANG', '1993-05-16', 'A', 1, 4, 1, 'OOM KOMARUDIN', 'SITI KHODIJAH', '2022-08-11', '1000-01-01'),
(8, '142002110191013', '3211142606880004', 'RIDWAN JUNIADI', 1, 'BANDUNG', '1988-06-26', 'O', 1, 4, 3, 'RIDWAN JUNAEDI', 'AI DEWI', '2021-08-05', '1000-01-01'),
(11, '142002110191013', '3211147108940005', 'EFA AGUSTINA', 2, 'SUMEDANG', '1994-08-31', 'A', 1, 3, 80, 'DIDIN ROHAENDI', 'NANI SUMARNI', '2022-08-18', '1000-01-01'),
(12, '3211140612100009', '3211144705960015', 'YAYU MELANI', 2, 'cianjur', '1996-05-07', 'A', 1, 4, 1, 'ASEP SUDRAJAT', 'YULIATI', '2021-08-27', '1000-01-03'),
(13, '123213', '21312', 'dava', 1, 'cjr', '2022-01-11', 'B', 1, 2, 1, 'asdas', 'adas', '2022-01-04', '2022-01-19');

-- --------------------------------------------------------

--
-- Table structure for table `profil_desa`
--

CREATE TABLE `profil_desa` (
  `desa` varchar(255) DEFAULT NULL,
  `kecamatan` varchar(255) DEFAULT NULL,
  `kabupaten` varchar(255) DEFAULT NULL,
  `provinsi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profil_desa`
--

INSERT INTO `profil_desa` (`desa`, `kecamatan`, `kabupaten`, `provinsi`) VALUES
('07 Cimacan', '20 CIANJUR', '11 CIANJUR', '32 JAWA BARAT');

-- --------------------------------------------------------

--
-- Table structure for table `shdrt`
--

CREATE TABLE `shdrt` (
  `id_shdrt` int(11) NOT NULL,
  `shdrt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shdrt`
--

INSERT INTO `shdrt` (`id_shdrt`, `shdrt`) VALUES
(0, 'Pilih SHDRT'),
(1, 'Kepala Keluarga'),
(2, 'Suami'),
(3, 'Istri'),
(4, 'Anak'),
(5, 'Menantu'),
(6, 'Cucu'),
(7, 'Orang Tua'),
(8, 'Mertua'),
(9, 'Pembantu'),
(10, 'Lainnya');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agama`
--
ALTER TABLE `agama`
  ADD PRIMARY KEY (`id_agama`);

--
-- Indexes for table `kedatangan`
--
ALTER TABLE `kedatangan`
  ADD PRIMARY KEY (`no`),
  ADD KEY `no_agama` (`no_agama`),
  ADD KEY `no_shdrt` (`no_shdrt`);

--
-- Indexes for table `kelahiran`
--
ALTER TABLE `kelahiran`
  ADD PRIMARY KEY (`no`),
  ADD KEY `no_agama` (`no_agama`),
  ADD KEY `no_shdrt` (`no_shdrt`);

--
-- Indexes for table `kematian`
--
ALTER TABLE `kematian`
  ADD PRIMARY KEY (`no`),
  ADD KEY `no_agama` (`no_agama`),
  ADD KEY `no_shdrt` (`no_shdrt`),
  ADD KEY `no_pekerjaan` (`no_pekerjaan`);

--
-- Indexes for table `pekerjaan`
--
ALTER TABLE `pekerjaan`
  ADD PRIMARY KEY (`id_pekerjaan`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `pindah`
--
ALTER TABLE `pindah`
  ADD PRIMARY KEY (`no`),
  ADD KEY `no_agama` (`no_agama`),
  ADD KEY `no_shdrt` (`no_shdrt`),
  ADD KEY `no_pekerjaan` (`no_pekerjaan`);

--
-- Indexes for table `shdrt`
--
ALTER TABLE `shdrt`
  ADD PRIMARY KEY (`id_shdrt`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kedatangan`
--
ALTER TABLE `kedatangan`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `kelahiran`
--
ALTER TABLE `kelahiran`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `kematian`
--
ALTER TABLE `kematian`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pindah`
--
ALTER TABLE `pindah`
  MODIFY `no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kedatangan`
--
ALTER TABLE `kedatangan`
  ADD CONSTRAINT `kedatangan_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `kedatangan_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kelahiran`
--
ALTER TABLE `kelahiran`
  ADD CONSTRAINT `kelahiran_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `kelahiran_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kematian`
--
ALTER TABLE `kematian`
  ADD CONSTRAINT `kematian_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `kematian_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `kematian_ibfk_3` FOREIGN KEY (`no_pekerjaan`) REFERENCES `pekerjaan` (`id_pekerjaan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pindah`
--
ALTER TABLE `pindah`
  ADD CONSTRAINT `pindah_ibfk_1` FOREIGN KEY (`no_agama`) REFERENCES `agama` (`id_agama`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pindah_ibfk_2` FOREIGN KEY (`no_shdrt`) REFERENCES `shdrt` (`id_shdrt`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pindah_ibfk_3` FOREIGN KEY (`no_pekerjaan`) REFERENCES `pekerjaan` (`id_pekerjaan`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jan 2023 pada 09.19
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_aset`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_aset`
--

CREATE TABLE `tbl_aset` (
  `id_aset` int(11) NOT NULL,
  `nama_aset` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_aset`
--

INSERT INTO `tbl_aset` (`id_aset`, `nama_aset`) VALUES
(1, 'Laptop'),
(5, 'Router'),
(6, 'Mikrotik RB750 GR2'),
(9, 'Mikrotik RB750 GR3'),
(10, 'Modem'),
(11, 'Switch Hub'),
(13, 'Mobil'),
(14, 'Motor'),
(17, 'Bajai'),
(19, 'Laptop Lenovo Ideapad 110_15ast'),
(20, 'Bitcoin'),
(21, 'Etherium');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_keluar`
--

CREATE TABLE `tbl_keluar` (
  `id_keluar` int(11) NOT NULL,
  `tanggal_keluar` varchar(100) NOT NULL,
  `id_aset` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_keluar`
--

INSERT INTO `tbl_keluar` (`id_keluar`, `tanggal_keluar`, `id_aset`) VALUES
(3, '05-January-2023', 5),
(4, '14-January-2023', 9),
(5, '07-January-2023', 6),
(6, '02-January-2023', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_login`
--

CREATE TABLE `tbl_login` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_login`
--

INSERT INTO `tbl_login` (`id`, `username`, `password`) VALUES
(1, 'Ashada', 'admin'),
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_lokasi`
--

CREATE TABLE `tbl_lokasi` (
  `id_lokasi` int(11) NOT NULL,
  `nama_lokasi` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_lokasi`
--

INSERT INTO `tbl_lokasi` (`id_lokasi`, `nama_lokasi`) VALUES
(3, 'Ruangan Direktur'),
(4, 'Ruangan Administrasi'),
(5, 'Ruangan Sekertaris'),
(6, 'Ruangan Bendahara'),
(7, 'Ruangan Management'),
(8, 'Ruang Utama'),
(9, 'Gudang'),
(11, 'Garasi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_masuk`
--

CREATE TABLE `tbl_masuk` (
  `id_masuk` int(11) NOT NULL,
  `tanggal_masuk` varchar(100) NOT NULL,
  `id_aset` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_masuk`
--

INSERT INTO `tbl_masuk` (`id_masuk`, `tanggal_masuk`, `id_aset`) VALUES
(1, '15-Desember-2022', 6),
(5, '30-December-2022', 1),
(6, '05-December-2022', 5),
(7, '01-December-2022', 10),
(8, '03-November-2022', 9),
(9, '05-January-2022', 11),
(10, '30-December-2022', 13),
(11, '30-December-2022', 14),
(18, '04-January-2023', 17),
(19, '04-January-2023', 19),
(20, '07-January-2023', 20),
(21, '07-January-2023', 21);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_penempatan`
--

CREATE TABLE `tbl_penempatan` (
  `id_penempatan` int(11) NOT NULL,
  `id_aset` int(11) NOT NULL,
  `id_lokasi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbl_penempatan`
--

INSERT INTO `tbl_penempatan` (`id_penempatan`, `id_aset`, `id_lokasi`) VALUES
(2, 6, 7),
(3, 9, 8),
(5, 10, 3),
(7, 13, 11),
(8, 17, 11),
(9, 1, 3),
(10, 19, 4),
(11, 5, 5);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_aset`
--
ALTER TABLE `tbl_aset`
  ADD PRIMARY KEY (`id_aset`);

--
-- Indeks untuk tabel `tbl_keluar`
--
ALTER TABLE `tbl_keluar`
  ADD PRIMARY KEY (`id_keluar`),
  ADD KEY `id_aset` (`id_aset`);

--
-- Indeks untuk tabel `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tbl_lokasi`
--
ALTER TABLE `tbl_lokasi`
  ADD PRIMARY KEY (`id_lokasi`);

--
-- Indeks untuk tabel `tbl_masuk`
--
ALTER TABLE `tbl_masuk`
  ADD PRIMARY KEY (`id_masuk`),
  ADD KEY `id_aset` (`id_aset`);

--
-- Indeks untuk tabel `tbl_penempatan`
--
ALTER TABLE `tbl_penempatan`
  ADD PRIMARY KEY (`id_penempatan`),
  ADD KEY `id_aset` (`id_aset`),
  ADD KEY `id_lokasi` (`id_lokasi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbl_aset`
--
ALTER TABLE `tbl_aset`
  MODIFY `id_aset` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT untuk tabel `tbl_keluar`
--
ALTER TABLE `tbl_keluar`
  MODIFY `id_keluar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tbl_login`
--
ALTER TABLE `tbl_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tbl_lokasi`
--
ALTER TABLE `tbl_lokasi`
  MODIFY `id_lokasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `tbl_masuk`
--
ALTER TABLE `tbl_masuk`
  MODIFY `id_masuk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT untuk tabel `tbl_penempatan`
--
ALTER TABLE `tbl_penempatan`
  MODIFY `id_penempatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tbl_keluar`
--
ALTER TABLE `tbl_keluar`
  ADD CONSTRAINT `tbl_keluar_ibfk_1` FOREIGN KEY (`id_aset`) REFERENCES `tbl_aset` (`id_aset`);

--
-- Ketidakleluasaan untuk tabel `tbl_masuk`
--
ALTER TABLE `tbl_masuk`
  ADD CONSTRAINT `tbl_masuk_ibfk_1` FOREIGN KEY (`id_aset`) REFERENCES `tbl_aset` (`id_aset`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tbl_penempatan`
--
ALTER TABLE `tbl_penempatan`
  ADD CONSTRAINT `tbl_penempatan_ibfk_1` FOREIGN KEY (`id_aset`) REFERENCES `tbl_aset` (`id_aset`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_penempatan_ibfk_2` FOREIGN KEY (`id_lokasi`) REFERENCES `tbl_lokasi` (`id_lokasi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

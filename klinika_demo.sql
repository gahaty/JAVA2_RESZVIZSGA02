-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
<<<<<<< HEAD
-- Létrehozás ideje: 2020. Dec 04. 19:21
=======
-- Létrehozás ideje: 2020. Dec 03. 20:43
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094
-- Kiszolgáló verziója: 10.4.14-MariaDB
-- PHP verzió: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `klinika_demo`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `betegek`
--

CREATE TABLE `betegek` (
  `betegek_id` int(11) NOT NULL,
  `nev` varchar(30) NOT NULL,
  `cim` varchar(50) NOT NULL,
  `tel` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `ht_nev` varchar(30) NOT NULL,
  `ht_cim` varchar(50) NOT NULL,
  `ht_tel` int(10) NOT NULL,
  `ht_email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `betegek`
--

INSERT INTO `betegek` (`betegek_id`, `nev`, `cim`, `tel`, `email`, `ht_nev`, `ht_cim`, `ht_tel`, `ht_email`) VALUES
<<<<<<< HEAD
(1, 'Balla Ilona', 'Monori u.32.', 321356, 'bail@freemail.hu', 'Keskeny György', 'Néma u. 12.', 321356, 'kegyo@gmail.com'),
(2, 'Léha Kálmán', 'Síp u.21.', 564615, 'leka@freemail.hu', 'Bereg Klára', 'Nagyárok út 10.', 564615, 'bekl@freemail.hu'),
(3, 'Bébi Orsolya', 'Haladó u. 4.', 869654, 'beor@freemail.hu', 'Kiss Péter', 'Moha tér 4.', 869654, 'kipe@freemail.hu'),
(4, 'Béla Imre', 'Varsó u. 43.', 849533, 'beim@gmail.com', 'Mala László', 'Pálffy u. 21.', 849533, 'mala@gmail.com');
=======
(3, 'Kiss Albert', 'Rozgonyi utca 50.', 518561, 'rozgonyi@gmail.com', 'Nagy Fióna', 'Vedres utca 6.', 1456511, 'fioncsi@gmail.com'),
(4, 'Nagy Tamás', 'Hosszú sor. 2.', 1865981, 'ntomi@freemail.hu', 'Horváth Ilona', 'Hosszú sor. 2.', 5141461, 'hilike@gmail.com'),
(5, 'Barta Árpád', 'Szigony u. 5.', 156165, 'b.arpi@fremail.hu', 'Nagy Áron', 'Maros u. 12.', 15641251, 'naron@gmail.com'),
(6, 'Juhász Kálmán', 'Bereg sor 4.', 4891616, 'juhikalmi@mail.com', 'Késő Orsolya', 'Mák utca 3.', 98981654, 'korsika@gmail.com'),
(11, 'Horváth Aranka', 'Berzsenyi u. 2.', 874892, 'haranka@gmail.com', 'Nagy Ibolya', 'Szobránc köz 3.', 874892, 'nagyibi@freemail.hu'),
(12, 'Barna Péter', 'Harap u. 4.', 56155648, 'barnapeti@gmail.com', 'Elek Sára', 'Vajda út 8.', 56155648, 'esari@freemail.hu'),
(14, 'Sólyom Gergő', 'Hosszú u. 12.', 5665456, 'soge@gmail.com', 'Hrk Béla', 'Tóth Tihamér', 5665456, 'tihi@freemail.hu'),
(15, 'Kiss Aladár', 'Bereg köz 4.', 565615, 'kali@gmail.com', 'Nagy Béla', 'Meghat utca 6.', 565615, 'nb@gmail.com'),
(16, 'Big Tamás', 'Hosszú utca 7.', 1681531, 'bita@gmail.com', 'Mahó Boglárka', 'Bereg köz 5.', 1681531, 'mabo@freemail.hu'),
(17, 'Bele Zoltánné', 'Mara u. 7.', 456161, 'bez@freemail.hu', 'Kala Imre', 'kalimi@gmail.com', 456161, 'kali@gmail.com'),
(18, 'Beteg Ilona', 'Mikor köz 5.', 8486463, 'beil@gmail.com', 'Kis Jakab', 'Berek út 8.', 8486463, 'kija@freemail.hu'),
(19, 'Meleg Gáspár', 'Hati u. 3.', 4684654, 'mega@freemail.hu', 'Meleg Árpád', 'Hati u. 3.', 4684654, 'megaenis@gmail.com'),
(20, 'Marton Anita', 'Lehel u. 6.', 84916165, 'matina@gmail.com', 'Béla Zoltán', 'Magyar u. 23.', 84916165, 'bezo@gmail.com'),
(21, 'KIss Áron', 'Hideg Ferenc', 181686, 'hife@gmial.com', 'László Dóra', 'László Emil', 181686, 'lamil@freemail.hu'),
(22, 'Margit Izolda', 'Bereg tér 2.', 1161618, 'mazolda@gmail.com', 'Nem István', 'Siha köz 5.', 1161618, 'nemi@freemail.hu'),
(23, 'Nagy Elemér', 'Bene u. 5.', 846168, 'nele@freemail.hu', 'Nyúl Áron', 'Léka u. 2.', 846168, 'nyar@freemail.hu'),
(24, 'Horvát Károly', 'Szegedi u. 2', 68468, 'hoka@freemail.hu', 'Imre Zsolt', 'Király u. 2.', 68468, 'izso@gmail.com'),
(25, 'Gáspár Imola', 'Szecsődi u. 8.', 1816851, 'gaim@gmail.com', 'Szilva Péter', 'Lemó u. 2.', 1816851, 'szipe@freemail.hu'),
(26, 'Hála Miklós', 'Ló u. 4.', 886866, 'hami@freemial.hu', 'Piros Ödön', 'Liget köz 5.', 886866, 'piod@freemail.hu'),
(27, 'Érsek Péter', 'Tót köz 8.', 156816, 'erpetike@freemail.hu', 'Virág János', 'vija@freemail.hu', 156816, 'vija@freemail.hu'),
(28, 'Mala László', 'Horgony u. 23.', 6541681, 'mala@freemail.hu', 'Orosz Margit', 'Veres köz 3.', 6541681, 'oma@freemail.hu'),
(29, 'Hála Kristóf', 'Nemes u. 7.', 5864168, 'nekri@freemail.hu', 'Cecil Lara', 'Még u. 45.', 5864168, 'cela@gmail.com'),
(30, 'Hét Károly', 'Doboz u. 32.', 56168, 'heka@freemail.hu', 'Virág János', 'Kele út 4.', 56168, 'vija@freemail.hu'),
(31, 'Beteg Elek', 'Híres út 56.', 186186, 'bele@freemail.hu', 'Eper Attila', 'Mondom u. 32.', 186186, 'epat@gmail.com'),
(32, 'q', 'q', 1, 'q', 'q', 'q', 1, 'q'),
(33, 'w', 'w', 2, 'w', 'w', 'w', 2, 'w'),
(34, '1', '1', 1, '1', '1', '1', 1, '1'),
(35, 'a', 'a', 3, 'a', 'a', 'a', 3, 'a'),
(36, 'r', 'r', 4, 'r', 'r', 'r', 4, 'r'),
(37, 'jakfkjanfkae', 'segersg', 65464, 'rthrthtrh', 'hrthrthr', 'tzjttz', 65464, 'rttzrz'),
(38, 'qw', 'qw', 12, 'qw', 'qw', 'qw', 12, 'qw'),
(39, 're', 're', 54, 're', 're', 're', 54, 're'),
(40, 'wq', 'wq', 21, 'wq', 'wq', 'wq', 21, 'wq'),
(41, 'rt', 'rt', 56, 'rt', 'rt', 'rt', 56, 'rt'),
(42, 'yx', 'yx', 12, 'yx', 'yx', 'yx', 12, 'yx'),
(43, 'da', 'da', 31, 'da', 'da', 'da', 31, 'da'),
(44, 'qw qw', 'qwqw', 21, 'dsds', 'dsdds', 'gfgf', 21, 'hghg'),
(45, 'bvy', 'bvy', 321, 'bvyc', 'bvy', 'bvy', 321, 'bvc'),
(46, 'cxy', 'cxy', 321, 'cxy', 'cxy', 'cxy', 321, 'cxy'),
(47, 'ewq', 'ewq', 321, 'ewq', 'ewq', 'ewq', 321, 'ewq'),
(48, '', 'cxy', 231, 'cxy', 'cxy', 'cxy', 231, 'cxy'),
(49, 'ewq', 'ewq', 321, 'ewq', 'ewq', 'ewq', 321, 'ewq'),
(50, 'cxy', 'cxy', 321, 'cxy', '321', 'cxy', 321, 'cxy'),
(51, 'cxy', 'cxy', 123, 'cxy', 'cxy', 'cxy', 123, 'yxc'),
(52, 'cxy', 'cxy', 123, 'cxy', 'cxy', 'cxy', 123, 'cxy'),
(53, 'cxy', 'cxy', 123, 'cxy', 'cxy', 'cxy', 123, 'cxy'),
(54, 'fds', 'fds', 321, 'fds', 'fds', 'fds', 321, 'rew'),
(55, 'bvc', 'bvc', 321, 'bvc', 'bvc', 'bvc', 321, '321'),
(56, 'nbv', 'nbv', 321, 'nbv', 'nbv', 'nbv', 321, 'nbv'),
(57, 'nmb', 'mnb', 321, 'mnb', 'mnb', 'mnb', 321, 'mnb'),
(58, 'mnb', 'mnb', 123, 'mnb', 'mnb', 'mnb', 123, 'mnb'),
(59, 'ztr', 'ztr', 321, 'ztr', 'ztr', 'ztr', 321, 'ztr'),
(60, 'ewq', 'ewq', 123, 'ewq', 'ewq', 'ewq', 123, 'ewq'),
(61, 'cxy', 'cxy', 123, 'cxy', 'cxy', 'cxy', 123, 'cxy'),
(62, 'ewq', 'ewq', 321, 'ewq', 'ewq', 'ewq', 321, 'ewq'),
(63, 'cxy', 'cxy', 321, 'cxy', 'cxy', 'cxy', 321, 'cxy'),
(64, 'cxy', 'cxy', 987, 'cxy', 'cxy', 'cxy', 987, 'cxy'),
(65, 'ewq', 'ewq', 321, 'ewq', 'ewq', 'ewq', 321, 'ewq'),
(66, 'ewq', 'ewq', 321, 'ewq', 'ewq', 'ewq', 321, 'ewq'),
(67, 'ewq', 'ewq', 123, 'ewq', 'ewq', 'ewq', 123, 'ewq');
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `datum`
--

CREATE TABLE `datum` (
  `datum_id` int(11) NOT NULL,
  `datum` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `datum`
--

INSERT INTO `datum` (`datum_id`, `datum`) VALUES
<<<<<<< HEAD
(1, '2020-12-07');
=======
(1, '2020-12-07'),
(2, '2020-12-08'),
(8, '2020-10-01'),
(9, '2020-12-01'),
(10, '2020-12-20'),
(12, '2020-01-01'),
(26, '2020-01-10'),
(27, '2020-01-11'),
(28, '2020-01-12'),
(29, '2020-01-13'),
(30, '2020-12-20'),
(31, '2020-12-20'),
(32, '2020-12-20'),
(33, '2020-12-20'),
(34, '2020-12-20'),
(35, '2020-12-30'),
(36, '2020-01-14'),
(37, '2020-01-15'),
(38, '2020-12-21'),
(39, '2020-05-20'),
(40, '2002-02-20'),
(41, '2002-12-20'),
(42, '2020-01-20'),
(43, '2020-12-02'),
(44, '2020-12-11'),
(45, '2020-02-01'),
(46, '2020-01-30'),
(47, '2020-01-21'),
(48, '2012-01-01'),
(49, '2020-12-12'),
(50, '2020-12-10');
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `idopont`
--

CREATE TABLE `idopont` (
  `idopont_id` int(11) NOT NULL,
  `idopont` time NOT NULL,
  `megjelenit` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `idopont`
--

INSERT INTO `idopont` (`idopont_id`, `idopont`, `megjelenit`) VALUES
(1, '08:00:00', 1),
(2, '08:30:00', 1),
(3, '09:00:00', 1),
<<<<<<< HEAD
(4, '09:30:00', 0),
=======
(4, '09:30:00', 1),
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094
(5, '10:00:00', 1),
(6, '10:30:00', 1),
(7, '11:00:00', 1),
(8, '11:30:00', 1),
(9, '12:00:00', 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kezelok`
--

CREATE TABLE `kezelok` (
  `id` int(11) NOT NULL,
  `szakr_id` int(11) NOT NULL,
  `rendelo` varchar(10) NOT NULL,
  `kezeles` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `kezelok`
--

INSERT INTO `kezelok` (`id`, `szakr_id`, `rendelo`, `kezeles`) VALUES
<<<<<<< HEAD
(1, 1, '101', 'Bőrsebészet'),
(2, 1, '102', 'Orvos esztétika'),
(3, 4, '401', 'Fogszabályozás'),
(4, 4, '402', 'Konzerváló');
=======
(1, 1, '101', ''),
(2, 1, '102', ''),
(3, 2, '201', ''),
(4, 3, '301', 'endokrinológiáskodás'),
(5, 4, '401', 'fogszabályozás'),
(6, 1, '103', 'valami');
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `orvosok`
--

CREATE TABLE `orvosok` (
  `id` int(11) NOT NULL,
  `szakr_id` int(11) NOT NULL,
  `nev` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `orvosok`
--

INSERT INTO `orvosok` (`id`, `szakr_id`, `nev`) VALUES
<<<<<<< HEAD
(1, 1, 'dr. Nagypál Tamás'),
(2, 1, 'dr. Kiss Hajnalka'),
(3, 4, 'dr. Szeder István'),
(4, 4, 'dr. Virágh Antal');
=======
(1, 1, 'Tóth Andor'),
(2, 1, 'Kis Lajos'),
(4, 3, 'Nagy Elemér'),
(7, 2, 'Lapási Pál'),
(12, 1, 'dr. Frank Pál'),
(13, 2, 'Nagy Antal'),
(14, 1, 'Szép Károly');
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szakrendeles`
--

CREATE TABLE `szakrendeles` (
  `szakrendeles_id` int(11) NOT NULL,
  `nev` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `szakrendeles`
--

INSERT INTO `szakrendeles` (`szakrendeles_id`, `nev`) VALUES
(1, 'Bőrgyógyászat'),
(2, 'Belgyógyászat'),
(3, 'Endokrinológia'),
(4, 'Fogászat'),
<<<<<<< HEAD
(5, 'Fül-orr-gégész'),
=======
(5, 'Fül-orr gége'),
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094
(6, 'Hematológia'),
(7, 'Ortopédia'),
(8, 'Pszichiátria'),
(9, 'Traumatológia'),
(10, 'Ultrahang');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `vizit`
--

CREATE TABLE `vizit` (
  `id` int(11) NOT NULL,
  `szakrendeles_id` int(11) NOT NULL,
  `orvosok_id` int(11) NOT NULL,
  `kezelok_id` int(11) NOT NULL,
  `datum_id` int(11) NOT NULL,
  `idopont_id` int(11) NOT NULL,
  `betegek_id` int(11) NOT NULL,
  `aktiv` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `vizit`
--

INSERT INTO `vizit` (`id`, `szakrendeles_id`, `orvosok_id`, `kezelok_id`, `datum_id`, `idopont_id`, `betegek_id`, `aktiv`) VALUES
<<<<<<< HEAD
(1, 1, 1, 2, 1, 1, 1, 0),
(2, 1, 2, 1, 1, 1, 2, 1),
(3, 4, 4, 3, 1, 4, 3, 1),
(4, 4, 3, 4, 1, 4, 4, 1);
=======
(20, 1, 1, 2, 8, 9, 16, 1),
(21, 1, 2, 1, 8, 9, 17, 1),
(23, 1, 1, 1, 10, 1, 19, 1),
(24, 1, 2, 2, 10, 1, 20, 1),
(25, 1, 1, 2, 10, 6, 21, 1),
(26, 1, 2, 1, 10, 6, 22, 1),
(27, 2, 7, 3, 10, 5, 23, 1),
(28, 2, 7, 3, 10, 3, 24, 1),
(29, 2, 7, 3, 10, 4, 25, 1),
(30, 2, 7, 3, 10, 2, 26, 1),
(31, 2, 7, 3, 10, 8, 27, 1),
(32, 2, 7, 3, 10, 7, 28, 1),
(33, 2, 7, 3, 10, 6, 29, 1),
(34, 2, 7, 3, 10, 1, 30, 1),
(35, 2, 7, 3, 10, 9, 31, 1),
(36, 1, 1, 1, 10, 2, 32, 1),
(37, 1, 1, 2, 10, 9, 32, 1),
(38, 1, 2, 1, 10, 9, 33, 1),
(39, 4, 1, 5, 12, 5, 34, 0),
(40, 1, 2, 1, 10, 5, 34, 0),
(41, 1, 1, 2, 10, 5, 35, 1),
(42, 1, 1, 2, 10, 7, 36, 1),
(43, 1, 2, 1, 10, 8, 37, 1),
(44, 1, 1, 2, 10, 8, 38, 1),
(45, 3, 4, 4, 12, 5, 39, 1),
(46, 1, 2, 1, 10, 7, 40, 1),
(47, 1, 2, 1, 10, 3, 41, 1),
(48, 2, 7, 3, 9, 1, 42, 1),
(49, 3, 4, 4, 37, 5, 43, 1),
(50, 1, 2, 1, 39, 1, 40, 1),
(51, 1, 2, 1, 12, 1, 39, 1),
(52, 1, 2, 1, 40, 9, 39, 1),
(53, 1, 2, 1, 41, 8, 39, 1),
(54, 1, 2, 2, 10, 2, 44, 1),
(55, 1, 1, 2, 10, 3, 45, 1),
(56, 1, 1, 2, 12, 1, 46, 0),
(57, 1, 2, 1, 9, 1, 46, 0),
(58, 1, 2, 1, 43, 1, 46, 0),
(59, 1, 2, 1, 12, 9, 47, 1),
(60, 1, 1, 2, 43, 1, 47, 1),
(61, 1, 1, 2, 9, 1, 48, 1),
(62, 1, 12, 6, 9, 1, 47, 1),
(63, 1, 12, 6, 43, 1, 46, 0),
(64, 1, 1, 1, 26, 9, 46, 0),
(65, 2, 7, 3, 42, 9, 46, 0),
(66, 1, 1, 1, 42, 9, 46, 0),
(67, 1, 1, 1, 43, 2, 54, 1),
(68, 1, 1, 1, 44, 9, 55, 1),
(69, 1, 12, 1, 45, 9, 56, 1),
(70, 1, 1, 1, 43, 9, 57, 1),
(71, 1, 12, 2, 42, 9, 58, 1),
(72, 2, 13, 3, 46, 7, 59, 1),
(73, 1, 1, 1, 9, 2, 47, 1),
(74, 1, 1, 1, 47, 1, 46, 1),
(75, 1, 1, 1, 48, 9, 47, 1),
(76, 1, 1, 1, 38, 1, 46, 1),
(77, 1, 1, 1, 49, 9, 46, 1),
(78, 1, 1, 1, 12, 7, 47, 1),
(79, 2, 7, 3, 50, 1, 47, 1),
(80, 1, 1, 1, 26, 1, 47, 1);
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `betegek`
--
ALTER TABLE `betegek`
  ADD PRIMARY KEY (`betegek_id`);

--
-- A tábla indexei `datum`
--
ALTER TABLE `datum`
  ADD PRIMARY KEY (`datum_id`);

--
-- A tábla indexei `idopont`
--
ALTER TABLE `idopont`
  ADD PRIMARY KEY (`idopont_id`);

--
-- A tábla indexei `kezelok`
--
ALTER TABLE `kezelok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `xy` (`szakr_id`);

--
-- A tábla indexei `orvosok`
--
ALTER TABLE `orvosok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `xyz` (`szakr_id`);

--
-- A tábla indexei `szakrendeles`
--
ALTER TABLE `szakrendeles`
  ADD PRIMARY KEY (`szakrendeles_id`);

--
-- A tábla indexei `vizit`
--
ALTER TABLE `vizit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `szakrendeles` (`szakrendeles_id`),
  ADD KEY `datum` (`datum_id`),
  ADD KEY `idopont` (`idopont_id`),
  ADD KEY `betegek` (`betegek_id`),
  ADD KEY `orvosok` (`orvosok_id`),
  ADD KEY `kezelok` (`kezelok_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `betegek`
--
ALTER TABLE `betegek`
<<<<<<< HEAD
  MODIFY `betegek_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
=======
  MODIFY `betegek_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- AUTO_INCREMENT a táblához `datum`
--
ALTER TABLE `datum`
<<<<<<< HEAD
  MODIFY `datum_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
=======
  MODIFY `datum_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- AUTO_INCREMENT a táblához `idopont`
--
ALTER TABLE `idopont`
  MODIFY `idopont_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT a táblához `kezelok`
--
ALTER TABLE `kezelok`
<<<<<<< HEAD
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
=======
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- AUTO_INCREMENT a táblához `orvosok`
--
ALTER TABLE `orvosok`
<<<<<<< HEAD
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
=======
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- AUTO_INCREMENT a táblához `szakrendeles`
--
ALTER TABLE `szakrendeles`
<<<<<<< HEAD
  MODIFY `szakrendeles_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
=======
  MODIFY `szakrendeles_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- AUTO_INCREMENT a táblához `vizit`
--
ALTER TABLE `vizit`
<<<<<<< HEAD
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
=======
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
>>>>>>> f9c5e7f83fe3671855a59302407e8993c51d0094

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `kezelok`
--
ALTER TABLE `kezelok`
  ADD CONSTRAINT `xy` FOREIGN KEY (`szakr_id`) REFERENCES `szakrendeles` (`szakrendeles_id`);

--
-- Megkötések a táblához `orvosok`
--
ALTER TABLE `orvosok`
  ADD CONSTRAINT `xyz` FOREIGN KEY (`szakr_id`) REFERENCES `szakrendeles` (`szakrendeles_id`);

--
-- Megkötések a táblához `vizit`
--
ALTER TABLE `vizit`
  ADD CONSTRAINT `betegek` FOREIGN KEY (`betegek_id`) REFERENCES `betegek` (`betegek_id`),
  ADD CONSTRAINT `datum` FOREIGN KEY (`datum_id`) REFERENCES `datum` (`datum_id`),
  ADD CONSTRAINT `idopont` FOREIGN KEY (`idopont_id`) REFERENCES `idopont` (`idopont_id`),
  ADD CONSTRAINT `kezelok` FOREIGN KEY (`kezelok_id`) REFERENCES `kezelok` (`id`),
  ADD CONSTRAINT `orvosok` FOREIGN KEY (`orvosok_id`) REFERENCES `orvosok` (`id`),
  ADD CONSTRAINT `szakrendeles` FOREIGN KEY (`szakrendeles_id`) REFERENCES `szakrendeles` (`szakrendeles_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

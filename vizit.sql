-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2020. Nov 30. 16:49
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
(20, 1, 1, 2, 8, 9, 16, 1),
(21, 1, 2, 1, 8, 9, 17, 1),
(22, 1, 1, 1, 8, 5, 18, 1),
(23, 1, 1, 1, 10, 1, 19, 1);

--
-- Indexek a kiírt táblákhoz
--

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
-- AUTO_INCREMENT a táblához `vizit`
--
ALTER TABLE `vizit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Megkötések a kiírt táblákhoz
--

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

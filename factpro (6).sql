-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Računalo: localhost
-- Vrijeme generiranja: May 31, 2014 u 06:30 PM
-- Verzija poslužitelja: 5.5.24-log
-- PHP verzija: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza podataka: `factpro`
--

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `faktura`
--

CREATE TABLE IF NOT EXISTS `faktura` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDZaposlenik` int(11) NOT NULL DEFAULT '0',
  `IDKlijent` int(11) NOT NULL,
  `Cijena` float NOT NULL,
  `Broj_usluga` int(11) NOT NULL,
  `naziv_firme` varchar(50) NOT NULL,
  `adresa_firme` varchar(50) NOT NULL,
  `id_firme` varchar(50) NOT NULL,
  `idpdv_firme` varchar(50) NOT NULL,
  `broj_fakture` int(11) NOT NULL,
  `mjesto_izdavanja` varchar(50) NOT NULL,
  `datum_izdavanja` date NOT NULL,
  `Komentar` varchar(200) NOT NULL,
  `deleted` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDKlijent` (`IDKlijent`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Izbacivanje podataka za tablicu `faktura`
--

INSERT INTO `faktura` (`ID`, `IDZaposlenik`, `IDKlijent`, `Cijena`, `Broj_usluga`, `naziv_firme`, `adresa_firme`, `id_firme`, `idpdv_firme`, `broj_fakture`, `mjesto_izdavanja`, `datum_izdavanja`, `Komentar`, `deleted`) VALUES
(1, 1, 11, 3, 0, 'blabl', 'bla 12', '123', '123', 32843, 'Sarajevo', '2014-05-31', '', 0),
(2, 1, 11, 1, 0, 'blabl', 'bla 12', '123', '123', 5337, 'Sarajevo', '2014-05-31', '', 0);

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `izvjestaj`
--

CREATE TABLE IF NOT EXISTS `izvjestaj` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tip` varchar(15) NOT NULL,
  `IDZaposlenik` int(11) NOT NULL,
  `Datum_izvjestaja` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `Zaposlenik` (`IDZaposlenik`),
  KEY `Zaposlenik_2` (`IDZaposlenik`),
  KEY `Zaposlenik_3` (`IDZaposlenik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `klijenti`
--

CREATE TABLE IF NOT EXISTS `klijenti` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(110) NOT NULL,
  `Tip` varchar(11) NOT NULL,
  `Adresa` varchar(110) NOT NULL,
  `PDV` int(11) NOT NULL,
  `PDVBROJ` int(11) NOT NULL,
  `Brojtelefona` varchar(11) NOT NULL,
  `Fax` varchar(50) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Deleted` int(1) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Izbacivanje podataka za tablicu `klijenti`
--

INSERT INTO `klijenti` (`Id`, `Naziv`, `Tip`, `Adresa`, `PDV`, `PDVBROJ`, `Brojtelefona`, `Fax`, `Email`, `Deleted`) VALUES
(11, 'blabl', 'firma', 'bla 12', 123, 123, '123 123 123', '123 123 123', 'bla@bla.ba', 0),
(12, 'blabla', 'firma', 'blabla 23', 123, 213, '123 123 123', '123 123 123', 'blabla@bla.ba', 0);

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(100) NOT NULL,
  `Prezime` varchar(100) NOT NULL,
  `Pozicija` varchar(100) NOT NULL,
  `Adresa` varchar(100) NOT NULL,
  `Telefon` varchar(100) NOT NULL,
  `DatumZaposlenja` date NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Deleted` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Izbacivanje podataka za tablicu `korisnik`
--

INSERT INTO `korisnik` (`ID`, `Ime`, `Prezime`, `Pozicija`, `Adresa`, `Telefon`, `DatumZaposlenja`, `Username`, `Password`, `Deleted`) VALUES
(2, 'blabl', 'blabla', 'operater', 'bla@bla.ba', '123 123 123', '2014-05-30', 'blalba', 'blabla', 1);

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `ponuda`
--

CREATE TABLE IF NOT EXISTS `ponuda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDStavka` int(11) NOT NULL,
  `IDZaposlenik` int(11) NOT NULL,
  `IDKlijent` int(11) NOT NULL,
  `Cijena` int(11) NOT NULL,
  `nacin_placanja` varchar(20) NOT NULL,
  `Datum_kreiranja` date NOT NULL,
  `Komentar` text NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDStavka` (`IDStavka`,`IDZaposlenik`,`IDKlijent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `predracun`
--

CREATE TABLE IF NOT EXISTS `predracun` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDZaposlenik` int(11) NOT NULL DEFAULT '0',
  `IDKlijent` int(11) NOT NULL,
  `Cijena` float NOT NULL,
  `Broj_usluga` int(11) NOT NULL,
  `naziv_firme` varchar(50) NOT NULL,
  `adresa_firme` varchar(50) NOT NULL,
  `id_firme` varchar(50) NOT NULL,
  `idpdv_firme` varchar(50) NOT NULL,
  `broj_predracuna` int(11) NOT NULL,
  `mjesto_izdavanja` varchar(50) NOT NULL,
  `datum_izdavanja` date NOT NULL,
  `Komentar` varchar(200) NOT NULL,
  `deleted` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDKlijent` (`IDKlijent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `stavka_faktura`
--

CREATE TABLE IF NOT EXISTS `stavka_faktura` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsluga` int(11) NOT NULL,
  `IDFaktura` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDUsluga` (`IDUsluga`),
  KEY `IDFaktura` (`IDFaktura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Izbacivanje podataka za tablicu `stavka_faktura`
--

INSERT INTO `stavka_faktura` (`ID`, `IDUsluga`, `IDFaktura`) VALUES
(1, 2, 1),
(2, 2, 1),
(3, 2, 2);

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `stavka_ponuda`
--

CREATE TABLE IF NOT EXISTS `stavka_ponuda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsluga` int(11) NOT NULL,
  `IDPonuda` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDUsluga` (`IDUsluga`),
  KEY `IDPonuda` (`IDPonuda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `stavka_predracuna`
--

CREATE TABLE IF NOT EXISTS `stavka_predracuna` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsluga` int(11) NOT NULL,
  `IDPredracun` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDUsluga` (`IDUsluga`),
  KEY `IDPredracun` (`IDPredracun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `usluga`
--

CREATE TABLE IF NOT EXISTS `usluga` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Cijena` int(11) NOT NULL,
  `Naziv` varchar(15) NOT NULL,
  `opisUsluge` varchar(50) NOT NULL,
  `tipUsluge` varchar(50) NOT NULL,
  `ukupanTrosak` int(50) NOT NULL,
  `Deleted` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Izbacivanje podataka za tablicu `usluga`
--

INSERT INTO `usluga` (`ID`, `Cijena`, `Naziv`, `opisUsluge`, `tipUsluge`, `ukupanTrosak`, `Deleted`) VALUES
(2, 1, 'uslugi', '', 'Servis', 10, 0);

-- --------------------------------------------------------

--
-- Tablična struktura za tablicu `zaposlenik`
--

CREATE TABLE IF NOT EXISTS `zaposlenik` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(15) NOT NULL,
  `Prezime` varchar(15) NOT NULL,
  `Adresa` varchar(15) NOT NULL,
  `Broj_telefona` int(8) NOT NULL,
  `Pozicija` varchar(15) NOT NULL,
  `Datum_zaposlenja` date NOT NULL,
  `Korisnicko_ime` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Ograničenja za izbačene tablice
--

--
-- Ograničenja za tablicu `faktura`
--
ALTER TABLE `faktura`
  ADD CONSTRAINT `faktura_ibfk_1` FOREIGN KEY (`IDKlijent`) REFERENCES `klijenti` (`Id`);

--
-- Ograničenja za tablicu `predracun`
--
ALTER TABLE `predracun`
  ADD CONSTRAINT `predracun_ibfk_1` FOREIGN KEY (`IDKlijent`) REFERENCES `klijenti` (`Id`);

--
-- Ograničenja za tablicu `stavka_faktura`
--
ALTER TABLE `stavka_faktura`
  ADD CONSTRAINT `stavka_faktura_ibfk_1` FOREIGN KEY (`IDUsluga`) REFERENCES `usluga` (`ID`),
  ADD CONSTRAINT `stavka_faktura_ibfk_2` FOREIGN KEY (`IDFaktura`) REFERENCES `faktura` (`ID`);

--
-- Ograničenja za tablicu `stavka_ponuda`
--
ALTER TABLE `stavka_ponuda`
  ADD CONSTRAINT `stavka_ponuda_ibfk_1` FOREIGN KEY (`IDUsluga`) REFERENCES `usluga` (`ID`),
  ADD CONSTRAINT `stavka_ponuda_ibfk_2` FOREIGN KEY (`IDPonuda`) REFERENCES `ponuda` (`ID`);

--
-- Ograničenja za tablicu `stavka_predracuna`
--
ALTER TABLE `stavka_predracuna`
  ADD CONSTRAINT `stavka_predracuna_ibfk_1` FOREIGN KEY (`IDUsluga`) REFERENCES `usluga` (`ID`),
  ADD CONSTRAINT `stavka_predracuna_ibfk_2` FOREIGN KEY (`IDPredracun`) REFERENCES `predracun` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

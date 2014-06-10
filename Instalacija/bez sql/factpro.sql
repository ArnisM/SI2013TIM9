

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;



INSERT INTO `klijenti` (`Id`, `Naziv`, `Tip`, `Adresa`, `PDV`, `PDVBROJ`, `Brojtelefona`, `Fax`, `Email`, `Deleted`) VALUES
(1, 'Samra Mrso', 'fizickoLice', 'Adresa 23', 132, 4132, '061 111 111', '033 222 222', 'mail@mail.mail', 0),
(2, 'Samra Mrso', 'fizickoLice', 'Adresa 23', 132, 4132, '061 111 111', '033 222 222', 'mail@mail.mail', 0),
(3, 'Samra Mrso', 'fizickoLice', 'Adresa 23', 132, 4132, '061 111 111', '033 222 222', 'mail@mail.mail', 0);



CREATE TABLE IF NOT EXISTS `korisnik` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(15) NOT NULL,
  `Prezime` varchar(15) NOT NULL,
  `Adresa` varchar(15) NOT NULL,
  `Telefon` VARCHAR(11) NOT NULL,
  `Pozicija` varchar(15) NOT NULL,
  `DatumZaposlenja` date NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `deleted` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



CREATE TABLE IF NOT EXISTS `ponuda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDZaposlenik` int(11) NOT NULL DEFAULT '0',
  `IDKlijent` int(11) NOT NULL,
  `Cijena` float NOT NULL,
  `Broj_usluga` int(11) NOT NULL,
  `naziv_firme` varchar(50) NOT NULL,
  `adresa_firme` varchar(50) NOT NULL,
  `id_firme` varchar(50) NOT NULL,
  `idpdv_firme` varchar(50) NOT NULL,
  `broj_ponude` int(11) NOT NULL,
  `mjesto_izdavanja` varchar(50) NOT NULL,
  `datum_izdavanja` date NOT NULL,
  `Komentar` varchar(200) NOT NULL,
  `deleted` int(1) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDKlijent` (`IDKlijent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



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



CREATE TABLE IF NOT EXISTS `stavka_faktura` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsluga` int(11) NOT NULL,
  `IDFaktura` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDUsluga` (`IDUsluga`),
  KEY `IDFaktura` (`IDFaktura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



CREATE TABLE IF NOT EXISTS `stavka_ponuda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsluga` int(11) NOT NULL,
  `IDPonuda` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDUsluga` (`IDUsluga`),
  KEY `IDPonuda` (`IDPonuda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



CREATE TABLE IF NOT EXISTS `stavka_predracuna` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDUsluga` int(11) NOT NULL,
  `IDPredracun` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `IDUsluga` (`IDUsluga`),
  KEY `IDPredracun` (`IDPredracun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;



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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;




ALTER TABLE `faktura`
  ADD CONSTRAINT `faktura_ibfk_1` FOREIGN KEY (`IDKlijent`) REFERENCES `klijenti` (`Id`);
 
ALTER TABLE `predracun`
  ADD CONSTRAINT `predracun_ibfk_1` FOREIGN KEY (`IDKlijent`) REFERENCES `klijenti` (`Id`);
  
  ALTER TABLE `ponuda`
  ADD CONSTRAINT `ponuda_ibfk_1` FOREIGN KEY (`IDKlijent`) REFERENCES `klijenti` (`Id`);


ALTER TABLE `stavka_faktura`
  ADD CONSTRAINT `stavka_faktura_ibfk_1` FOREIGN KEY (`IDUsluga`) REFERENCES `usluga` (`ID`),
  ADD CONSTRAINT `stavka_faktura_ibfk_2` FOREIGN KEY (`IDFaktura`) REFERENCES `faktura` (`ID`);


ALTER TABLE `stavka_ponuda`
  ADD CONSTRAINT `stavka_ponuda_ibfk_1` FOREIGN KEY (`IDUsluga`) REFERENCES `usluga` (`ID`),
  ADD CONSTRAINT `stavka_ponuda_ibfk_2` FOREIGN KEY (`IDPonuda`) REFERENCES `ponuda` (`ID`);


ALTER TABLE `stavka_predracuna`
  ADD CONSTRAINT `stavka_predracuna_ibfk_1` FOREIGN KEY (`IDUsluga`) REFERENCES `usluga` (`ID`),
  ADD CONSTRAINT `stavka_predracuna_ibfk_2` FOREIGN KEY (`IDPredracun`) REFERENCES `predracun` (`ID`);

INSERT INTO `factpro`.`korisnik` (`ID`, `Ime`, `Prezime`, `Adresa`, `Telefon`, `Pozicija`, `DatumZaposlenja`, `Username`, `Password`, `deleted`) VALUES (NULL, 'operater', 'operater', 'operater 1', '061-111-111', 'operater', '2014-06-01', 'operater', 'operater', '0');

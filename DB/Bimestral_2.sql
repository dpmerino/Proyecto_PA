-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Bimestral2B
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Bimestral2B
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Bimestral2B` DEFAULT CHARACTER SET utf8 ;
USE `Bimestral2B` ;

-- -----------------------------------------------------
-- Table `Bimestral2B`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bimestral2B`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `apellidos` VARCHAR(25) NULL,
  `nombres` VARCHAR(25) NULL,
  `edad` INT NULL,
  `mail` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bimestral2B`.`Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bimestral2B`.`Servicio` (
  `idSer` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(15) NULL,
  `servicio` VARCHAR(45) NULL,
  `costo` DOUBLE NULL,
  `edadMin` INT NULL,
  `xDias` INT NULL,
  PRIMARY KEY (`idSer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bimestral2B`.`Suscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bimestral2B`.`Suscripcion` (
  `idSuscripcion` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `idServicio` INT NOT NULL,
  `fechaDesde` VARCHAR(45) NULL,
  `fechaHasta` VARCHAR(45) NULL,
  `estado` INT NULL,
  PRIMARY KEY (`idSuscripcion`),
  INDEX `fk_Suscripcion_Cliente_idx` (`idCliente` ASC),
  INDEX `fk_Suscripcion_Servicio1_idx` (`idServicio` ASC),
  CONSTRAINT `fk_Suscripcion_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `Bimestral2B`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Suscripcion_Servicio1`
    FOREIGN KEY (`idServicio`)
    REFERENCES `Bimestral2B`.`Servicio` (`idSer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bimestral2B`.`Transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bimestral2B`.`Transaccion` (
  `idTra` INT NOT NULL AUTO_INCREMENT,
  `idSuscripcion` INT NOT NULL,
  `fecha` VARCHAR(45) NULL,
  `valor` DOUBLE NULL,
  `numDias` INT NULL,
  `promocion` INT NULL,
  PRIMARY KEY (`idTra`),
  INDEX `fk_Transaccion_Suscripcion1_idx` (`idSuscripcion` ASC),
  CONSTRAINT `fk_Transaccion_Suscripcion1`
    FOREIGN KEY (`idSuscripcion`)
    REFERENCES `Bimestral2B`.`Suscripcion` (`idSuscripcion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

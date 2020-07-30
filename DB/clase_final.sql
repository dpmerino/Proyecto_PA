-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema clase_final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema clase_final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clase_final` DEFAULT CHARACTER SET utf8 ;
USE `clase_final` ;

-- -----------------------------------------------------
-- Table `clase_final`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase_final`.`Cliente` (
  `idCli` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(10) NULL,
  `apellidos` VARCHAR(25) NULL,
  `nombres` VARCHAR(25) NULL,
  `edad` INT NULL,
  `telefono` VARCHAR(15) NULL,
  `correo` VARCHAR(45) NULL,
  `genero` INT NULL,
  PRIMARY KEY (`idCli`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clase_final`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase_final`.`Provincia` (
  `idPro` INT NOT NULL AUTO_INCREMENT,
  `Provincia` VARCHAR(45) NULL,
  PRIMARY KEY (`idPro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clase_final`.`Canton`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase_final`.`Canton` (
  `idCan` INT NOT NULL AUTO_INCREMENT,
  `canton` VARCHAR(45) NULL,
  `idPro` INT NOT NULL,
  PRIMARY KEY (`idCan`),
  INDEX `fk_Canton_Pronvincia1_idx` (`idPro` ASC),
  CONSTRAINT `fk_Canton_Pronvincia1`
    FOREIGN KEY (`idPro`)
    REFERENCES `clase_final`.`Provincia` (`idPro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `clase_final`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clase_final`.`Direccion` (
  `idDir` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NULL,
  `numero` VARCHAR(10) NULL,
  `actual` TINYINT NULL,
  `idCan` INT NOT NULL,
  `idCli` INT NOT NULL,
  PRIMARY KEY (`idDir`),
  INDEX `fk_Direccion_Canton1_idx` (`idCan` ASC),
  INDEX `fk_Direccion_Cliente1_idx` (`idCli` ASC),
  CONSTRAINT `fk_Direccion_Canton1`
    FOREIGN KEY (`idCan`)
    REFERENCES `clase_final`.`Canton` (`idCan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Direccion_Cliente1`
    FOREIGN KEY (`idCli`)
    REFERENCES `clase_final`.`Cliente` (`idCli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

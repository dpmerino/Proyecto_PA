-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Grupo5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Grupo5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Grupo5` DEFAULT CHARACTER SET utf8 ;
USE `Grupo5` ;

-- -----------------------------------------------------
-- Table `Grupo5`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Admin` (
  `idAdmin` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `nombre` VARCHAR(25) NULL,
  `apellido` VARCHAR(25) NULL,
  `mail` VARCHAR(45) NULL,
  `clave` VARCHAR(20) NULL,
  PRIMARY KEY (`idAdmin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `nombre` VARCHAR(25) NULL,
  `apellido` VARCHAR(25) NULL,
  `mail` VARCHAR(45) NULL,
  `clave` VARCHAR(20) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Gerente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Gerente` (
  `idGerente` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `nombre` VARCHAR(25) NULL,
  `apellido` VARCHAR(25) NULL,
  `mail` VARCHAR(45) NULL,
  `clave` VARCHAR(20) NULL,
  `turno` INT NULL,
  `sueldo` DOUBLE NULL,
  PRIMARY KEY (`idGerente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Bodeguero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Bodeguero` (
  `idBodeguero` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `nombre` VARCHAR(25) NULL,
  `apellido` VARCHAR(25) NULL,
  `mail` VARCHAR(45) NULL,
  `clave` VARCHAR(20) NULL,
  `turno` INT NULL,
  `sueldo` DOUBLE NULL,
  PRIMARY KEY (`idBodeguero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Local` (
  `idLocal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `codigo` VARCHAR(20) NULL,
  `direccion` VARCHAR(45) NULL,
  `idGer` INT NOT NULL,
  `idBod` INT NOT NULL,
  PRIMARY KEY (`idLocal`),
  INDEX `fk_Local_Gerente1_idx` (`idGer` ASC),
  INDEX `fk_Local_Bodeguero1_idx` (`idBod` ASC),
  CONSTRAINT `fk_Local_Gerente1`
    FOREIGN KEY (`idGer`)
    REFERENCES `Grupo5`.`Gerente` (`idGerente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Local_Bodeguero1`
    FOREIGN KEY (`idBod`)
    REFERENCES `Grupo5`.`Bodeguero` (`idBodeguero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Inventario` (
  `idInventario` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `codigo` VARCHAR(20) NULL,
  `nombre` VARCHAR(45) NULL,
  `precio` DOUBLE NULL,
  `idLoc` INT NOT NULL,
  PRIMARY KEY (`idInventario`),
  INDEX `fk_Inventario_Local1_idx` (`idLoc` ASC),
  CONSTRAINT `fk_Inventario_Local1`
    FOREIGN KEY (`idLoc`)
    REFERENCES `Grupo5`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Vendedor` (
  `idVendedor` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(10) NULL,
  `nombre` VARCHAR(25) NULL,
  `apellido` VARCHAR(25) NULL,
  `mail` VARCHAR(45) NULL,
  `clave` VARCHAR(20) NULL,
  `turno` INT NULL,
  `suledo` DOUBLE NULL,
  `Local_idLocal` INT NOT NULL,
  PRIMARY KEY (`idVendedor`),
  INDEX `fk_Vendedor_Local1_idx` (`Local_idLocal` ASC),
  CONSTRAINT `fk_Vendedor_Local1`
    FOREIGN KEY (`Local_idLocal`)
    REFERENCES `Grupo5`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL,
  `estado` INT NULL,
  `total` DOUBLE NULL,
  `idCli` INT NOT NULL,
  `idLoc` INT NOT NULL,
  `idVen` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Cliente1_idx` (`idCli` ASC),
  INDEX `fk_Pedido_Local1_idx` (`idLoc` ASC),
  INDEX `fk_Pedido_Vendedor1_idx` (`idVen` ASC),
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`idCli`)
    REFERENCES `Grupo5`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Local1`
    FOREIGN KEY (`idLoc`)
    REFERENCES `Grupo5`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Vendedor1`
    FOREIGN KEY (`idVen`)
    REFERENCES `Grupo5`.`Vendedor` (`idVendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo5`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo5`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `formaDePago` INT NULL,
  `descuento` DOUBLE NULL,
  `total` DOUBLE NULL,
  `Pedido_idPedido` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Pedido1_idx` (`Pedido_idPedido` ASC),
  CONSTRAINT `fk_Factura_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `Grupo5`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

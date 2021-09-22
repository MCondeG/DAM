-- MySQL Workbench Forward Engineering

-- begin attached script 'script'
SET GLOBAL time_zone = "+00:00";
-- end attached script 'script'
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema instituto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema instituto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `instituto` DEFAULT CHARACTER SET utf8 ;
USE `instituto` ;

-- -----------------------------------------------------
-- Table `instituto`.`Profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instituto`.`Profesor` (
  `idProfesor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `observaciones` VARCHAR(200) NULL,
  PRIMARY KEY (`idProfesor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instituto`.`Grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instituto`.`Grupo` (
  `idGrupo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idGrupo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instituto`.`Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instituto`.`Alumno` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `Grupo_idGrupo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idAlumno`),
  INDEX `fk_Alumno_Grupo1_idx` (`Grupo_idGrupo` ASC) VISIBLE,
  CONSTRAINT `fk_Alumno_Grupo1`
    FOREIGN KEY (`Grupo_idGrupo`)
    REFERENCES `instituto`.`Grupo` (`idGrupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instituto`.`Incidencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instituto`.`Incidencia` (
  `idIncidencia` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idIncidencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instituto`.`Parte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instituto`.`Parte` (
  `idParte` INT NOT NULL AUTO_INCREMENT,
  `Profesor_idProfesor` INT NOT NULL,
  `Alumno_idAlumno` INT NOT NULL,
  `Incidencia_idIncidencia` INT NOT NULL,
  PRIMARY KEY (`idParte`),
  INDEX `fk_Parte_Profesor1_idx` (`Profesor_idProfesor` ASC) VISIBLE,
  INDEX `fk_Parte_Alumno1_idx` (`Alumno_idAlumno` ASC) VISIBLE,
  INDEX `fk_Parte_Incidencia1_idx` (`Incidencia_idIncidencia` ASC) VISIBLE,
  CONSTRAINT `fk_Parte_Profesor1`
    FOREIGN KEY (`Profesor_idProfesor`)
    REFERENCES `instituto`.`Profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parte_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno`)
    REFERENCES `instituto`.`Alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Parte_Incidencia1`
    FOREIGN KEY (`Incidencia_idIncidencia`)
    REFERENCES `instituto`.`Incidencia` (`idIncidencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `instituto`.`Profesor`
-- -----------------------------------------------------
START TRANSACTION;
USE `instituto`;
INSERT INTO `instituto`.`Profesor` (`idProfesor`, `nombre`, `password`, `observaciones`) VALUES (DEFAULT, 'Enrique', '1234', NULL);
INSERT INTO `instituto`.`Profesor` (`idProfesor`, `nombre`, `password`, `observaciones`) VALUES (DEFAULT, 'Jorge', '4321', 'Profesor nuevo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `instituto`.`Grupo`
-- -----------------------------------------------------
START TRANSACTION;
USE `instituto`;
INSERT INTO `instituto`.`Grupo` (`idGrupo`, `nombre`) VALUES (DEFAULT, '1DAM');
INSERT INTO `instituto`.`Grupo` (`idGrupo`, `nombre`) VALUES (DEFAULT, '2DAM');

COMMIT;


-- -----------------------------------------------------
-- Data for table `instituto`.`Alumno`
-- -----------------------------------------------------
START TRANSACTION;
USE `instituto`;
INSERT INTO `instituto`.`Alumno` (`idAlumno`, `Grupo_idGrupo`, `nombre`) VALUES (DEFAULT, 2, 'Manuel');
INSERT INTO `instituto`.`Alumno` (`idAlumno`, `Grupo_idGrupo`, `nombre`) VALUES (DEFAULT, 1, 'Pepe');
INSERT INTO `instituto`.`Alumno` (`idAlumno`, `Grupo_idGrupo`, `nombre`) VALUES (DEFAULT, 2, 'Maria');

COMMIT;


-- -----------------------------------------------------
-- Data for table `instituto`.`Incidencia`
-- -----------------------------------------------------
START TRANSACTION;
USE `instituto`;
INSERT INTO `instituto`.`Incidencia` (`idIncidencia`, `tipo`) VALUES (DEFAULT, 'Molestar');
INSERT INTO `instituto`.`Incidencia` (`idIncidencia`, `tipo`) VALUES (DEFAULT, 'Sin deberes');
INSERT INTO `instituto`.`Incidencia` (`idIncidencia`, `tipo`) VALUES (DEFAULT, 'Violencia');

COMMIT;


-- -----------------------------------------------------
-- Data for table `instituto`.`Parte`
-- -----------------------------------------------------
START TRANSACTION;
USE `instituto`;
INSERT INTO `instituto`.`Parte` (`idParte`, `Profesor_idProfesor`, `Alumno_idAlumno`, `Incidencia_idIncidencia`) VALUES (DEFAULT, 1, 3, 2);
INSERT INTO `instituto`.`Parte` (`idParte`, `Profesor_idProfesor`, `Alumno_idAlumno`, `Incidencia_idIncidencia`) VALUES (DEFAULT, 2, 2, 1);
INSERT INTO `instituto`.`Parte` (`idParte`, `Profesor_idProfesor`, `Alumno_idAlumno`, `Incidencia_idIncidencia`) VALUES (DEFAULT, 1, 2, 3);

COMMIT;


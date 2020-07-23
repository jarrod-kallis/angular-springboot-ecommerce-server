DROP TABLE IF EXISTS `full-stack-ecommerce`.`state`;
DROP TABLE IF EXISTS `full-stack-ecommerce`.`country`;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-ecommerce`.`country` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(2) NOT NULL UNIQUE,
  `name` VARCHAR(255) NOT NULL,
  `state_description` VARCHAR(255) NOT NULL,
  `zip_code_description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `full-stack-ecommerce`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `full-stack-ecommerce`.`state` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `country_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_country` (`country_id`),
  CONSTRAINT `fk_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Countries
-- -----------------------------------------------------
INSERT INTO COUNTRY(CODE, NAME, STATE_DESCRIPTION, ZIP_CODE_DESCRIPTION) VALUES 
('US', 'America', 'State', 'Zip Code'), 
('ZA', 'South Africa', 'Province', 'Postal Code');

-- -----------------------------------------------------
-- States
-- -----------------------------------------------------
INSERT INTO STATE (NAME, COUNTRY_ID) VALUES 
('Alabama',1),
('Alaska',1),
('Arizona',1),
('Arkansas',1),
('California',1),
('Colorado',1),
('Connecticut',1),
('Delaware',1),
('District Of Columbia',1),
('Florida',1),
('Georgia',1),
('Hawaii',1),
('Idaho',1),
('Illinois',1),
('Indiana',1),
('Iowa',1),
('Kansas',1),
('Kentucky',1),
('Louisiana',1),
('Maine',1),
('Maryland',1),
('Massachusetts',1),
('Michigan',1),
('Minnesota',1),
('Mississippi',1),
('Missouri',1),
('Montana',1),
('Nebraska',1),
('Nevada',1),
('New Hampshire',1),
('New Jersey',1),
('New Mexico',1),
('New York',1),
('North Carolina',1),
('North Dakota',1),
('Ohio',1),
('Oklahoma',1),
('Oregon',1),
('Pennsylvania',1),
('Rhode Island',1),
('South Carolina',1),
('South Dakota',1),
('Tennessee',1),
('Texas',1),
('Utah',1),
('Vermont',1),
('Virginia',1),
('Washington',1),
('West Virginia',1),
('Wisconsin',1),
('Wyoming',1),
('Western Cape', 2),
('Gauteng', 2);

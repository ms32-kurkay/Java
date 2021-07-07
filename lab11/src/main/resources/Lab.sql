USE lab11;

DROP TABLES IF EXISTS populations, regions, countries;

CREATE TABLE populations
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    population_name VARCHAR(20),
    population_language VARCHAR(20)
);

CREATE TABLE regions
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    population_id INT,
    region_name VARCHAR(20),
    region_area INT,
    FOREIGN KEY (population_id) REFERENCES populations(id)
);

CREATE TABLE countries
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    region_id INT,
    country_date DATE,
    temperature SMALLINT,
    precipitation SMALLINT,
    FOREIGN KEY (region_id) REFERENCES regions(id)
);



INSERT INTO populations SET
    population_name = 'belorussians',
    population_language = 'russian';

INSERT INTO populations SET 
    population_name='belorussians',
    population_language='belorussian';

INSERT INTO populations SET 
    population_name='russians',
    population_language='russian';



INSERT INTO regions SET
	population_id=(SELECT id FROM populations WHERE population_language='belorussian'),
    region_name='Minsk',
    region_area=348;

INSERT INTO regions SET
	population_id=(SELECT id FROM populations WHERE population_name='russian'),
    region_name='Gomel',
    region_area=139;
    
INSERT INTO regions SET
	population_id=(SELECT id FROM populations WHERE population_name='belorussian'),
    region_name='Vitebsk',
    region_area=124;



INSERT INTO countries SET
	region_id=(SELECT id FROM regions WHERE region_name='Minsk'), 
    country_date='2019-11-22',
    temperature=-1,
    precipitation=3;

INSERT INTO countries SET 
	region_id=(SELECT id FROM regions WHERE region_name='Gomel'), 
    country_date='2019-11-27',
    temperature=2,
    precipitation=5;

INSERT INTO countries SET 
	region_id=(SELECT id FROM regions WHERE region_name='Minsk'), 
    country_date='2019-11-27',
    temperature=3,
    precipitation=0;
    
INSERT INTO countries SET 
	region_id=(SELECT id FROM regions WHERE region_name='Vitebsk'), 
    country_date='2019-11-27',
    temperature=0,
    precipitation=2;


INSERT INTO countries SET 
	region_id=(SELECT id FROM regions WHERE region_name='Minsk'), 
    country_date='2019-12-3',
    temperature=-1,
    precipitation=0;
    
INSERT INTO countries SET 
	region_id=(SELECT id FROM regions WHERE region_name='Vitebsk'), 
    country_date='2019-12-3',
    temperature=1,
    precipitation=0;
    
INSERT INTO countries SET 
	region_id=(SELECT id FROM regions WHERE region_name='Gomel'), 
    country_date='2019-12-3',
    temperature=-3,
    precipitation=8;


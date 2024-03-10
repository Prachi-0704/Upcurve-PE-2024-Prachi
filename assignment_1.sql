DROP DATABASE IF EXISTS INFO;
CREATE DATABASE INFO;
USE INFO;

CREATE TABLE REGIONS(
	region_id INT PRIMARY KEY,
    region_name VARCHAR(50) NOT NULL
);

INSERT INTO REGIONS(region_id, region_name) 
VALUES 
    (1, 'Europe'),
    (2, 'Americas'),
    (3, 'Asia'),
    (4, 'Middle East and Africa');


CREATE TABLE COUNTRIES(
	country_id VARCHAR(2) PRIMARY KEY,
    country_name VARCHAR(50) NOT NULL,
    region_id INT, 
    FOREIGN KEY(region_id) REFERENCES REGIONS(region_id)
);

INSERT INTO COUNTRIES(country_id, country_name, region_id) 
VALUES
('IT', 'Italy', 1),
('JP', 'Japan', 3),
('US', 'United States of America', 2),
('CA', 'Canada', 2),
('CN', 'China', 3),
('IN', 'India', 3),
('AU', 'Australia', 3),
('ZW', 'Zimbabwe', 4),
('SG', 'Singapore', 3),
('UK', 'United Kingdom', 1),
('FR', 'France', 1),
('DE', 'Germany', 1),
('ZM', 'Zambia', 4),
('EG', 'Egypt', 4),
('BR', 'Brazil', 2),
('CH', 'Switzerland', 1),
('NL', 'Netherlands', 1),
('MX', 'Mexico', 2),
('KW', 'Kuwait', 4),
('IL', 'Israel', 4),
('DK', 'Denmark', 1),
('HK', 'HongKong', 3),
('NG', 'Nigeria', 4),
('AR', 'Argentina', 2),
('BE', 'Belgium', 1);

CREATE TABLE EMPLOYEES(
	employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone_number VARCHAR(50),
    hire_date DATE,
    job_id VARCHAR(15),
    salary DOUBLE,
    commission_pct DOUBLE,
    manager_id INT REFERENCES EMPLOYEES(manager_id),
    department_id INT REFERENCES DEPARTMENTS(department_id)
);

INSERT INTO EMPLOYEES(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES 
(100,'Steven','King','SKING','515.123.4567','1987-06-17','AD_PRES',24000,NULL,NULL,90),
(101,'Neena','Kochhar','NKOCHHAR','515.123.4568','1989-09-21','AD_VP',17000,NULL,100,90),
(102,'Lex','De Haan','LDEHAAN','515.123.4569','1993-01-13','AD_VP',17000,NULL,100,90),
(103,'Alexander','Hunold','AHUNOLD','590.423.4567','1990-01-03','IT_PROG',9000,NULL,102,60),
(104,'Bruce','Ernst','BERNST','590.423.4568','1991-05-21','IT_PROG',6000,NULL,103,60),
(105,'David','Austin','DAUSTIN','590.423.4569','1997-06-25','IT_PROG',4800,NULL,103,60),
(106,'Valli','Pataballa','VPATABAL','590.423.4560','1998-02-05','IT_PROG',4800,NULL,103,60),
(107,'Diana','Lorentz','DLORENTZ','590.423.5567','1999-02-07','IT_PROG',4200,NULL,103,60),
(108,'Nancy','Greenberg','NGREENBE','515.124.4569','1994-08-17','FI_MGR',12000,NULL,101,100),
(109,'Daniel','Faviet','DFAVIET','515.124.4169','1994-08-16','FI_ACCOUNT',9000,NULL,108,100),
(110,'John','Chen','JCHEN','515.124.4269','1997-09-28','FI_ACCOUNT',8200,NULL,108,100),
(111,'Ismael','Sciarra','ISCIARRA','515.124.4369','1997-09-30','FI_ACCOUNT',7700,NULL,108,100),
(112,'Jose Manuel','Urman','JMURMAN','515.124.4469','1998-04-07','FI_ACCOUNT',7800,NULL,108,100),
(113,'Luis','Popp','LPOPP','515.124.4567','1999-12-07','FI_ACCOUNT',6900,NULL,108,100),
(114,'Den','Raphaely','DRAPHEAL','515.127.4561','1994-12-07','PU_MAN',11000,NULL,100,30),
(115,'Alexander','Khoo','AKHOO','515.127.4562','1995-05-18','PU_CLERK',3100,NULL,114,30),
(116,'Shelli','Baida','SBAIDA','515.127.4563','1997-12-24','PU_CLERK',2900,NULL,114,30),
(117,'Sigal','Tobias','STOBIAS','515.127.4564','1997-07-24','PU_CLERK',2800,NULL,114,30),
(118,'Guy','Himuro','GHIMURO','515.127.4565','1998-11-15','PU_CLERK',2600,NULL,114,30),
(119,'Karen','Colmenares','KCOLMENA','515.127.4566','1999-08-10','PU_CLERK',2500,NULL,114,30),
(120,'Matthew','Weiss','MWEISS','650.123.1234','1996-07-18','ST_MAN',8000,NULL,100,50),
(121,'Adam','Fripp','AFRIPP','650.123.2234','1997-04-10','ST_MAN',8200,NULL,100,50),
(122,'Payam','Kaufling','PKAUFLIN','650.123.3234','1995-05-01','ST_MAN',7900,NULL,100,50),
(123,'Shanta','Vollman','SVOLLMAN','650.123.4234','1997-10-10','ST_MAN',6500,NULL,100,50),
(124,'Kevin','Mourgos','KMOURGOS','650.123.5234','1999-11-16','ST_MAN',5800,NULL,100,50),
(125,'Julia','Nayer','JNAYER','650.124.1214','1997-07-16','ST_CLERK',3200,NULL,120,50),
(126,'Irene','Mikkilineni','IMIKKILI','650.124.1224','1998-09-28','ST_CLERK',2700,NULL,120,50),
(127,'James','Landry','JLANDRY','650.124.1334','1999-01-14','ST_CLERK',2400,NULL,120,50),
(128,'Steven','Markle','SMARKLE','650.124.1434','2000-04-08','ST_CLERK',2200,NULL,120,50),
(129,'Laura','Bissot','LBISSOT','650.124.5234','1997-08-20','ST_CLERK',3300,NULL,121,50),
(130,'Mozhe','Atkinson','MATKINSO','650.124.6234','1997-10-30','ST_CLERK',2800,NULL,121,50),
(131,'James','Marlow','JAMRLOW','650.124.7234','1997-02-16','ST_CLERK',2500,NULL,121,50),
(132,'TJ','Olson','TJOLSON','650.124.8234','1999-04-10','ST_CLERK',2100,NULL,121,50),
(133,'Jason','Mallin','JMALLIN','650.127.1934','1996-06-14','ST_CLERK',3300,NULL,122,50),
(134,'Michael','Rogers','MROGERS','650.127.1834','1998-08-26','ST_CLERK',2900,NULL,122,50),
(135,'Ki','Gee','KGEE','650.127.1734','1999-12-12','ST_CLERK',2400,NULL,122,50),
(136,'Hazel','Philtanker','HPHILTAN','650.127.1634','2000-02-06','ST_CLERK',2200,NULL,122,50),
(137,'Renske','Ladwig','RLADWIG','650.121.1234','1995-07-14','ST_CLERK',3600,NULL,123,50),
(138,'Stephen','Stiles','SSTILES','650.121.2034','1997-10-26','ST_CLERK',3200,NULL,123,50),
(139,'John','Seo','JSEO','650.121.2019','1998-02-12','ST_CLERK',2700,NULL,123,50),
(140,'Joshua','Patel','JPATEL','650.121.1834','1998-04-06','ST_CLERK',2500,NULL,123,50),
(141,'Trenna','Rajs','TRAJS','650.121.8009','1995-10-17','ST_CLERK',3500,NULL,124,50),
(142,'Curtis','Davies','CDAVIES','650.121.2994','1997-01-29','ST_CLERK',3100,NULL,124,50),
(143,'Randall','Matos','RMATOS','650.121.2874','1998-04-15','ST_CLERK',2600,NULL,124,50),
(144,'Peter','Vargas','PVARGAS','650.121.2004','1998-07-09','ST_CLERK',2500,NULL,124,50),
(145,'John','Russell','JRUSSEL','011.44.1344.429268','1996-10-01','SA_MAN',14000,0.4,100,80),
(146,'Karen','Partners','KPARTNER','011.44.1344.467268','1997-01-05','SA_MAN',13500,0.3,100,80),
(147,'Alberto','Errazuriz','AERRAZUR','011.44.1344.429278','1997-04-10','SA_MAN',12000,0.3,100,80),
(148,'Gerald','Cambrault','GCAMBRAU','011.44.1344.619268','1999-10-15','SA_MAN',11000,0.3,100,80),
(149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018','2000-01-29','SA_MAN',10500,0.2,100,80),
(150,'Peter','Tucker','PTUCKER','011.44.1344.129268','1997-01-30','SA_REP',10000,0.3,145,80),
(151,'David','Bernstein','DBERNSTE','011.44.1344.345268','1997-04-24','SA_REP',9500,0.25,145,80),
(152,'Peter','Hall','PHALL','011.44.1344.478968','1997-08-20','SA_REP',9000,0.25,145,80),
(153,'Christopher','Olsen','COLSEN','011.44.1344.498718','1998-04-30','SA_REP',8000,0.2,145,80),
(154,'Nanette','Cambrault','NCAMBRAU','011.44.1344.987668','1998-12-09','SA_REP',7500,0.2,145,80),
(155,'Oliver','Tuvault','OTUVAULT','011.44.1344.486508','1999-11-23','SA_REP',7000,0.15,145,80),
(156,'Janette','King','JKING','011.44.1345.429268','1996-01-30','SA_REP',10000,0.35,146,80),
(157,'Patrick','Sully','PSULLY','011.44.1345.929268','1996-04-04','SA_REP',9500,0.35,146,80),
(158,'Allan','McEwen','AMCEWEN','011.44.1345.829268','1996-08-01','SA_REP',9000,0.35,146,80),
(159,'Lindsey','Smith','LSMITH','011.44.1345.729268','1997-04-10','SA_REP',8000,0.3,146,80),
(160,'Louise','Doran','LDORAN','011.44.1345.629268','1997-12-15','SA_REP',7500,0.3,146,80),
(161,'Sarath','Sewall','SSEWALL','011.44.1345.529268','1998-11-03','SA_REP',7000,0.25,146,80),
(162,'Clara','Vishney','CVISHNEY','011.44.1346.129268','1997-11-11','SA_REP',10500,0.25,147,80),
(163,'Danielle','Greene','DGREENE','011.44.1346.229268','1999-04-19','SA_REP',9500,0.15,147,80),
(164,'Mattea','Marvins','MMARVINS','011.44.1346.329268','2000-01-24','SA_REP',7200,0.1,147,80),
(165,'David','Lee','DLEE','011.44.1346.529268','1997-02-23','SA_REP',6800,0.1,147,80),
(166,'Sundar','Ande','SANDE','011.44.1346.629268','1998-03-24','SA_REP',6400,0.1,147,80),
(167,'Amit','Banda','ABANDA','011.44.1346.729268','1999-07-22','SA_REP',6200,0.1,147,80),
(168,'Lisa','Ozer','LOZER','011.44.1343.929268','1997-03-11','SA_REP',11500,0.25,148,80),
(169,'Harrison','Bloom','HBLOOM','011.44.1343.829268','1998-03-23','SA_REP',10000,0.2,148,80);

CREATE TABLE LOCATIONS(
	location_id INT PRIMARY KEY,
    street_address VARCHAR(255),
    postal_code VARCHAR(10),
    city VARCHAR(50),
    state_province VARCHAR(50),
    country_id VARCHAR(2),
    FOREIGN KEY(country_id) REFERENCES COUNTRIES(country_id)
);

INSERT INTO LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id) 
VALUES
(1000, '1297 Via Cola di Rie', '989', 'Roma', NULL, 'IT'),
(1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'IT'),
(1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP'),
(1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP'),
(1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
(1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US'),
(1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US'),
(1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
(1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),
(1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA'),
(2000, '40-5-12 Laogianggen', '190518', 'Beijing', NULL, 'CN'),
(2100, '1298 Vileparle (E)', '490231', 'Bombay', 'Maharashtra', 'IN'),
(2200, '12-98 Victoria Street', '2901', 'Sydney', 'New South Wales', 'AU'),
(2300, '198 Clementi North', '540198', 'Singapore', NULL, 'SG'),
(2400, '8204 Arthur St', NULL, 'London', NULL, 'UK'),
(2500, 'Magdalen Centre, The Oxford Science Park', 'OX9 9ZB', 'Oxford', NULL, 'UK'),
(2600, '9702 Chester Road', '9629850293', 'Stretford', 'Manchester', 'UK'),
(2700, 'Schwanthalerstr. 7031', '80925', 'Munich', 'Bavaria', 'DE'),
(2800, 'Rua Frei Caneca 1360', '01307-002', 'Sao Paulo', 'Sao Paulo', 'BR'),
(2900, '20 Rue des Corps-Saints', '1730', 'Geneva', 'Geneve', 'CH'),
(3000, 'Murtenstrasse 921', '3095', 'Bern', 'BE', 'CH'),
(3100, 'Pieter Breughelstraat 837', '3029SK', 'Utrecht', 'Utrecht', 'NL'),
(3200, 'Mariano Escobedo 9991', '11932', 'Mexico City', 'Distrito Federal', 'MX');

CREATE TABLE DEPARTMENTS(
	department_id INT PRIMARY KEY,
    department_name VARCHAR(50),
    manager_id INT REFERENCES EMPLOYEES(employee_id),
    location_id INT REFERENCES LOCATIONS(location_id)
);

INSERT INTO DEPARTMENTS(department_id, department_name, manager_id, location_id) 
VALUES
(10, 'Administration', 200, 1700),
(20, 'Marketing', 201, 1800),
(30, 'Purchasing', 114, 1700),
(40, 'Human Resources', 203, 2400),
(50, 'Shipping', 121, 1500),
(60, 'IT', 103, 1400),
(70, 'Public Relations', 204, 2700),
(80, 'Sales', 145, 2500),
(90, 'Executive', 100, 1700),
(100, 'Finance', 108, 1700),
(110, 'Accounting', 205, 1700),
(120, 'Treasury',  NULL, 1700),
(130, 'Corporate Tax',  NULL, 1700),
(140, 'Control And Credit',  NULL, 1700),
(150, 'Shareholder Services',  NULL, 1700),
(160, 'Benefits',  NULL, 1700),
(170, 'Manufacturing',  NULL, 1700),
(180, 'Construction',  NULL, 1700),
(190, 'Contracting',  NULL, 1700),
(200, 'Operations',  NULL, 1700),
(210, 'IT Support',  NULL, 1700),
(220, 'NOC',  NULL, 1700),
(230, 'IT Helpdesk',  NULL, 1700),
(240, 'Government Sales',  NULL, 1700),
(250, 'Retail Sales',  NULL, 1700),
(260, 'Recruiting',  NULL, 1700),
(270, 'Payroll',  NULL, 1700);

CREATE TABLE JOBS(
	job_id VARCHAR(15) PRIMARY KEY,
    job_title VARCHAR(50),
    min_salary INT,
    max_salary INT
); 

INSERT INTO JOBS(job_id, job_title, min_salary, max_salary) 
VALUES
(' AD_PRES', ' President', 20000, 40000),
(' AD_VP', ' Administration Vice President', 15000, 30000),
(' AD_ASST', ' Administration Assistant', 3000, 6000),
(' FI_MGR', ' Finance Manager', 8200, 16000),
(' FI_ACCOUNT', ' Accountant', 4200, 9000),
(' AC_MGR', ' Accounting Manager', 8200, 16000),
(' AC_ACCOUNT', ' Public Accountant', 4200, 9000),
(' SA_MAN', ' Sales Manager', 10000, 20000),
(' SA_REP', ' Sales Representative', 6000, 12000),
(' PU_MAN', ' Purchasing Manager', 8000, 15000),
(' PU_CLERK', ' Purchasing Clerk', 2500, 5500),
(' ST_MAN', ' Stock Manager', 5500, 8500),
(' ST_CLERK', ' Stock Clerk', 2000, 5000),
(' SH_CLERK', ' Shipping Clerk', 2500, 5500),
(' IT_PROG', ' Programmer', 4000, 10000),
(' MK_MAN', ' Marketing Manager', 9000, 15000),
(' MK_REP', ' Marketing Representative', 4000, 9000),
(' HR_REP', ' Human Resources Representative', 4000, 9000),
(' PR_REP', ' Public Relations Representative', 4500, 10500);

CREATE TABLE JOB_HISTORY(
	employee_id INT,
    start_date DATE,
    PRIMARY KEY(employee_id, start_date),
    end_date DATE,
    job_id VARCHAR(15) REFERENCES JOBS(job_id),
    department_id INT REFERENCES DEPARTMENTS(department_id)
);

INSERT INTO JOB_HISTORY(employee_id, start_date, end_date, job_id, department_id) 
VALUES
(102, '1993-01-13','1998-07-24', 'IT_PROG', 60),
(101, '1989-09-21','1993-10-27', 'AC_ACCOUNT', 110),
(101, '1993-10-28','1997-04-15', 'AC_MGR', 110),
(201, '1996-02-17','1999-12-19', 'MK_REP', 20),
(114, '1998-04-24','1999-12-31', 'ST_CLERK', 50),
(122, '1999-01-01','1999-12-31', 'ST_CLERK', 50),
(200, '1987-09-17','1993-06-17', 'AD_ASST', 90),
(176, '1998-04-24','1998-12-31', 'SA_REP', 80),
(176, '1999-01-01','1999-12-31', 'SA_MAN', 80),
(200, '1994-07-01','1998-12-31', 'AC_ACCOUNT', 90);
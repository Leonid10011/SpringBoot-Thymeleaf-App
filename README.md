# Introduction
This is a simple App that lists, saves, updates and deletes **Employee** entities. 

Built with:
- Spring boot for backend 
- Thymeleaf template engine for frontend visualization
- Bootstrap for css
- Mysql database for storage

# Instructions
## 1. Install Mysql
Install mysql server
```shell
    sudo apt install mysql-server
```

## 2. Create DB User
Log in as root or other user with sufficient access rights and run the **create-user.sql** script:
```roomsql
-- Drop user first if they exist
DROP USER if exists 'testUser001'@'%' ;

-- Now create user with prop privileges
CREATE USER 'testUser001'@'%' IDENTIFIED BY 'test';

GRANT ALL PRIVILEGES ON * . * TO 'testUser001'@'%';
```

## 3. Init Database
Create the database and initialize it with some data, use the **employee-directory.sql** script:
```roomsql
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
    (1,'Xavier','Harrington','Xavier@example.com'),
    (2,'Olivia','Rodriguez','Olivia@example.com'),
    (3,'Ethan','Montgomery','Ethan@example.com')
```

## 4. Dependencies
Install the maven dependencies
```shell
./mvn install
```
## 5. Run
### 5.1 Maven
Run the spring app in dev mode with, e.g. maven
```shell
./mvnw spring-dev:boot
```
### 5.2 Standard built
Or alternatively build and run the 
```shell
./src/main/java/com/lbcoding/springboot/thymeleafApp/Main.java
```
file.

## 6. Start App
Use the app on
```text
https://localhost:8080
```

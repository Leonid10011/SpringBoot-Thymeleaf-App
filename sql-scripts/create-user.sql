-- Drop user first if they exist
DROP USER if exists 'testUser001'@'%' ;

-- Now create user with prop privileges
CREATE USER 'testUser001'@'%' IDENTIFIED BY 'testUser001';

GRANT ALL PRIVILEGES ON * . * TO 'testUser001'@'%';
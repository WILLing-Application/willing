DROP DATABASE IF EXISTS willing_app;

CREATE DATABASE IF NOT EXISTS willing_app;

USE willing_app;

CREATE USER 'willing'@'localhost' IDENTIFIED BY 'codeup';
GRANT ALL ON willing_app.* TO 'willing'@'localhost';
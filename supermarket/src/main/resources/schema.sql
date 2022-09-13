DROP TABLE IF EXISTS supermarket;

CREATE TABLE supermarket(
    id INT AUTO_INCREMENT PRIMARY KEY,
    item VARCHAR(250) UNIQUE,
    price INT NOT NULL,
    promotion1 BOOLEAN,
    promotion2 BOOLEAN
);
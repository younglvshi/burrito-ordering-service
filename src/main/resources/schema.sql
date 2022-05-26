DROP TABLE IF EXISTS BurritoOrder;

CREATE TABLE BurritoOrder (
    orderId INT PRIMARY KEY,
    tortilla VARCHAR(50) NOT NULL,
    protein VARCHAR(50) NOT NULL,
    vegetable_1 VARCHAR(50),
    vegetable_2 VARCHAR(50),
    vegetable_3 VARCHAR(50),
    salsa VARCHAR(50) NOT NULL,
    extra VARCHAR(50)
);
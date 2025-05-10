CREATE TABLE IF NOT EXISTS products
(
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price NUMERIC NOT NULL
);
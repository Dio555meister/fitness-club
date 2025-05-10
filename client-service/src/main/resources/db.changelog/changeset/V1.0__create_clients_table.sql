CREATE TABLE IF NOT EXISTS clients
    (
    id UUID PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    phone_number VARCHAR(32) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(255),
    gender VARCHAR(32),
    membership_id UUID,
    date_of_last_visit TIMESTAMPTZ,
    create_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
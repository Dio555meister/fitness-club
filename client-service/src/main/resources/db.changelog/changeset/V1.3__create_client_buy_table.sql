CREATE TABLE IF NOT EXISTS "order"
(
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    product_id UUID NOT NULL,
    payment_id UUID NOT NULL,
    amount NUMERIC NOT NULL,
    date TIMESTAMPTZ NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );
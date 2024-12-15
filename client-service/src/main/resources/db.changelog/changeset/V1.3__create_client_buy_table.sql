CREATE TABLE IF NOT EXISTS client_buy
(
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    product_id UUID NOT NULL,
    payment_id UUID NOT NULL,
    amount NUMERIC NOT NULL,
    buy_date TIMESTAMPTZ NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );
CREATE TABLE IF NOT EXISTS payment
(
    id UUID PRIMARY KEY,
    sender_account_number VARCHAR(20) NOT NULL,
    receiver_account_number VARCHAR(20) NOT NULL,
    satus VARCHAR(32),
    amount NUMERIC NOT NULL,
    currency VARCHAR(32),
    idempotency_key UUID NOT NULL,
    client_id UUID NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW() NOT NULL,

    FOREIGN KEY (client_id) REFERENCES client(id),
)
CREATE TABLE IF NOT EXISTS client_visits
(
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    visit_date TIMESTAMPTZ NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);
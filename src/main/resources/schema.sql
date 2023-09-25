CREATE TABLE IF NOT EXISTS image
(
    id        SERIAL PRIMARY KEY,
    title     VARCHAR(255),
    path      VARCHAR(255) NOT NULL
);

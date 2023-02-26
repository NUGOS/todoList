CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL,
    role VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password, enabled, role) VALUES ('user', '$2a$10$5YfLHxvDBdsGXrY6JZObLO9RC4VExlIzafVevqFZwq0dyg.yPvyNS', true, 'USER');

CREATE TABLE IF NOT EXISTS users (
    id BIGINT auto_increment,
    uuid UUID NOT NULL,
    name TEXT,
    password TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX uuid_users ON users (uuid);
CREATE INDEX name_users ON users (name);
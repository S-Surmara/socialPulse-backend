CREATE TABLE user_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);
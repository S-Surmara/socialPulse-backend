CREATE TABLE IF NOT EXISTS friendship (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    friend_id BIGINT,
    status VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user_table(id),
    FOREIGN KEY (friend_id) REFERENCES user_table(id)
);
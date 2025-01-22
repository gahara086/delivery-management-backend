-- データベースの作成とユーザーの設定
CREATE DATABASE IF NOT EXISTS delivery_db;
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON delivery_db.* TO 'user'@'%';
FLUSH PRIVILEGES;

-- テーブルの作成
USE delivery_db;

CREATE TABLE IF NOT EXISTS deliveries (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    recipient_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL
);

-- サンプルデータの挿入
INSERT INTO deliveries (recipient_name, address, status) VALUES
('田中太郎', '東京都千代田区丸の内1-1-1', 'Pending'),
('山田花子', '愛知県名古屋市中区栄3-1-1', 'Shipped'),
('佐藤次郎', '大阪府大阪市中央区本町4-2-1', 'Delivered');

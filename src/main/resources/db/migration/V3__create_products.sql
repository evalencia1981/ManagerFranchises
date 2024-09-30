-- Migration script to create the products table
-- Version: 3
-- Description: Create the products table

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Primary key, auto-incremented
    branche_id INT NOT NULL,                -- Foreign key referencing branches table
    name VARCHAR(255) NOT NULL,              -- Name of the product (cannot be null)
    price DECIMAL(10, 2) NOT NULL,           -- Price of the product (up to 99999999.99)
    stock INT DEFAULT 0,                     -- Stock quantity, default 0
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Automatically captures creation time
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- Updates on modification
    FOREIGN KEY (branche_id) REFERENCES branches(id) ON DELETE CASCADE  -- Foreign key constraint
);
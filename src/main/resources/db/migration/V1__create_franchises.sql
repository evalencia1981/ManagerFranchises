-- Migration script to create the franchises table
-- Version: 1
-- Description: Initial creation of the franchises table

CREATE TABLE franchises (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Primary key, auto-incremented
    name VARCHAR(255) NOT NULL,              -- Name of the franchise (cannot be null)
    description TEXT,                        -- Description of the franchise (optional)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Automatically captures creation time
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- Automatically updates the timestamp when a record is modified
);
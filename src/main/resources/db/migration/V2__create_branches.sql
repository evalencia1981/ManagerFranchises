-- Migration script to create the branches table
-- Version: 2
-- Description: Create the branches table

CREATE TABLE branches (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Primary key, auto-incremented
    franchise_id INT NOT NULL,              -- Foreign key referencing franchises table
    name VARCHAR(255) NOT NULL,              -- Name of the branch (cannot be null)
    address VARCHAR(255),                    -- Address of the branch (optional)
    phone VARCHAR(50),                       -- Phone number of the branch (optional)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Automatically captures creation time
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  -- Updates on modification
    FOREIGN KEY (franchise_id) REFERENCES franchises(id) ON DELETE CASCADE  -- Set up foreign key constraint
);
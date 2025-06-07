
-- Insert demo Users
INSERT INTO users (username, password, role, pharmacy_id, status, created_by, updated_by)
VALUES
('admin', 'admin123', 'ADMIN', 1, 'ACTIVE',  'system', 'system'),
('cashier1', 'cashier123', 'CASHIER',1,  'ACTIVE', 'system', 'system');


-- Insert demo Customers
INSERT INTO customers (name, email, phone, address, created_by, updated_by)
VALUES
('John Doe', 'john@example.com', '1234567890', '123 Main St', 'admin', 'admin'),
('Jane Smith', 'jane@example.com', '9876543210', '456 Oak St', 'admin', 'admin');


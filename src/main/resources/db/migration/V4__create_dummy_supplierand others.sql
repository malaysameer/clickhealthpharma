
-- Insert demo Suppliers
INSERT INTO suppliers (name, contact_email, phone, address, created_by, updated_by)
VALUES
('MediSupply Co', 'contact@medisupply.com', '1112223333', '789 Supplier Rd', 'admin', 'admin'),
('PharmaPlus Ltd', 'support@pharmaplus.com', '4445556666', '321 Health Ave', 'admin', 'admin');

-- Insert demo Medicines
INSERT INTO medicines (name, batch_number, expiry_date, quantity, price, supplier_id, created_by, updated_by)
VALUES
('Paracetamol 500mg', 'BATCH001', '2026-12-31', 100, 2.50, 1, 'admin', 'admin'),
('Ibuprofen 200mg', 'BATCH002', '2025-11-30', 200, 3.00, 2, 'admin', 'admin');

-- Insert demo Sales
INSERT INTO sales (customer_id, sale_date, total_amount, created_by, updated_by)
VALUES
(1, SYSDATETIMEOFFSET(), 10.00, 'admin', 'admin'),
(2, SYSDATETIMEOFFSET(), 6.00, 'admin', 'admin');

-- Insert demo Sale Items
INSERT INTO sale_items (medicine_id, quantity, price, sale_id, created_by, updated_by)
VALUES
(1, 2, 2.50, 1, 'admin', 'admin'),  -- 2 units of medicine_id 1
(2, 2, 3.00, 2, 'admin', 'admin');  -- 2 units of medicine_id 2

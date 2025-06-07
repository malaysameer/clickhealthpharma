-- Drop existing tables in reverse order of dependencies to avoid FK conflicts
IF OBJECT_ID('sale_items', 'U') IS NOT NULL DROP TABLE sale_items;
IF OBJECT_ID('sales', 'U') IS NOT NULL DROP TABLE sales;
IF OBJECT_ID('purchase_items', 'U') IS NOT NULL DROP TABLE purchase_items;
IF OBJECT_ID('purchases', 'U') IS NOT NULL DROP TABLE purchases;
IF OBJECT_ID('medicines', 'U') IS NOT NULL DROP TABLE medicines;
IF OBJECT_ID('suppliers', 'U') IS NOT NULL DROP TABLE suppliers;
IF OBJECT_ID('customers', 'U') IS NOT NULL DROP TABLE customers;
IF OBJECT_ID('users', 'U') IS NOT NULL DROP TABLE users;
IF OBJECT_ID('pharmacies', 'U') IS NOT NULL DROP TABLE pharmacies;

-- Customers
CREATE TABLE customers (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100)
);

-- Suppliers
CREATE TABLE suppliers (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100)
);

-- Medicines
CREATE TABLE medicines (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    batch_number VARCHAR(255) NOT NULL,
    expiry_date DATE NOT NULL,
    quantity INT NOT NULL CHECK (quantity >= 0),
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    supplier_id INT,
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

-- Purchases
CREATE TABLE purchases (
    id INT IDENTITY PRIMARY KEY,
    supplier_id INT NOT NULL,
    purchase_date DATETIME2 NOT NULL,
    total_amount DECIMAL(10, 2),
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

-- Purchase Items
CREATE TABLE purchase_items (
    id BIGINT IDENTITY PRIMARY KEY,
    medicine_id INT NOT NULL,
    quantity INT NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    purchase_id INT,
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100),
    FOREIGN KEY (medicine_id) REFERENCES medicines(id),
    FOREIGN KEY (purchase_id) REFERENCES purchases(id)
);

-- Sales
CREATE TABLE sales (
    id INT IDENTITY PRIMARY KEY,
    customer_id INT NOT NULL,
    sale_date DATETIMEOFFSET NOT NULL,
    total_amount DECIMAL(10, 2),
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Sale Items
CREATE TABLE sale_items (
    id BIGINT IDENTITY PRIMARY KEY,
    medicine_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    sale_id INT,
    created_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    created_by  VARCHAR(100),
    updated_at  DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    updated_by  VARCHAR(100),
    FOREIGN KEY (medicine_id) REFERENCES medicines(id),
    FOREIGN KEY (sale_id) REFERENCES sales(id)
);

-- Create pharmacies table
CREATE TABLE pharmacies (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(500),
    created_at DATETIMEOFFSET DEFAULT SYSDATETIMEOFFSET(),
    created_by VARCHAR(100),
    updated_at DATETIMEOFFSET DEFAULT SYSDATETIMEOFFSET(),
    updated_by VARCHAR(100)
);

-- Users
CREATE TABLE users (
    id INT IDENTITY PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'ACTIVE',
    pharmacy_id INT NOT NULL,
    last_login_at DATETIMEOFFSET NULL,
    failed_login_attempts INT NOT NULL DEFAULT 0,
    created_at DATETIMEOFFSET DEFAULT SYSDATETIMEOFFSET() NOT NULL,
    created_by VARCHAR(100),
    updated_at DATETIMEOFFSET DEFAULT SYSDATETIMEOFFSET(),
    updated_by VARCHAR(100),
    FOREIGN KEY (pharmacy_id) REFERENCES pharmacies(id)
);


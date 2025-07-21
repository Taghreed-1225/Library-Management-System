-- Library Management System Database Schema
-- Created for CODE81 Task

-- Create the database
CREATE DATABASE IF NOT EXISTS library_management;
USE library_management


-- Drop tables if they exist (in correct order to handle foreign key constraints)
DROP TABLE IF EXISTS borrowing_transaction;
DROP TABLE IF EXISTS book_authors;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS publishers;

-- Create Publishers table
CREATE TABLE publishers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Authors table
CREATE TABLE authors (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Categories table (with hierarchical structure)
CREATE TABLE categories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    parent_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (parent_id) REFERENCES categories(id) ON DELETE CASCADE
);

-- Create Users table (system users)
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL, -- Should be hashed
    role ENUM('ADMIN', 'LIBRARIAN', 'STAFF') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Members table
CREATE TABLE members (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    registration_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create Books table
CREATE TABLE books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(500) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    language VARCHAR(50),
    edition VARCHAR(50),
    summary TEXT,
    publication_year INT,
    cover_image VARCHAR(500),
    available BOOLEAN NOT NULL DEFAULT TRUE,
    publisher_id BIGINT,
    category_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (publisher_id) REFERENCES publishers(id) ON DELETE SET NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

-- Create Many-to-Many relationship table for Books and Authors
CREATE TABLE book_authors (
    book_id BIGINT,
    author_id BIGINT,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);

-- Create Borrowing Transactions table
CREATE TABLE borrowing_transaction (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    borrow_date DATE NOT NULL,
    return_date DATE,
    returned BOOLEAN NOT NULL DEFAULT FALSE,
    book_id BIGINT NOT NULL,
    member_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE RESTRICT,
    FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE RESTRICT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE RESTRICT
);

-- Insert sample data

-- Publishers
INSERT INTO publishers (name, address) VALUES
('Penguin Random House', '1745 Broadway, New York, NY 10019'),
('HarperCollins', '195 Broadway, New York, NY 10007'),
('Simon & Schuster', '1230 Avenue of the Americas, New York, NY 10020'),
('Hachette Book Group', '1290 Avenue of the Americas, New York, NY 10104'),
('Macmillan Publishers', '120 Broadway, New York, NY 10271');

-- Authors
INSERT INTO authors (first_name, last_name) VALUES
('George', 'Orwell'),
('Jane', 'Austen'),
('Mark', 'Twain'),
('Charles', 'Dickens'),
('Virginia', 'Woolf'),
('Ernest', 'Hemingway'),
('Agatha', 'Christie'),
('J.K.', 'Rowling'),
('Stephen', 'King'),
('Toni', 'Morrison');

-- Categories (with hierarchical structure)
INSERT INTO categories (name, parent_id) VALUES
('Fiction', NULL),
('Non-Fiction', NULL),
('Science', NULL),
('History', NULL),
('Biography', NULL);

-- Sub-categories
INSERT INTO categories (name, parent_id) VALUES
('Classic Literature', 1),
('Mystery & Thriller', 1),
('Science Fiction', 1),
('Romance', 1),
('Computer Science', 3),
('Physics', 3),
('Mathematics', 3),
('World History', 4),
('Ancient History', 4);

-- System Users
INSERT INTO users (username, email, password, role) VALUES
('admin', 'admin@library.com', '$2a$10$example.hashed.password', 'ADMIN'),
('librarian1', 'librarian1@library.com', '$2a$10$example.hashed.password', 'LIBRARIAN'),
('librarian2', 'librarian2@library.com', '$2a$10$example.hashed.password', 'LIBRARIAN'),
('staff1', 'staff1@library.com', '$2a$10$example.hashed.password', 'STAFF'),
('staff2', 'staff2@library.com', '$2a$10$example.hashed.password', 'STAFF');

-- Members
INSERT INTO members (name, email, phone, address, registration_date) VALUES
('Ahmed Ali', 'ahmed.ali@email.com', '+20123456789', '123 Main St, Cairo, Egypt', '2024-01-15'),
('Sara Mohamed', 'sara.mohamed@email.com', '+20987654321', '456 Elm St, Giza, Egypt', '2024-02-20'),
('Omar Hassan', 'omar.hassan@email.com', '+20555666777', '789 Oak Ave, Alexandria, Egypt', '2024-03-10'),
('Fatma Ahmed', 'fatma.ahmed@email.com', '+20111222333', '321 Pine St, Cairo, Egypt', '2024-04-05'),
('Khaled Ibrahim', 'khaled.ibrahim@email.com', '+20444555666', '654 Cedar Rd, Luxor, Egypt', '2024-05-12');

-- Books
INSERT INTO books (title, isbn, language, edition, summary, publication_year, cover_image, available, publisher_id, category_id) VALUES
('1984', '978-0451524935', 'English', '1st', 'A dystopian social science fiction novel about totalitarian rule', 1949, 'https://example.com/1984.jpg', TRUE, 1, 6),
('Pride and Prejudice', '978-0141439518', 'English', '2nd', 'A romantic novel of manners set in Georgian England', 1813, 'https://example.com/pride.jpg', TRUE, 2, 9),
('The Adventures of Tom Sawyer', '978-0486400778', 'English', '1st', 'Adventures of a boy growing up along the Mississippi River', 1876, 'https://example.com/tom.jpg', TRUE, 3, 6),
('A Tale of Two Cities', '978-0486406510', 'English', '3rd', 'Historical novel set in London and Paris before and during the French Revolution', 1859, 'https://example.com/tale.jpg', FALSE, 2, 6),
('To the Lighthouse', '978-0156907392', 'English', '1st', 'Modernist novel examining the Ramsay family during visits to the Isle of Skye', 1927, 'https://example.com/lighthouse.jpg', TRUE, 4, 6),
('The Old Man and the Sea', '978-0684801223', 'English', '1st', 'Short novel about an aging Cuban fisherman', 1952, 'https://example.com/oldman.jpg', TRUE, 3, 6),
('Murder on the Orient Express', '978-0062693662', 'English', '2nd', 'Detective novel featuring Hercule Poirot', 1934, 'https://example.com/orient.jpg', TRUE, 2, 7),
('Harry Potter and the Philosophers Stone', '978-0439708180', 'English', '1st', 'First book in the Harry Potter series', 1997, 'https://example.com/harry1.jpg', TRUE, 1, 8),
('The Shining', '978-0307743657', 'English', '1st', 'Horror novel about a family isolated in a haunted hotel', 1977, 'https://example.com/shining.jpg', TRUE, 5, 7),
('Beloved', '978-1400033416', 'English', '1st', 'Novel about the legacy of slavery', 1987, 'https://example.com/beloved.jpg', TRUE, 1, 6);

-- Book Authors relationships
INSERT INTO book_authors (book_id, author_id) VALUES
(1, 1), -- 1984 by George Orwell
(2, 2), -- Pride and Prejudice by Jane Austen
(3, 3), -- Tom Sawyer by Mark Twain
(4, 4), -- Tale of Two Cities by Charles Dickens
(5, 5), -- To the Lighthouse by Virginia Woolf
(6, 6), -- Old Man and the Sea by Ernest Hemingway
(7, 7), -- Orient Express by Agatha Christie
(8, 8), -- Harry Potter by J.K. Rowling
(9, 9), -- The Shining by Stephen King
(10, 10); -- Beloved by Toni Morrison

-- Borrowing Transactions
INSERT INTO borrowing_transaction (borrow_date, return_date, returned, book_id, member_id, user_id) VALUES
('2024-06-01', '2024-06-15', TRUE, 1, 1, 2),
('2024-06-05', NULL, FALSE, 2, 2, 3),
('2024-06-10', '2024-06-24', TRUE, 3, 3, 2),
('2024-06-15', NULL, FALSE, 5, 4, 4),
('2024-06-20', NULL, FALSE, 6, 5, 3),
('2024-06-25', '2024-07-09', TRUE, 7, 1, 2),
('2024-07-01', NULL, FALSE, 8, 2, 4),
('2024-07-05', NULL, FALSE, 9, 3, 3);

-- Create indexes for better performance
CREATE INDEX idx_books_title ON books(title);
CREATE INDEX idx_books_isbn ON books(isbn);
CREATE INDEX idx_books_available ON books(available);
CREATE INDEX idx_members_email ON members(email);
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_borrowing_transaction_dates ON borrowing_transaction(borrow_date, return_date);
CREATE INDEX idx_borrowing_transaction_returned ON borrowing_transaction(returned);

-- Create views for common queries
CREATE VIEW active_borrowings AS
SELECT 
    bt.id,
    bt.borrow_date,
    b.title as book_title,
    m.name as member_name,
    m.email as member_email,
    u.username as handled_by,
    DATEDIFF(CURRENT_DATE, bt.borrow_date) as days_borrowed
FROM borrowing_transaction bt
JOIN books b ON bt.book_id = b.id
JOIN members m ON bt.member_id = m.id
JOIN users u ON bt.user_id = u.id
WHERE bt.returned = FALSE;

CREATE VIEW book_catalog AS
SELECT 
    b.id,
    b.title,
    b.isbn,
    b.language,
    b.publication_year,
    b.available,
    GROUP_CONCAT(CONCAT(a.first_name, ' ', a.last_name) SEPARATOR ', ') as authors,
    p.name as publisher,
    c.name as category
FROM books b
LEFT JOIN book_authors ba ON b.id = ba.book_id
LEFT JOIN authors a ON ba.author_id = a.id
LEFT JOIN publishers p ON b.publisher_id = p.id
LEFT JOIN categories c ON b.category_id = c.id
GROUP BY b.id, b.title, b.isbn, b.language, b.publication_year, b.available, p.name, c.name;
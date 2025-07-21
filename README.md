# 📚 Library Management System

## 🧩 Overview
A backend RESTful API built with **Spring Boot** for managing a library system.  
The system allows the management of books, authors, categories, members, publishers, users, and borrowing transactions.

---

## 🛠️ Technologies Used
- Java 17+
- Spring Boot
- Spring Web
- Spring Security
- Spring Data JPA (Hibernate)
- Lombok
- MySQL
- Postman (for API testing)

---
## 📌 Core Tables
| Table Name             | Description                          |
|------------------------|--------------------------------------|
| `books`                | Book information with metadata       |
| `authors`              | Author information                   |
| `publishers`           | Publisher details                    |
| `categories`           | Hierarchical category system         |
| `members`              | Library member information           |
| `users`                | System users with roles              |
| `borrowing_transaction`| Transaction records                  |

---

## 🗃️ Entities & Relationships
- `Book`:
  - Many-to-Many with `Author`
  - Many-to-One with `Category`
  - Many-to-One with `Publisher`
- `BorrowingTransaction`:
  - One `Book`
  - One `Member`
  - One `User` (who made the transaction)

---

## 🔐 User Roles & Access
| Role       | Access Example           |
|------------|--------------------------|
| ADMIN      | Manage all resources     |
| LIBRARIAN  | Handle books & lending   |
| STAFF      | View and update status   |

*🔐 (Security details can be added later)*

---

## 📦 REST API Endpoints

### 👤 AppUserController
| Method | Endpoint         | Description            |
|--------|------------------|------------------------|
| GET    | `/api/users`     | Get all users          |
| POST   | `/api/users`     | Create new user        |
| DELETE | `/api/users/{id}`| Delete user by ID      |

---

### 📚 BookController
| Method | Endpoint         | Description            |
|--------|------------------|------------------------|
| GET    | `/api/books`     | Get all books          |
| GET    | `/api/books/{id}`| Get book by ID         |
| POST   | `/api/books`     | Add new book           |
| PUT    | `/api/books/{id}`| Update book            |
| DELETE | `/api/books/{id}`| Delete book            |

---

### ✍️ AuthorController
| Method | Endpoint       | Description        |
|--------|----------------|--------------------|
| GET    | `/api/authors` | Get all authors    |
| POST   | `/api/authors` | Create new author  |

---

### 📂 CategoryController
| Method | Endpoint          | Description         |
|--------|-------------------|---------------------|
| GET    | `/api/categories` | Get all categories  |
| POST   | `/api/categories` | Add new category    |

---

### 🧾 PublisherController
| Method | Endpoint           | Description        |
|--------|--------------------|--------------------|
| GET    | `/api/publishers`  | Get all publishers |
| POST   | `/api/publishers`  | Add new publisher  |

---

### 👥 MemberController
| Method | Endpoint             | Description        |
|--------|----------------------|--------------------|
| GET    | `/api/members`       | Get all members    |
| GET    | `/api/members/{id}`  | Get member by ID   |
| POST   | `/api/members`       | Add new member     |
| PUT    | `/api/members/{id}`  | Update member      |
| DELETE | `/api/members/{id}`  | Delete member      |

---

### 🔄 BorrowingTransactionController
| Method | Endpoint                     | Description         |
|--------|------------------------------|---------------------|
| GET    | `/api/transactions`          | Get all transactions|
| POST   | `/api/transactions/borrow`   | Borrow a book       |
| PUT    | `/api/transactions/return/{id}` | Return a book    |

---



# Personal Blogging Platform REST API

A simple RESTful API built with **Java and Spring Boot** that supports basic CRUD (Create, Read, Update, Delete) operations for a personal blogging platform. This project is designed to demonstrate REST best practices, HTTP methods, status codes, validation, and database interaction.

---

## 🚀 Features

* Create a new blog post
* Get a single blog post by ID
* Get all blog posts
* Update an existing blog post
* Delete a blog post
* Filter blog posts using a search term (wildcard search)
* Proper HTTP status codes and error handling

---

## 🛠 Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Build Tool:** Maven
* **Database:** MySQL
* **ORM:** Spring Data JPA
* **API Style:** RESTful

---

## 🗄 Database Design (ER Diagram / Schema)

### 'posts' Table

| Column Name | Data Type    | Constraints                 |
| ----------- | ------------ | --------------------------- |
| id          | BIGINT       | Primary Key, Auto Increment |
| title       | VARCHAR(255) | NOT NULL                    |
| content     | TEXT         | NOT NULL                    |
| category    | VARCHAR(100) | NOT NULL                    |
| tags        | JSON / TEXT  | Nullable                    |
| created_at  | TIMESTAMP    | NOT NULL                    |
| updated_at  | TIMESTAMP    | NOT NULL                    |

**Notes:**

* `tags` are stored as a JSON array or serialized string (based on implementation)
* `created_at` and `updated_at` are automatically managed

---

## 📁 Project Structure

```
src/main/java
 └── com.example.blogging_platform
     ├── controllers        # REST Controllers
     ├── services           # Business Logic
     ├── repositories       # Data Access Layer
     ├── models             # Entity Classes
     ├── dtos               # Request and Response DTO's
     ├── exceptions         # PostNotFoundException Class
     ├── utilities          # Post and Tag Mappers
     ├── controller_advice  # Global Exception Handler
     └── BloggingPlatformApplication.java
```

---

## 🔗 API Endpoints

### ➕ Create Blog Post

**POST** `/posts`

**Request Body**

```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

**Success Response – 201 Created**

```json
{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:00:00Z"
}
```

**Error Response – 400 Bad Request**

* Returned when validation fails

---

### ✏️ Update Blog Post

**PUT** `/posts/{id}`

**Request Body**

```json
{
  "title": "My Updated Blog Post",
  "content": "This is the updated content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

**Success Response – 200 OK**

```json
{
  "id": 1,
  "title": "My Updated Blog Post",
  "content": "This is the updated content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:30:00Z"
}
```

**Error Responses**

* `400 Bad Request` – validation errors
* `404 Not Found` – blog post does not exist

---

### 🗑 Delete Blog Post

**DELETE** `/posts/{id}`

**Success Response**

* `204 No Content`

**Error Response**

* `404 Not Found` – blog post not found

---

### 📄 Get Blog Post by ID

**GET** `/posts/{id}`

**Success Response – 200 OK**

```json
{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:00:00Z"
}
```

**Error Response**

* `404 Not Found`

---

### 📚 Get All Blog Posts

**GET** `/posts`

**Success Response – 200 OK**

```json
[
  {
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2021-09-01T12:00:00Z",
    "updatedAt": "2021-09-01T12:00:00Z"
  }
]
```

---

### 🔍 Search / Filter Blog Posts

**GET** `/posts?searchTerm=tech`

* Performs a wildcard search on **title**, **content**, or **category**
* Case-insensitive matching

---

## ⚙️ Running the Application

### Prerequisites

* Java 8 or higher
* Maven
* Database

### Steps

```bash
# Clone the repository
git clone https://github.com/shlokmotwani/blogging-platform-api.git

# Navigate to project directory
cd blogging-platform-api

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## 🧪 Testing the API

You can test the endpoints using:

* Postman
* cURL

---

## 📌 Notes

* Pagination, authentication, and authorization are intentionally not implemented
* Focus is on core RESTful API functionality
* Designed for learning and practice purposes

---

## 🎯 Portfolio Highlights

* Designed and implemented a complete RESTful API using **Java & Spring Boot**
* Followed REST best practices and HTTP standards
* Implemented full **CRUD functionality** with proper status codes
* Used **Spring Data JPA** for database interactions
* Integrated **MySQL** for persistent data storage
* Implemented search functionality using wildcard queries
* Clean layered architecture (Controller → Service → Repository)

---

## 📄 License

This project is open-source and available under the **MIT License**.

---

## 👤 Author

Developed by Shlok Motwani using Java & Spring Boot as part of [Blogging Platform API learning project](https://roadmap.sh/projects/blogging-platform-api) by roadmap.sh.

Feel free to ⭐ the repository if you find it useful!

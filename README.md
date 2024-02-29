Book Store Application

This application, named "Book Store," is a small web application developed in the Spring Boot framework with a MySQL database. 
The main purpose of the application is to allow users to manage books, including creating new books,
editing existing ones, deleting books, and adding books to their own list.

Features
-Creating a New Book: Users can add information about a new book, such as title, author, price.

-Editing a Book: Existing book information can be modified as needed.

-Deleting a Book: Users can delete books from the database.

-Adding a Book to Their List: Users can add books to their favorite or wishlist.

Database Configuration

spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

The application will be launched at http://localhost:8081.

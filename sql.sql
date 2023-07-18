create database xcr_assignment_java;
use xcr_assignment_java;
CREATE TABLE book(
   bkId INT PRIMARY KEY AUTO_INCREMENT,
   title VARCHAR(255),
 author VARCHAR(255),
  isAvailable BOOLEAN DEFAULT true
 );

 INSERT INTO book (title, author, isAvailable) VALUES
    ("TestBook-1", "Author-1", true),
     ("TestBook-2", "Author-2", true);


CREATE TABLE users (
  userId INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  email VARCHAR(255),
  password varchar(255)
);
INSERT INTO users (name, email, password)
VALUES
    ("user-1", "user@user1.com", "password"),
    ("user-2", "user@user2.com", "password");

CREATE TABLE user_book (
  id INT PRIMARY KEY AUTO_INCREMENT,
  userId INT,
  bookId INT,
  startDate DATE,
  endDate DATE,
  FOREIGN KEY (userId) REFERENCES users(userId),
  FOREIGN KEY (bookId) REFERENCES book(bkId)
);
INSERT INTO user_book (userId, bookId, startDate,endDate)
VALUES
    (1,2,'2023-07-15','2023-07-20');



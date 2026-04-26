CREATE TABLE branch (
  b_id INT PRIMARY KEY AUTO_INCREMENT,
  b_name VARCHAR(50)
);

CREATE TABLE courses (
  c_id INT PRIMARY KEY AUTO_INCREMENT,
  c_name VARCHAR(50)
);

CREATE TABLE student (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  age INT,
  b_id INT,
  FOREIGN KEY (b_id) REFERENCES branch(b_id)
);

CREATE TABLE registration (
  reg_id INT PRIMARY KEY AUTO_INCREMENT,
  student_id INT,
  c_id INT,
  fees_paid DOUBLE,
  FOREIGN KEY (student_id) REFERENCES student(id),
  FOREIGN KEY (c_id) REFERENCES courses(c_id)
);
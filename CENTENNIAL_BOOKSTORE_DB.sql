--table creation
CREATE TABLE BOOKS_java(
BOOKCODE NUMBER(10),
TITLE VARCHAR2(50) NOT NULL,
AUTHOR VARCHAR2(25) NOT NULL,
PRICE DECIMAL (7,2),
TYPE VARCHAR2(25),
SUBJECT VARCHAR2(25),
CONSTRAINT BOOKS_BOOKCODE_pk PRIMARY KEY (BOOKCODE));
--Table creation
CREATE TABLE SALES(
BOOKCODE NUMBER(10),
SALESDATE DATE NOT NULL,
QUANTITY NUMBER(2,0) NOT NULL,
PRICE DECIMAL(7,2),
CONSTRAINT SALES_BOOKCODE_fk FOREIGN KEY (BOOKCODE)
REFERENCES BOOKS_java (BOOKCODE));


--inserting data for Books table
insert into BOOKS_java (bookcode,title, author, price, type, subject)
values (1,'Servletsand JSP', 'Murach',40.75, 'Technology', 'Software Engineering');

insert into BOOKS_java (bookcode,title, author, price, type, subject)
values (2,'Learning Android 2', 'Marco', 56.97, 'Technology', 'Internet');

insert into BOOKS_java (bookcode,title, author, price, type, subject)
values (3,'Under the Sea', 'Johnson', 43.00, 'Science', 'Marine Life');

insert into BOOKS_java (bookcode,title, author, price, type, subject)
values (4,'Harry Potter', 'Rowling', 20.50, 'Fiction', 'Fantasy');

insert into BOOKS_java (bookcode,title, author, price, type, subject)
values (5,'Dogs', 'Smith', 30.75, 'Lifestyle', 'Pets');

--inserting data for Sales table
insert into Sales (bookcode,SALESDATE, quantity, price)
values (1,'23-Sep-2018', 5, 40.75);

insert into Sales (bookcode,SALESDATE, quantity, price)
values (2,'14-Oct-2018', 10, 40.75);

insert into Sales (bookcode,SALESDATE, quantity, price)
values (3,'20-Oct-2018', 15, 56.97);

insert into Sales (bookcode,SALESDATE, quantity, price)
values (4,'01-Oct-2018', 5, 20.50);

insert into Sales (bookcode,SALESDATE, quantity, price)
values (5,'15-Nov-2018', 25, 30.75);


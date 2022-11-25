INSERT INTO products (proname, unitprice) VALUES
    ('Sat', 9.99),
    ('Xi mang', 1.99),
    ('Gach', 2.99),
	('Da', 2.05),
	('Voi', 1.5);
INSERT INTO orders (customername, orderdate) VALUES
	('Pham Van Thuan', '2019-08-13'),
	('Vu', '2021-09-13'),
	('Thanh', '2021-06-10'),
	('Thao', '2020-04-05'),
	('Ly', '2020-07-21');
INSERT INTO orderdetails (orderid, proid,quantity) VALUES
	(1,1,2),
	(1,2,3),
	(2,1,3),
	(2,2,1),
	(3,1,1);
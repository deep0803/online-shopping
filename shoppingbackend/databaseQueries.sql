create table category(
id IDENTITY,
name varchar(50),
description varchar(255),
image_url varchar(50),
is_active boolean,

CONSTRAINT pk_cateogry_id PRIMARY KEY(id)

);


INSERT INTO category(name,description,image_url,is_active) VALUES('LAPTOP','This is description for Laptop','cat_102.jpg',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('Mobile','This is description for Mobile','cat_103.jpg',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('Television','This is description for Television','cat_104.jpg',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('Camera','This is description for Camera','cat_105.jpg',true);

CREATE table user_detail(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
email VARCHAR(100),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT into user_detail(first_name,last_name,role,enabled,password,email,contact_number) VALUES('Deepankaj','Yadav','ADMIN',true,'admin','deepankajyadav@gmail.com','7838094027');

INSERT into user_detail(first_name,last_name,role,enabled,password,email,contact_number) VALUES('Manoj','Yadav','SUPPLIER',true,'12345','manojyadav@gmail.com','7838094027');

INSERT into user_detail(first_name,last_name,role,enabled,password,email,contact_number) VALUES('Pratima','Yadav','SUPPLIER',true,'12345','pratimayadav@gmail.com','7838094027');


CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	

-- adding five products
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );
-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (4, '102 Sabarmati Society, Mahatma Gandhi Road', 'Near Salt Lake, Gandhi Nagar', 'Ahmedabad', 'Gujarat', 'India', '111111', true, false );
-- adding a cart for testing 
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (4, 0, 0);


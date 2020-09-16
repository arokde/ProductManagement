CREATE TABLE
    product
    (
        id BIGINT NOT NULL,
        product_name VARCHAR,
        product_code VARCHAR,
        release_date VARCHAR,
        description VARCHAR,
        price VARCHAR,
        star_rating VARCHAR,
        image_url VARCHAR,
        PRIMARY KEY (id)
    );

CREATE TABLE
    hibernate_sequence
    (
        next_val BIGINT
    );

INSERT INTO product (id, product_name,product_code,release_date,description,price,star_rating,image_url)
  VALUES (1, 'Leaf Rake', 'GDN-0011','March 19, 2019','Leaf rake with 48-inch wooden handle.','19.95','3.2','assets/images/leaf_rake.png');
INSERT INTO product (id, product_name,product_code,release_date,description,price,star_rating,image_url)
  VALUES (2, 'Garden Cart', 'GDN-0023','March 18, 2019','15 gallon capacity rolling garden cart','32.99','4.2','assets/images/garden_cart.png');
INSERT INTO product (id, product_name,product_code,release_date,description,price,star_rating,image_url)
  VALUES (3, 'Hammer', 'TBX-0048','March 21, 2019','Curved claw steel hammer','8.9','4.8','assets/images/hammer.png');
INSERT INTO product (id, product_name,product_code,release_date,description,price,star_rating,image_url)
  VALUES (4, 'Saw', 'GDN-0022','May 15, 2019','15-inch steel blade hand saw','11.55','3.7','assets/images/saw.png');
INSERT INTO product (id, product_name,product_code,release_date,description,price,star_rating,image_url)
  VALUES (5, 'Video Game Controller', 'GMG-0042','October 15, 2018','Standard two-button video game controller','35.95','4.6','assets/images/xbox-controller.png');

INSERT INTO hibernate_sequence (next_val) VALUES (4);



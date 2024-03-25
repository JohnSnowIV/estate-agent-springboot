INSERT INTO SELLER (firstname, surname, address, postcode, phone)
VALUES
('Daniel', 'Smith', '8 Lord Lane, Failsworth', 'M35 0SL', '0161 456 1143'),
('Anna', 'Smith', '6 Lord Lane, Failsworth', 'M35 0SL', '0161 742 1143'),
('Peter', 'Jones', '38 Thornley Street, Middleton', 'M24 2HX', '01706 321855'),
('Karen', 'Slater', '1 Pattishall Close, Manchester', 'M4 7DU', '0161 730 6724'),
('Jade', 'Huang', '67C King Street, Knutsford',  'WA16 6DX', '01565 671670'),
('Stephanie', 'Hill', 'Flat 3, Willow Court, Willow Bank, Manchester', 'M14 6XP', '0161 422 8502'),
('Sally', 'Bates', '39 Moss Lane, Sale',  'M33 6QF', '0161 046 3264');

INSERT INTO BUYER (firstname, surname, address, postcode, phone)
VALUES
('Nilla', 'Cat', '140 Leicester Road, Salford', 'M7 4GA', '0161 587 8706'),
('Monty', 'Dog', '34 Ravensbury Street, Manchester', 'M11 4JL', '0161 764 5760'),
('David', 'Buyerman', '2 Venesta Avenue, Salford', 'M6 8FE', '0161 671 1635');


INSERT INTO PROPERTY (listed, address, postcode, type, price, bedroom, bathroom, garden, sellerId, status, image, description)
VALUES
(true, '3 Inchcape Drive, Manchester', 'M9 8JN', 'DETACHED', 1000000, 3, 1, 1, 1, 'SOLD', 'https://media.istockphoto.com/id/1470006282/photo/for-sale-real-estate-sign-in-front-of-new-house.webp?b=1&s=170667a&w=0&k=20&c=yBoP5dTQZsTf8ZiPehFAnb1AQHc0tsedvN6FRdVmy6Q=',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'),
(true, '5 Parkfield Avenue, Urmston', 'M41 9FE', 'APARTMENT', 250000, 1, 1, 0, 2, 'FOR SALE', 'https://media.istockphoto.com/id/1470006282/photo/for-sale-real-estate-sign-in-front-of-new-house.webp?b=1&s=170667a&w=0&k=20&c=yBoP5dTQZsTf8ZiPehFAnb1AQHc0tsedvN6FRdVmy6Q=',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.');


INSERT INTO BOOKING (buyerId, propertyId, time)
VALUES
(1, 1, '2024-02-28 11:30'),
(2, 2, '2024-02-28 8:30');
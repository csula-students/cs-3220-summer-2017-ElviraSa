use item;
CREATE TABLE food_items (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    item VARCHAR(255) ,
    description VARCHAR(255) ,
    image VARCHAR(255),
    price 	DOUBLE,
    quantity INTEGER);
    
    INSERT into food_items (item, description, image, price, quantity)values
    ( 'Hamburger','A hamburger','http://assets.epicurious.com/photos/57c5c6d9cf9e9ad43de2d96e/master/pass/the-ultimate-hamburger.jpg',  9.99,1) ,
    ('Fries','Some fries','https://img.kapook.com/u/pirawan/Cooking1/french%20fried.jpg',4.99,1),
    ('Coke', 'Coke cola', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRSXMp1lJqUxpZxWmmCZdLzGLges-k-Bg7xW6FvtaL0wWQpux3',   2.99,1) ;

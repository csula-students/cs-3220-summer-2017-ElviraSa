use test;
/*Create restaurant food item table*/
CREATE TABLE foodItems (
    id INTEGER ,
    name_of_item VARCHAR(255) ,
    description VARCHAR(255) ,
    price double);
/*Create restaurant order statuses table*/
CREATE TABLE orderStatuses (
    id INTEGER ,
    customer_name VARCHAR(255) ,
    created datetime);
    /*Create restaurant  order food table*/
CREATE TABLE orderFood (
    orderId INTEGER ,
    foodId Integer ,
    quantity Integer);

    /*Create restaurant cart table*/
    
    CREATE TABLE cart (
    id INTEGER ,
    customer_name VARCHAR(255) ,
    food_id INTEGER,
    quantity INTEGER);
    /*Insert default food items into food items table*/
    INSERT into foodItems values(1, 'Hamburger',    'A hamburger',  9.99) ;
    INSERT into foodItems values(2, 'Fries',    'Some fries',   4.99) ;
    INSERT into foodItems values(3, 'Coke', 'Coke cola',    2.99) ;
    /*Insert default order statuses into order statuses table*/
    INSERT into orderStatuses values(1, 'Eric', '2017-07-20 13:35:55');
    INSERT into orderStatuses values(2, 'John', '2017-07-22 10:35:55');
    INSERT into orderStatuses values(3, 'Jane', '2017-07-22 15:35:55');
    INSERT into orderStatuses values(4, 'Alice','2017-07-22 16:35:55');
    
    /*Insert default value to the  order food table*/
    INSERT into orderFood values(1, 1,  1);
    INSERT into orderFood values(1, 2,  2);
    INSERT into orderFood values(2, 2,  2);
    INSERT into orderFood values(2, 3,  1);
    INSERT into orderFood values(3, 3,  1);
    INSERT into orderFood values(4, 2,  1);
    INSERT into orderFood values(4, 3,  2);
    /*Insert default value to the  cart table*/
    insert into cart values(1,  'Anonymous',    1,  2);
    insert into cart values(1,  'Anonymous',    2,  1);
    insert into cart values(1,  'Anonymous',    2,  1);
    insert into cart values(2,  'Mike', 1,  1);
    insert into cart values(2,  'Mike', 2,  1);
    insert into cart values(3,  'Bob',  3,  1);
   /*Update food item name from "Hamburger" to "Salad"*/
    update foodItems set name_of_item ='Salad' where name_of_item='Hamburger';
    /*Update customer name from "Jane" to "Doe"*/
    update orderStatuses set customer_name='Doe' where customer_name='Jane';
    /*Find out which food item has the most orders*/
    SELECT foodItems.name_of_item,sum(quantity)
    FROM orderFood JOIN foodItems
    WHERE foodItems.id= orderFood.foodId
    group by name_of_item 
    order by sum(quantity) desc limit 1;
    /*Find out all restaurant food items using SELECT query*/
    Select foodItems.name_of_item,sum(quantity)
from cart join foodItems
where foodItems.id=cart.food_id
group by name_of_item
order by sum(quantity)   asc limit 1; 
/*Find out all restaurant food items using SELECT query*/

    Select name_of_item
    from foodItems;
    /*Find out all restaurant order statuses using SELECT query*/
    Select*
    from orderStatuses;
    /*Find out the order statuses that is created today?*/
    Select *from orderStatuses where created like '2017-07-22%';
    /*DELETE restaurant food items table*/
    drop table if exists foodItems;
    /*Delete restaurant order statuses table*/
    drop table if exists orderStatuses;
    /*Delete restaurant cart table*/
    drop table if exists cart;

    
        
  
    
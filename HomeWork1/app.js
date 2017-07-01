    // single state store
    class Store {
        constructor(storage) {
            this.storage = storage; // assuming local storage will be passed in as storage
            // these are the key name you can use in Store
            this.CART_KEY = 'CART';
            this.QUEUE_KEY = 'QUEUE';
            this.FOODS_KEY = 'FOODS';
        }

        // you can get item by store.cartItems
        get cartItems() {
            return JSON.parse(this.storage.getItem(this.CART_KEY));
        }

        // to call setter, simply "assign" like store.cartItems = something
        set cartItems(cartItems) {
            this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
        }

        get queue() {
            return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
        }

        set queue(queue) {
            this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
        }

        get foods() {
            return JSON.parse(this.storage.getItem(this.FOODS_KEY));
        }

        set foods(foods) {
            this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
        }
    }

    class Cart {
        // take dom element into JavaScript class to attachment events
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.items = this.store.cartItems;
            this.init();

        }

        init() {
            // Render a list of items under root element
            this.render();
            // TODO: attach remove cart items to rendered HTML
        }

        destroy() {
            // TODO: remove all the events attached from init
        }

        // remove an item from shopping cart
        removeItem(item) {
            // TODO: logic to remove an item from cart
            // call render method when the item is removed to update view
            var temp=this.store.cartItems;
            temp=temp.filter(a => a !== temp[item]);
            console.log(temp);

            this.store.cartItems = temp;
            this.render();

        }

        

        // render a list of item under root element
        render() {

            console.log(this.store.cartItems);
            let tbody = this.root.querySelector('tbody');
            var dataset = this.store.cartItems;
            if (dataset === null)
                return;
            // using innerHTML to render a list of table row item under tbody
            var tbodyText = '';
            for (var i = 0; i < dataset.length; i++) {
                tbodyText = tbodyText + `<tr class="item">
                <td>${dataset[i].name}</td>
                <td>${dataset[i].price}</td>
                <td>${dataset[i].quantity}</td>
                <td><button data-id="${i}" class="delete-button">Delete</td>
                <tr>`;
            }
            tbody.innerHTML = tbodyText;
            let deleteButtons = document.querySelectorAll('.delete-button');
            deleteButtons.forEach(btn => {
                btn.addEventListener('click', () => {
  //      alert(btn.dataset.name);

  this.removeItem(btn.dataset.id);
});
            });
        }
        
    }

    class CheckoutButton {
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.onClick = () => this.addItemToCart();
            this.init();

        }

        init() {
            this.root.addEventListener('click', this.onClick);
        }

        destroy() {
        }

        addItemToCart() {


            // hint: you can use `dataset` to access data attributes
            // See passing data from HTML to JavaScript from course note
            let cartItems = this.store.cartItems || [];
            console.log(cartItems);

            // TODO: replace with actual item
            console.log(this.root);

            cartItems.push({
                name: this.root.dataset.name,
                price: this.root.dataset.price,
                image: this.root.dataset.img

            });


            this.store.cartItems = cartItems;

        }

    }

    class StatusTable {
        // take dom element into JavaScript class to attachment events
        constructor(root, store) {
            this.root = root;
            this.store = store;
            init();
        }

        init() {
            // attach click event listener to table header row on each column
            render();
        }

        destroy() {
            // remove all the events attached from init
        }

        sort(columnName) {
            // after sorting the array of statuses, re render item to update view
            render();
        }

        // render rows of items under table using root.innerHTML
        render() {
            console.log(this.store.cartItems);
            let tbody = this.root.querySelector('.status-body');
            var dataset = this.store.cartItems;
            if (dataset === null)
                return;
            // using innerHTML to render a list of table row item under tbody
            var tbodyText = '';
            for (var i = 0; i < dataset.length; i++) {
                tbodyText = tbodyText + `<tr class="item">
                <td>${dataset[i].created}</td>
                <td>${dataset[i].name}</td>
                <td>${dataset[i].price}</td>
                <td>${dataset[i].status}</td>
                <tr>`;
            }
            tbody.innerHTML = tbodyText;

        }
    }
// continue from Lab2 with Store, CheckoutButton, Cart components
class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.removeItem();
        this.init();
    }

    init() {
        let inventoryItems = this.store.inventoryItems || [];
        let foodItems=this.store.foods || [];

        //console.log(this.root[0].dataset);
        this.root.forEach(item => {
            inventoryItems.push({
                created: item.dataset.date,
                name: item.dataset.name,
                image: item.dataset.img

            })
        });
        this.store.inventoryItems = inventoryItems;
        console.log(inventoryItems[0]);
        let deleteInventorybutton = document.querySelectorAll('.delete');

        deleteInventorybutton.forEach(btn => {
            btn.addEventListener('click', () => {

                this.removeItem(btn.dataset.name);
            });
        });
        this.render();
    }


    destroy() {
        // TODO: remove event listeners added from the init above
    }

    removeItem(item) {
        // TODO: function to remove item given item name from store

   //ss     console.log(item);

        var food = this.store.inventoryItems;
        for (var i = 0; i < food.length; i++) {
            if (food[i].name === item)
                food.splice(i, 1);

        }

       // alert(item);
       this.store.inventoryItems = food;

       var foodItem=this.store.foods;
       console.log(foodItem)
       for (var i = 0; i < foodItem.length; i++) {
        if (foodItem[i].name === item)
            foodItem.splice(i, 1);

    }
    this.store.foods=foodItem;

    this.render();


}


render() {

    console.log(this.store.inventoryItems);
    let tbody = document.querySelector('.newItem');
    var dataset = this.store.inventoryItems;

    var dataset2=this.store.foods;
        //console.log('datasetfooditem'+ dataset2[0].name);

        if (dataset === null)
            return;
        // using innerHTML to render a list of table row item under tbody
        var tbodyText = '';
        for (var i = 0; i < dataset.length; i++) {
            tbodyText = tbodyText + `<tr class="newItem-Tr" data-img="${dataset[i].image}" data-name="${dataset[i].name}" data-date="${dataset[i].created}">
            <td>${dataset[i].created}</td>
            <td><img src="${dataset[i].image}" style="width:100px;height:100px;"><h3>${dataset[i].name}</h3></td> 
            <td><button data-name="${dataset[i].name}" class="delete">Delete</td>
            <tr>`;
        }
        if(dataset2){
           for (var i = 0; i < dataset2.length; i++) {
            tbodyText = tbodyText + `<tr class="newItem-Tr" data-img="${dataset2[i].image}" data-name="${dataset2[i].name}" data-date="${dataset2[i].created}">
            <td>${dataset2[i].created}</td>
            <td><img src="${dataset2[i].image}" style="width:100px;height:100px;"><h3>${dataset2[i].name}</h3></td> 
            <td><button data-name="${dataset2[i].name}" class="delete">Delete</td>
            <tr>`;
        }
    }
    if(tbody)
       tbody.innerHTML = tbodyText;

   let deleteButtons = document.querySelectorAll('.delete');
   deleteButtons.forEach(btn => {
    btn.addEventListener('click', () => {

        this.removeItem(btn.dataset.name);
    });
});


}

}

class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {
        this.render();
    }

    render() {
        // TODO: render a list of food menu from store using innerHTML
        var  store=this.store.foods;
        var menuList = document.querySelector('.menuList');
        


    }
}

class CreateFood {
    constructor(root, store) {
        this.root = root; // root should be the container of the form itself
        this.store = store;
        this.init();
       // alert('hello');

   }
   addIngredient(){
     let ingredient= this.store.ingredient || []

     var ulClass=document.querySelector('.Ingredient');
     var ingredientValue=document.querySelector('#foodIngr').value;
          // alert(ingredientValue);
          ingredient.push({ingredients: ingredientValue});
          this.store.ingredient=ingredient;
          var tbodyText = '';
          console.log(this.store.ingredient);
          ulClass.innerHTML='<li class="ingredientLi">${ingredientValue}</li>';
          for (var i = 0; i < ingredient.length; i++) {
            tbodyText = tbodyText + `<li class="ingredientLi">${ingredient[i].ingredients}</li>`;
        }
        ulClass.innerHTML = tbodyText;
    }   
    render(){

      //console.log(this.store.ingredient);
      let tbody = document.querySelector('.Ingredient');
      var dataset = this.store.ingredient;

      if (dataset === null)
        return;
        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML='';
        
        document.querySelector('#foodIngr').value='';

        document.querySelector('#foodName').value='';
        document.querySelector('#foodImg').value='';
        document.querySelector('#foodDescrip').value='';

        
    }
    init() {


        var addIng=document.querySelector('.addIngr')
        addIng.addEventListener('click', () => {

            this.addIngredient();
        });
        // attach click  to create button
        var addFood = document.querySelector('#addfood');
        addFood.addEventListener('click', ()=>{this.addfood()});
    }

    addfood() {
        // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store

        var newFood=this.store.foods || [];
        var foodName= document.querySelector('#foodName').value;
        var foodImg =document.querySelector('#foodImg').value;
       // alert(foodImg);
       var foodDescrip=document.querySelector('#foodDescrip').value;


       newFood.push({
        name:foodName,
        image:foodImg,
        Description:foodDescrip,
        Ingredients:this.store.ingredient || [],
        created: 'Jun 30 2017 10 PM'
    });
       this.store.foods=newFood;
       this.render();
       console.log(newFood);


   }
}
// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    // let statusTable = document.querySelector('');
    // // use querySelector to find the cart element (preferably by id selector)
    let cart = document.querySelector('.cart-table');
    let checkoutButtons = document.querySelectorAll('.checkout-button');
    let inventoryTableRow = document.querySelectorAll('.newItem-Tr');
    let addfood=document.querySelector('.newFood');
    let store = new Store(window.localStorage);
    // if (table) {
    //     new StatusTable(table, store);
    // }
    if(addfood)
        new CreateFood(addfood,store);

    if (inventoryTableRow)
        new Inventory(inventoryTableRow, store);

    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i++) {

            new CheckoutButton(checkoutButtons[i], store);
        }
    }
});
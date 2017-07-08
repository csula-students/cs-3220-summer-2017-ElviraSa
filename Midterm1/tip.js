let percentage = document.querySelector('#percent').value;
let bill=document.querySelector('#bill').value;
var tip = (bill*percentage)/100;

var calculate = document.querySelector('#submit');
calculate.addEventListener('click', () => {

               var total= bill+tip;
            });


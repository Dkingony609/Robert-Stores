// function addItem() {
//
//   let cards = document.getElementById("cards");
//
//   let customerID = document.getElementById("customer_id");
//   let stocks = document.getElementById("stocks");
//   let amount = document.getElementById("amount");
//   let dateOfSale = document.getElementById("dateofsale");
//   let paymentMethod = document.getElementById("payment_method");
//
//   let panel = document.createElement("li");
//
//   panel.setAttribute('cards', stocks.value);
//   panel.setAttribute('cards', customerID.value);
//   panel.setAttribute('cards', amount.value);
//   panel.setAttribute('cards', dateOfSale.value);
//   panel.setAttribute('cards', paymentMethod.value);
//
//   panel.appendChild(document.createTextNode(customerID.value));
//   panel.appendChild(document.createTextNode(stocks.value));
//   panel.appendChild(document.createTextNode(amount.value));
//   panel.appendChild(document.createTextNode(dateOfSale.value));
//   panel.appendChild(document.createTextNode(paymentMethod.value));
//
//
//   cards.appendChild(panel);
// }

setTimeout(
    ()=> {
      document.querySelector("#successful-save").style.display = "none";

    }, 5000
)
function addItem() {

  let ul = document.getElementsByClassName("cards");

  let customerID = document.getElementById("customer_id");
  let stocks = document.getElementById("stocks");
  let amount = document.getElementById("amount");
  let dateOfSale = document.getElementById("dateofsale");
  let paymentMethod = document.getElementById("payment_method");

  let li = document.createElement("li");

  li.setAttribute('id', customerID.value);
  li.setAttribute('id', stocks.value);
  li.setAttribute('id', amount.value);
  li.setAttribute('id', dateOfSale.value);
  li.setAttribute('id', paymentMethod.value);

  li.appendChild(document.createTextNode(customerID.value));
  li.appendChild(document.createTextNode(stocks.value));
  li.appendChild(document.createTextNode(amount.value));
  li.appendChild(document.createTextNode(dateOfSale.value));
  li.appendChild(document.createTextNode(paymentMethod.value));

  // console.log(customerID.value, stocks.value, amount.value, dateOfSale.value, paymentMethod.value);

  ul.appendChild(li);

}

// console.log(addItem);

function PrintMenu(menu){
  let htmlString = "";
  menu.forEach(element => {
    htmlString += `<li><a href="${element.link}">${element.name}</a></li>`
  });
  insertToMultipleElement("menu", htmlString);
}
function printProducts(quantity, bestSellers) {
  let htmlString = "";
  let q = quantity === 0 ? bestSellers.length : quantity;
  for (let index = 0; index < q; index++) {
    htmlString += `<div class="productCont">
    <a href="item.html?SKU=${bestSellers[index].SKU}">
    <img class="img" src="/img/${bestSellers[index].img}" alt="${bestSellers[index].name}">
    <img class="img2" src="/img/${bestSellers[index].img2}" alt="${bestSellers[index].name}">
    <div class="textCont">
        <h3>
        ${bestSellers[index].name}
        </h3>
        <p>${bestSellers[index].price}</p>
    </div>
    </a>
  </div>`;
  }
  insertElement("bestSellers", htmlString);
}
function printMoreBites(moreBites) {
  let htmlString = "";
  for (let index = 0; index < moreBites.length; index++) {
    const element = moreBites[index];
    htmlString += `<div class="moreBitesContainer" style="background-image:url('/img/0${index+1}.jpg') ";>
      <div>
        <h3>${element.name}</h3>
      </div>
    </div>`;
  }
  insertElement("moreBites", htmlString);
}

function insertElement(selector, text) {
  const result = document.querySelector("#" + selector);
  result.innerHTML = text;
}
function insertToMultipleElement(selector, text) {
  const result = document.querySelectorAll("." + selector);
  result.forEach(e => {
    e.innerHTML = text;
  });
}


function printOneProduct(id, shop){
  id =  parseInt(id);
  let product = shop.filter(item => item.SKU === id)[0];

  let selectOptions ="";
  for (let i = 1; i <= product.q; i++) {
    selectOptions += `<option value="${i}">${i}</option>`
  }
  let htmlString = `<div class="item">
  <div class="imgCont">
    <img src="/img/${product.img}" alt="${product.name}">
  </div>
  <div class="formCont">
    <h2>${product.name} </h2>
    <h3>sku: 000<span id="sku">${product.SKU}</span> </h3>
    <p>${product.price}</p>
    <p>Quantity</p>
    <form action="#">
      <select name="quantity" id="quantity">
        ${selectOptions}
      </select>
      <br>
      <button type="submit" id="addToCart">ADD TO CART</button>
    </form>
    <p>Description</p>
    <p>
      ${product.detail}
    </p>
  </div>
</div>`;

insertElement("bestSellers", htmlString);

}

function getItFresh(){
  const emailInput = document.querySelector(".getItFresh input");
  const emailButton = document.querySelector(".getItFresh button");

  emailButton.addEventListener("click", function(e){
    e.preventDefault();
    let email = emailInput.value;
    console.log(email)
    if(email == "" || email== null){
      alert("Most enter an email");
    }else {
      if(validateEmail(email)){
        alert(`${email} Thanks For subscribing!` );
      }else{
        alert(`${email} Is not a valid email!` );
      }

    }
    console.log();
  });
}
function getAdd(){
  const quantity = document.querySelector(".formCont Select");
  const button = document.querySelector(".formCont button");
  const name = document.querySelector(".formCont h2").innerHTML;

  button.addEventListener("click", function(e){
    e.preventDefault();
    let q = quantity.value;
    alert(`${q} ${name} have been added to the cart`)
  });
}
const validateEmail = (email) => {
  return String(email)
    .toLowerCase()
    .match(
      /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    );
};

function getUrlParams(){
  let queryString = window.location.search;
  return new URLSearchParams(queryString);
}

export{insertElement, printMoreBites, printProducts, PrintMenu, printOneProduct, getItFresh, getUrlParams, getAdd };
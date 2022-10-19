import { shop, moreBites, menu } from "/js/initialData.js";
import {
  printMoreBites,
  printProducts,
  PrintMenu,

  getItFresh
} from "/js/function.js";

printProducts(3, shop);
printMoreBites(moreBites);
PrintMenu(menu);
getItFresh();

let moreBitesCont = document.querySelectorAll(".moreBitesContainer");

moreBitesCont.forEach((element) => {
  element.addEventListener("mouseenter", function () {
    // this.classList.add("hover");
    this.querySelector("div").classList.add("hover");
    this.querySelector("h3").classList.add("hover");
  });
  element.addEventListener("mouseleave", function () {
    // this.classList.add("hover");
    this.querySelector("div").classList.remove("hover");
    this.querySelector("h3").classList.remove("hover");
  });
});

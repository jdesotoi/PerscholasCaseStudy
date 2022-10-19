import { shop, moreBites, menu } from "/js/initialData.js";
import {
  printMoreBites,
  getItFresh
} from "/js/function.js";


printMoreBites(moreBites);

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

import { shop,  menu  } from "/js/initialData.js";
import { printProducts, PrintMenu, getItFresh } from "/js/function.js";

printProducts(0, shop);
PrintMenu(menu);
getItFresh();
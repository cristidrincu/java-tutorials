/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza.new_york;

import pizza.Pizza;

/**
 *
 * @author cristiandrincu
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin crust dough";
        sauce = "Marinara Sauce";
        
        toppings.add("Grated Reggiano Cheese");
    }
}

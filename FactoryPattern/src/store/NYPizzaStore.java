/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import pizza.Pizza;
import pizza.new_york.NYStyleCheesePizza;
import pizza.new_york.NYStyleVeggiePizza;
import pizza_types.PizzaTypes;

/**
 *
 * @author cristiandrincu
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaTypes type) {
        switch (type) {
            case CHEESE:
                return new NYStyleCheesePizza();
            case VEGGIE:
                return new NYStyleVeggiePizza();
            default:
                return null;
        }
    }
    
}

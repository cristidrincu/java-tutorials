/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import pizza.Pizza;
import pizza.california.CaliforniaStyleCheesePizza;
import pizza.california.CaliforniaStyleVeggiePizza;
import pizza_types.PizzaTypes;

/**
 *
 * @author cristiandrincu
 */
public class CaliforniaPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaTypes type) {
        switch (type) {
            case CHEESE:
                return new CaliforniaStyleCheesePizza();
            case VEGGIE:
                return new CaliforniaStyleVeggiePizza();
            default:
                return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import pizza.Pizza;
import pizza.chicago.ChicagoStyleCheesePizza;
import pizza.chicago.ChicagoStyleVeggiePizza;
import pizza_types.PizzaTypes;

/**
 *
 * @author cristiandrincu
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(PizzaTypes type) {
        switch (type) {
            case CHEESE:
                return new ChicagoStyleCheesePizza();
            case VEGGIE:
                return new ChicagoStyleVeggiePizza();
            default:
                return null;
        }
    }
    
}

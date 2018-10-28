/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypattern;

import pizza.Pizza;
import pizza.VeggiePizza;
import pizza_types.PizzaTypes;

/**
 *
 * @author cristiandrincu
 */
public class SimplePizzaFactory {

    public Pizza createPizza(PizzaTypes type) {
        Pizza pizza = null;
        
        switch (type) {           
            case VEGGIE:
                pizza = new VeggiePizza();
                break;
            default:
                break;
        }        
        return pizza;
    }
}

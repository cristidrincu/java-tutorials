/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import pizza.Pizza;
import pizza_types.PizzaTypes;

/**
 *
 * @author cristiandrincu
 */
public abstract class PizzaStore {           
    
    abstract Pizza createPizza(PizzaTypes type);
    
    public Pizza orderPizza(PizzaTypes type) {
        Pizza pizza;
        
        pizza = createPizza(type);
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
}

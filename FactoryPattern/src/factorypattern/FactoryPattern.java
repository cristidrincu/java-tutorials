/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorypattern;

import pizza.Pizza;
import pizza_types.PizzaTypes;
import store.ChicagoPizzaStore;
import store.NYPizzaStore;
import store.PizzaStore;

/**
 *
 * @author cristiandrincu
 */
public class FactoryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        
        Pizza pizza = nyPizzaStore.orderPizza(PizzaTypes.CHEESE);
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        
        pizza = chicagoPizzaStore.orderPizza(PizzaTypes.CHEESE);
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
    
}

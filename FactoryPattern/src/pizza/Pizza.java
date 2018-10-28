/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import java.util.ArrayList;
import pizza_types.PizzaTypes;

/**
 *
 * @author cristiandrincu
 */
public abstract class Pizza {
    PizzaTypes type;
    public String name;
    public String dough;
    public String sauce;
    public ArrayList toppings = new ArrayList();
    
    public PizzaTypes getPizzaType() {
        return type;
    }
    
    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        toppings.forEach((topping) -> {
            System.out.println("  " + topping);
        });
    }  
    
    public void cut() {
        System.out.println("Cutting the pizza into diagonale slices");
    }
    
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    
    public String getName() {
        return name;
    }
    
}

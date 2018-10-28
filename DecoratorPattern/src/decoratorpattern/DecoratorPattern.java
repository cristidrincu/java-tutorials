/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoratorpattern;

import beverage_sizes.Sizes;
import beverages.Beverage;
import beverages.DarkRoast;
import beverages.Espresso;
import beverages.HouseBlend;
import decorators.Mocha;
import decorators.Soy;
import decorators.Whip;

/**
 *
 * @author cristiandrincu
 */
public class DecoratorPattern {   
    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        beverage.setSize(Sizes.TALL);
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        
        Beverage beverage2 = new DarkRoast();
        beverage2.setSize(Sizes.VENTI);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
        
        Beverage beverage3 = new HouseBlend();
        beverage3.setSize(Sizes.GRANDE);
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}

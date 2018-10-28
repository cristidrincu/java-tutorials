/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorators;

import beverage_sizes.Sizes;
import beverages.Beverage;

/**
 *
 * @author cristiandrincu
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;
    
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
    
    @Override
    public Sizes getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }            
}

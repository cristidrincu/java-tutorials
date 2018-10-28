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
public class Soy extends CondimentDecorator {

    Beverage beverage;
    
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
    
    @Override
    public Sizes getSize() {
        return beverage.getSize();
    }

    @Override
    public double cost() {
        switch(beverage.getSize()) {
            case TALL:
                return beverage.cost() + .10;
            case GRANDE:
                return beverage.cost() + .15;
            case VENTI:
                return beverage.cost() + .20;
            default:
                return beverage.cost();
        }        
    }            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beverages;

import beverage_sizes.Sizes;

/**
 *
 * @author cristiandrincu
 */
public abstract class Beverage {
    public String description = "Unknown Beverage";
    public Sizes size;
    
    public Sizes setSize(Sizes size) {
        return this.size = size;        
    }
    
    public Sizes getSize() {
        return size;
    }
    
    public String getDescription() {
        return description;
    }       
    
    public abstract double cost();
}

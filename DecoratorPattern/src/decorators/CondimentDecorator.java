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
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();

    @Override
    public abstract Sizes getSize();
}

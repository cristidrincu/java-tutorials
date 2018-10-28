package strategypattern.characters;

import strategypattern.weapons.BowAndArrowBehavior;

/**
 *
 * @author cristiandrincu
 */
public class Knight extends Character {
    
    public Knight() {
        this.weapon = new BowAndArrowBehavior();
    }
    
    @Override
    public void fight() {
        this.weapon.useWeapon();
    }
    
}

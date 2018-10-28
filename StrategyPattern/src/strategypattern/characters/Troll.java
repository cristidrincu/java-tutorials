package strategypattern.characters;

import strategypattern.weapons.AxeBehavior;

/**
 *
 * @author cristiandrincu
 */
public class Troll extends Character {
    
    public Troll() {
        this.weapon = new AxeBehavior();
    }
    
    @Override
    public void fight() {
        this.weapon.useWeapon();
    }
    
}

package strategypattern.characters;

import strategypattern.weapons.KnifeBehavior;

/**
 *
 * @author cristiandrincu
 */
public class Queen extends Character {

    public Queen() {
        this.weapon = new KnifeBehavior();
    }
    
    @Override
    public void fight() {
        this.weapon.useWeapon();
    }
    
}

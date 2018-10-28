package strategypattern.characters;

import strategypattern.weapons.WeaponBehavior;

/**
 *
 * @author cristiandrincu
 */
public abstract class Character {
    WeaponBehavior weapon;
    abstract public void fight();
    
    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public WeaponBehavior getWeapon() {
        return weapon;
    }
        
}

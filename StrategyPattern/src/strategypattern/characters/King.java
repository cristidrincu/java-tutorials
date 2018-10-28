package strategypattern.characters;
import strategypattern.weapons.SwordBehavior;
/**
 *
 * @author cristiandrincu
 */
public class King extends Character {

    public King() {
        this.weapon = new SwordBehavior();
    }
    
    public void fight() {
        this.weapon.useWeapon();
    }
    
}

package strategypattern.weapons;

/**
 *
 * @author cristiandrincu
 */
public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Using a sword as a weapon");
    }

    @Override
    public String printWeapon() {
        return "sword";
    }
    
}

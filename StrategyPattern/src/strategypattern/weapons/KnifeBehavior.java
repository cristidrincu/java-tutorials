package strategypattern.weapons;

/**
 *
 * @author cristiandrincu
 */
public class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Using a knife as a weapon");
    }

    @Override
    public String printWeapon() {
        return "knife";
    }
    
}

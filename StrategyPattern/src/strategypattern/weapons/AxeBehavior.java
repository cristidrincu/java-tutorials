package strategypattern.weapons;

/**
 *
 * @author cristiandrincu
 */
public class AxeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Using an axe as a weapon");
    }       

    @Override
    public String printWeapon() {
        return "axe";
    }
}

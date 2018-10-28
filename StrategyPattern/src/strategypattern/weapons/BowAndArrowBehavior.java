package strategypattern.weapons;

/**
 *
 * @author cristiandrincu
 */
public class BowAndArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Using bow and arrow as weapons");
    }

    @Override
    public String printWeapon() {
        return "bow and arrow";
    }
    
}

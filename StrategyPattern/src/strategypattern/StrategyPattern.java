package strategypattern;

import strategypattern.characters.King;
import strategypattern.characters.Knight;
import strategypattern.characters.Queen;
import strategypattern.characters.Troll;
import strategypattern.weapons.AxeBehavior;
import strategypattern.weapons.BowAndArrowBehavior;
import strategypattern.weapons.KnifeBehavior;
import strategypattern.weapons.SwordBehavior;

/**
 *
 * @author cristiandrincu
 */
public class StrategyPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Initializing fighters");
        System.out.println("======================");
        King king = new King();
        Queen queen = new Queen();
        Knight knight = new Knight();
        Troll troll = new Troll();
        System.out.println("======================\n");
        
        System.out.println("Fighting begins with initial weapons");
        System.out.println("================");
        System.out.println("The " + king.getClass().getSimpleName() +  " starts with: " + king.getWeapon().printWeapon());
        king.fight();
        System.out.println("The " + queen.getClass().getSimpleName() +  " starts with: " + queen.getWeapon().printWeapon());
        queen.fight();
        System.out.println("The " + knight.getClass().getSimpleName() +  " starts with: " + knight.getWeapon().printWeapon());
        knight.fight();
        System.out.println("The " + troll.getClass().getSimpleName() +  " starts with: " + troll.getWeapon().printWeapon());
        troll.fight();
        System.out.println("================\n");
        
        System.out.println("Changing weapons on the fly");
        System.out.println("===========================");
        king.setWeapon(new BowAndArrowBehavior());                
        knight.setWeapon(new SwordBehavior());       
        queen.setWeapon(new AxeBehavior());        
        troll.setWeapon(new KnifeBehavior());        
        System.out.println("===========================\n");
        
        System.out.println("New round of fighting begins");
        System.out.println("============================");
        System.out.println("The " + king.getClass().getSimpleName() +  " has switched to: " + king.getWeapon().printWeapon());
        king.fight();
        System.out.println("The " + knight.getClass().getSimpleName() +  " has switched to: " + knight.getWeapon().printWeapon());
        knight.fight();
        System.out.println("The " + queen.getClass().getSimpleName() +  " has switched to: " + queen.getWeapon().printWeapon());
        queen.fight();
        System.out.println("The " + troll.getClass().getSimpleName() +  " has switched to: " + troll.getWeapon().printWeapon());
        troll.fight();
        System.out.println("============================\n");
    }
    
}

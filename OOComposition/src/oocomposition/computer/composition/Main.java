package oocomposition.computer.composition;

/**
 *
 * @author cristiandrincu
 */
public class Main {
    
    public static void main(String[] args) {        
        Dimensions dimensions = new Dimensions(20, 20, 5);
        ComputerCase theCase = new ComputerCase("220B", "Dell", "240", dimensions);
        
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
        
        //COMPOSE the PC from all available components(classes) that make a PC - HAS-A is crucial - A PC has a monitor, a motherboard, a computer case
        PC thePC = new PC(theCase, theMonitor, theMotherboard);
        thePC.powerUp();
    }
}

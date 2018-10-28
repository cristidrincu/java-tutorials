package oocomposition.computer.composition;

/**
 *
 * @author cristiandrincu
 */
public class PC {
    private ComputerCase computerCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(ComputerCase computerCase, Monitor monitor, Motherboard motherboard) {
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        computerCase.pressPowerButton();
        this.drawLogo();        
    }
    
    private void drawLogo() {                
        monitor.drawPixelAt(1200, 50, "green");
    }              
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author cristiandrincu
 */
public class Remote {
    private DogDoor door;
    
    public Remote(DogDoor door) {
        this.door = door;
    }
    
    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
        }
        
        //Create a new Timer so we can schedule the dog door closing
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                door.close();
                timer.cancel();
            }
        }, 5000);
    }
}

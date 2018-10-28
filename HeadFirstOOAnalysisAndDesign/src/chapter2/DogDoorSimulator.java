/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

/**
 *
 * @author cristiandrincu
 */
public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        Remote remote = new Remote(door);
        
        System.out.println("Fido barks to go outside...");
        remote.pressButton();
        //The door closes automatically, so there is no need for our clients to push buttons on the remote        
        System.out.println("\nFido has gone outside");        
        System.out.println("\nFido's all done...");

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {}
        
        System.out.println("...but he's stuck outside!");
        System.out.println("\nFido starts barking...");
        System.out.println("...so Gina grabs the remote control.");
        remote.pressButton();
        System.out.println("\nFido's back inside...");        
    }
}

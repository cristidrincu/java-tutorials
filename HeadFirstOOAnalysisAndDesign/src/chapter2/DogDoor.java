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
public class DogDoor {
    private boolean open;
    
    public DogDoor() {
        this.open = false;
    }
    
    public void open() {
        System.out.println("The dog door opens.");
        open = true;
    }
    
    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }
    
    public boolean isOpen() {
        return open;
    }
}

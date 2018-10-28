/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.ejb.chp02;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author cristiandrincu
 */
@Stateful(name = "ShoppingCart")
public class ShoppingCartBean {    
    
    public ShoppingCartBean(){}
    
    public ArrayList<String> cartItems;
    public final String[] wines = {"Cristian's Wine", "Nica's Wine", "Ispan's Wine", "Tibi's Wine"};
    
    @PostConstruct
    public void initialize(){
        cartItems = new ArrayList<String>();
        for(int i =0; i< wines.length; i++){
            cartItems.add(wines[i]);
        }
    }
    
    public void addWineItem(String wine){
        cartItems.add(wine);
    }
    
    public void removeWineItem(String wine){
        cartItems.remove(wine);
    }
    
    public void setCartItems(ArrayList<String> cartItems){
        this.cartItems = cartItems;
    }
    
    public ArrayList<String> getCartItems(){
        return this.cartItems;
    }
    
    @PreDestroy
    public void exit(){
        System.out.println("Items saved in the database");
    }
    
    @Remove
    public void stopSession(){
        System.out.println("From stopSession() method with @Remove invocation");
    }
}

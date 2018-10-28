package com.apress.ejb.chp02.utility;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author cristiandrincu
 */
@Singleton(name = "ShopperCountSingleton")
@Startup
public class ShopperCountBean {
    
    private int shopperCounter = 0;
    
    //increment number of shopers
    @Lock(LockType.WRITE)
    public void incrementShopperCount(){
        shopperCounter++;
    }
    
    //return number of shoppers
    @Lock(LockType.READ)
    public int getNumberOfShopers(){
        return shopperCounter;
    }
    
    public void resetCounter(){
        shopperCounter = 0;
    }
    
    //reset counter
    @PostConstruct
    public void applicationStartup(){
        System.out.println("From application startup method...");
        resetCounter();
    }
    
    @PreDestroy
    public void applicationShutdown(){
        System.out.println("From application shutdown method...");
    }
    
}

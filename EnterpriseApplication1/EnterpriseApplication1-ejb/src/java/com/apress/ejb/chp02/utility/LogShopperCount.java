/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.ejb.chp02.utility;

import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import org.jboss.logging.Logger;

/**
 *
 * @author cristiandrincu
 */
@Singleton
@Startup
@DependsOn("ShopperCountSingleton")
public class LogShopperCount {
    private final Logger log = Logger.getLogger("LogShopperCount.class");
    
    
    /**
     * Logs shopper count every 2 hours  
    */
    @Schedule( hour = "*/2")
    public void logShopperCount(Timer timer){
        //Log shopper count - get information about the timer that just expired
        String timerInfo = (String) timer.getInfo();
        System.out.println(timerInfo);
    }
}

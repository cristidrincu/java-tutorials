/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.ejb.chp02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
/**
 *
 * @author cristiandrincu
 */
@Stateless(name="SearchFacade")
public class SearchFacadeBean {
    
    Map<String, String> countryMap = new HashMap<String, String>();
    
    public SearchFacadeBean(){}
    
    /**
     * After constructing the bean, initialize a map with countries and specific wines
     */
    @PostConstruct
    public void initializeCountryWineList(){
        //country map is hashMap
        
        countryMap.put("Australia", "Sauvignon Blanc");
        countryMap.put("France", "Grenache");
        countryMap.put("Australia", "Gewurztraminer");
        countryMap.put("France", "Bordeaux");
    }
    /**
     * Clear any resources used by the bean before the container deletes the bean (unused or expired) from the object pool
    */
    @PreDestroy
    public void destroyWineList(){
       countryMap.clear(); 
    }
    
    /**
     * Interceptor method that logs the time taken to execute each business method from this bean
     * @param ctx
     * @return 
     * @throws java.lang.Exception
     */
    @AroundInvoke
    public Object TimerLog(InvocationContext ctx) throws Exception{
        String beanClassName = ctx.getClass().getName();
        String businessMethodName = ctx.getMethod().getName();
        String target = beanClassName + "."+ businessMethodName;
        long startTime = System.currentTimeMillis();
        
        System.out.println("Invoking " + target);
        
        try{
            return ctx.proceed();
        }finally{
            System.out.println("Exiting " + target);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Business method " + businessMethodName + " in " + beanClassName + " takes " + totalTime + " ms to execute!");
        }
    }
    
    
    public List<String> wineSearch(String wineType) {
        List<String> wineList = new ArrayList<String>();
        if(wineType.equals("Red")){
            wineList.add("Bordeaux");
            wineList.add("Merlot");
            wineList.add("Pinot Noir");            
        }else if(wineType.equals("White")){
            wineList.add("Chardonnay");
        }
        return wineList;
        
    }
}

package com.airhacks;
/**
 *
 * @author cristiandrincu
 */

public class Developer {
    private String name;
    private String last;      
    
    public Developer(String name, String last) {
        this.name = name;
        this.last = last;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }  
}

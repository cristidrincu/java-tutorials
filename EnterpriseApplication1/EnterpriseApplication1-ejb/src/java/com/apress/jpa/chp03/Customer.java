/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.jpa.chp03;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author cristiandrincu
 */
@Entity( name = "Customer")
@Table( name = "CUSTOMER")
@IdClass(CustomerPK.class)
public class Customer implements Serializable {
    
    @Id
    @Column( name = "CUSTOMERID", table="CUSTOMER", unique=true, nullable=false, insertable=true, updatable=true)
    private Integer customerId;
    
    @Id
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "Name", table="CUSTOMER")
    private String name;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}

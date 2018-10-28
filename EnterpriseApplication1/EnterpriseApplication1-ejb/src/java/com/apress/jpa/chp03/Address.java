/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apress.jpa.chp03;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author cristiandrincu
 */
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "ZIP")
    private int zipCodeInternal;
    @Transient
    private String zipCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getZipCodeInternal() {
        return zipCodeInternal;
    }

    public void setZipCodeInternal(int zipCodeInternal) {
        this.zipCodeInternal = zipCodeInternal;
    }
    
    public String getZipCode() {
        if (zipCode == null && zipCodeInternal > 0) {
            zipCode = convertToStr(zipCodeInternal);
        }
        return zipCode;
    }
    
    
    public void setZipCode(String zipCode) throws IllegalArgumentException {
    // Validate the zipcode String, to make sure it reduces cleanly to
    // either a 5- or 9- digit integer, and assign it to the internal
    // persistent 'zipCodeInternal' class field
    // . . . <validation code here>. . .
        this.zipCode = zipCode;
        zipCodeInternal = convertToInt(zipCode);
    }
    
    private int convertToInt(String zipCode) {
        return new Integer(zipCode).intValue();
    }
    
    private String convertToStr(int zipCode) {
        return new Integer(zipCode).toString();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apress.jpa.chp03.Address[ id=" + id + " ]";
    }
    
}

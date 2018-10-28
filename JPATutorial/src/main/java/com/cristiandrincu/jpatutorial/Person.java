package com.cristiandrincu.jpatutorial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author cristiandrincu
 */
@Entity
@Table(name = "T_PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    private Long id;
    private String firstName;
    private String lastName;

    public void setId(Long id) {
        this.id = id;
    }    
    
    @Id //this is the primary key
    @GeneratedValue //generate the id automatically
    public Long getId() {
        return id;
    }
    
    @Column(name= "FIRST_NAME", length = 100, nullable = false, unique = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package com.cristiandrincu.jpatutorial;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author cristiandrincu
 */
@Entity
@Table(name = "T_GEEK")
public class Geek extends Person {
    private String favouriteProgrammingLanguage;
    private List<Project> projects = new ArrayList<Project>();
    
    @Column(name = "FAV_PROG_LANG")    
    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }

    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }

//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }
    
}

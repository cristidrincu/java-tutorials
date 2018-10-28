package com.cristiandrincu.jpatutorial;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

/**
 *
 * @author cristiandrincu
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger("JPA");    
    
    public static void main(String[] args) {                
        Main main = new Main();
        main.run();
    }
    
    public void run() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("PersistenceUnit");
            entityManager = factory.createEntityManager();
            persistPerson(entityManager);
            persistGeek(entityManager);
            listPersons(entityManager);
        } catch (Exception e) {
            LOGGER.log(Level.ERROR, e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            
            if (factory != null) {
                factory.close();
            }
        }
    }
    
    private void persistPerson(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Person person = new Person();
            person.setFirstName("Homer");
            person.setLastName("Simpson");
            entityManager.persist(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    
    private void persistGeek(EntityManager entityManager) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Geek geek = new Geek();
            geek.setFirstName("Gavin");
            geek.setLastName("Coffee");
            geek.setFavouriteProgrammingLanguage("Java");
            entityManager.persist(geek);
            geek = new Geek();
            geek.setFirstName("Thomas");
            geek.setLastName("Micro");
            geek.setFavouriteProgrammingLanguage("C#");
            entityManager.persist(geek);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    
    private void listPersons(EntityManager entityManager) {
        TypedQuery<Person> query = entityManager.createQuery("from Person p", Person.class);
        List<Person> resultList = query.getResultList();
        StringBuilder sb = new StringBuilder();
        resultList.forEach(person -> {
          sb.append(person.getFirstName()).append(" ").append(person.getLastName());
          if (person instanceof Geek) {
              Geek geek = (Geek)person;
              sb.append(" ").append(geek.getFavouriteProgrammingLanguage());
          }
          LOGGER.info(sb.toString());
        });
    }
    
}

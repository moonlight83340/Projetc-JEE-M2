package services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Person;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonManager {

    @PersistenceContext(unitName = "myBase")
    EntityManager em;

    public Person getPerson(Integer id) {
        return em.find(Person.class, id);
    }


    public void createPerson(String lastname, String firstname, String email, String website, Date birthDate, String password) {
        //removeCounter(name);
    	Person p = new Person(lastname, firstname, email, website, birthDate, password);

        em.persist(p);
    }
    
    public void removePerson(Integer id) {
        Person p = em.find(Person.class, id);
        if (p != null) {
            em.remove(p);
        }
    }
    
    public void updatePerson(Integer id, String lastname, String firstname, String email, String website, Date birthDate, String password) {
    	
    }

}
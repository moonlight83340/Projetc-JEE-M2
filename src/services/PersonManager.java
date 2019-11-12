package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Person;

import java.util.List;

@Stateless
public class PersonManager {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

    public List<Person> findPersons() {
        return em.createQuery("Select p From Person p", Person.class)
                .getResultList();
    }
    
    public List<Person> findPersonsLike(String patern) {
        return em.createQuery("Select p From Person p where p.lastname = " + patern + " or p.firstname = " + patern, Person.class)
                .getResultList();
    }

    public Person findPerson(Long id) {
        return em.find(Person.class, id);
    }

    public Person savePerson(Person p) {
        if (p.getId() == null) {
            em.persist(p);
        } else {
            p = em.merge(p);
        }
        return p;
    }

    public void deletePerson(Person p) {
        p = em.merge(p);
        em.remove(p);
    }

}
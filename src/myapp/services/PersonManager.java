package myapp.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myapp.model.Person;

import java.util.List;

@Stateless
public class PersonManager implements IManager<Person>{

    @PersistenceContext(unitName="myData")
    EntityManager em;

	@Override
	public List<Person> findAll() {
        return em.createQuery("Select p From Person p", Person.class)
                .getResultList();
	}

	@Override
	public List<Person> findLike(String patern) {
        return em.createQuery("Select p From Person p where p.lastname = " + patern + " or p.firstname = " + patern, Person.class)
                .getResultList();
	}

	@Override
	public Person find(Integer id) {
		return em.find(Person.class, id);
	}

	@Override
	public Person save(Person t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            t = em.merge(t);
        }
        return t;
	}

	@Override
	public void delete(Person t) {
        t = em.merge(t);
        em.remove(t);	
	}

}
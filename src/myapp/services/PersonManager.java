package myapp.services;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myapp.model.Person;

import java.util.List;

@Stateless
@Local(IFindLikeManager.class)
public class PersonManager implements IManager<Person>, IFindLikeManager<Person>{

    @PersistenceContext(unitName="myData")
    EntityManager em;

	@Override
	public List<Person> findAll() {
        return em.createQuery("Select p From Person p", Person.class)
                .getResultList();
	}

	@Override
	public List<Person> findLike(String patern) {
        return em.createQuery("Select p From Person p where p.lastname like '%" + patern + "%' or p.firstname like '%" + patern + "%'", Person.class)
                .getResultList();
	}

	@Override
	public Person find(Integer id) {
		return em.find(Person.class, id);
	}
	
	public Person findByEmail(String email) {
		return em.createQuery("Select p From Person p where p.email = " + email, Person.class)
                .getSingleResult();
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

	@Override
	public Person create() {
		return new Person();
	}

}
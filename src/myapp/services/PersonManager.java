package myapp.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import myapp.model.Person;

import java.util.List;

@Stateless(name="personManager")
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class PersonManager implements IFindLikeManager<Person>{
	
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
	
	public List<Person> findSome(int some) {
		TypedQuery<Person> query = em.createQuery("Select p From Person p", Person.class);
		query.setMaxResults(some);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getResultList();
	}

	
	public Person findByEmail(String email) {
		TypedQuery<Person> query = em.createQuery("Select p From Person p where p.email = '" + email + "'", Person.class);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getSingleResult();
	}

	public Person getBySignUpToken(String signUpToken) {
		TypedQuery<Person> query = em.createQuery("From Person where signUpToken = ?1", Person.class).setParameter(1,
				signUpToken);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getSingleResult();
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
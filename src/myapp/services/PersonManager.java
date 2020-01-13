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

/**
 * The Class PersonManager.
 */
@Stateless(name="personManager")
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class PersonManager implements IFindLikeManager<Person>{
	
    /** The Entity manager. */
    @PersistenceContext(unitName="myData")
    EntityManager em;

	/**
	 * Find all Persons.
	 *
	 * @return the list
	 */
	@Override
	public List<Person> findAll() {
        return em.createQuery("Select p From Person p", Person.class)
                .getResultList();
	}

	/**
	 * Find like Persons with patern in parameter.
	 *
	 * @param patern the patern
	 * @return the list
	 */
	@Override
	public List<Person> findLike(String patern) {
        return em.createQuery("Select p From Person p where p.lastname like '%" + patern + "%' or p.firstname like '%" + patern + "%'", Person.class)
                .getResultList();
	}

	/**
	 * Find a Person by it's ID.
	 *
	 * @param id the id
	 * @return the person
	 */
	@Override
	public Person find(Integer id) {
		return em.find(Person.class, id);
	}
	
	/**
	 * Find some Person.
	 *
	 * @param some the some
	 * @return the list
	 */
	public List<Person> findSome(int some) {
		TypedQuery<Person> query = em.createQuery("Select p From Person p", Person.class);
		query.setMaxResults(some);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getResultList();
	}

	
	/**
	 * Find Person by email.
	 *
	 * @param email the email
	 * @return the person
	 */
	public Person findByEmail(String email) {
		TypedQuery<Person> query = em.createQuery("Select p From Person p where p.email = '" + email + "'", Person.class);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getSingleResult();
	}

	/**
	 * Gets the by sign up token.
	 *
	 * @param signUpToken the sign up token
	 * @return the by sign up token
	 */
	public Person getBySignUpToken(String signUpToken) {
		TypedQuery<Person> query = em.createQuery("From Person where signUpToken = ?1", Person.class).setParameter(1,
				signUpToken);
		if (query.getResultList().isEmpty())
			return null;
		else
			return query.getSingleResult();
	}
	
	/**
	 * Save a Person (update or create a new one).
	 *
	 * @param t the t
	 * @return the person
	 */
	@Override
    public Person save(Person t) {
        if (t.getId() == null ||find(t.getId()) == null) {
            em.persist(t);
        }        
        em.joinTransaction();
        return t = em.merge(t);
    }

	/**
	 * Delete a Person.
	 *
	 * @param t the t
	 */
	@Override
	public void delete(Person t) {
		Person pers = find(t.getId());
		if (pers != null) {
			em.remove(t);	
		}
	}

	/**
	 * Creates a new Person.
	 *
	 * @return the person
	 */
	@Override
	public Person create() {
		return new Person();
	}

}
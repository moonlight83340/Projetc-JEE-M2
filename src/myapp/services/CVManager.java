package myapp.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myapp.model.CV;

/**
 * The Class CVManager.
 */
@Stateless(name="cvManager")
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class CVManager implements IManager<CV>{

	/** The Entity manager. */
    @PersistenceContext(unitName = "myData")
    EntityManager em;

	/**
	 * Find all CVs.
	 *
	 * @return the list
	 */
	@Override
	public List<CV> findAll() {
        return em.createQuery("Select c From CV c", CV.class)
                .getResultList();
	}

	/**
	 * Find a CV by it's ID.
	 *
	 * @param id the id
	 * @return the cv
	 */
	@Override
	public CV find(Integer id) {
		return em.find(CV.class, id);
	}

	/**
	 * Save a CV (update or create a new one).
	 *
	 * @param t the t
	 * @return the cv
	 */
	@Override
	public CV save(CV t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            t = em.merge(t);
        }
        return t;
	}

	/**
	 * Delete a CV.
	 *
	 * @param t the t
	 */
	@Override
	public void delete(CV t) {
        t = em.merge(t);
        em.remove(t);	
	}

	/**
	 * Creates a new CV.
	 *
	 * @return the cv
	 */
	@Override
	public CV create() {
		return new CV();
	}
}

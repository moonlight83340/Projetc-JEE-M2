package myapp.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myapp.model.Activity;

/**
 * The Class ActivityManager.
 */
@Stateless(name="activityManager")
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class ActivityManager implements IFindLikeManager<Activity> {

	/** The Entity manager. */
    @PersistenceContext(unitName = "myData")
    EntityManager em;

	/**
	 * Find all Activities.
	 *
	 * @return the list
	 */
	@Override
	public List<Activity> findAll() {
        return em.createQuery("Select a From Activity a", Activity.class)
                .getResultList();
	}

	/**
	 * Find like Activities with pattern in parameter.
	 *
	 * @param patern the patern
	 * @return the list
	 */
	@Override
	public List<Activity> findLike(String patern) {
        return em.createQuery("Select a From Activity a where a.title like '%" + patern + "%'", Activity.class)
                .getResultList();
	}

	/**
	 * Find an Activity by it's ID.
	 *
	 * @param id the id
	 * @return the activity
	 */
	@Override
	public Activity find(Integer id) {
		return em.find(Activity.class, id);
	}

	/**
	 * Save an Activity (update or create a new one).
	 *
	 * @param t the t
	 * @return the activity
	 */
	@Override
	public Activity save(Activity t) {
        if (t.getId() == null) {
            em.persist(t);
        }
        em.joinTransaction();
        return t = em.merge(t);
	}

	/**
	 * Delete an Acitivity.
	 *
	 * @param t the t
	 */
	@Override
	public void delete(Activity t) {
		if (t != null) {
	        t = em.merge(t);
	        em.remove(t);	
		}
	}

	/**
	 * Creates a new Activity.
	 *
	 * @return the activity
	 */
	@Override 
	public Activity create() {
		return new Activity();
	}
}

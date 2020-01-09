package myapp.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myapp.model.Activity;

@Stateless(name="activityManager")
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class ActivityManager implements IFindLikeManager<Activity> {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

	@Override
	public List<Activity> findAll() {
        return em.createQuery("Select a From Activity a", Activity.class)
                .getResultList();
	}

	@Override
	public List<Activity> findLike(String patern) {
        return em.createQuery("Select a From Activity a where a.title like '%" + patern + "%'", Activity.class)
                .getResultList();
	}

	@Override
	public Activity find(Integer id) {
		return em.find(Activity.class, id);
	}

	@Override
	public Activity save(Activity t) {
        if (t.getId() == null) {
            em.persist(t);
        }
        em.joinTransaction();
        return t = em.merge(t);
	}

	@Override
	public void delete(Activity t) {
		if (t != null) {
	        t = em.merge(t);
	        em.remove(t);	
		}
	}

	@Override 
	public Activity create() {
		return new Activity();
	}
}

package myapp.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myapp.model.Activity;

@Stateless
public class ActivityManager implements IManager<Activity>, IFindLikeManager<Activity> {

    @PersistenceContext(unitName = "myData")
    EntityManager em;

	@Override
	public List<Activity> findAll() {
        return em.createQuery("Select a From Activity a", Activity.class)
                .getResultList();
	}

	@Override
	public List<Activity> findLike(String patern) {
        return em.createQuery("Select a From Activity a where a.title = " + patern + " or a.title = " + patern, Activity.class)
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
        } else {
            t = em.merge(t);
        }
        return t;
	}

	@Override
	public void delete(Activity t) {
        t = em.merge(t);
        em.remove(t);	
	}
}

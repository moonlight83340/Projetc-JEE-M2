package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.CV;

@Stateless
public class CVManager implements IManager<CV>{

    @PersistenceContext(unitName = "myData")
    EntityManager em;

	@Override
	public List<CV> findAll() {
        return em.createQuery("Select c From CV c", CV.class)
                .getResultList();
	}

	@Override
	public CV find(Long id) {
		return em.find(CV.class, id);
	}

	@Override
	public CV save(CV t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            t = em.merge(t);
        }
        return t;
	}

	@Override
	public void delete(CV t) {
        t = em.merge(t);
        em.remove(t);	
	}
}

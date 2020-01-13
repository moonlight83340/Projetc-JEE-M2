package myapp.services;

import java.util.List;
import javax.ejb.Local;

/**
 * The Interface IManager.
 *
 * @param <T> the generic type
 */
@Local
public interface IManager<T> {
	
	/**
	 * Creates a new T
	 *
	 * @return the t
	 */
	public T create();
    
    /**
     * Find a T by it's ID
     *
     * @param id the id
     * @return the t
     */
    public T find(Integer id);
    
    /**
     * Find all the T.
     *
     * @return the list
     */
    public List<T> findAll();

    /**
     * Save a T (update or create a new one).
     *
     * @param t the t
     * @return the t
     */
    public T save(T t);

    /**
     * Delete a T.
     *
     * @param t the t
     */
    public void delete(T t);
    
}

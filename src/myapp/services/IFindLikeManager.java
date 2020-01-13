package myapp.services;

import java.util.List;

import javax.ejb.Local;

/**
 * The Interface IFindLikeManager.
 *
 * @param <T> the generic type
 */
@Local
public interface IFindLikeManager<T> extends IManager<T>{
	
	/**
	 * Find like with the pattern in parameter.
	 *
	 * @param patern the patern
	 * @return the list
	 */
	public List<T> findLike(String patern);
}

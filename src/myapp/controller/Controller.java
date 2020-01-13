package myapp.controller;

import java.util.List;

/**
 * The Interface Controller.
 *
 * @param <T> the generic type
 */
public interface Controller<T> {
	
	/**
	 * Gets all Ts.
	 *
	 * @return the all
	 */
	public List<T> getAll();
	
	/**
	 * Update with filter.
	 *
	 * @return the string
	 */
	public String updateWithFilter();

	/**
	 * Show a T by it's ID.
	 *
	 * @param n the n
	 * @return the string
	 */
	public String show(Integer n);
	
	/**
	 * Edits a T.
	 *
	 * @return the string
	 */
	public String edit();

	/**
	 * Save a T.
	 *
	 * @return the string
	 */
	public String save();

	/**
	 * Create new T.
	 *
	 * @return the string
	 */
	public String newInstance();

}

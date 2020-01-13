package myapp.controller;

import java.util.List;

import javax.ejb.EJB;

import myapp.model.Activity;
import myapp.services.ActivityManager;

/**
 * The Class ActivityController.
 */
public class ActivityController implements Controller<Activity> {

	/** The Activity Manager. */
	@EJB
	ActivityManager manager;
	
	/**
	 * Gets all Activities.
	 *
	 * @return activities
	 */
	@Override
	public List<Activity> getAll() {
		return manager.findAll();
	}

	/**
	 * Update with filter.
	 *
	 * @return the string
	 */
	@Override
	public String updateWithFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Show an Activity by it's ID.
	 *
	 * @param n the n
	 * @return the string
	 */
	@Override
	public String show(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Edits an Activity.
	 *
	 * @return the string
	 */
	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Save an Activity.
	 *
	 * @return the string
	 */
	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Create a new Activity
	 *
	 * @return the string
	 */
	@Override
	public String newInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}

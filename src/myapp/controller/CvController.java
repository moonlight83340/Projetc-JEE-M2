package myapp.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import myapp.model.CV;
import myapp.services.CVManager;

/**
 * The Class CvController.
 */
@ManagedBean(name = "cv")
@SessionScoped
public class CvController implements Controller<CV>{

	/** The CV manager. */
	@EJB
	CVManager manager;

	/** The instance of the current CV. */
	CV theInstance = new CV();
	
	/** The wanteds CVs. */
	List<CV> wanteds = new ArrayList<CV>();
	
	/** The filter text. */
	String filterText = "";

	/**
	 * Inits the controller.
	 */
	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		if (manager.findAll().size() == 0) {
			CV c1 = new CV();
			manager.save(c1);
		}
		
		wanteds = getAll();
	}

	/**
	 * Gets all CVs.
	 *
	 * @return the all
	 */
	@Override
	public List<CV> getAll() {
		return manager.findAll();
	}

	/**
	 * Gets wanteds CVs.
	 *
	 * @return the wanteds
	 */
	public List<CV> getWanteds() {
		return wanteds;
	}
	
	/**
	 * Gets the filter text.
	 *
	 * @return the filter text
	 */
	public String getFilterText() {
		return filterText;
	}
	
	/**
	 * Gets the instance of the current CV.
	 *
	 * @return the current CV
	 */
	public CV getTheInstance() {
		return theInstance;
	}
	
	/**
	 * Sets the filter text.
	 *
	 * @param filter the new filter text
	 */
	public void setFilterText(String filter) {
		this.filterText = filter;
	}

	/**
	 * Show a CV by it's ID.
	 *
	 * @param n the n
	 * @return the string
	 */
	@Override
	public String show(Integer n) {
		theInstance = manager.find(n);
		return "showCV";
	}
	
	/**
	 * Save a CV.
	 *
	 * @return the string
	 */
	@Override
	public String save() {
		manager.save(theInstance);
		return "showCV";
	}


	/**
	 * Update with filter.
	 *
	 * @return the string
	 */
	@Override
	public String updateWithFilter() {
		return null;
	}

	/**
	 * Edits a CV.
	 *
	 * @return the string
	 */
	@Override
	public String edit() {
		return "editCV?faces-redirect=true";
	}

	/**
	 * Create a new CV.
	 *
	 * @return the string
	 */
	@Override
	public String newInstance() {
		theInstance = new CV();
		return "editCV?faces-redirect=true";
	}
}
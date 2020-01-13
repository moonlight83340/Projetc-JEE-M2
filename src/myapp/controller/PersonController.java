package myapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mindrot.jbcrypt.BCrypt;

import myapp.model.Person;
import myapp.services.PersonManager;

/**
 * The Class PersonController.
 */
@ManagedBean(name = "person")
@SessionScoped
public class PersonController implements Controller<Person>{
	
	/** The Person manager. */
	@EJB
	private PersonManager manager;

	/** The instance of the current Person. */
	private Person theInstance = new Person();
	
	/** The wanteds Persons. */
	private List<Person> wanteds = new ArrayList<Person>();
	
	/** The filter text. */
	private String filterText = "";

	/**
	 * Inits the Controller.
	 */
	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		if (manager.findAll().size() == 0) {
			System.out.println("DB Vide je crée personne");
			Person p1 = new Person();
			
			p1.setLastname("lastname");
			p1.setFirstname("firstname");
			p1.setEmail("lastname.firstname@a.fr");
			p1.setBirthDate(new Date());
			p1.setPassword(BCrypt.hashpw("password", BCrypt.gensalt()));
			
			manager.save(p1);
		}
		
		wanteds = getAll();
	}

	/**
	 * Gets the wanteds Persons.
	 *
	 * @return the wanteds
	 */
	@PermitAll
	public List<Person> getWanteds() {
		return wanteds;
	}
	
	/**
	 * Gets the instance of the current Person.
	 *
	 * @return the current Person
	 */
	public Person getTheInstance() {
		return theInstance;
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
	 * Sets the filter text.
	 *
	 * @param filter the new filter text
	 */
	public void setFilterText(String filter) {
		this.filterText = filter;
	}

	/**
	 * Show a Person by it's ID.
	 *
	 * @param n the n
	 * @return the string
	 */
	@Override
	@PermitAll
	public String show(Integer n) {
		theInstance = manager.find(n);
		return "showPerson";
	}

	/**
	 * Save a Person.
	 *
	 * @return the string
	 */
	@Override
	public String save() {
		manager.save(theInstance);
		wanteds = getAll();
		return "showPerson";
	}

	/**
	 * Gets all Persons.
	 *
	 * @return the all
	 */
	@Override
	public List<Person> getAll() {
		return manager.findAll();
	}
	
	/**
	 * Gets some persons.
	 *
	 * @return the some persons
	 */
	public List<Person> getSomePersons(){
		return manager.findSome(5);
	}

	/**
	 * Update with filter.
	 *
	 * @return the string
	 */
	@Override
	public String updateWithFilter() {
		if(filterText == "") {
			this.wanteds = manager.findAll();
		}else{
			this.wanteds = manager.findLike(filterText);
		}
		return filterText;
	}

	/**
	 * Edits a Person.
	 *
	 * @return the string
	 */
	@Override
	public String edit() {
		return "editPerson?faces-redirect=true";
	}

	/**
	 * Create a new Person
	 *
	 * @return the string
	 */
	@Override
	public String newInstance() {
		theInstance = new Person();
		return "editPerson?faces-redirect=true";
	}
}
package myapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import myapp.model.Person;
import myapp.services.PersonManager;

@ManagedBean(name = "person")
@SessionScoped
public class PersonController {

	@EJB
	PersonManager pm;

	Person thePerson = new Person();
	List<Person> wantedPersons = new ArrayList<Person>();
	
	String filterText = "";

	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		if (pm.findAll().size() == 0) {
			Person p1 = new Person();
			
			p1.setLastname("lastname");
			p1.setFirstname("firstname");
			p1.setEmail("lastname.firstname@a.fr");
			p1.setBirthDate(new Date());
			p1.setPassword("password");
			
			pm.save(p1);
		}
		
		wantedPersons = getPersons();
	}

	public List<Person> getPersons() {
		return pm.findAll();
	}

	public List<Person> getWantedPersons() {
		return wantedPersons;
	}
	
	public String getFilterText() {
		return filterText;
	}
	
	public Person getThePerson() {
		return thePerson;
	}
	
	public void setFilterText(String filter) {
		this.filterText = filter;
	}

	public String updatePersonsWithFilter() {
		if(filterText == "") {
			this.wantedPersons = pm.findAll();
		}else{
			this.wantedPersons = pm.findLike(filterText);
		}
		return filterText;
	}

	public String show(Integer n) {
		thePerson = pm.find(n);
		return "showPerson";
	}

	public String save() {
		pm.save(thePerson);
		return "showPerson";
	}

	public String newPerson() {
		thePerson = new Person();
		return "editPerson?faces-redirect=true";
	}

	public String editPerson() {
		return "editPerson?faces-redirect=true";
	}
}
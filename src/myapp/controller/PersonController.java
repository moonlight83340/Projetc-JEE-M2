package myapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import myapp.model.Person;
import myapp.services.PersonManager;

@ManagedBean(name = "person")
@SessionScoped
public class PersonController implements Controller<Person>{

	@EJB
	private PersonManager manager;

	private Person theInstance = new Person();
	private List<Person> wanteds = new ArrayList<Person>();
	private String filterText = "";

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
			p1.setPassword("password");
			
			manager.save(p1);
		}
		
		wanteds = getAll();
	}

	@PermitAll
	public List<Person> getWanteds() {
		return wanteds;
	}
	
	public Person getTheInstance() {
		return theInstance;
	}
	
	public String getFilterText() {
		return filterText;
	}
	
	public void setFilterText(String filter) {
		this.filterText = filter;
	}

	@Override
	@PermitAll
	public String show(Integer n) {
		theInstance = manager.find(n);
		return "showPerson";
	}

	@Override
	public String save() {
		manager.save(theInstance);
		wanteds = getAll();
		return "showPerson";
	}

	@Override
	public List<Person> getAll() {
		return manager.findAll();
	}

	@Override
	public String updateWithFilter() {
		if(filterText == "") {
			this.wanteds = manager.findAll();
		}else{
			this.wanteds = manager.findLike(filterText);
		}
		return filterText;
	}

	@Override
	public String edit() {
		return "editPerson?faces-redirect=true";
	}

	@Override
	public String newInstance() {
		theInstance = new Person();
		return "editPerson?faces-redirect=true";
	}
}
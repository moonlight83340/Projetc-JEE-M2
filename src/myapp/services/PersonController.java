package myapp.services;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import myapp.model.Person;

@ManagedBean(name = "person")
@SessionScoped
public class PersonController {

	@EJB
	PersonManager pm;

	Person thePerson = new Person();

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
	}

	public List<Person> getPersons() {
		return pm.findAll();
	}

	public Person getThePerson() {
		return thePerson;
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

}
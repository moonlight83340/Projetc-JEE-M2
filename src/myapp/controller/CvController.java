package myapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import myapp.model.CV;
import myapp.model.Person;
import myapp.services.CVManager;
import myapp.services.PersonManager;

@ManagedBean(name = "cv")
@SessionScoped
public class CvController implements Controller<CV>{

	@EJB
	CVManager manager;

	CV theInstance = new CV();
	List<CV> wanteds = new ArrayList<CV>();
	
	String filterText = "";

	@PostConstruct
	public void init() {
		System.out.println("Create " + this);
		if (manager.findAll().size() == 0) {
			CV c1 = new CV();
			
			
			
			manager.save(c1);
		}
		
		wanteds = getAll();
	}

	@Override
	public List<CV> getAll() {
		return manager.findAll();
	}

	public List<CV> getWanteds() {
		return wanteds;
	}
	
	public String getFilterText() {
		return filterText;
	}
	
	public CV getTheInstance() {
		return theInstance;
	}
	
	public void setFilterText(String filter) {
		this.filterText = filter;
	}

	@Override
	public String show(Integer n) {
		theInstance = manager.find(n);
		return "showCV";
	}
	
	@Override
	public String save() {
		manager.save(theInstance);
		return "showCV";
	}


	@Override
	public String updateWithFilter() {
		return null;
	}

	@Override
	public String edit() {
		return "editCV?faces-redirect=true";
	}

	@Override
	public String newInstance() {
		theInstance = new CV();
		return "editCV?faces-redirect=true";
	}
}
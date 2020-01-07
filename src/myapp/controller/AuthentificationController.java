package myapp.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import myapp.model.Person;
import myapp.services.AuthentificationManager;
import myapp.services.PersonManager;

@ManagedBean(name = "authentification")
@SessionScoped
public class AuthentificationController {

	@EJB
	AuthentificationManager am;

	@EJB 
	PersonManager pm;
	
	public void login() {
		

	}

	
}
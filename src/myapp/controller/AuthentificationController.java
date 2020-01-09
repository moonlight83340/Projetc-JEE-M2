package myapp.controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import myapp.model.Person;
import myapp.services.AuthentificationManager;
@ManagedBean(name = "userAuth")
@SessionScoped
public class AuthentificationController {

	@EJB
	AuthentificationManager am;
	
	public Person login(String emailAddress, String password) {
		return am.login(emailAddress,password);
	}

    public void logout() {
    	am.logout();
    }
	
	public boolean isLogged() {
		return am.isLogged();
	}
	
	public Person getConnectedPerson() {
		return am.getAuthUser();
	}
}
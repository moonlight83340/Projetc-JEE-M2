package myapp.controller;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;

import myapp.services.AuthentificationManager;
import myapp.services.PersonManager;

@SessionScoped
public class AuthentificationController {

	@EJB
	AuthentificationManager am;

	@EJB 
	PersonManager pm;
	
	public void login() {
		//am.login(user);
	}

    public void logout() {
    	//am.logout();
    }
	
	public boolean isLogged() {
		return am.isLogged();
	}
	
}
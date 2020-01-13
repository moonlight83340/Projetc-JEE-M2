package myapp.controller;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import myapp.model.Person;
import myapp.services.AuthentificationManager;
@ManagedBean(name = "userAuth")
@SessionScoped
public class AuthentificationController {

	@EJB
	AuthentificationManager am;
	
	private String email;
	private String password;

	public String login() {
		Person user = am.login(email,password);;
		if (user != null) {
			return "index.xhmtl?faces-redirect=true";			
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect email or password",
							"Please enter correct username and Password"));
			return null;
		}
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
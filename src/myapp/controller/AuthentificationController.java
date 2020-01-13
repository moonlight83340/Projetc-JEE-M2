package myapp.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import myapp.model.Person;
import myapp.services.AuthentificationManager;

/**
 * The Class AuthentificationController.
 */
@ManagedBean(name = "userAuth")
@SessionScoped
public class AuthentificationController {

	/** The Authentification Manager. */
	@EJB
	AuthentificationManager am;
	
	/** The email of the current user. */
	private String email;
	
	/** The password of the current user. */
	private String password;

	/**
	 * Login the user.
	 *
	 * @return the string
	 */
	public String login() {
		Person user = am.login(email,password);
		if (user != null) {
			setPassword("");
			return "index.xhmtl?faces-redirect=true";			
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Email ou mot de passe incorrect",
							"Merci d'entrer un email et un mot de passe valide !"));
			return null;
		}
	}

    /**
     * Logout the user.
     */
    public String logout() {
    	setEmail("");
    	am.logout();
    	return "index.xhmtl?faces-redirect=true";	
    }
	
	/**
	 * Checks if is logged.
	 *
	 * @return true, if is logged
	 */
	public boolean isLogged() {
		return am.isLogged();
	}
	
	/**
	 * Gets the connected person.
	 *
	 * @return the connected person
	 */
	public Person getConnectedPerson() {
		return am.getAuthUser();
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
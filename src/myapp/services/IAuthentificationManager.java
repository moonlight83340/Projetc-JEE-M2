package myapp.services;

import javax.ejb.Local;

import myapp.model.Person;

/**
 * The Interface IAuthentificationManager.
 */
@Local
public interface IAuthentificationManager {
    
    /**
     * Login an user.
     *
     * @param emailAddress the email address
     * @param password the password
     * @return the person
     */
    public Person login(String emailAddress, String password);
    
    /**
     * Logout the current log user.
     */
    public void logout();
    
    /**
     * Checks if is logged.
     *
     * @return true, if is logged
     */
    public boolean isLogged();

	/**
	 * Generate sign up token.
	 *
	 * @return the string
	 */
	public String generateSignUpToken();
	
	/**
	 * Verify sign up token.
	 *
	 * @param signUpToken the sign up token
	 * @return the person
	 */
	public Person verifySignUpToken(String signUpToken);
	
	/**
	 * Sign up.
	 *
	 * @param signUpToken the sign up token
	 * @param person the person
	 * @return the person
	 */
	public Person signUp(String signUpToken, Person person);

}
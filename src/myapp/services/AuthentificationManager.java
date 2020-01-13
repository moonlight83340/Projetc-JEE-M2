package myapp.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import org.mindrot.jbcrypt.BCrypt;

import myapp.model.Person;

/**
 * The Class AuthentificationManager.
 */
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class AuthentificationManager implements IAuthentificationManager{
    
	/** The Person manager. */
	@EJB
	private PersonManager pm;
	
    /** The authentified user. */
    private Person authUser = null;
    
    /**
     * Login an User
     *
     * @param emailAddress the email address
     * @param password the password
     * @return the person
     */
    @Override
    public Person login(String emailAddress, String password) {
		if (emailAddress.isBlank() || password.isBlank())
			return null;
		
		Person person = pm.findByEmail(emailAddress);

		if (person == null)
			return null;

		if (authUser != null)
			return null;
		
		if (person.getPassword().isBlank())
			return null;

		if (BCrypt.checkpw(password, person.getPassword())) {
			setAuthUser(person);
		}
		
    	System.out.println("User connected");
		return authUser;
    }
    
    /**
     * Logout the current log user
     */
    @Override
    public void logout() {
    	if(authUser != null) {
        	setAuthUser(null);
        	System.out.println("User disconnected");
    	}
    }
    
    /**
     * Checks if is logged.
     *
     * @return true, if is logged
     */
    @Override
    public boolean isLogged() {
    	return getAuthUser() != null;
    }
    
	/**
	 * Gets the auth user.
	 *
	 * @return the auth user
	 */
	public Person getAuthUser() {
		return authUser;
	}

	/**
	 * Sets the auth user.
	 *
	 * @param authUser the new auth user
	 */
	private void setAuthUser(Person authUser) {
		this.authUser = authUser;
	}

	/**
	 * Generate sign up token.
	 *
	 * @return the string
	 */
	@Override
	public String generateSignUpToken() {
		Person newUser = createNewUser();
		newUser.setSignUpToken(getSignUpToken(newUser));
		newUser = pm.save(newUser);	
		return newUser.getSignUpToken();
	}

	/**
	 * Creates the new user.
	 *
	 * @return the person
	 */
	private Person createNewUser() {
		int authUserId = authUser.getId();
		long millis = System.currentTimeMillis();

		String hash = authUserId + "a" + millis;

		Person person = new Person();
		person.setFirstname("Guest" + hash);
		person.setFirstname("Guest" + hash);
		person.setEmail("guest" + hash + "@guest.co");
		person.setPassword(BCrypt.hashpw("guest" + hash, BCrypt.gensalt()));
		person.setInvitedBy(authUser);
		person = pm.save(person);
		return person;
	}	
	
	/**
	 * Gets the sign up token.
	 *
	 * @param person the person
	 * @return the sign up token
	 */
	private String getSignUpToken(Person person) {
		String token = person.getId() + "/" + person.getInvitedBy().getId();
		return BCrypt.hashpw(token, BCrypt.gensalt());
	}

	/**
	 * Verify sign up token.
	 *
	 * @param signUpToken the sign up token
	 * @return the person
	 */
	@Override
	public Person verifySignUpToken(String signUpToken) {
		return pm.getBySignUpToken(signUpToken);
	}

	/**
	 * Sign up a new user.
	 *
	 * @param signUpToken the sign up token
	 * @param person the person
	 * @return the person
	 */
	@Override
	public Person signUp(String signUpToken, Person person) {
	Person newUser = verifySignUpToken(signUpToken);	
		if (newUser != null) {
			person.setId(newUser.getId());
			person.setPassword(BCrypt.hashpw(person.getPassword(), BCrypt.gensalt()));
			person = pm.save(person);
			return person;
		}
		return null;
	}
}

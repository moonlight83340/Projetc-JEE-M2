package myapp.services;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import org.mindrot.jbcrypt.BCrypt;

import myapp.model.Person;

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class AuthentificationManager implements IAuthentificationManager{
    
	@EJB
	private PersonManager pm;
	
    private Person authUser = null;
    
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
    
    @Override
    public void logout() {
    	if(authUser != null) {
        	setAuthUser(null);
        	System.out.println("User disconnected");
    	}
    }
    
    @Override
    public boolean isLogged() {
    	return getAuthUser() != null;
    }
    
	public Person getAuthUser() {
		return authUser;
	}

	private void setAuthUser(Person authUser) {
		this.authUser = authUser;
	}

	@Override
	public String generateSignUpToken() {
		Person newUser = createNewUser();
		newUser.setSignUpToken(getSignUpToken(newUser));
		newUser = pm.save(newUser);	
		return newUser.getSignUpToken();
	}

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
	
	private String getSignUpToken(Person person) {
		String token = person.getId() + "/" + person.getInvitedBy().getId();
		return BCrypt.hashpw(token, BCrypt.gensalt());
	}

	@Override
	public Person verifySignUpToken(String signUpToken) {
		return pm.getBySignUpToken(signUpToken);
	}

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

package myapp.services;

import javax.ejb.Local;

import myapp.model.Person;

@Local
public interface IAuthentificationManager {
    public Person login(String emailAddress, String password);
    
    public void logout();
    
    public boolean isLogged();

	public String generateSignUpToken();
	
	public Person verifySignUpToken(String signUpToken);
	
	public Person signUp(String signUpToken, Person person);

}
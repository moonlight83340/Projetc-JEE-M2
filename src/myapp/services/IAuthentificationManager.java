package myapp.services;

import javax.ejb.Local;

import myapp.model.Person;

@Local
public interface IAuthentificationManager {
    public void login(Person user);
    
    public void logout();
    
    public boolean isLogged();
}
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.Person;
import services.PersonManager;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;

class TestPersonManager {
	    @EJB
	    PersonManager pm;

	    @Before
	    public void setUp() throws Exception {
	        EJBContainer.createEJBContainer().getContext().bind("inject", this);
	    }

	    @After
	    public void tearDown() throws Exception {
	        EJBContainer.createEJBContainer().close();
	    }
	    
	    public Person createNewPerson() {
	    	Person p = new Person();   	
	    	return p;
	    }

	    @Test
	    public void testFindPersons() {
	    	assert(!pm.findAll().isEmpty());
	    }

	    @Test
	    public void testAddPerson() {
	    	Person p = createNewPerson();
	    	assertNotNull(pm.save(p));
	    }
	    
	    @Test
	    public void testBadAddPerson() {
	    	//Person p = createNewPerson();
	    }
	    
	    @Test
	    public void testUpdatePerson() {
	    	//Person p = createNewPerson();
	    }
	    
	    @Test
	    public void testRemovePerson() {
	    	//Person p = createNewPerson();
	    }
	
	    @Test
	    public void testBadRemovePerson() {
	    	//Person p = createNewPerson();
	    }
	

}

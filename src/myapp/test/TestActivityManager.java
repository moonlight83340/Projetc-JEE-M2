package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myapp.model.Activity;
import myapp.services.ActivityManager;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;

class TestActivityManager {
	    @EJB
	    ActivityManager pm;

		static EJBContainer container;
		
	    @BeforeAll
	    static  public void beforeAll() throws Exception {
	        container = EJBContainer.createEJBContainer();
	    }
	    
	    @AfterAll
	    static  public void afterAll() throws Exception {
	        container.close();
	    }

	    @BeforeEach
	    public void before() throws Exception {
	        container.getContext().bind("inject", this);
	    }
	    
	    public Activity createNewActivity() {
	    	Activity a = new Activity();
	    	return a;
	    }

	    @Test
	    public void testAddActivity() {
	    	Activity a = createNewActivity();
	    	assertNotNull(a);
	    }
	    
	    @Test
	    public void testFindActivities() {
	    	//assert(!pm.findAll().isEmpty());
	    }
	    
	    @Test
	    public void testBadAddActivity() {
	    	//Activity a = createNewActivity();
	    }
	    
	    @Test
	    public void testUpdatePerson() {
	    	//Person a = createNewActivity();
	    }
	    
	    @Test
	    public void testRemovePerson() {
	    	//Activity a = createNewActivity();
	    }
	
	    @Test
	    public void testBadRemovePerson() {
	    	//Activity a = createNewActivity();
	    }
	

}

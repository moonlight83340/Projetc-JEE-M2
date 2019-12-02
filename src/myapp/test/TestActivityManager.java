package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

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
	    
	    @Before
	    public void setUp() throws Exception {
	        EJBContainer.createEJBContainer().getContext().bind("inject", this);
	        assertNotNull(pm);
	    }

	    @After
	    public void tearDown() throws Exception {
	        EJBContainer.createEJBContainer().close();
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

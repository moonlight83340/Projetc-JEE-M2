package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myapp.model.CV;
import myapp.services.CVManager;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;

class TestCVManager {
	    @EJB
	    CVManager pm;

	    @Before
	    public void setUp() throws Exception {
	        EJBContainer.createEJBContainer().getContext().bind("inject", this);
	    }

	    @After
	    public void tearDown() throws Exception {
	        EJBContainer.createEJBContainer().close();
	    }
	    
	    public CV createNewCV() {
	    	CV c = new CV();
	    	
	    	return c;
	    }

	    @Test
	    public void testFindCourses() {
	    	assert(!pm.findAll().isEmpty());
	    }

	    @Test
	    public void testAddCV() {
	    	CV c = createNewCV();
	    	assertNotNull(c);
	    }
	    
	    @Test
	    public void testBadAddCV() {
	    	//CV c = createNewCV();
	    }
	    
	    @Test
	    public void testUpdateCV() {
	    	//CV c = createNewCV();
	    }
	    
	    @Test
	    public void testRemoveCV() {
	    	//CV c = createNewCV();
	    }
	
	    @Test
	    public void testBadRemoveCV() {
	    	//CV c = createNewCV();
	    }
	

}

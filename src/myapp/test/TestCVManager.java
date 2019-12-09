package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	    
	    public CV createNewCV() {
	    	CV c = new CV();
	    	return c;
	    }

	    @Test
	    public void testFindCourses() {
	    	//assert(!pm.findAll().isEmpty());
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

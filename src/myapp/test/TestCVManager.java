package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myapp.model.Activity;
import myapp.model.CV;
import myapp.services.CVManager;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

/**
 * @author Gaëtan
 * ToDo Test Activity's functions
 */
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
	    
		public CV createNewDefaultActivityInit() {
			CV c = new CV();
			return c;
		}

	    @Test
	    public void testAddCV() {
	    	CV c = createNewCV();
	    	c = pm.save(c);
	    	CV same = pm.find(c.getId());
			assertNotNull(same);
	    }
	    
	    @Test
	    public void testFindAllCV() {
	        assertNotNull(pm);
	        CV c = createNewDefaultActivityInit();
	        c = pm.save(c);

	        CV c2 = createNewDefaultActivityInit();
	        c2 = pm.save(c2);
	        
			assert (!pm.findAll().isEmpty());
	    }
   
	    @Test
	    public void testRemoveCV() {
	    	CV c = createNewDefaultActivityInit();
	    	c = pm.save(c);		
			pm.delete(c);			
			CV same = pm.find(c.getId());
			assertNull(same);
	    }
	    
	    @Test
		public void testSaveCVMerge() {
	    	CV c = createNewDefaultActivityInit();
	    	c = pm.save(c);	
	    	c.setId(2);
	    	c = pm.save(c);	
			CV same = pm.find(c.getId());
			assertNotNull(same);
		}
}

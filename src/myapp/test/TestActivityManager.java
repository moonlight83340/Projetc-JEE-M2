package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myapp.model.Activity;
import myapp.services.ActivityManager;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

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
	    	Activity activity = pm.create();
	    	return activity;
	    }
	    
		public Activity createNewDefaultActivityInit() {
			Activity activity = new Activity(2019,"TestNature", "TestTitle");
			return activity;
		}

	    @Test
	    public void testAddActivity() {
	    	Activity activity = createNewDefaultActivityInit();
	    	activity = pm.save(activity);
	    	Activity same = pm.find(activity.getId());
			assertNotNull(same);
	    }
	    
	    @Test
	    public void testFindActivities() {
	        assertNotNull(pm);
	        Activity activity = createNewDefaultActivityInit();
	        activity = pm.save(activity);

			Activity activity2 = createNewDefaultActivityInit();
			activity2 = pm.save(activity2);

			assert (!pm.findAll().isEmpty());
	    }

	    @Test
	    public void testRemoveActivity() {
	    	Activity activity = createNewDefaultActivityInit();
	    	activity = pm.save(activity);		
			pm.delete(activity);			
			Activity same = pm.find(activity.getId());
			assertNull(same);
	    }
	    
		@Test
		public void testActivityLike() {
			Activity activity = createNewDefaultActivityInit();
			activity.setTitle("NewTitle");
			activity = pm.save(activity);
			
			Activity activity2 = createNewDefaultActivityInit();
			activity2.setTitle("NewTitle2");
			activity2 = pm.save(activity2);
			
			List<Activity> same = pm.findLike("NewTitle");
			assertTrue(same.size() >= 2);
		}
		
		@Test
		public void testSaveActivityMerge() {
	    	Activity activity = createNewDefaultActivityInit();
	    	activity = pm.save(activity);	
	    	activity.setNature("defaultNat");
	    	activity = pm.save(activity);	
			Activity same = pm.find(activity.getId());
			assertNotNull(same);
		}
}

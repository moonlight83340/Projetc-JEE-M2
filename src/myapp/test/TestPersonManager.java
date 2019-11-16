package myapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import myapp.model.CV;
import myapp.model.Person;
import myapp.services.PersonManager;

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
		assertNotNull(pm);
	}

	@After
	public void tearDown() throws Exception {
		EJBContainer.createEJBContainer().close();
	}

	public Person createNewPerson() {
		Person p = new Person();
		return p;
	}

	public Person createNewPersonInit() {
		Person p = new Person("a", "a", "a@a.a", "a.com", new Date(), "a");
		return p;
	}

	@Test
	public void testCorrect() {
		assertNotNull(pm);
	}

	@Test
	public void testFindPersons() {
		Person person = createNewPersonInit();
		person = pm.save(person);

		Person person2 = createNewPersonInit();
		person = pm.save(person2);

		assert (!pm.findAll().isEmpty());
	}

	@Test
	public void testAddPerson() {
		Person person = createNewPersonInit();
		person = pm.save(person);
		Person same = pm.find(person.getId());
		assertNotNull(same);
	}

	@Test
	public void testUpdatePerson() {
		Person person = createNewPersonInit();
		person = pm.save(person);
		
		person.setFirstname("b");
		pm.save(person);
		
		Person same = pm.find(person.getId());
		assertTrue(same.getFirstname().equals("b"));
	}

	@Test
	public void testRemovePerson() {
		Person person = createNewPersonInit();
		person = pm.save(person);
		
		pm.delete(person);
		
		Person same = pm.find(person.getId());
		assertNull(same);
	}

	@Test
	public void testAddCV() {
		Person person = createNewPersonInit();
		
		CV cv = new CV();
		person.setCv(cv);
		
		person = pm.save(person);
		
		Person same = pm.find(person.getId());
		
		assertNotNull(same.getCv());
	}

}

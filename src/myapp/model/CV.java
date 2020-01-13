package myapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class CV.
 * @author Gaëtan
 */
@Entity()
@Table(name = "T_CV")
public class CV implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id()
    @GeneratedValue
    private Integer id;
    
	/** The person. */
	@OneToOne(mappedBy = "cv")
	private Person person;
    
    /** The activities. */
    @OneToMany(mappedBy = "cv", fetch=FetchType.EAGER)
    List<Activity> activities = new ArrayList<Activity>();

    /**
     * Get the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Get the person.
     *
     * @return the person
     */
    public Person getPerson() {
		return person;
	}

	/**
	 * Set the person.
	 *
	 * @param person the new person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Get the activities.
	 *
	 * @return the activities
	 */
	public List<Activity> getActivities() {
    	return activities;
    }
    
	/**
	 * Set the activities.
	 *
	 * @param activities the new activities
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
    /**
     * Add the activity.
     *
     * @param activity the activity
     */
    public void addActivity(Activity activity) {
    	activities.add(activity);
    }
    
    /**
     * Remove the activity.
     *
     * @param activity the activity
     */
    public void removeActivity(Activity activity) {
    	for(Activity act : activities) {
    		if( activity.equals(act) ) {
    			activities.remove(act);
    		}
    	}
    }
    
    /**
     * Remove the activity by id.
     *
     * @param activityId the activity id
     */
    public void removeActivityById(int activityId) {
    	for(Activity act : activities) {
    		if( act.getId() == activityId ) {
    			activities.remove(act);
    		}
    	}
    }
    
    /**
     * Get the activity by id.
     *
     * @param activityId the activity id
     * @return the activity by id
     */
    public Activity getActivityById(int activityId) {
    	return activities.get(activityId);
    }

}
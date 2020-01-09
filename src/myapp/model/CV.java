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

@Entity()
@Table(name = "T_CV")
public class CV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue
    private Integer id;
    
	@OneToOne(mappedBy = "cv")
	private Person person;
    
    @OneToMany(mappedBy = "cv", fetch=FetchType.EAGER)
    List<Activity> activities = new ArrayList<Activity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Activity> getActivities() {
    	return activities;
    }
    
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
    public void addActivity(Activity activity) {
    	activities.add(activity);
    }
    
    public void removeActivity(Activity activity) {
    	for(Activity act : activities) {
    		if( activity.equals(act) ) {
    			activities.remove(act);
    		}
    	}
    }
    
    public void removeActivityById(int activityId) {
    	for(Activity act : activities) {
    		if( act.getId() == activityId ) {
    			activities.remove(act);
    		}
    	}
    }
    
    public Activity getActivityById(int activityId) {
    	return activities.get(activityId);
    }

}
package myapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "T_CV")
public class CV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue
    private Integer id;
    
    @OneToMany
    List<Activity> activities = new ArrayList<Activity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public List<Activity> getActivities() {
    	return activities;
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
package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name = "T_CV")
public class CV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    private Integer id;
    
    @OneToMany
    ArrayList<Activity> activities = new ArrayList<Activity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public ArrayList<Activity> getActivities() {
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
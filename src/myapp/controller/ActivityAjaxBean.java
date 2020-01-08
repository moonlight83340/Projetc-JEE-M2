package myapp.controller;

import java.io.Serializable;
import java.time.Year;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import myapp.model.Activity;
import myapp.services.ActivityManager;
import myapp.services.CVManager;

@ManagedBean
@ViewScoped
public class ActivityAjaxBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    
    @EJB
    private ActivityManager manager;
    
	private String natureText = "";
    private Integer yearValue = 0;
    private String titleText = "";
    private String descriptionText = "";
    private String webAdressText = "";
    
    private String buttonText = "Ajouter";
    private boolean addMode = true;
    private int updateIndex = -1;
    
	private List<Activity> activities = new LinkedList<Activity>();

    public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public ActivityAjaxBean() {
		//activities = cvController.theInstance.getActivities();
    }
	
    public void addActivity() {
    	Activity activity = createActivity();
    	if(addMode != true) {
    		activities.set(updateIndex, activity);
    		manager.save(activity);
    		addMode = true;
    		updateIndex = -1;
    		setButtonText("Ajouter");
    		resetActivity();
    	}
    	else if (checkActivity()) {
    		activities.add(activity);
    		resetActivity();
        }
        
    }

    public void removeActivity(int index) {
        activities.remove(index);
        resetActivity();
        addMode = true;
        setButtonText("Ajouter");
    }
    
    public void updateActivity(int index) {
    	Activity activity = activities.get(index);
    	setActivity(activity);
    	updateIndex = index;
    	addMode = false;
    	setButtonText("Mettre à jour");
    }

    private boolean checkActivity() {
    	boolean isCorrect = true;
    	
    	if(yearValue < 1900 || yearValue > Year.now().getValue()) {
    		isCorrect = false;
    	}
    	
    	if(titleText.trim().length() == 0) {
    		isCorrect = false;
    	}
    	
      	if(natureText.trim().length() == 0) {
    		isCorrect = false;
    	}
    	
    	return isCorrect;
    }
    
    public Activity createActivity() {
    	Activity activity = new Activity();
    	
        activity.setYear(yearValue);
        activity.setNature(natureText);
		activity.setTitle(titleText);
		activity.setDescription(descriptionText);
		activity.setWebAdress(webAdressText);
		
    	return activity;
    }
    
    public void setActivity(Activity activity) {
        yearValue = activity.getYear();
        natureText = activity.getNature();
		titleText = activity.getTitle();
		descriptionText = activity.getDescription();
		webAdressText = activity.getWebAdress();
    }
    
    public void resetActivity() {
        yearValue = 0;
        natureText = "";
		titleText = "";
		descriptionText = "";
		webAdressText = "";
    }
    
    public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
    
    public String getNatureText() {
		return natureText;
	}

	public void setNatureText(String natureText) {
		this.natureText = natureText;
	}

	public Integer getYearValue() {
		return yearValue;
	}

	public void setYearValue(Integer yearValue) {
		this.yearValue = yearValue;
	}

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public String getWebAdressText() {
		return webAdressText;
	}

	public void setWebAdressText(String webAdressText) {
		this.webAdressText = webAdressText;
	}
}
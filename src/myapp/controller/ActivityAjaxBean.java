package myapp.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import myapp.model.Activity;

@ManagedBean
@ViewScoped
public class ActivityAjaxBean implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

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
    }
	
    public void addActivity() {
    	if(addMode != true) {
    		activities.set(updateIndex, createActivity());
    		addMode = true;
    		updateIndex = -1;
    		setButtonText("Add");
    		text = "";
    	}
    	else if (text.trim().length() > 0) {
    		activities.add(text);
            System.err.println("add " + text);
            text = "";
        }
        
    }

    public void removeCity(int index) {
        cities.remove(index);
        text = "";
        addMode = true;
        setButtonText("Add");
    }
    
    public void updateCity(int index) {
    	text = cities.get(index);
    	updateIndex = index;
    	addMode = false;
    	setButtonText("Update");
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
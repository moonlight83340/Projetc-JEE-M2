package myapp.controller;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import myapp.model.Activity;
import myapp.services.ActivityManager;

/**
 * The Class ActivityAjaxBean.
 */
@ManagedBean
@ViewScoped
public class ActivityAjaxBean implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5443351151396868724L;
    
    /** The Activity Manager. */
    @EJB
    private ActivityManager manager;
    
	/** The nature text. */
	private String natureText = "";
    
    /** The year value. */
    private Integer yearValue = 0;
    
    /** The title text. */
    private String titleText = "";
    
    /** The description text. */
    private String descriptionText = "";
    
    /** The web adress text. */
    private String webAdressText = "";
    
    /** The button text. */
    private String buttonText = "Ajouter";
    
    /** The add mode. */
    private boolean addMode = true;
    
    /** The update index. */
    private int updateIndex = -1;
    
	/** The activities. */
	private List<Activity> activities = new LinkedList<Activity>();

    /**
     * Gets the button text.
     *
     * @return the button text
     */
    public String getButtonText() {
		return buttonText;
	}

	/**
	 * Sets the button text.
	 *
	 * @param buttonText the new button text
	 */
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	/**
	 * Checks if is adds the mode.
	 *
	 * @return true, if is adds the mode
	 */
	public boolean isAddMode() {
		return addMode;
	}

	/**
	 * Sets the adds the mode.
	 *
	 * @param addMode the new adds the mode
	 */
	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	/**
	 * Instantiates a new activity ajax bean.
	 */
	public ActivityAjaxBean() {
		//activities = cvController.theInstance.getActivities();
    }
	
    /**
     * Adds the activity.
     */
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

    /**
     * Removes the activity.
     *
     * @param index the index
     */
    public void removeActivity(int index) {
        activities.remove(index);
        resetActivity();
        addMode = true;
        setButtonText("Ajouter");
    }
    
    /**
     * Update activity.
     *
     * @param index the index
     */
    public void updateActivity(int index) {
    	Activity activity = activities.get(index);
    	setActivity(activity);
    	updateIndex = index;
    	addMode = false;
    	setButtonText("Mettre à jour");
    }

    /**
     * Check activity.
     *
     * @return true, if successful
     */
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
    
    /**
     * Creates the activity.
     *
     * @return the activity
     */
    public Activity createActivity() {
    	Activity activity = new Activity();
    	
    	Date date = new Date();
    	date.setYear(yearValue.intValue());
        activity.setYear(date);
        
        //activity.setType(natureText);
        
		activity.setTitle(titleText);
		activity.setDescription(descriptionText);
		activity.setWebAddress(webAdressText);
		
    	return activity;
    }
    
    /**
     * Sets the activity.
     *
     * @param activity the new activity
     */
    public void setActivity(Activity activity) {
        yearValue = activity.getYear().getYear();
        natureText = activity.getType().toString();
		titleText = activity.getTitle();
		descriptionText = activity.getDescription();
		webAdressText = activity.getWebAddress();
    }
    
    /**
     * Reset activity.
     */
    public void resetActivity() {
        yearValue = 0;
        natureText = "";
		titleText = "";
		descriptionText = "";
		webAdressText = "";
    }
    
    /**
     * Gets the activities.
     *
     * @return the activities
     */
    public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * Sets the activities.
	 *
	 * @param activities the new activities
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
    
    /**
     * Gets the nature text.
     *
     * @return the nature text
     */
    public String getNatureText() {
		return natureText;
	}

	/**
	 * Sets the nature text.
	 *
	 * @param natureText the new nature text
	 */
	public void setNatureText(String natureText) {
		this.natureText = natureText;
	}

	/**
	 * Gets the year value.
	 *
	 * @return the year value
	 */
	public Integer getYearValue() {
		return yearValue;
	}

	/**
	 * Sets the year value.
	 *
	 * @param yearValue the new year value
	 */
	public void setYearValue(Integer yearValue) {
		this.yearValue = yearValue;
	}

	/**
	 * Gets the title text.
	 *
	 * @return the title text
	 */
	public String getTitleText() {
		return titleText;
	}

	/**
	 * Sets the title text.
	 *
	 * @param titleText the new title text
	 */
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	/**
	 * Gets the description text.
	 *
	 * @return the description text
	 */
	public String getDescriptionText() {
		return descriptionText;
	}

	/**
	 * Sets the description text.
	 *
	 * @param descriptionText the new description text
	 */
	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	/**
	 * Gets the web adress text.
	 *
	 * @return the web adress text
	 */
	public String getWebAdressText() {
		return webAdressText;
	}

	/**
	 * Sets the web adress text.
	 *
	 * @param webAdressText the new web adress text
	 */
	public void setWebAdressText(String webAdressText) {
		this.webAdressText = webAdressText;
	}
}
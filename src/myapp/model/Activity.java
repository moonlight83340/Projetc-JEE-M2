package myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The Class Activity.
 * @author Gaëtan
 */
@Entity()
@Table(name = "T_Activity")
public class Activity implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

	/** The id. */
	@Id()
    @GeneratedValue
    private Integer id;
	
    /** The title. */
    @Column
    @NotNull
    private String title;

	/** The year. */
	@NotNull
	@Column()
	private Date year;
    
	/** The type. */
	@Column()
	@NotNull()
	private ActivityType type;

	/** The description. */
	@Column()
	private String description;
    
    /** The web address. */
    @Column 
    private String webAddress;
	
	/** The cv. */
	@ManyToOne()
	@JoinColumn()
	private CV cv;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public Date getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(Date year) {
		this.year = year;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ActivityType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(ActivityType type) {
		this.type = type;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the web address.
	 *
	 * @return the web address
	 */
	public String getWebAddress() {
		return webAddress;
	}

	/**
	 * Sets the web address.
	 *
	 * @param webAddress the new web address
	 */
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	/**
	 * Gets the cv.
	 *
	 * @return the cv
	 */
	public CV getCv() {
		return cv;
	}

	/**
	 * Sets the cv.
	 *
	 * @param cv the new cv
	 */
	public void setCv(CV cv) {
		this.cv = cv;
	}
	
	/**
	 * Equals function.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof Activity)
    		if(((Activity) obj).getId() == this.getId())
    			return true;
    	return false;
    }
    
}
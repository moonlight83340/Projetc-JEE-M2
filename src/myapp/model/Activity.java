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

@Entity()
@Table(name = "T_Activity")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;

	@Id()
    @GeneratedValue
    private Integer id;
	
    @Column
    @NotNull
    private String title;

	@NotNull
	@Column()
	private Date year;
    
	@Column()
	@NotNull()
	private ActivityType type;

	@Column()
	private String description;
    
    @Column 
    private String webAddress;
	
	@ManyToOne()
	@JoinColumn()
	private CV cv;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}
	
	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof Activity)
    		if(((Activity) obj).getId() == this.getId())
    			return true;
    	return false;
    }
    
}
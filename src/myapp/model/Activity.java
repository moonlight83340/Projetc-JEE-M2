package myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "T_Activity")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Activity() {
    	
    }
    
    public Activity(Integer year, String nature, String title, String description, String webAdress) {
		this.year = year;
		this.nature = nature;
		this.title = title;
		this.description = description;
		this.webAdress = webAdress;
	}
    
    public Activity(Integer year, String nature, String title) {
		this.year = year;
		this.nature = nature;
		this.title = title;
	}

	@Id()
    @GeneratedValue
    private Integer id;

    @Column 
    @NotNull
    private Integer year;
    
    @Column
    @NotNull
    private String nature;
   
    @Column
    @NotNull
    private String title;
    
    @Column
    private String description;
    
    @Column 
    private String webAdress;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNature() {
		return nature;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebAdress() {
		return webAdress;
	}

	public void setWebAdress(String webAdress) {
		this.webAdress = webAdress;
	}

	@Override
    public boolean equals(Object obj) {
    	if(obj instanceof Activity)
    		if(((Activity) obj).getId() == this.getId())
    			return true;
    	return false;
    }
    
}
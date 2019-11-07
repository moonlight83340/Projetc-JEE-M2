package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "T_Activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
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

    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Activity)
    		if(((Activity) obj).getId() == this.getId())
    			return true;
    	return false;
    }
    
}
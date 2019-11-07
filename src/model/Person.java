package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name = "T_Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id()
    private Integer id;

    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "website")
    private String website;
    
    @Column(name = "birthDate")
    private String birthDate;
    
    @Column(name = "password")
    private String password;

	@OneToOne
    private CV cv;

	public Person() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    public CV getCv() {
		return cv;
	}

	public void setCv(CV cv) {
		this.cv = cv;
	}

}
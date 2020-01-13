package myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The Class Person.
 * @author Ga�tan
 */
@Entity()
@Table(name = "T_Person", uniqueConstraints={@UniqueConstraint(columnNames = "email")})
public class Person implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id()
    @GeneratedValue
    private Integer id;

    /** The lastname. */
    @Column(name = "lastname")
    private String lastname;
    
    /** The firstname. */
    @Column(name = "firstname")
    private String firstname;
    
    /** The email. */
    @Column(name = "email")
    private String email;
    
    /** The website. */
    @Column(name = "website")
    private String website;
    
    /** The birth date. */
    @Column(name = "birthDate")
    private Date birthDate;
    
    /** The password. */
    @Column(name = "password")
    private String password;

	/** The cv. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private CV cv;
	
	/** The sign up token. */
	@Column()
	private String signUpToken;
	
	/** The invited by. */
	@ManyToOne()
	@JoinColumn()
	private Person invitedBy;


	/**
	 * Instantiates a new person.
	 */
	public Person() {
        super();
    }
	
	/**
	 * Instantiates a new person.
	 *
	 * @param lastname the lastname
	 * @param firstname the firstname
	 * @param email the email
	 * @param website the website
	 * @param birthDate the birth date
	 * @param password the password
	 */
	public Person(String lastname, String firstname, String email, String website, Date birthDate, String password) {
        super();
        
        this.lastname = lastname;
        
        this.firstname = firstname;
        
        this.email = email;
        
        this.website = website;
        
        this.birthDate = birthDate;
        
        this.password = password;
    }

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
     * Gets the lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the website.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Sets the website.
	 *
	 * @param website the new website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * Gets the sign up token.
	 *
	 * @return the sign up token
	 */
	public String getSignUpToken() {
		return signUpToken;
	}

	/**
	 * Sets the sign up token.
	 *
	 * @param signUpToken the new sign up token
	 */
	public void setSignUpToken(String signUpToken) {
		this.signUpToken = signUpToken;
	}

	/**
	 * Gets the invited by.
	 *
	 * @return the invited by
	 */
	public Person getInvitedBy() {
		return invitedBy;
	}

	/**
	 * Sets the invited by.
	 *
	 * @param invitedBy the new invited by
	 */
	public void setInvitedBy(Person invitedBy) {
		this.invitedBy = invitedBy;
	}

	/**
	 * Equals function.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Person) ) return false;
		
		Person p = (Person) obj;
		return this.getId() == p.getId();
	}
}
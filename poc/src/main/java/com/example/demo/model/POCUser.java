package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class POCUser implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6340001930731156025L;
	private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Integer typeid;
   
    //private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    //@ManyToMany
    //@Fetch(FetchMode.JOIN)
    //@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_typeid"), inverseJoinColumns = @JoinColumn(name = "role_typeid"))
   // public Set<Role> getRoles() {
       // return roles;
   // }

    //public void setRoles(Set<Role> roles) {
       // this.roles = roles;
    //}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
    
}

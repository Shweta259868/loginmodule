package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6337763067535270782L;
	private Long id;
    private String name;
    
    private Integer typeid;
    
    //private Set<POCUser> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* @ManyToMany(mappedBy = "roles")
    public Set<POCUser> getUsers() {
        return users;
    }

    public void setUsers(Set<POCUser> users) {
        this.users = users;
    }*/

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
    
}

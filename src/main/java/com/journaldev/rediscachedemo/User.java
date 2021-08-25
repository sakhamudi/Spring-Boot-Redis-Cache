package com.journaldev.rediscachedemo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER")
public class User implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
    @GeneratedValue
     Long id;
    
    @Column(name="name")
     String name;
    
    @Column(name="followers")
     String followers;

    public User() {
    }

    public User(String name, String followers) {
        this.name = name;
        this.followers = followers;
    }

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

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }
   
    @Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", followers=" + followers + "]";
	}
}

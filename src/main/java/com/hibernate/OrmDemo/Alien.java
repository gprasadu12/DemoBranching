package com.hibernate.OrmDemo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	@Id
	private int id;
	private Fullname fullname;
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fullname getName() {
		return fullname;
	}
	public void setName(Fullname name) {
		this.fullname = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + fullname + ", color=" + color + "]";
	}
	

}

package com.niranjan.custom.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HDFC")
public class HDFCDto implements Serializable{
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="custom",strategy="com.niranjan.custom.generator.IFSCCodeGenerator")
	@GeneratedValue(generator="custom")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="creation_date")
	private Date creationDate;
	public HDFCDto() {
		System.out.println(this.getClass().getSimpleName()+" created...");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}

package com.template.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.template.app.util.JsonDateSerializer;

@Entity
@Table(name="POST")
@SequenceGenerator(name = "POST_ID_GENERATOR", sequenceName = "SE_POST", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="PostEntity.retrieveAll", query="Select distinct a from PostEntity a")
}) 

public class PostEntity implements IEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -22186901797010962L;

	/**
	 * 
	 */

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_ID_GENERATOR")
	private Long id;
	
	@Size(min = 1, max = 999)
	@Column
	private String text;
	
	@Size(min = 1, max = 255)
	@Column
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP) // yyyy-MM-dd HH:mm:ss
	@Column
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateCreated;
	
	@Temporal(TemporalType.TIMESTAMP) // yyyy-MM-dd HH:mm:ss
	@Column
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateLastUpdated;
	
	@PrePersist
    protected void onCreate() {
		dateCreated = new Date();
		dateLastUpdated = new Date();
    }
	
	@PreUpdate
	protected void onUpdate() {
		dateLastUpdated = new Date();
	}
	
	public PostEntity() {
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastUpdated() {
		return dateLastUpdated;
	}

	public void setDateLastUpdated(Date dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}

	public void setAttributes(PostEntity other) {
		//this.id = other.id;
		this.title = other.title;
		this.text = other.text;
	}
	

}

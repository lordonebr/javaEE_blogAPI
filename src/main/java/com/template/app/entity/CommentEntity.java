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
@Table(name="COMMENT")
@SequenceGenerator(name = "COMMENT_ID_GENERATOR", sequenceName = "SE_COMMENT", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="CommentEntity.retrieveAll", query="Select distinct p from CommentEntity p ORDER BY p.dateCreated ASC")
}) 

public class CommentEntity implements IEntity<Long> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8935449785811267587L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_ID_GENERATOR")
	private Long id;
	
	@Size(min = 1, max = 999)
	@Column
	private String text;
	
	@Size(min = 1, max = 255)
	@Column
	private String userName;
	
	@Temporal(TemporalType.TIMESTAMP) // yyyy-MM-dd HH:mm:ss
	@Column
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateCreated;
	
	@PrePersist
    protected void onCreate() {
		dateCreated = new Date();
    }
	
	public CommentEntity() {
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
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}

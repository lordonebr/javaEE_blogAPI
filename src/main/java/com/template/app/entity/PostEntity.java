package com.template.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="POST")
@SequenceGenerator(name = "POST_ID_GENERATOR", sequenceName = "SE_POST", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="PostEntity.retrieveAll", query="Select distinct a from PostEntity a"),
    @NamedQuery(name="PostEntity.removeById", query="Delete from PostEntity a where a.id = :id")
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
	
	public PostEntity() {
		
	}
	
	public PostEntity(Long id, String title, String text) {
		this.id = id;
		this.title = title;
		this.text = text;
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

}

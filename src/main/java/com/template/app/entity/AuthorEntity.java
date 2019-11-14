package com.template.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="AUTHOR")
@SequenceGenerator(name = "AUTHOR_ID_GENERATOR", sequenceName = "SE_AUTHOR", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="AutorEntity.retrieveAll", query="Select distinct a from AuthorEntity a ORDER BY a.id ASC")
}) 

public class AuthorEntity implements IEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7618064921038917140L;

	/**
	 * 
	 */
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_ID_GENERATOR")
	private Long id;
	
	@Size(max = 255)
	@Column
	private String name;
	
	@OneToMany (cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "POST_ID")
	private List<PostEntity> posts = new ArrayList<>();
	
	public AuthorEntity() {
		
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PostEntity> getPosts() {
		return posts;
	}

	public void setPosts(List<PostEntity> listPostsEntity) {
		this.posts = listPostsEntity;
	}
	
}

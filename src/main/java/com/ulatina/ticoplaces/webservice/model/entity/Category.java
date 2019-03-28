package com.ulatina.ticoplaces.webservice.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tbl_category")
public class Category implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_Category")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategory;
	
	@Column(name="Category_Name")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="category", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Place> places;
	
	

	public Category() {
		this.places = new ArrayList<>();
		
	}
	
	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	
	

}

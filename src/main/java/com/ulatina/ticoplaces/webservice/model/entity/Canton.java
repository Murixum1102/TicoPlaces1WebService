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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tbl_canton")
public class Canton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_Canton")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="Name")
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TBL_Province_id_Province")
	@JsonBackReference
	private Province province;
	
	//un caonton tiene una lista de distritos
	//@OneToMany(fetch=FetchType.LAZY, mappedBy="canton", cascade=CascadeType.ALL)
	//@JsonManagedReference
	//private List<District> districts;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cantonPlace", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Place> places;
	
		
	public Canton() {
		//districts = new ArrayList<>();
		places = new ArrayList<>();
	}
	
	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	/*public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}*/
	
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
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	
}

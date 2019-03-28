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
@Table(name="tbl_province")
public class Province implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_Province")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Name_Province")
	private String provinceName;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="province", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Canton> cantones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="provincia", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Place> place;
	
	public Province() {
		this.cantones = new ArrayList<>();
		this.place = new ArrayList<>();
	}
	
	public List<Place> getPlace() {
		return place;
	}
	public void setPlace(List<Place> place) {
		this.place = place;
	}
	
	public List<Canton> getCantones() {
		return cantones;
	}
	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	
	
}

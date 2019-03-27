package com.ulatina.ticoplaces.webservice.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tbl_place")
public class Place implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_Place")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPlace;
	
	@Column(name="Name")
	private String placeName;
	
	@Column(name="Longitud")
	private String longitude;
	
	@Column(name="Latitud")
	private String latitude;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Province_id_Province")
	@JsonBackReference
	private Province provincia;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TBL_Canton_id_Canton")
	@JsonBackReference
	private Canton canton;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="District_id_District")
	@JsonBackReference
	private District distrito;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TBL_Category_id_Category")
	@JsonBackReference
	private Category category;
}

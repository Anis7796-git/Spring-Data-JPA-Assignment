package com.anhee.entity;

import jakarta.persistence.*;

import lombok.RequiredArgsConstructor;
import lombok.Data;

@Table(name="Travel_Taj")
@Entity
@RequiredArgsConstructor
@Data
public class Travel {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	
	@Column(name="DESTINATION")
	private String destination;
	
	@Column(name="TRANSPORTATIONMODE")
	private String transportatoinMode;
	
	@Column(name="PRICE")
	private Double price;
	
}

/**
 * 
 */
package com.example.mycrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mobility")
public class Mobility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "year", nullable = false)
	private Integer year;

	@Column(name = "type_of_mobility", nullable = false)
	private String typeOfMobility;

	@Column(name = "campus", nullable = false)
	private String campus;

	@Column(name = "mobility_level", nullable = false)
	private String mobilityLevel;
	
	@Column(name = "mobility_goal", nullable = false)
	private String mobilityGoal;
	
	@Column(name = "number of participants", nullable = false)
	private Integer numberParticipants;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String rol;

	@Column(nullable = false)
	private Boolean state;

}

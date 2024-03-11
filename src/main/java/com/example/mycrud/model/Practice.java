/**
 * 
 */
package com.example.mycrud.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
@Table(name = "practices")
public class Practice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String laboratorio;

	@Column(name = "hora_planeada", nullable = false)
	private Integer horaPlaneada;

	@Column(name = "hora_ejecutada", nullable = false)
	private Integer horaEjecutada;

	@Column(nullable = false)
	private Integer ano;

	@Column(nullable = false)
	private Boolean estado;

	public BigDecimal getPorcentaje() {
		BigDecimal bd = new BigDecimal((horaEjecutada.doubleValue() / horaPlaneada) * 100);
		return bd.setScale(2, RoundingMode.HALF_UP);
	}

}

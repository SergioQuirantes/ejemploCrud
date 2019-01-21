package com.formacionsergio.ejemploCrud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "TODO")
public class TODO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TODO_id", updatable = false)
	@ApiModelProperty(notes = "ID de la tarea. Generado por la base de datos.")
	private Long id;
	
	@Column(name = "title", nullable = false)
	@ApiModelProperty(notes = "Titulo de la tarea. Indicado por el usuario.")
	private String title;
	
	@Column(name = "description", nullable = false)
	@ApiModelProperty(notes = "Descripcion de la tarea. Indicada por el usuario.")
	private String description;
	
	@Column(name = "state", nullable = false)
	@ApiModelProperty(notes = "Estado de la tarea. Indicado por el usuario.")
	private String state;

	@Column(name = "creationDate", nullable = false, updatable = false)
	@ApiModelProperty(notes = "Fecha de creacion de la tarea. Generada por la API")
	private Date creationDate;
	
	@Column(name = "modificationDate", nullable = false)
	@ApiModelProperty(notes = "Fecha de la ultima modificacion de la tarea. Generada por la API")
	private Date modificationDate;

	public TODO() {
	}

	public TODO(String title, String description, String state) {
		this.title = title;
		this.description = description;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
	
}

package com.crud.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min = 1, max = 100)
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name", length = 100)
	private String name;
	
    @Size(min = 4, max = 4)
    @Pattern(regexp = "^(5[0-9][0-9][0-9A-Ea-e]|[1-5][0-9][0-9][A-Fa-f])$", message = "The office must be between 100A-599F")
	@NotBlank(message = "Office is mandatory")
	@Column(name = "office", length = 4)
	private String office;
	
    @Size(min = 1, max = 150)
	@NotBlank(message = "Email is mandatory")
	@Column(name = "email", length = 150)
	private String email;
	
    @Size(min = 1, max = 12)
	@NotBlank(message = "Phone is mandatory")
	@Column(name = "phone", length = 12)
	private String phone;
	
    @Size(min = 1, max = 150)
	@NotBlank(message = "Role is mandatory")
	@Column(name = "role", length = 150)
	private String role;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
}

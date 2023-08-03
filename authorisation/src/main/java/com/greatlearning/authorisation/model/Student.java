package com.greatlearning.authorisation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
    private int studentId;
	
	@Column(name ="firstname")
	private String firstName;
	
	@Column(name ="lastname")
	private String lastName;
	
	@Column(name ="course")
	private String course;
	
	@Column(name ="country")
	private String country;
}

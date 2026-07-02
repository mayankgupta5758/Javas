package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_user")
public class User {
	
	@Id
	@Column(name = "id")
	private String userId;
	
	private String name;
	
	private String email;
	
	private String about;
	
//	ise Jpa db me save nahi karega
	@Transient
	private List<Ratings> ratings = new ArrayList<>();

}

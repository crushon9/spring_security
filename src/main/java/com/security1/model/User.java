package com.security1.model;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// ORM - Object Relation Mapping

@Entity
@Data
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String userid;
	private String password;
	private String email;
	private String role; //ROLE_USER, ROLE_ADMIN
	
	@CreationTimestamp // 자동으로 시간 삽입
	private Timestamp createDate;
}
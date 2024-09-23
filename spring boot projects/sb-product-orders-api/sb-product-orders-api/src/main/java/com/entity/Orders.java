package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
//@Setter
//@Getter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)		// auto increment 
private int oid;
private LocalDateTime orderdatatime;
@Column
private int qty;
private Integer pid;				// FK 	Integer can hold null value

}

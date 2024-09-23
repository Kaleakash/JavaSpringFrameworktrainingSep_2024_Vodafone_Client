package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
//@Setter
//@Getter
public class Product {
@Id
private int pid;
private String pname;
private float price;
private int qty;
@OneToMany
@JoinColumn(name = "pid")				// make PID as FK in orders table. 
private List<Orders> orders;

}

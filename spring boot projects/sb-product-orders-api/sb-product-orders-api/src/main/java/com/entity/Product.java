package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
//@Setter
//@Getter
public class Product {
@Id
@Min(value = 1,message = "Value must be +ve number")
private int pid;
@NotBlank(message = "Product Name required")
private String pname;
@Min(value = 1000,message = "price value must be > 1000")
@Max(value = 50000,message = "price value must be < 50000")
private float price;
private int qty;
@OneToMany
@JoinColumn(name = "pid")				// make PID as FK in orders table. 
private List<Orders> orders;

}

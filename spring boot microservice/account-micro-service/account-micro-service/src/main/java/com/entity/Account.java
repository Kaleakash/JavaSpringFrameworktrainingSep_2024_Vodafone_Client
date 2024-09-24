package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
@Id
private int accno;
private String name;
private float amount;
@Column(unique = true)
private String emailid;

}

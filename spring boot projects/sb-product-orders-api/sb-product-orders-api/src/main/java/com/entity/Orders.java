package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)		// auto increment 
private int oid;
private LocalDateTime orderdatatime;
private int qty;
private Integer pid;				// FK 	Integer can hold null value
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public LocalDateTime getOrderdatatime() {
	return orderdatatime;
}
public void setOrderdatatime(LocalDateTime orderdatatime) {
	this.orderdatatime = orderdatatime;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
@Override
public String toString() {
	return "Orders [oid=" + oid + ", orderdatatime=" + orderdatatime + ", qty=" + qty + ", pid=" + pid + "]";
}

}

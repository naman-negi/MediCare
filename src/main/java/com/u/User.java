package com.u;
import javax.persistence.Entity;  //Below Annotations
import javax.persistence.Table;   //Below Annotations
import javax.persistence.Id;   //Below Annotations
@Entity 
@Table
public class User {
@Id
private String username;
private String password;
private String address;
private String carddetail;
private String dateofpurchase;
private String cart;
private String purchase;

public User() {	
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [username=" + username + "]";
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCarddetail() {
	return carddetail;
}
public void setCarddetail(String carddetail) {
	this.carddetail = carddetail;
}
public String getDateofpurchase() {
	return dateofpurchase;
}
public void setDateofpurchase(String dateofpurchase) {
	this.dateofpurchase = dateofpurchase;
}
public String getCart() {
	return cart;
}
public void setCart(String cart) {
	this.cart = cart;
}
public String getPurchase() {
	return purchase;
}
public void setPurchase(String purchase) {
	this.purchase = purchase;
}

}

package com.controller;
import javax.persistence.Entity;  //Below Annotations
import javax.persistence.Table;   //Below Annotations
import javax.persistence.Id;   //Below Annotations
@Entity 
@Table
public class Medicinal {
@Id
private String productid;
private String company;
private String expiry_date;
private String description;
private String category;
private String quantity;
private String price;
private String medicine_name;
private String imgurl;

public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}
public void setProductid(String productid) {
	this.productid = productid;
}
public void setMedicine_name(String medicine_name) {
	this.medicine_name =  medicine_name;
}
public void setCompany(String company) {
	this.company = company;
}
public void setExpiry_date(String expiry_date) {
	this.expiry_date = expiry_date;
}
public void setDescription(String description) {
	this.description = description;
}
public void setCategory(String category) {
	this.category = category;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public void setPrice(String price) {
	this.price = price;
}
public String getCompany() {
	return company;
}
public String getExpiry_date() {
	return expiry_date;
}
public String getDescription() {
	return description;
}
public String getCategory() {
	return category;
}
public String getQuantity() {
	return quantity;
}
public String getPrice() {
	return price;
}
public String getProductid() {
	return productid;
}
public String getMedicine_name() {
	return  medicine_name;
}
public String getImgurl() {
	return  imgurl;
}
@Override
public String toString() {
	return "Medicinal [company=" + company + ", expiry_date=" + expiry_date + ", description=" + description
			+ ", categories=" + category + ", quantities=" + quantity + ", prices=" + price + "]";
}
}

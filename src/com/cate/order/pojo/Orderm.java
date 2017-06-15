package com.cate.order.pojo;

import java.util.Date;

public class Orderm {
private String id;
private Date ordertime;
private String foodid;
private String orderid;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Date getOrdertime() {
	return ordertime;
}
public void setOrdertime(Date ordertime) {
	this.ordertime = ordertime;
}
public String getFoodid() {
	return foodid;
}
public void setFoodid(String foodid) {
	this.foodid = foodid;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}


public Orderm() {
}

public Orderm(String id, Date ordertime, String foodid, String orderid) {
	super();
	this.id = id;
	this.ordertime = ordertime;
	this.foodid = foodid;
	this.orderid = orderid;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((foodid == null) ? 0 : foodid.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
	result = prime * result + ((ordertime == null) ? 0 : ordertime.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orderm other = (Orderm) obj;
	if (foodid == null) {
		if (other.foodid != null)
			return false;
	} else if (!foodid.equals(other.foodid))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (orderid == null) {
		if (other.orderid != null)
			return false;
	} else if (!orderid.equals(other.orderid))
		return false;
	if (ordertime == null) {
		if (other.ordertime != null)
			return false;
	} else if (!ordertime.equals(other.ordertime))
		return false;
	return true;
}


@Override
public String toString() {
	return "Orderm [id=" + id + ", ordertime=" + ordertime + ", foodid=" + foodid + ", orderid=" + orderid + "]";
}


}

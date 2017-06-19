package com.cate.order.pojo;

public class Order {
private String id;
private double prices;
private String status;
private String userid;
private String createtime;



public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public double getPrices() {
	return prices;
}
public void setPrices(double prices) {
	this.prices = prices;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}

public String getCreatetime() {
	return createtime;
}
public void setCreatetime(String createtime) {
	this.createtime = createtime;
}
public Order() {
}
public Order(String id, double prices, String status, String userid, String createtime) {
	super();
	this.id = id;
	this.prices = prices;
	this.status = status;
	this.userid = userid;
	this.createtime = createtime;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	long temp;
	temp = Double.doubleToLongBits(prices);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
	Order other = (Order) obj;
	if (createtime == null) {
		if (other.createtime != null)
			return false;
	} else if (!createtime.equals(other.createtime))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (Double.doubleToLongBits(prices) != Double.doubleToLongBits(other.prices))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (userid == null) {
		if (other.userid != null)
			return false;
	} else if (!userid.equals(other.userid))
		return false;
	return true;
}


@Override
public String toString() {
	return "Order [id=" + id + ", prices=" + prices + ", status=" + status + ", userid=" + userid + ", createtime="
			+ createtime + "]";
}



}

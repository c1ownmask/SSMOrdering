package com.cate.order.pojo;

public class Food {
private String id;
private String foodinfo;
private String foodname;
private String photo;
private double price;
private String catelogid;
private int num;



public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFoodinfo() {
	return foodinfo;
}
public void setFoodinfo(String foodinfo) {
	this.foodinfo = foodinfo;
}
public String getFoodname() {
	return foodname;
}
public void setFoodname(String foodname) {
	this.foodname = foodname;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getCatelogid() {
	return catelogid;
}
public void setCatelogid(String catelogid) {
	this.catelogid = catelogid;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}


public Food() {
}

public Food(String id, String foodinfo, String foodname, String photo, double price, String catelogid, int num) {
	super();
	this.id = id;
	this.foodinfo = foodinfo;
	this.foodname = foodname;
	this.photo = photo;
	this.price = price;
	this.catelogid = catelogid;
	this.num = num;
}
public Food(String id, String foodinfo, String foodname, double price, String catelogid) {
	this.id = id;
	this.foodinfo = foodinfo;
	this.foodname = foodname;
	this.price = price;
	this.catelogid = catelogid;
}

public Food(String id, String foodinfo, String foodname, double price, String catelogid,String photo) {
	this.id = id;
	this.foodinfo = foodinfo;
	this.foodname = foodname;
	this.price = price;
	this.catelogid = catelogid;
	this.photo=photo;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((catelogid == null) ? 0 : catelogid.hashCode());
	result = prime * result + ((foodinfo == null) ? 0 : foodinfo.hashCode());
	result = prime * result + ((foodname == null) ? 0 : foodname.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + num;
	result = prime * result + ((photo == null) ? 0 : photo.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Food other = (Food) obj;
	if (catelogid == null) {
		if (other.catelogid != null)
			return false;
	} else if (!catelogid.equals(other.catelogid))
		return false;
	if (foodinfo == null) {
		if (other.foodinfo != null)
			return false;
	} else if (!foodinfo.equals(other.foodinfo))
		return false;
	if (foodname == null) {
		if (other.foodname != null)
			return false;
	} else if (!foodname.equals(other.foodname))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (num != other.num)
		return false;
	if (photo == null) {
		if (other.photo != null)
			return false;
	} else if (!photo.equals(other.photo))
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	return true;
}

@Override
public String toString() {
	return "Food [id=" + id + ", foodinfo=" + foodinfo + ", foodname=" + foodname + ", photo=" + photo + ", price="
			+ price + ", catelogid=" + catelogid + ", num=" + num + "]";
}


}

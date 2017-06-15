package com.cate.order.pojo;

import java.util.Date;

public class Eamil {
private String id;
private String content;
private Date time;
private String userid;



public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}


public Eamil() {
}

public Eamil(String id, String content, Date time, String userid) {
	super();
	this.id = id;
	this.content = content;
	this.time = time;
	this.userid = userid;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((content == null) ? 0 : content.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((time == null) ? 0 : time.hashCode());
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
	Eamil other = (Eamil) obj;
	if (content == null) {
		if (other.content != null)
			return false;
	} else if (!content.equals(other.content))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (time == null) {
		if (other.time != null)
			return false;
	} else if (!time.equals(other.time))
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
	return "Eamil [id=" + id + ", content=" + content + ", time=" + time + ", userid=" + userid + "]";
}


}

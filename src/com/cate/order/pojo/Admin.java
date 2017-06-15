package com.cate.order.pojo;

import java.util.Date;

/**
*@autor:yl email:1940927916@qq.com
*@version:1.8
*@Date:2017年6月12日 下午7:18:57
*@ps
*/

public class Admin {
	private String id;
	private String adminname;
	private String password;
	private String create_Time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(String create_Time) {
		this.create_Time = create_Time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminname == null) ? 0 : adminname.hashCode());
		result = prime * result + ((create_Time == null) ? 0 : create_Time.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Admin other = (Admin) obj;
		if (adminname == null) {
			if (other.adminname != null)
				return false;
		} else if (!adminname.equals(other.adminname))
			return false;
		if (create_Time == null) {
			if (other.create_Time != null)
				return false;
		} else if (!create_Time.equals(other.create_Time))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	public Admin() {
		
	}
	public Admin(String id, String adminname, String password) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.password = password;
	}
	public Admin(String id, String adminname, String password, String create_Time) {
		this.id = id;
		this.adminname = adminname;
		this.password = password;
		this.create_Time = create_Time;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", password=" + password + ", create_Time="
				+ create_Time + "]";
	}
	
}

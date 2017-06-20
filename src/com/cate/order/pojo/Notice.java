package com.cate.order.pojo;

import java.util.Date;

public class Notice {
	private String id;
	private String content;
	private String createtime;
	private String title;
	private String updatetime;
	private String adminid;

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

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public Notice() {
	}

	public Notice(String id, String content, String createtime, String title, String adminid) {
		super();
		this.id = id;
		this.content = content;
		this.createtime = createtime;
		this.title = title;
		this.adminid = adminid;
	}

	public Notice(String id, String content, String createtime, String title, String updatetime, String adminid) {
		super();
		this.id = id;
		this.content = content;
		this.createtime = createtime;
		this.title = title;
		this.updatetime = updatetime;
		this.adminid = adminid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminid == null) ? 0 : adminid.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updatetime == null) ? 0 : updatetime.hashCode());
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
		Notice other = (Notice) obj;
		if (adminid == null) {
			if (other.adminid != null)
				return false;
		} else if (!adminid.equals(other.adminid))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updatetime == null) {
			if (other.updatetime != null)
				return false;
		} else if (!updatetime.equals(other.updatetime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", content=" + content + ", createtime=" + createtime + ", title=" + title
				+ ", updatetime=" + updatetime + ", adminid=" + adminid + "]";
	}

}

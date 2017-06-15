package com.cate.order.pojo;

public class Catelog {
	private String id;
	private String cateloginfo;
	private String catelogname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateloginfo() {
		return cateloginfo;
	}

	public void setCateloginfo(String cateloginfo) {
		this.cateloginfo = cateloginfo;
	}

	public String getCatelogname() {
		return catelogname;
	}

	public void setCatelogname(String catelogname) {
		this.catelogname = catelogname;
	}

	public Catelog() {
	}

	public Catelog(String id, String cateloginfo, String catelogname) {
		super();
		this.id = id;
		this.cateloginfo = cateloginfo;
		this.catelogname = catelogname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cateloginfo == null) ? 0 : cateloginfo.hashCode());
		result = prime * result + ((catelogname == null) ? 0 : catelogname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Catelog other = (Catelog) obj;
		if (cateloginfo == null) {
			if (other.cateloginfo != null)
				return false;
		} else if (!cateloginfo.equals(other.cateloginfo))
			return false;
		if (catelogname == null) {
			if (other.catelogname != null)
				return false;
		} else if (!catelogname.equals(other.catelogname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Catelog [id=" + id + ", cateloginfo=" + cateloginfo + ", catelogname=" + catelogname + "]";
	}

}

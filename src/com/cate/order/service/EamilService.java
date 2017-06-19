package com.cate.order.service;

import java.util.ArrayList;
import java.util.List;

import com.cate.order.dao.EamilDao;
import com.cate.order.pojo.Eamil;

public class EamilService {
    EamilDao dao = new EamilDao();
    
	public List<Eamil> selecteamil() {
		List<Eamil> list = new ArrayList<Eamil>();
		list = dao.selecteamil();
		return list;
	}
	//删除管理员邮箱信息
	public boolean removeeamil(Eamil eamil) {
		return dao.deleteeamil(eamil);
	}
	
}

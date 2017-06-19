package com.cate.order.service;

import java.util.ArrayList;
import java.util.List;

import com.cate.order.dao.CatelogDao;
import com.cate.order.pojo.Catelog;

/**
 * @Date:2017年6月14日 09:29:14
 * @ps:Catelog类Service
 */

public class CatelogService {
	CatelogDao dao = new CatelogDao();

	/**
	 * @ps查找所有菜品种类Service
	 */
	public List<Catelog> selectcatelog() {
		List<Catelog> list = new ArrayList<Catelog>();
		list = dao.selectcatelog();
		return list;

	}

	/**
	 * @Ps:Catelog添加Service
	 */
	public boolean registercatelog(Catelog catelog) {
		return dao.registercatelog(catelog);
	}

	public int selectcatelognum() {
		return dao.selectlognum();
	}

	public String selectId() {
		return dao.selectId();
	}
 
	
	/**
	 * @Ps:Catelog删除Service
	 */
	public boolean deletecatelogservice(String id) {
		return dao.deletecatelogservice(id);
	}

	
	/**
	 * @Ps:Catelog修改Service
	 */
	public boolean updatecatelog(Catelog catelog) {
		return dao.updatecatelog(catelog);
	}

}

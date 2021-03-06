package com.cate.order.service;
/**
*@Date:2017年6月13日 上午10:28:45
*@ps管理员service
*/

import java.util.ArrayList;
import java.util.List;

import com.cate.order.dao.AdminDao;
import com.cate.order.pojo.Admin;

public class AdminService {
	AdminDao dao = new AdminDao();

	/**
	 * @PS管理员登陆service
	 */
	public Admin adminlogin(String adminname, String password) {
		return dao.adminlogin(adminname, password);
	}

	/**
	 * @PS管理员注册
	 */
	public boolean adminregister(Admin admin) {
		if (null != admin) {
			return dao.adminregister(admin);
		} else {
			return false;
		}
	}

	/**
	 * @PS查找所有管理员
	 */
	public List<Admin> selectalladmin() {
		List<Admin> list = new ArrayList<Admin>();
		list = dao.selectalladmin();
		return list;
	}

	/**
	 * @PS修改管理员信息
	 */
	public boolean adminchange(Admin admin) {
		return dao.adminupdate(admin);
	}

	/**
	 * @PS删除管理员信息
	 */
	public boolean removeadmin(Admin admin) {
		return dao.admindelete(admin);
	}

	public List<Admin> selectadminid(String id) {
		return dao.selectAdminId(id);
	}
}

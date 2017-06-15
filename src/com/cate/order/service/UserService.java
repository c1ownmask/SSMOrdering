package com.cate.order.service;

import java.util.ArrayList;
import java.util.List;

import com.cate.order.dao.UserDao;
import com.cate.order.pojo.User;

/**
*@Date:2017年6月13日 下午7:00:14
*@ps User类service
*/

public class UserService {
	UserDao dao=new UserDao();
	/**
	 * @PS 查找所有会员service
	 * */
	public List<User> selectalluser() {
		List<User> list=new ArrayList<User>();
		list=dao.selectalluser();
		return list;
	}
	
	public int selectusernum(){
		return dao.selectusernum();
	}

	public String selectId() {
		return dao.selectId();
	}

	public boolean registeruser(User user) {
		return dao.registeruser(user);
	}

	public List<User> selectuserbyid(String id) {
		return dao.selectuserbyid(id);
	}

	public boolean updateuserservice(User user) {
		return dao.updateuserservice(user);
	}

	public boolean deleteuserservice(String id) {
		return dao.deleteuserservice(id);
	}
	
	
}

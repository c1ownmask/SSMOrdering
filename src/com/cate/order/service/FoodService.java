package com.cate.order.service;

import java.util.List;

import com.cate.order.dao.FoodDao;
import com.cate.order.pojo.Food;

/**
*@autor:yl email:1940927916@qq.com
*@version:1.8
*@Date:2017年6月16日 上午9:47:14
*@ps
*/

public class FoodService {
	FoodDao dao=new FoodDao();
	
	public List<Food> selectallfood() {
		return dao.selectallfood();
	}

	public int selectfoodnum() {
		return dao.selectfoodnum();
	}

	public String selectId() {
		return dao.selectId();
	}

	public boolean addfoodservice(Food food) {
		return dao.addfoodservice(food);
	}

	public boolean updatefood(Food food) {
		return dao.updatefood(food);
	}

	public boolean deletefood(String id) {
		return dao.deletefood(id);
	}

	public List<Food> selectfoodbyid(String id) {
		return dao.selectfoodbyid(id);
	}

}

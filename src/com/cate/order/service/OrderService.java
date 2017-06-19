package com.cate.order.service;

import java.util.List;

import com.cate.order.dao.OrderDao;
import com.cate.order.pojo.Order;

/**
*@autor:yl email:1940927916@qq.com
*@version:1.8
*@Date:2017年6月19日 下午1:41:15
*@ps
*/

public class OrderService {
	OrderDao dao=new OrderDao();

	public List<Order> selectallorder() {
		return dao.selectallorder();
	}

	public boolean deleteorder(String id) {
		return dao.deleteorder(id);
	}
}

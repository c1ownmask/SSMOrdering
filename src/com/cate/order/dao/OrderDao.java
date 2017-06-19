package com.cate.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.Order;
import com.cate.order.util.ConnectionFactory;

/**
 * @Date:2017年6月19日 下午1:41:58
 * @ps OrderDao
 */

public class OrderDao {
	/**
	 * 搜索所有订单Dao
	 */
	public List<Order> selectallorder() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		try {
			ps = conn.prepareStatement("SELECT a.*,b.username FROM t_order a,t_user b WHERE a.user_id=b.id");
			rs = ps.executeQuery();
			while (rs.next()) {
				order = new Order(rs.getString("id"), rs.getDouble("prices"), rs.getString("status"),
						rs.getString("username"), rs.getString("create_time"));
				list.add(order);
			}
			if (list.size() > 0) {
				return list;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteorder(String id) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("delete from t_order where id=?");
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

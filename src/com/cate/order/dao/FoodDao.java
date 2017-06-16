package com.cate.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.Food;
import com.cate.order.util.ConnectionFactory;

/**
 * @Date:2017年6月16日 上午9:49:54
 * @ps 菜品管理dao
 */

public class FoodDao {

	public List<Food> selectallfood() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Food food = null;
		List<Food> list = new ArrayList<Food>();
		try {
			ps = conn.prepareStatement("select a.*,b.catelog_name from t_food a ,t_catelog b WHERE a.catelog_id=b.id");
			rs = ps.executeQuery();
			while (rs.next()) {
				food = new Food(rs.getString("id"), rs.getString("foodinfo"), rs.getString("foodname"),
						rs.getString("photo"), rs.getDouble("price"), rs.getString("catelog_name"), rs.getInt("num"));
				list.add(food);
			}
			if(list.size()>0){
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

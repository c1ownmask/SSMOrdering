package com.cate.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.Food;
import com.cate.order.util.ConnectionFactory;
import com.sun.org.apache.regexp.internal.recompile;

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
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int selectfoodnum() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) count from t_food;");
			rs = ps.executeQuery();
			while (rs.next()) {
				int count = rs.getInt("count");
				if (count >= 0) {
					return count;
				} else {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String selectId() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"select id FROM(SELECT (@rowno:=@rowno+1) as row,a.id FROM t_food a ,(SELECT @rowno:=0) t ORDER BY id DESC) a WHERE a.row=1;");
			rs = ps.executeQuery();
			while (rs.next()) {
				String hisId = rs.getString("id");
				if (null != hisId) {
					return hisId;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addfoodservice(Food food) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into t_food(id,foodinfo,foodname,price,catelog_id) values(?,?,?,?,?);");
			ps.setString(1, food.getId());
			ps.setString(2, food.getFoodinfo());
			ps.setString(3, food.getFoodname());
			ps.setDouble(4, food.getPrice());
			ps.setString(5, food.getCatelogid());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatefood(Food food) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"UPDATE `ordermanager`.`t_food` SET `foodinfo`=?, `foodname`=?, `photo`=?, `price`=?, `catelog_id`=? WHERE (`id`=?);");
			ps.setString(1, food.getFoodinfo());
			ps.setString(2, food.getFoodname());
			ps.setString(3, food.getPhoto());
			ps.setDouble(4, food.getPrice());
			ps.setString(5, food.getCatelogid());
			ps.setString(6, food.getId());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletefood(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from t_food where id=?");
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Food> selectfoodbyid(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		List<Food> list = new ArrayList<Food>();
		Food food = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from t_food where id like ? ;");
			ps.setString(1, '%' + id + '%');
			rs = ps.executeQuery();
			while (rs.next()) {
				food = new Food(rs.getString("id"), rs.getString("foodinfo"), rs.getString("foodname"),
						rs.getString("photo"), rs.getDouble("price"), rs.getString("catelog_id"), rs.getInt("num"));
				list.add(food);
			}
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

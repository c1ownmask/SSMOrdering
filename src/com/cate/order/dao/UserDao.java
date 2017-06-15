package com.cate.order.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.User;
import com.cate.order.util.ConnectionFactory;

/**
 * @Date:2017年6月13日 下午6:42:33
 * @ps User类Dao
 */

public class UserDao {

	/**
	 * @PS查找所有会员dao
	 */
	public List<User> selectalluser() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		User user;
		try {
			ps = conn.prepareStatement("select * from t_user;");
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("sex"), rs.getString("realname"), rs.getString("tel"), rs.getString("address"),
						rs.getString("create_time"), rs.getString("login_time"), rs.getString("update_time"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	public int selectusernum() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) count from t_user;");
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
					"select id FROM(SELECT (@rowno:=@rowno+1) as row,a.id FROM t_user a ,(SELECT @rowno:=0) t ORDER BY id DESC) a WHERE a.row=1;");
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

	public boolean registeruser(User user) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"insert into t_user(id,username,password,sex,realname,tel,address,create_time) values(?,?,?,?,?,?,?,?);");
			ps.setString(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getRealname());
			ps.setString(6, user.getTel());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getCreatetime());
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

	public List<User> selectuserbyid(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<User> list=new ArrayList<User>();
		try {
			ps = conn.prepareStatement("select * from t_user where id like ?;");
			ps.setString(1, "%"+id+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("sex"), rs.getString("realname"), rs.getString("tel"), rs.getString("address"),rs.getString("create_time"),rs.getString("update_time"),rs.getString("login_time"));
				list.add(user);
			}
			if (null != list) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateuserservice(User user) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"update t_user set username=? , password=? , realname=? , sex=? , tel=? , update_time=? where id=?;");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRealname());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getTel());
			ps.setString(6, user.getCreatetime());
			ps.setString(7, user.getId());
			int i=ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteuserservice(String id) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("delete from t_user where id=?");
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}

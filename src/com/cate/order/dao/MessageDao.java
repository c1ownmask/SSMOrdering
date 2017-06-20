package com.cate.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cate.order.pojo.Message;
import com.cate.order.util.ConnectionFactory;
import java.sql.PreparedStatement;

public class MessageDao {
	/**
	 * @PS:Message获取页面dao
	 */
	public List<Message> selectmessage() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<Message>();
		Message message;
		try {
			ps = conn.prepareStatement(
					"select m.*,u.username,f.foodname from t_message m,t_user u,t_food f WHERE m.user_id=u.id AND m.food_id=f.id;");
			rs = ps.executeQuery();
			while (rs.next()) {
				message = new Message(rs.getString("id"), rs.getString("username"), rs.getString("foodname"),
						rs.getString("content"), rs.getString("time"));
				list.add(message);
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

	/**
	 * @PS:Message模糊查询dao
	 */
	public List<Message> selectmessagebyid(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Message message;
		List<Message> list = new ArrayList<Message>();
		try {
			ps = conn.prepareStatement(
					"select m.*,u.username,f.foodname from t_message m,t_user u,t_food f WHERE m.user_id=u.id AND m.food_id=f.id and m.id like ?");
			ps.setString(1, "%" + id + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				message = new Message(rs.getString("id"), rs.getString("username"), rs.getString("foodname"),
						rs.getString("content"), rs.getString("time"));
				list.add(message);
			}
			if (null != list) {
				return list;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @PS:Message添加dao
	 */
	public boolean registermessager(Message message) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into t_message(id,user_id,food_id,content,time) values(?,?,?,?,?)");
			ps.setString(1, message.getId());
			ps.setString(2, message.getUserid());
			ps.setString(3, message.getFoodid());
			ps.setString(4, message.getContent());
			ps.setString(5, message.getTime());
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

	public int selectmessagenum() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) count from t_message");
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
					"select id from(select(@rowno:=@rowno+1) as row,a.id from t_message a,(select @rowno:=0)t order by id desc)a where a.row=1;");
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

	/**
	 * @PS:Message删除Service
	 */
	public boolean deletemessage(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from t_message where id=?");
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatemessage(Message message) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement("update t_message set content=?,time=?,food_id=?,user_id=? where id=?;");
			ps.setString(1, message.getContent());
			ps.setString(2, message.getTime());
			ps.setString(3, message.getFoodid());
			ps.setString(4, message.getUserid());
			ps.setString(5, message.getId());
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

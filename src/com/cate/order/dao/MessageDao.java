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

	public List<Message> selectmessage() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Message> list = new ArrayList<Message>();
		Message message;
		try {
			ps = conn.prepareStatement("select * from t_message");
			rs = ps.executeQuery();
			while (rs.next()) {
				message = new Message(rs.getString("id"), rs.getString("user_id"), rs.getString("food_id"),
						rs.getString("content"), rs.getDate("time"));
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
}

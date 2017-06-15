package com.cate.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cate.order.pojo.Catelog;
import com.cate.order.util.ConnectionFactory;
import  java.sql.PreparedStatement;

/**
 * 
 * @Date:2017年6月14日 09:38:45
 * @PS Catelog类Dao
 */

public class CatelogDao {

	/**
	 * 
	 * @PS查找所有菜品类别dao
	 */
	public List<Catelog> selectcatelog() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Catelog> list = new ArrayList<Catelog>();
		Catelog catelog;
		try {
			ps=conn.prepareStatement("select * from t_catelog");
			rs = ps.executeQuery();
			while (rs.next()) {
				catelog = new Catelog(rs.getString("id"), rs.getString("catelog_info"), rs.getString("catelog_name"));
				list.add(catelog);
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

package com.cate.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.Eamil;
import com.cate.order.util.ConnectionFactory;

public class EamilDao {
	//查询管理员邮箱信息集合
	public List<Eamil> selecteamil() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Eamil> list = new ArrayList<Eamil>();
		Eamil eamil;
		try {
			ps = conn.prepareStatement("select * from t_eamil");
			rs = ps.executeQuery();
			while (rs.next()) {
				eamil = new Eamil(rs.getString("id"), rs.getString("content"), rs.getString("time"),rs.getString("user_id"));
				list.add(eamil);
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
	//删除管理员邮箱信息
	public boolean deleteeamil(Eamil eamil) {
		Connection conn =ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		int i=0;
		try {
			ps = conn.prepareStatement("delete from t_eamil where id=?");
			ps.setString(1, eamil.getId());
			i = ps.executeUpdate();
			if(i==0){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(null !=ps){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionFactory.CloseConnection(conn);
		}
		return false;
	}

}

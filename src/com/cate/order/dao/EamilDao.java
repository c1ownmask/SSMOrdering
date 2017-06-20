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
			ps = conn.prepareStatement("select e.id,e.content,e.time,u.realName from t_eamil e,t_user u where e.user_id = u.id");
			rs = ps.executeQuery();
			while (rs.next()) {
				eamil = new Eamil(rs.getString("id"), rs.getString("content"), rs.getString("time"),rs.getString("realName"));
				list.add(eamil);
			}
			if (list.size() > 0) {
				return list;
			} else {
				return null;
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
		return null;
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

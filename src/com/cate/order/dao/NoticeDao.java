package com.cate.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.Notice;
import com.cate.order.util.ConnectionFactory;

public class NoticeDao {

	public List<Notice> selectNotice() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Notice> list=new ArrayList<Notice>();
		Notice notice;
		try {
			ps = conn.prepareStatement("select n.id,n.content,n.create_time,n.title,n.update_time,a.adminname from t_notice n,t_admin a where n.admin_id = a.id;");
			rs=ps.executeQuery();
			while(rs.next()){
				notice = new Notice(rs.getString("id"),rs.getString("content"),rs.getString("create_time"),rs.getString("title"),rs.getString("update_time"),rs.getString("adminname"));
				list.add(notice);
			}
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (null != ps) {
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

//	public boolean addnotice(Notice notice) {
//		Connection conn = ConnectionFactory.getConnection();
//		PreparedStatement ps =null;
//		int i=0;
//		try {
//			ps=conn.prepareStatement("insert into t_notice()");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

}

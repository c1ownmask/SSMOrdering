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
		//查找所有公告信息
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
	//新增公告信息
	public boolean addnotice(Notice notice) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps =null;
		int i=0;
		try {
			ps=conn.prepareStatement("insert into t_notice(id,title,content,create_time,admin_id) value (?,?,?,?,?)");
			ps.setString(1, notice.getId());
			ps.setString(2, notice.getTitle());
			ps.setString(3, notice.getContent());
			ps.setString(4, notice.getCreatetime());
			ps.setString(5, notice.getAdminid());
			i=ps.executeUpdate();
			if(i==0){
				return false;
			}else{
				return true;
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
		return false;
	}
	//删除公告信息
	public boolean removeNotice(Notice notice) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		int i=0;
		try {
			ps =conn.prepareStatement("delete from t_notice where id =?");
			ps.setString(1, notice.getId());
			i=ps.executeUpdate();
			if(i==0){
				return false;
			}else{
				return true;
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
		
		return false;
	}
	//修改公告信息
	public boolean updatenotice(Notice notice) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		int i=0;
		try {
			ps =conn.prepareStatement("update t_notice set title=?,content=?,update_time=? where id=?");
			ps.setString(1, notice.getTitle());
			ps.setString(2, notice.getContent());
			ps.setString(3, notice.getUpdatetime());
			ps.setString(4, notice.getId());
			i=ps.executeUpdate();
			if(i==0){
				return false;
			}else{
				return true;
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
		
		return false;
	}
	//关键字查询
	public List<Notice> selectNoticeId(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Notice> list=new ArrayList<Notice>();
		Notice notice;
		try {
			ps = conn.prepareStatement("select n.id,n.content,n.create_time,n.title,n.update_time,a.adminname from t_notice n,t_admin a where n.admin_id = a.id and n.id like ?");
			ps.setString(1, "%"+id+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				notice = new Notice(rs.getString("id"),rs.getString("content"),rs.getString("create_time"),rs.getString("title"),rs.getString("update_time"),rs.getString("adminname"));
				list.add(notice);
			}
			if(null !=list){
				return list;
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
	
}

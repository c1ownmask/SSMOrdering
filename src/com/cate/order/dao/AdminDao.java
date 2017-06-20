package com.cate.order.dao;
/**
*@Date:2017年6月13日 上午9:17:53
*@ps 管理员管理Dao
*/

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cate.order.pojo.Admin;
import com.cate.order.pojo.Notice;
import com.cate.order.util.ConnectionFactory;
import com.sun.media.sound.SoftSynthesizer;

public class AdminDao {
	/**
	 * @ps 管理员登陆功能
	 */
	public Admin adminlogin(Admin admin) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from t_admin where adminname=? and password=?");
			rs = ps.executeQuery();
			while (rs.next()) {
				admin = new Admin(rs.getString("id"), rs.getString("adminname"), rs.getString("password"),
						rs.getString("create_Time"));
			}
			if (rs.next()) {
				return admin;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * 管理员注册dao
	 */
	public boolean adminregister(Admin admin) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		int i =0;
		try {
			ps = conn.prepareStatement("insert into t_admin values(?,?,?,?);");
			ps.setString(1, admin.getId());
			ps.setString(2, admin.getAdminname());
			ps.setString(3, admin.getCreate_Time());
			ps.setString(4, admin.getPassword());
			i = ps.executeUpdate();
			if (i == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * 管理员删除dao
	 */
	public boolean admindelete(Admin admin) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		int i=0;
		try {
			ps = conn.prepareStatement("delete from t_admin where id=?");
			ps.setString(1, admin.getId());
			i = ps.executeUpdate();
			if (i == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	/**
	 * 管理员修改dao
	 */
	public boolean adminupdate(Admin admin) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		int i=0;
		try {
			ps = conn.prepareStatement("update t_admin set adminname=?,password=? where id=?"); 
			ps.setString(1, admin.getAdminname());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getId());
			i = ps.executeUpdate();
			if (i == 0) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
//查找所有管理员admin
	public List<Admin> selectalladmin() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Admin>list =new ArrayList<Admin>();
		Admin admin;
		try {
			ps=conn.prepareStatement("select * from t_admin");
			rs = ps.executeQuery();
			while(rs.next()){
				admin = new Admin(rs.getString("id"),rs.getString("adminname"),rs.getString("password"),rs.getString("create_Time"));
				list.add(admin);
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
}

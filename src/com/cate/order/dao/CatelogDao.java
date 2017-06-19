package com.cate.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cate.order.pojo.Catelog;
import com.cate.order.util.ConnectionFactory;
import java.sql.PreparedStatement;

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
			ps = conn.prepareStatement("select * from t_catelog");
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

	/**
	 * 
	 * @PS Catelog添加功能dao
	 * @Date:2017年6月15日 18:54:35
	 */
	public boolean registercatelog(Catelog catelog) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into t_catelog(id,catelog_name,catelog_info) values(?,?,?);");
			ps.setString(1, catelog.getId());
			ps.setString(2, catelog.getCatelogname());
			ps.setString(3, catelog.getCateloginfo());
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

	public int selectlognum() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) count from t_catelog");
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
					"select id from(select(@rowno:=@rowno+1) as row,a.id from t_catelog a,(select @rowno:=0)t order by id desc)a where a.row=1;");
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
	 * 
	 * @Date:2017年6月16日 09:37:58
	 * @PS:Catelog删除功能dao
	 */

	public boolean deletecatelogservice(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from t_catelog where id=?");
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

	/**
	 * @Date:2017年6月16日 10:07:27
	 * @PS:Catelog修改功能dao
	 */

	public boolean updatecatelog(Catelog catelog) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = conn.prepareStatement("update t_catelog set catelog_info=? , catelog_name=? where id=?");
			ps.setString(1, catelog.getCateloginfo());
			ps.setString(2, catelog.getCatelogname());
			ps.setString(3, catelog.getId().trim());
			i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * @Ps:Catelog模糊查询dao
	 */
	public List<Catelog> selectcatelogbyid(String id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Catelog catelog;
		List<Catelog> list=new ArrayList<Catelog>();
		try {
			ps = conn.prepareStatement("select * from t_catelog where id like ?");
			ps.setString(1, "%"+id+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				catelog = new Catelog(rs.getString("id"),rs.getString("catelog_info"),rs.getString("catelog_name"));
				list.add(catelog);
			}
			if(null!=list){
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

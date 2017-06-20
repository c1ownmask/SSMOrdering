package com.cate.order.util;
/**
*@Date:2017年6月13日 上午9:09:11
*@ps连接数据库
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionFactory {
	static Connection conn=null;
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://192.168.1.81:3306/ordermanager","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void CloseConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

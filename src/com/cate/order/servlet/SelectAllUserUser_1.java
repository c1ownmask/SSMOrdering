package com.cate.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cate.order.pojo.User;
import com.cate.order.service.UserService;

/**
 * Servlet implementation class SelectAllUserUser_1
 */
@WebServlet("/selectalluseraction")
public class SelectAllUserUser_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllUserUser_1() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		UserService service=new UserService();
		List<User> list=new ArrayList<User>();
		list=service.selectalluser();
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		if(list.size()>0){
			jsonObject.put("list", list);
			jsonArray.add(jsonObject);
		}
		System.out.println(jsonArray);
		// 获得输出流
		PrintWriter out=response.getWriter();
		// 通过 out 对象将 jsonArray 传到前端页面
		out.println(jsonArray.toJSONString());
		out.close();
	}

}

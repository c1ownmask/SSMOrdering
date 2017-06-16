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
import com.cate.order.pojo.Catelog;
import com.cate.order.service.CatelogService;

/**
 * Servlet implementation class SelectAllCatelogNameServlet
 */
@WebServlet("/selectallcatelognameservlet")
public class SelectAllCatelogNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllCatelogNameServlet() {
        
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
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CatelogService service = new CatelogService();
		List<Catelog> list = new ArrayList<Catelog>();
		list = service.selectcatelog();

		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonObject.put("list", list);
		jsonArray.add(jsonObject);
//		System.out.println(jsonObject);
//		System.out.println(jsonArray);
		// 获得输出流
		PrintWriter out = response.getWriter();
		// 通过 out 对象将 jsonArray 传到前端页面
		out.println(jsonArray.toJSONString());
		out.close();
	}

}

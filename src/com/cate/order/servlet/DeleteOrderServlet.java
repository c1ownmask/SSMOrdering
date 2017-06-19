package com.cate.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cate.order.service.OrderService;

/**
 * Servlet implementation class DeleteOrderServlet
 */
@WebServlet("/deleteorderaction")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderServlet() {
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
		String id=request.getParameter("id");
		OrderService service=new OrderService();
		boolean a=service.deleteorder(id);
		JSONObject jsonObject=new JSONObject();
		JSONArray list=new JSONArray();
		if(a){
			jsonObject.put("message", true);
			list.add(jsonObject);
		}else{
			jsonObject.put("message", false);
			list.add(jsonObject);
		}
		PrintWriter out = response.getWriter();
		// 通过 out 对象将 jsonArray 传到前端页面
		out.println(list.toJSONString());
		out.close();
	}

}

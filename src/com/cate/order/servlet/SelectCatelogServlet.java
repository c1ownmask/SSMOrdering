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
 * Servlet implementation class SelectCatelogServlet
 */
@WebServlet("/selectcatelogservlet")
public class SelectCatelogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectCatelogServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CatelogService service = new CatelogService();
		List<Catelog> list = new ArrayList<Catelog>();
		list = service.selectcatelog();
		request.setAttribute("list", list);
		request.getRequestDispatcher("cpzlgl.jsp").forward(request, response);
	}

}

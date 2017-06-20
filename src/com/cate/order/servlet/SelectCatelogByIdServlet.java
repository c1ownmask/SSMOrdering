package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Catelog;
import com.cate.order.service.CatelogService;

/**
 * Servlet implementation class SelectCatlogByIdServlet
 */
@WebServlet("/selectcatelogbyidservlet")
public class SelectCatelogByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectCatelogByIdServlet() {
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
		String id = request.getParameter("id");
		CatelogService service = new CatelogService();
		List<Catelog> list=new ArrayList<Catelog>();
		list=service.slelectcatebyid(id);
		if (null != list) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("cpzlgl.jsp").forward(request, response);
		}
	}

}

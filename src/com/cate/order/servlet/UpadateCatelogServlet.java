package com.cate.order.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Catelog;
import com.cate.order.service.CatelogService;

/**
 * Servlet implementation class UpadateCatelogServlet
 */
@WebServlet("/upadatecatelogaction")
public class UpadateCatelogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpadateCatelogServlet() {
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String cateloginfo = request.getParameter("cateloginfo");
		String catelogname = request.getParameter("catelogname");
		Catelog catelog = new Catelog(id, cateloginfo, catelogname);
		CatelogService service = new CatelogService();
		boolean b = service.updatecatelog(catelog);
		if (b) {
			request.getRequestDispatcher("selectcatelogservlet").forward(request, response);
		}
	}

}

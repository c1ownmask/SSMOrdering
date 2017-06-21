package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Admin;
import com.cate.order.service.AdminService;

/**
 * Servlet implementation class SelectAdminIdServlet
 */
//通过关键字查询管理员
@WebServlet("/selectadminidaction")
public class SelectAdminIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAdminIdServlet() {
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
		String id = request.getParameter("id");
		AdminService service = new AdminService();
		List<Admin> list = new ArrayList<Admin>();
		list=service.selectadminid(id);
		System.out.println(list);
		if(null !=list){
			request.setAttribute("list", list);
			request.getRequestDispatcher("index-admin.jsp").forward(request, response);
		}
	}

}

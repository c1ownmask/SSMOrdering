package com.cate.order.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cate.order.pojo.Admin;
import com.cate.order.service.AdminService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginaction")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String adminname=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(null!=adminname&&!"".equals(adminname)&&null!=password&&!"".equals(password)){
			AdminService service=new AdminService();
			Admin admin=new Admin();
			admin=service.adminlogin(adminname,password);
			if(null!=admin){
				session.setAttribute("adminname", admin.getAdminname());
				response.sendRedirect("index.jsp");
			}
		}
	}

}

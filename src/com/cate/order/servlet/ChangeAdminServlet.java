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
 * Servlet implementation class ChangeAdminServlet
 * 修改管理员信息
 */
@WebServlet("/changeadminaction")
public class ChangeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAdminServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if(!password.equals(repassword)){
			request.setAttribute("message", "修改失败。两次密码不同，请重新输入！！");
			request.getRequestDispatcher("selectalladminservlet").forward(request, response);
		}else{
			Admin admin = new Admin(id,username,repassword);
			AdminService service = new AdminService();
			boolean b =service.adminchange(admin);
			if(b){
				request.getRequestDispatcher("selectalladminservlet").forward(request, response);
			}
		}
	}

}

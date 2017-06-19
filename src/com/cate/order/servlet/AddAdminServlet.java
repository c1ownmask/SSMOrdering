package com.cate.order.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Admin;
import com.cate.order.service.AdminService;

/**
 * Servlet implementation class AddAdminServlet
 */
//新增管理员
@WebServlet("/addadminaction")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
      
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
		System.out.println("新增管理员");
		String id= request.getParameter("id");
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if(!password.equals(repassword)){
			request.setAttribute("message", "两次密码不同");
			request.getRequestDispatcher("selectalladminservlet").forward(request, response);
		}else{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String date = df.format(new Date());
			Admin admin = new Admin(id,username,repassword,date);
			AdminService service = new AdminService(); 
			boolean b =service.adminregister(admin);
			if(b){
				request.getRequestDispatcher("selectalladminservlet").forward(request, response);
			}
		}
	}

}

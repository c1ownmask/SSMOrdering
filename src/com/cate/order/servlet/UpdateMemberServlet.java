package com.cate.order.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.User;
import com.cate.order.service.UserService;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updatememberaction")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
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
		String id=request.getParameter("resiveid");
		String username=request.getParameter("usernames");
		String password=request.getParameter("passwords");
		String sex=request.getParameter("sexs");
		String realname=request.getParameter("realnames");
		String tel=request.getParameter("tels");
		String address=request.getParameter("addresss");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String updatetime=format.format(new Date());
		User user=new User(id, username, password, sex, realname, tel, address,updatetime);
		UserService service=new UserService();
		boolean a=service.updateuserservice(user);
		if(a){
			request.getRequestDispatcher("selectalluserservlet").forward(request, response);
		}
	}

}

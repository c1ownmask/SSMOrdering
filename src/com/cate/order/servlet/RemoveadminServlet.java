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
import com.cate.order.pojo.Admin;
import com.cate.order.service.AdminService;


/**
 * Servlet implementation class RemoveadminServlet
 */
//删除admin
@WebServlet("/removeadminaction")
public class RemoveadminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveadminServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("删除admin");
		response.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		Admin admin = new Admin(id);
		AdminService service = new AdminService();
		boolean b =service.removeadmin(admin);
		if(b){
			request.getRequestDispatcher("selectalladminservlet").forward(request, response);
		}
	}

}

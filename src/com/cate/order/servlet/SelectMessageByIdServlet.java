package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Message;
import com.cate.order.service.MessageService;

/**
 * Servlet implementation class SelectMessageByIdServlet
 */
@WebServlet("/selectmessagebyidservlet")
public class SelectMessageByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMessageByIdServlet() {
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
		MessageService service = new MessageService();
		List<Message> list = new ArrayList<Message>();
		list=service.selectmessagebyid(id);
		if(null!=list){
			request.setAttribute("list", list);
			request.getRequestDispatcher("lygl.jsp").forward(request, response);
		}
	}

}

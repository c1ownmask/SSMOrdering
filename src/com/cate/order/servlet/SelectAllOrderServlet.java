package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Order;
import com.cate.order.service.OrderService;

/**
 * Servlet implementation class SelectAllOrderServlet
 */
@WebServlet("/selectallorderaction")
public class SelectAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllOrderServlet() {
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
		OrderService service=new OrderService();
		List<Order> list=new ArrayList<Order>();
		list=service.selectallorder();
		if(list.size()>0){
			request.setAttribute("list", list);
			request.getRequestDispatcher("OrderManager.jsp").forward(request, response);
		}
	}

}

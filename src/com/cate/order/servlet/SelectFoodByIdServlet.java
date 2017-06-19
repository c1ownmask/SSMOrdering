package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Food;
import com.cate.order.service.FoodService;

/**
 * Servlet implementation class SelectFoodByIdServlet
 */
@WebServlet("/selectfoodbyidaction")
public class SelectFoodByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFoodByIdServlet() {
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
		String id=request.getParameter("id");
		List<Food> list=new ArrayList<Food>();
		FoodService service=new FoodService();
		list=service.selectfoodbyid(id);
		if(list.size()>0){
			request.setAttribute("list", list);
			request.getRequestDispatcher("dishmanager.jsp").forward(request, response);
		}
	}

}

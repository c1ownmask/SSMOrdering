package com.cate.order.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Food;
import com.cate.order.service.FoodService;

/**
 * Servlet implementation class UpdateFoodServlet
 */
@WebServlet("/changefoodaction")
public class UpdateFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFoodServlet() {
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
		String foodname=request.getParameter("foodname1");
		String catelogid=request.getParameter("catelog_id");
		String foodinfo=request.getParameter("food_message1");
		String picture=request.getParameter("picture");
		String price1=request.getParameter("food_price1");
		double price=Double.parseDouble(price1);
		Food food=new Food(id, foodinfo, foodname, price, catelogid,picture);
		FoodService service=new FoodService();
		boolean a=service.updatefood(food);
		if(a){
			request.getRequestDispatcher("selectalldishservlet").forward(request, response);
		}
	}

}

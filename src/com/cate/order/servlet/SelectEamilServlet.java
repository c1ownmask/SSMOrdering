package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Eamil;
import com.cate.order.service.EamilService;


/**
 * Servlet implementation class SelectEamilServlet
 */
//管理员邮箱集合类SelectEamilServlet
@WebServlet("/selecreamilservlet")
public class SelectEamilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEamilServlet() {
        
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
		EamilService service = new EamilService();
		List<Eamil> list =new ArrayList<Eamil>();
		list = service.selecteamil();
		request.setAttribute("list", list);
		request.getRequestDispatcher("index-admineamil.jsp").forward(request, response);
	}

}

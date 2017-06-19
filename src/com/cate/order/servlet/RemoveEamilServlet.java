package com.cate.order.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Eamil;
import com.cate.order.service.EamilService;

/**
 * Servlet implementation class RemoveEamilServlet
 */
@WebServlet("/removeeamilaction")
public class RemoveEamilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveEamilServlet() {
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
		System.out.println("删除管理员邮箱");
		response.setCharacterEncoding("utf-8");
		String id= request.getParameter("id");
		Eamil eamil = new Eamil(id);
		EamilService service = new EamilService();
		boolean b = service.removeeamil(eamil);
		if(b){
			request.getRequestDispatcher("selecreamilservlet").forward(request, response);
		}
	}

}

package com.cate.order.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Message;
import com.cate.order.service.MessageService;

/**
 * Servlet implementation class UpdateMessageServlet
 */
@WebServlet("/updatemessageaction")
public class UpdateMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMessageServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String userid = request.getParameter("userid");
		String foodid = request.getParameter("foodid");
		String content1 = request.getParameter("content");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=format.format(new Date());
		if (null != id && !"".equals(id) && null != userid && !"".equals(userid) && null != foodid && !"".equals(foodid)
				&& null != content1 && !"".equals(content1)) {
			Message message=new Message(id, userid, foodid, content1, time);
			MessageService service=new MessageService();
			boolean a=service.updatemessage(message);
			if(a){
				request.getRequestDispatcher("selectmessageservlet").forward(request, response);
			}
		}
	}

}

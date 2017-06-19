package com.cate.order.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Message;
import com.cate.order.service.MessageService;

/**
 * Servlet implementation class AddMessageServlet
 */
@WebServlet("/addmessageservlet")
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMessageServlet() {
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
		String userid = request.getParameter("userid");
		String foodid = request.getParameter("foodid");
		String content = request.getParameter("content");
		Message message = new Message(getId("M"), userid, foodid, content);
		MessageService service = new MessageService();
		boolean issuccess = service.registermessage(message);
		if (issuccess) {
			request.getRequestDispatcher("selectmessageservlet").forward(request, response);
		}

	}

	// 账户尾号
	private static int tail = 1;

	// 每月注册账户数量限制
	private int limit = 9999;

	private String getId(String i) {
		MessageService service = new MessageService();
		int num = service.selectmessagenum();
		String hisId = null;
		String id1 = null;
		String id2 = null;
		if (num > 0) {
			hisId = service.selectId();
			id1 = hisId.substring(0, 7);
			id2 = hisId.substring(7);
		}
		String a;
		int b;
		String c;
		// 每月开户名额为9999
		if (tail > limit) {
			return "";
			
		} // date0424 时间 年+月
		SimpleDateFormat df = new SimpleDateFormat("YYYYMM");
		Calendar calendar = Calendar.getInstance();
		String date = df.format(calendar.getTime());

		// 如果新月份账号尾数重置
		calendar.add(Calendar.DATE, -1);
		if (!date.equals(df.format(calendar.getTime()))) {
			tail = 1;
		}

		// id 帐号
		DecimalFormat format = new DecimalFormat();
		format.applyPattern("0000");
		a = i + date;
		if (null != hisId) {
			if (a.equals(id1)) {
				b = Integer.parseInt(id2);
				c = a + format.format(++b);
			} else {
				c = a + format.format(tail++);
			}
		} else {
			c = a + format.format(tail++);
		}
		return c;
	}
}

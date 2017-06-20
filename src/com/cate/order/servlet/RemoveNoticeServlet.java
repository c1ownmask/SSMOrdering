package com.cate.order.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Notice;
import com.cate.order.service.NoticeService;

/**
 * Servlet implementation class RemoveNoticeServlet
 */
//删除公告
@WebServlet("/removenoticeaction")
public class RemoveNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveNoticeServlet() {
       
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
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		Notice notice = new Notice(id);
		NoticeService service = new NoticeService();
		boolean b = service.removenotice(notice);
		if(b){
			request.getRequestDispatcher("selectnoticeaction").forward(request, response);
		}
	}

}

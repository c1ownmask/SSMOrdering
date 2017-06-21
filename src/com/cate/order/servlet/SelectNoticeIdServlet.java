package com.cate.order.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Notice;
import com.cate.order.service.NoticeService;

/**
 * Servlet implementation class SelectNoticeIdServlet
 */
@WebServlet("/selectnoticeidaction")
public class SelectNoticeIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNoticeIdServlet() {
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
		String id= request.getParameter("id");
		NoticeService service = new NoticeService();
		List<Notice> list =new ArrayList<Notice>();
		list=service.selectnoticeid(id);
		if( null !=list){
			request.setAttribute("list", list);
			request.getRequestDispatcher("index-notice.jsp").forward(request, response);
		}
	}

}

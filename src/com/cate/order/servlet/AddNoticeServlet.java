package com.cate.order.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cate.order.pojo.Admin;
import com.cate.order.pojo.Notice;
import com.cate.order.service.AdminService;
import com.cate.order.service.NoticeService;

/**
 * Servlet implementation class AddNoticeServlet
 */
//新增公告信息
@WebServlet("/addnoticeaction")
public class AddNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNoticeServlet() {
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
//		System.out.println("新增公告");
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String content = request.getParameter("content");
		String name=request.getParameter("name");
//		System.out.println(id+" "+title+" "+content+" "+name);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());
//		Notice notice = new Notice(id,content,date,title,name);
//		NoticeService service2 = new NoticeService();
//		boolean b = service2.addNotice(notice);
	}

}

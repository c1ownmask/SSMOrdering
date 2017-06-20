package com.cate.order.service;

import java.util.ArrayList;
import java.util.List;
import com.cate.order.dao.MessageDao;
import com.cate.order.pojo.Message;

/**
 * 
 * @Date:2017年6月14日 15:03:30
 * @PS:Message类Service
 *
 */
public class MessageService {
	MessageDao dao = new MessageDao();

	/**
	 * @PS:查找所有留言Service
	 */
	
	public List<Message> selectmessage() {
		List<Message> list = new ArrayList<Message>();
		list = dao.selectmessage();
		return list;
	}

	/**
	 * @PS:Message模糊查询Service
	 */
	public List<Message> selectmessagebyid(String id) {
		return dao.selectmessagebyid(id);
	}

	/**
	 * @PS:Message添加Service
	 */
	public boolean registermessage(Message message) {
		return dao.registermessager(message);
	}

	public int selectmessagenum() {
		return dao.selectmessagenum();
	}
	
	public String selectId() {
		return dao.selectId();
	}
	
	/**
	 * @PS:Message删除Service
	 */
	public boolean deletemessageservice(String id) {
		return dao.deletemessage(id);
	}

	public boolean updatemessage(Message message) {
		return dao.updatemessage(message);
	}

	


	
}

package com.cate.order.service;

import java.util.ArrayList;
import java.util.List;

import com.cate.order.dao.NoticeDao;
import com.cate.order.pojo.Notice;

public class NoticeService {
	NoticeDao dao = new NoticeDao();

	public List<Notice> selectnotice() {
		List<Notice> list = new ArrayList<Notice>();
		list = dao.selectNotice();
		return list;
	}

	public boolean addNotice(Notice notice) {
		return dao.addnotice(notice);
	}

	public boolean removenotice(Notice notice) {
		return dao.removeNotice(notice);
	}

	public boolean changenotice(Notice notice) {
		return dao.updatenotice(notice);
	}

	public List<Notice> selectnoticeid(String id) {
		return dao.selectNoticeId(id);
	}

}

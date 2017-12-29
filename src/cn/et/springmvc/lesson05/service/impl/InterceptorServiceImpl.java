package cn.et.springmvc.lesson05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.springmvc.lesson05.dao.InterceptorDao;
import cn.et.springmvc.lesson05.service.InterceptorService;

@Service
public class InterceptorServiceImpl implements InterceptorService{

	@Autowired
	InterceptorDao dao;
	public Integer selectMoney() {
		Integer result = dao.selectMoney();
		return result;
	}

	public void updateMoney(Integer money) {
		dao.updateMoney(money);
	}
}

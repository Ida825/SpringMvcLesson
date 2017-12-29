package cn.et.springmvc.lesson06.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.springmvc.lesson06.dao.MyFoodDao;
import cn.et.springmvc.lesson06.service.MyFoodService;

@Service
public class MyFoodServiceImpl implements MyFoodService {
	
	@Autowired
	MyFoodDao dao;
	public List<Map<String, Object>> queryFood(String foodname) {
		if(foodname==null){
			foodname="";
		}
		return dao.queryFood(foodname);
	}
	public void addFood(String foodname, String price) {
		dao.addFood(foodname, price);
	}
	public void deleteFood(String foodid) {	
		dao.deleteFood(foodid);
	}
	public void updateFood(String foodid,String foodname, String price) {
		dao.updateFood(foodid,foodname, price);
	}

}

package cn.et.springmvc.lesson01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.springmvc.lesson01.dao.FoodDao;
import cn.et.springmvc.lesson01.service.FoodService;
import cn.et.springmvc.lesson01.utils.PageTools;

/**
 * 业务逻辑层
 * @author Administrator
 *
 */
@Service
public class FoodServiceImpl implements FoodService{
	
	
	@Autowired
	private FoodDao dao;

	public PageTools getFoodListPage(String name,int curPage) {
		if(name==null){
			name="";
		}	
		int totalCount = dao.getFoodListCount(name);
		PageTools pt = new PageTools(curPage,totalCount,null);
		List<Map<String,Object>> foodListPage = dao.getFoodListPage(name, pt.getStartIndex()-1,pt.getPageCount());
		//将查到的数据放入List集合
		pt.setData(foodListPage);
		return pt;
	}
	

	public Map<String, Object> queryById(String foodid) {	
		return dao.queryById(foodid);
	}
	
	
	public void saveFood(String name, String price,String imgPath){		
		dao.saveFood(name, price, imgPath);
	}


	public void deleteFood(String fid) {
		dao.deleteFood(fid);		
	}


	public void updateFood(String foodid, String foodname, String price,
			String imgPath) {
		dao.updateFood(foodid, foodname, price, imgPath);	
	}

	
}

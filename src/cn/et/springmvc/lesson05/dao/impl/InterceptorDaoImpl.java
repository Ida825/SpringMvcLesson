package cn.et.springmvc.lesson05.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson05.dao.InterceptorDao;

@Repository
public class InterceptorDaoImpl implements InterceptorDao{

	@Autowired
	JdbcTemplate jdbc;
	
	public Integer selectMoney() {
		String sql = "select lostedmoney from mymoney";
		Integer result = jdbc.queryForObject(sql, Integer.class);
		return result;
	}

	public void updateMoney(Integer money) {
		String sql = "update mymoney set lostedmoney=lostedmoney-"+money+" where id=1";
		jdbc.execute(sql);
	}

}

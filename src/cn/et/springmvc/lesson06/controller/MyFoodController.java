package cn.et.springmvc.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.springmvc.lesson06.service.MyFoodService;

@Controller
public class MyFoodController {

	/**
	 * 第一种：原始输出json方式：Outputstream os;
	 * os.write(通过第三方json-lib转换的json字符串.getByte())
	 * 
	 * 查询菜品
	 */
	
	@Autowired
	MyFoodService ms;	
	@RequestMapping(value="/queryFood",method=RequestMethod.GET)
	public String queryFood(String foodname,OutputStream os) throws IOException{
		List<Map<String, Object>> foodList =  ms.queryFood(foodname);
		//将查到的数据放入JSON转换成相应的格式
		JSONArray array = JSONArray.fromObject(foodList);
		//获取json的字符串
		String jsonStr = array.toString();
		os.write(jsonStr.getBytes("UTF-8"));
		return null;
	}
	
	/**
	 * 第二种：直接返回字符数组 byte[] 
	 * 必须要有注解 @ResponseBody
	 * @param foodname
	 * @param os
	 * @return
	 * @throws IOException
	 */
	
	//响应消息体:将返回的内容响应给浏览器
	@ResponseBody
	@RequestMapping(value="/queryFoodReturn",method=RequestMethod.GET)
	public byte[] queryFoodByte(String foodname) throws IOException{
		List<Map<String, Object>> foodList =  ms.queryFood(foodname);
		//将查到的数据放入JSON转换成相应的格式
		JSONArray array = JSONArray.fromObject(foodList);
		//获取json的字符串
		String jsonStr = array.toString();
		return jsonStr.getBytes("UTF-8");
	}
	
	
	/**
	 * 第三种：直接返回对象SpringMVC自动转换成json
	 * 要配置消息转换器
	 * @param foodname
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/queryFoodList",method=RequestMethod.GET)
	public List<Map<String, Object>> queryFoodList(String foodname) throws IOException{
		List<Map<String, Object>> foodList =  ms.queryFood(foodname);	
		return foodList;
	}
	
	
	
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodid,OutputStream os) throws IOException{
		try {
			ms.deleteFood(foodid);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));	
		}
		return null;
	}
	
	@RequestMapping(value="/food",method=RequestMethod.POST)
	public String addFood(String foodname,String price,OutputStream os) throws IOException{
		try {
			ms.addFood(foodname,price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));	
		}
		return null;
	}
	
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.PUT)
	public String updateFood(@PathVariable String foodid,String foodname,String price,OutputStream os) throws IOException{
		try {
			ms.updateFood(foodid,foodname,price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
			e.printStackTrace();
		}
		return null;
	}
}

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
	 * ��һ�֣�ԭʼ���json��ʽ��Outputstream os;
	 * os.write(ͨ��������json-libת����json�ַ���.getByte())
	 * 
	 * ��ѯ��Ʒ
	 */
	
	@Autowired
	MyFoodService ms;	
	@RequestMapping(value="/queryFood",method=RequestMethod.GET)
	public String queryFood(String foodname,OutputStream os) throws IOException{
		List<Map<String, Object>> foodList =  ms.queryFood(foodname);
		//���鵽�����ݷ���JSONת������Ӧ�ĸ�ʽ
		JSONArray array = JSONArray.fromObject(foodList);
		//��ȡjson���ַ���
		String jsonStr = array.toString();
		os.write(jsonStr.getBytes("UTF-8"));
		return null;
	}
	
	/**
	 * �ڶ��֣�ֱ�ӷ����ַ����� byte[] 
	 * ����Ҫ��ע�� @ResponseBody
	 * @param foodname
	 * @param os
	 * @return
	 * @throws IOException
	 */
	
	//��Ӧ��Ϣ��:�����ص�������Ӧ�������
	@ResponseBody
	@RequestMapping(value="/queryFoodReturn",method=RequestMethod.GET)
	public byte[] queryFoodByte(String foodname) throws IOException{
		List<Map<String, Object>> foodList =  ms.queryFood(foodname);
		//���鵽�����ݷ���JSONת������Ӧ�ĸ�ʽ
		JSONArray array = JSONArray.fromObject(foodList);
		//��ȡjson���ַ���
		String jsonStr = array.toString();
		return jsonStr.getBytes("UTF-8");
	}
	
	
	/**
	 * �����֣�ֱ�ӷ��ض���SpringMVC�Զ�ת����json
	 * Ҫ������Ϣת����
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

package cn.et.springmvc.lesson06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyTest {
	
	public static void parseObject(){
		Map map = new HashMap();
		map.put("username", "zs");
		map.put("age", "18");
		JSONObject obj = JSONObject.fromObject(map);
		System.out.println(obj.toString());
	}
	
	
	public static void parseArray(){
		Map map = new HashMap();
		map.put("username", "zs");
		map.put("age", "18");
		
		Map map1 = new HashMap();
		map1.put("username", "ls");
		map1.put("age", "25");
		
		List list = new ArrayList();
		list.add(map);
		list.add(map1);
		
		JSONArray array = JSONArray.fromObject(list);
		System.out.println(array.toString());
	}
	
	public static void main(String[] args) {
		parseObject();//{"username":"zs","age":"18"}
		parseArray();//[{"username":"zs","age":"18"},{"username":"ls","age":"25"}]
		
	}
}

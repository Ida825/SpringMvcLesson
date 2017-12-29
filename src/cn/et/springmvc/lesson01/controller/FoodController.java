package cn.et.springmvc.lesson01.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.et.springmvc.lesson01.service.FoodService;
import cn.et.springmvc.lesson01.utils.PageTools;

/**
 * 控制层
 * @author Administrator
 *
 */
@Controller
public class FoodController {
	@Autowired
	private FoodService service;
	
	/**
	 * 查询
	 * @return
	 */
	@RequestMapping(value="/showFood",method=RequestMethod.GET)
	public String queryFood(String foodname,Integer curPage,Model model){
		if(curPage==null){
			curPage=1;
		}
		//model 相当于request.setAttribute("","");
		PageTools foodList = service.getFoodListPage(foodname,curPage);
		
		//将结果放入作用域
		model.addAttribute("foodList", foodList);
		return "/detail/foodList.jsp";
	}
	

	/**
	 * 根据菜品编号查询
	 * @param foodid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.GET)
	public String queryFoodById(@PathVariable String foodid,Model model){
		//将结果放入作用域
		model.addAttribute("myFood", service.queryById(foodid));
		return "/detail/detailFood.ftl";
	}
	
	/**
	 * 
	 * 修改
	 * @param foodid
	 * @param foodname
	 * @param price
	 * @param img
	 * @param imageUrl
	 * @param model
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.POST)
	public String updateFoodById(@PathVariable String foodid,String foodname,String price,String img,MultipartFile imageUrl,Model model) throws IllegalStateException, IOException{
		//获取文件名
		String filename = imageUrl.getOriginalFilename();
		//当不改图片时，默认传原图片
		if(filename!=null && !"".equals(filename)){
			//获取绝对路径
			String absPath = "E:\\Eclipse工作空间\\MyEclipse\\.metadata\\.me_tcat\\webapps\\s\\images";
			//保存文件
			imageUrl.transferTo(new File(absPath+"\\"+filename));
			//将结果放入作用域
			img=filename;
		}
		
		service.updateFood(foodid, foodname, price, img);		
		return queryFood(null,1,model);
	}
	
	/**
	 * 下载图片
	 * @param img
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFoodImg(String img) throws Exception {
		String absPath="E:\\Eclipse工作空间\\MyEclipse\\.metadata\\.me_tcat\\webapps\\s\\images\\"+img;
		String fileName=img;
		//需要下载的目标文件
		File file = new File(absPath);
		//设置响应头
		HttpHeaders hh = new HttpHeaders();
		//设置下载的文件名
		hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName,"UTF-8"));
		//读取目标文件为二进制数组
		byte[] fileByte = FileCopyUtils.copyToByteArray(file);
		//构建ResponseEntity对象
		ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte,hh,HttpStatus.CREATED);
		return re;
	}
	
	/**
	 * 删除
	 * @param foodid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/food",method=RequestMethod.GET)
	public String deleteFoodById(String foodname,String foodid,Model model){
		service.deleteFood(foodid);
		return queryFood(foodname,1,model);
	}
	
	
	/**
	 * 添加菜品
	 * @param foodname
	 * @param price
	 * @param imageUrl
	 * @param model
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="/food",method=RequestMethod.POST)
	public String addFood(String foodname,String price,MultipartFile imageUrl,Model model) throws IllegalStateException, IOException{
		//获取文件名
		String filename = imageUrl.getOriginalFilename();
	
		if(imageUrl.isEmpty()){
			return queryFood(foodname, 1, model);
		}
		//获取绝对路径
		String absPath = "E:\\Eclipse工作空间\\MyEclipse\\.metadata\\.me_tcat\\webapps\\s\\images";
		//保存文件
		imageUrl.transferTo(new File(absPath+"\\"+filename));
		//将结果放入作用域
		
		
		service.saveFood(foodname, price, filename);
		return queryFood(foodname, 1, model);
	}
	
}

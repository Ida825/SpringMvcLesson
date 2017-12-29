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
 * ���Ʋ�
 * @author Administrator
 *
 */
@Controller
public class FoodController {
	@Autowired
	private FoodService service;
	
	/**
	 * ��ѯ
	 * @return
	 */
	@RequestMapping(value="/showFood",method=RequestMethod.GET)
	public String queryFood(String foodname,Integer curPage,Model model){
		if(curPage==null){
			curPage=1;
		}
		//model �൱��request.setAttribute("","");
		PageTools foodList = service.getFoodListPage(foodname,curPage);
		
		//���������������
		model.addAttribute("foodList", foodList);
		return "/detail/foodList.jsp";
	}
	

	/**
	 * ���ݲ�Ʒ��Ų�ѯ
	 * @param foodid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/food/{foodid}",method=RequestMethod.GET)
	public String queryFoodById(@PathVariable String foodid,Model model){
		//���������������
		model.addAttribute("myFood", service.queryById(foodid));
		return "/detail/detailFood.ftl";
	}
	
	/**
	 * 
	 * �޸�
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
		//��ȡ�ļ���
		String filename = imageUrl.getOriginalFilename();
		//������ͼƬʱ��Ĭ�ϴ�ԭͼƬ
		if(filename!=null && !"".equals(filename)){
			//��ȡ����·��
			String absPath = "E:\\Eclipse�����ռ�\\MyEclipse\\.metadata\\.me_tcat\\webapps\\s\\images";
			//�����ļ�
			imageUrl.transferTo(new File(absPath+"\\"+filename));
			//���������������
			img=filename;
		}
		
		service.updateFood(foodid, foodname, price, img);		
		return queryFood(null,1,model);
	}
	
	/**
	 * ����ͼƬ
	 * @param img
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public ResponseEntity<byte[]> downloadFoodImg(String img) throws Exception {
		String absPath="E:\\Eclipse�����ռ�\\MyEclipse\\.metadata\\.me_tcat\\webapps\\s\\images\\"+img;
		String fileName=img;
		//��Ҫ���ص�Ŀ���ļ�
		File file = new File(absPath);
		//������Ӧͷ
		HttpHeaders hh = new HttpHeaders();
		//�������ص��ļ���
		hh.setContentDispositionFormData("attachment", URLEncoder.encode(fileName,"UTF-8"));
		//��ȡĿ���ļ�Ϊ����������
		byte[] fileByte = FileCopyUtils.copyToByteArray(file);
		//����ResponseEntity����
		ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte,hh,HttpStatus.CREATED);
		return re;
	}
	
	/**
	 * ɾ��
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
	 * ��Ӳ�Ʒ
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
		//��ȡ�ļ���
		String filename = imageUrl.getOriginalFilename();
	
		if(imageUrl.isEmpty()){
			return queryFood(foodname, 1, model);
		}
		//��ȡ����·��
		String absPath = "E:\\Eclipse�����ռ�\\MyEclipse\\.metadata\\.me_tcat\\webapps\\s\\images";
		//�����ļ�
		imageUrl.transferTo(new File(absPath+"\\"+filename));
		//���������������
		
		
		service.saveFood(foodname, price, filename);
		return queryFood(foodname, 1, model);
	}
	
}

package cn.et.springmvc.lesson05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ���������
 * @author Administrator
 *
 */
public class TokenInterceptor implements HandlerInterceptor {
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String myToken = request.getParameter("myToken");
		Object myToken2 = request.getSession().getAttribute("myToken");
		
		if(myToken!=null){
			/*//�ظ��ύ
			if(myToken2==null){
				//�Ѿ��ύ���ˣ�ֱ���÷���
				return false;
			}else{
				if(myToken.equals(myToken2)){
					//��һ���ύ�ɹ���Ҫ���session
					request.getSession().removeAttribute("myToken");
					return true;
				}else{
					return false;
				}
			}*/
			
			if(myToken2 != null){	// session ����uuid����Ҫ��parameter�е�uuid�Ա�
				
				if(myToken.equals(myToken2.toString())){
					request.getSession().removeAttribute("myToken");
					return true;
				}
				
			}
			
			// ������session�е�uuidΪ�ջ���uuid��һ�£����ǷǷ�����ͳͳ����
			return false;	
		}else{
			//û��������û��token���Ͳ���Ҫ�ж�
			return true;
		}
		
	}
	
	
	
	

}

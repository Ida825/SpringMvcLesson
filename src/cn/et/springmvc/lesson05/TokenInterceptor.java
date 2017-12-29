package cn.et.springmvc.lesson05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
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
			/*//重复提交
			if(myToken2==null){
				//已经提交过了，直接让返回
				return false;
			}else{
				if(myToken.equals(myToken2)){
					//第一次提交成功后要清空session
					request.getSession().removeAttribute("myToken");
					return true;
				}else{
					return false;
				}
			}*/
			
			if(myToken2 != null){	// session 中有uuid，需要跟parameter中的uuid对比
				
				if(myToken.equals(myToken2.toString())){
					request.getSession().removeAttribute("myToken");
					return true;
				}
				
			}
			
			// 无论是session中的uuid为空或者uuid不一致，都是非法请求，统统拦截
			return false;	
		}else{
			//没有请求中没有token，就不需要判断
			return true;
		}
		
	}
	
	
	
	

}

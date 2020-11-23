package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;

//@WebFilter(urlPatterns={"/admin/*"})
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession httpSession = req.getSession();
		Object object = httpSession.getAttribute("user");
		if(object != null){
			Customer user = (Customer) object;
//			if(user.getRole().equals("ADMIN")){
//				filterChain.doFilter(request, response);
//			}else{
//				resp.sendRedirect(req.getContextPath() + "/home");
//			}
		}else{
			resp.sendRedirect(req.getContextPath() + "/admin/login");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}

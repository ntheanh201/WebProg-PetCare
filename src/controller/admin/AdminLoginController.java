//package controller.admin;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import model.Customer;
//import service.UserService;
//import service.impl.UserServiceImpl;
//
//@WebServlet(urlPatterns = { "/admin/login" })
//public class AdminLoginController extends HttpServlet {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private UserService userService = new UserServiceImpl();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/login.jsp");
//		requestDispatcher.forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		String username = req.getParameter("username");
//
//		String password = req.getParameter("password");
//		
//		System.out.println("user :" + username + " " +  password);
//		
//		if (username != null && password != null && userService.checkLogin(username, password)) {
//			Customer user = userService.getByUsername(username);
//			HttpSession httpSession = req.getSession();
//			httpSession.setAttribute("user", user);
//			System.out.println("login successful");
//			resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
//		} else {
//			System.out.println("fail login");
//			resp.sendRedirect(req.getContextPath() + "/login");
//		}
//	}
//}

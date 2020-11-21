package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/login.jsp");
////		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/common/index.jsp");
//		requestDispatcher.forward(req, resp);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");

		String password = req.getParameter("password");
		
		System.out.println("user :" + username + " " +  password);
		
		if (username != null && password != null && userService.checkLogin(username, password)) {
			User user = userService.getByUsername(username);
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", user);
			System.out.println("login successful");
			if (user.getRole().equals("USER")) {
				resp.sendRedirect(req.getContextPath() + "/home");
//				System.out.println("userSession: " + httpSession.getAttribute("user").toString());
			} else {
				resp.sendRedirect(req.getContextPath() + "/admin/admin-page");
			}

		} else {
			System.out.println("fail login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}

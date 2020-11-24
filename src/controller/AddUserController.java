package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.mindrot.jbcrypt.BCrypt;

import model.Customer;
import service.UserService;
import service.impl.UserServiceImpl;
import util.Hasher;

@WebServlet(urlPatterns={"/register"})
public class AddUserController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/register.jsp");
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/ui/register.jsp");
		requestDispatcher.forward(req, resp);
//		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
//		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
		String hashed = Hasher.getHash(password);
		String role = req.getParameter("role");
		System.out.println("pass : " + hashed);
		if(name != null && username != null && password != null && role != null) {
			Customer khachHang = new Customer();
			khachHang.setName(name);
			khachHang.setUsername(username);
			khachHang.setPassword(hashed);
			khachHang.setEmail(email);
			
			UserService khachHangService = new UserServiceImpl();
			khachHangService.addKhachHang(khachHang);
			
			resp.sendRedirect(req.getContextPath() + "/");
		}
	}
}

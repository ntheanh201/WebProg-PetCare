package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import model.User;
import service.ProductsService;
import service.UserService;
import service.impl.ProductsServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns={"/admin/admin-page"})
public class AdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductsService ProductsService = new ProductsServiceImpl();
		List<Products> dsProducts = ProductsService.getAll();
		
		UserService userService = new UserServiceImpl();
		List<User> dskhachhang = userService.getAll();
		req.setAttribute("dskhachhang", dskhachhang);
		req.setAttribute("dsProducts", dsProducts);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/common/index.jsp");
		requestDispatcher.forward(req, resp);
	}
}

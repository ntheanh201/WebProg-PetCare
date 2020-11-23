package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.Customer;
import service.ProductService;
import service.UserService;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns={"/admin/orders"})
public class OrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ProductService ProductsService = new ProductServiceImpl();
//		List<Product> dsProducts = ProductsService.getAll();
//		
//		UserService userService = new UserServiceImpl();
//		List<Customer> dskhachhang = userService.getAll();
//		req.setAttribute("dskhachhang", dskhachhang);
//		req.setAttribute("dsProducts", dsProducts);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/orders.jsp");
		requestDispatcher.forward(req, resp);
	}
}

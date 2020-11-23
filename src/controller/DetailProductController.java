package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns={"/product/detail"})
public class DetailProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("query id : " + id);
		ProductService ProductService = new ProductServiceImpl();
		Product Product = ProductService.getByID(Integer.valueOf(id));
//		Products Product = ProductService.getByID(Integer.valueOf(id));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/product/detail.jsp");
		req.setAttribute("product", Product);
		requestDispatcher.forward(req, resp);
	}
}

package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;
import service.CategoriesService;
import service.impl.CategoriesServiceImpl;

@WebServlet(urlPatterns={"/admin/category/addCategory"})
public class AddCateController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CategoryDao CategoriesDao = new CategoryDaoImpl();
	
	CategoriesService CategoriesService = new CategoriesServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("get cate page ");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/product/addCate.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("post from cate page");
		resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		Category Categories = new Category();
		Categories.setName(name);
		Categories.setDescription(description);
		
		CategoriesService.addCategories(Categories);
		resp.sendRedirect(req.getContextPath() + "/admin");
	}
}

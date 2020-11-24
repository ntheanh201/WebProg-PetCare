//package controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import dao.ProductDao;
//import dao.impl.ProductDaoImpl;
//import model.Category;
//import model.Product;
//import service.CategoriesService;
//import service.ProductService;
//import service.impl.CategoriesServiceImpl;
//import service.impl.ProductServiceImpl;
//
//@WebServlet(urlPatterns={"/admin/products/addProduct"})
//@MultipartConfig(maxFileSize = 16177215)
//public class AddProductController extends HttpServlet{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private static final int BUFFER_SIZE = 4096;
//		
//	ProductDao ProductsDao = new ProductDaoImpl();
//	
//	ProductService ProductsService = new ProductServiceImpl();
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		CategoriesService categoriesService = new CategoriesServiceImpl();
//		List<Category> categories = categoriesService.getAllCategories();
////		for (Categories categories2 : categories) {
////			System.out.println("type : "+ categories2);
////		}
//		req.setAttribute("categories", categories);
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/product/addProduct.jsp");
//		requestDispatcher.forward(req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////		System.out.println("get add product page ");
//		resp.setContentType("text/html;charset=UTF-8");
//        req.setCharacterEncoding("UTF-8");
//		String name = req.getParameter("name");
//		String code = req.getParameter("code");
//		String category_Id = req.getParameter("category_ID");
//		String brief = req.getParameter("brief");
//		String price = req.getParameter("price");
//		String description = req.getParameter("description");
//		
//		Part filePart = req.getPart("photo");
////		System.out.println("cate id:  " + category_Id);
//		Product Products = new Product();
//		Products.setName(name);
//		Products.setCode(code);
//		Products.setCategory_id(Integer.parseInt(category_Id));
//		Products.setBrief(brief);
//		Products.setPrice(Double.valueOf(price));
//		Products.setDescription(description);
//		Products.setPhoto(filePart);
//		
//		ProductsService.addProduct(Products);
//		resp.sendRedirect(req.getContextPath() + "/admin/admin-page");
//	}
//}

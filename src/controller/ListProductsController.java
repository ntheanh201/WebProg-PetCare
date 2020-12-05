//package controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import model.Category;
//import model.Product;
//
//@WebServlet(urlPatterns = { "/products/list-products" })
//public class ListProductsController extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
////	ProductService ProductsService = new ProductServiceImpl();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<Product> Productss = ProductsService.getAll();
////		String iddanhmuc = req.getParameter("id_danhmuc");
////		
//		CategoriesService categoriesService = new CategoriesServiceImpl();
//		List<Category> categories = categoriesService.getAllCategories();
//////		categories.forEach(cat -> {
//////			System.out.println(cat.getId() + " " + cat.getName());
//////		});
////		req.setAttribute("danhmuc", categories);
//		
//		//System.out.println(iddanhmuc);
////		if (iddanhmuc != null) {
////			List<Products> Productss = ProductsService.getProductByIDCategori(Integer.parseInt(iddanhmuc));
////			req.setAttribute("Products", Productss);
////		} else {
////			List<Products> Productss = ProductsService.getAll();
////			req.setAttribute("Products", Productss);
////		}
//		
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/product/listProducts.jsp");
//		req.setAttribute("Products", Productss);
//		requestDispatcher.forward(req, resp);
//	}
//}

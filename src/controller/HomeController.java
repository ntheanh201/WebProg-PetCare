package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.SanPham;
//import service.SanPhamService;
//import service.impl.SanPhamServiceImpl;

@WebServlet(urlPatterns={"/"})
public class HomeController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	SanPhamService sanPhamService = new SanPhamServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
//		List<SanPham> sanPhams = sanPhamService.getAll();
		
//		req.setAttribute("sanpham", sanPhams);
		
//		
//		SanPham idsanPhams = sanPhamService.getByID(Integer.valueOf(id));
//		req.setAttribute("idsanpham", idsanPhams);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/common/index.jsp");
		requestDispatcher.forward(req, resp);
	}
	
}

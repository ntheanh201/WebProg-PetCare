//package controller;
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
//@WebServlet(urlPatterns={"/logout"})
//public class LogoutController extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session != null) {
//            session.removeAttribute("user");
////            resp.sendRedirect(req.getContextPath() + "/home");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/common/index.jsp");
//            dispatcher.forward(req, resp);
//        }
//	}
//}

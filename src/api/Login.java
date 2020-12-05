package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.AdminDao;
import dao.CustomerDao;
import dao.ShipperDao;
import dao.impl.AdminDaoImpl;
import dao.impl.CustomerDaoImpl;
import dao.impl.ShipperDaoImpl;
import model.Admin;
import model.Customer;
import model.LoginModel;
import model.Shipper;
import util.Hasher;

@WebServlet(urlPatterns = { "/auth/*" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = null;
	private CustomerDao customerDao = new CustomerDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	private ShipperDao shipperDao = new ShipperDaoImpl();

	public Login() {
		super();
		_gson = new Gson();
	}

	private void sendAsJson(HttpServletResponse response, String obj) throws IOException {
		response.setContentType("application/json");
		String res = _gson.toJson(obj);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.flush();
	}

	public boolean checkLogin(String username, String password) {
		String hashed = Hasher.getHash(password);
		Customer customer = customerDao.getByUsername(username);
		Admin admin = adminDao.getByUsername(username);
		Shipper shipper = shipperDao.getByUsername(username);

		if ((customer != null && customer.getPassword().equals(hashed))
				|| (admin != null && admin.getPassword().equals(hashed))
				|| (shipper != null && shipper.getPassword().equals(hashed))) {
			return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {

			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}

			String payload = buffer.toString();

			LoginModel model = _gson.fromJson(payload, LoginModel.class);
			if (model != null && checkLogin(model.getUsername(), model.getPassword())) {
				sendAsJson(response, "success");
			} else {
				sendAsJson(response, "error");
			}

//			sendAsJson(response, model);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}
}
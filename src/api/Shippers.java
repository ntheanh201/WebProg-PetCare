package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ShipperDao;
import dao.impl.ShipperDaoImpl;
import model.Shipper;

@WebServlet(urlPatterns = { "/shippers/*" })
public class Shippers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson _gson = null;
	private ShipperDao ShipperDao = new ShipperDaoImpl();

	private HashMap<String, Shipper> _modelsDb = new HashMap<>();

	public Shippers() {
		super();

		_gson = new Gson();

		List<Shipper> Shippers = ShipperDao.getAllCategories();
		for (Shipper s : Shippers) {
			String id = s.getId();
			_modelsDb.put(id, s);
		}
	}

	private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
		response.setContentType("application/json");

		String res = _gson.toJson(obj);

		PrintWriter out = response.getWriter();

		out.print(res);
		out.flush();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {

			Collection<Shipper> models = _modelsDb.values();

			sendAsJson(response, models);
			return;
		}

		String[] splits = pathInfo.split("/");

		if (splits.length != 2) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String modelId = splits[1];

		if (!_modelsDb.containsKey(modelId)) {

			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		sendAsJson(response, _modelsDb.get(modelId));
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {

			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = request.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}

			String payload = buffer.toString();

			Shipper model = _gson.fromJson(payload, Shipper.class);
						
			model.setId(UUID.randomUUID().toString());
			
			ShipperDao.addShipper(model);
			
			_modelsDb.put(model.getId(), model);

			sendAsJson(response, model);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] splits = pathInfo.split("/");

		if (splits.length != 2) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String modelId = splits[1];

		if (!_modelsDb.containsKey(modelId)) {

			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}

		String payload = buffer.toString();

		Shipper model = _gson.fromJson(payload, Shipper.class);
		
		model.setId(modelId);
		
		ShipperDao.editShipper(model);
		_modelsDb.put(modelId, model);

		sendAsJson(response, model);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] splits = pathInfo.split("/");

		if (splits.length != 2) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String modelId = splits[1];

		if (!_modelsDb.containsKey(modelId)) {

			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Shipper model = _modelsDb.get(modelId);

		ShipperDao.deleteShipper(modelId);
		_modelsDb.remove(modelId);

		sendAsJson(response, model);
		return;
	}
}
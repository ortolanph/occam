package org.occam.servlet;

import org.occam.core.exceptions.InvalidOperationException;
import org.occam.core.exceptions.NoNavigationFoundException;
import org.occam.infra.OccamFacade;
import org.occam.infra.executor.beans.ResultBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "OccamServlet", loadOnStartup = 1, urlPatterns = { "/occam/*" })
public class OccamServlet extends HttpServlet {
	private static final long serialVersionUID = 2448189969137605786L;
	
	private static final String OPERATIONS_FILE = "/WEB-INF/operations.xml";
	
	public OccamServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String> values = new HashMap<String, String>();
		OccamFacade facade = new OccamFacade();

		String uri = req.getRequestURI();

		String operation = uri.substring(uri.lastIndexOf('/') + 1,
				uri.lastIndexOf('.'));
		String method = uri.substring(uri.lastIndexOf('.') + 1);

		Enumeration<String> names = req.getParameterNames();

		while (names.hasMoreElements()) {
			String name = names.nextElement();
			
			values.put(name, req.getParameter(name));
		}

		ResultBean result = null;
		
		URL operationsFile = getConfigurationPath();
		
		try {
			Object operationInstance = facade.getOperation(operationsFile, operation);
			
			if (!values.isEmpty()) {
				facade.resolveBeans(operationInstance, values);
			}

			result = facade.runMethod(operationInstance, method);
		} catch (InvalidOperationException e) {
			e.printStackTrace();
		} catch (NoNavigationFoundException e) {
			e.printStackTrace();
		}

		req.setAttribute("bean", result.getReturnInstance());

		RequestDispatcher rd = req.getRequestDispatcher("../" + result.getUrl());
		rd.forward(req, resp);
	}
	
	public URL getConfigurationPath() {
		URL url;
		
		try {
			url = getServletContext().getResource(OPERATIONS_FILE);
			
			return url;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

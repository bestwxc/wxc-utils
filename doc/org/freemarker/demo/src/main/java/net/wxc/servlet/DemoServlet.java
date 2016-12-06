package net.wxc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demo.do")
public class DemoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", "wxc");
		req.setAttribute("age", 26);
		Map<String, String> car = new HashMap<String, String>();
		car.put("name", "BMW");
		car.put("price", "1500000");
		req.setAttribute("car", car);
		List<String> list = new ArrayList<String>();
		list.add("ccc");
		list.add("ccf");
		list.add("sxf");
		req.setAttribute("list", list);
		req.getRequestDispatcher("/demo.ftlh").forward(req, resp);
	}
}

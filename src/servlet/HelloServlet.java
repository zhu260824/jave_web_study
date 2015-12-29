package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("---------init without parameters-------------");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		System.out.println("---------get-------------");
		PrintWriter pw = resp.getWriter();
		pw.println("Hellow word");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp);
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("---------destroy-------------");
	}

}

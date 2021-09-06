package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Snack;
import dao.impl.ISnackDaoImpl;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("customer", null);
		ArrayList<Snack> snacks=iSnackDaoImpl.getSnacksByRecommed();
		for (int i = 0; i < snacks.size(); i++) {
			System.out.println(snacks.get(i).getSname());
		}
		request.setAttribute("url", "index");
		request.setAttribute("snacks", snacks);
		request.getRequestDispatcher("WEB-INF/content/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

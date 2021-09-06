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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String category = request.getParameter("cate");
		if (category==null||category.equals("recom")) {
			ArrayList<Snack> snacks=iSnackDaoImpl.getSnacksByRecommed();
			System.out.println(category);
			request.setAttribute("cate", "recom");
			request.setAttribute("url", "index");
			request.setAttribute("snacks", snacks);
			request.getRequestDispatcher("WEB-INF/content/index.jsp").forward(request, response);
		}else {
			ArrayList<Snack> snacks=iSnackDaoImpl.getSnacksByCategory(category);
			System.out.println(category);
			
			request.setAttribute("cate", category);
			request.setAttribute("url", "index");
			request.setAttribute("snacks", snacks);
			request.getRequestDispatcher("WEB-INF/content/index.jsp").forward(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

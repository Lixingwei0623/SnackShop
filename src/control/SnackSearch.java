/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: SnackSearch.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月30日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
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
 * Servlet implementation class SnackSearch
 */
@WebServlet("/snackSearch")
public class SnackSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wd = request.getParameter("wd");
		if (wd==null||wd=="") {
			request.setAttribute("url", "snackSearch");		
			request.getRequestDispatcher("WEB-INF/content/snackSearch.jsp").forward(request, response);
		}else {
			ArrayList<Snack> snacks=iSnackDaoImpl.searchSnacks(wd);
			request.setAttribute("snacks", snacks);
			request.setAttribute("url", "snackSearch");
			request.getRequestDispatcher("WEB-INF/content/snackSearch.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: SnackList.java </p> 
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
 * Servlet implementation class SnackList
 */
@WebServlet("/snackList")
public class SnackList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();    
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		if (sid!=null&&sid!="") {
			iSnackDaoImpl.deleteSnack(new Integer(sid));
		}
		ArrayList<Snack> snacks=iSnackDaoImpl.getAllSnacks();
		request.setAttribute("url", "snackList");		
		request.setAttribute("snacks", snacks);
		request.getRequestDispatcher("WEB-INF/content/snackList.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
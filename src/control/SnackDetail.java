/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: SnackDetail.java </p> 
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
 * Servlet implementation class SnackDetail
 */
@WebServlet("/snackDetail")
public class SnackDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidString = request.getParameter("sid");
		if (sidString!=null&&sidString!="") {
			int sid=new Integer(sidString);
			ArrayList<Snack> snacks=iSnackDaoImpl.getSnacksById(sid);
			if (snacks.size()!=0) {
				request.setAttribute("snack", snacks.get(0));
				request.getRequestDispatcher("WEB-INF/content/snackDetail.jsp").forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
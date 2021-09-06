package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Customer;
import dao.impl.ICustomerDaoImpl;

/**
 * Servlet implementation class ModifiyInfo
 */
@WebServlet("/modifiyInfo")
public class ModifiyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerDaoImpl iCustomerDaoImpl=new ICustomerDaoImpl();   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String sex = request.getParameter("optionsRadiosinline");
		String phnumber = request.getParameter("phnumber");
		if (name==null) {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("modifymessage", "info");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}else if (name.equals("")||phnumber.equals("")) {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("resultInfo", "No");
			request.setAttribute("modifymessage", "info");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}else if (((Customer)request.getSession().getAttribute("customer"))!=null){
			request.setAttribute("url", "personalCenter");
			request.setAttribute("resultInfo", "Yes");
			((Customer)request.getSession().getAttribute("customer")).setUname(name);
			((Customer)request.getSession().getAttribute("customer")).setSex(sex.equals("option1")?1:0);			
			((Customer)request.getSession().getAttribute("customer")).setPhnumber(phnumber);
			iCustomerDaoImpl.update((Customer)request.getSession().getAttribute("customer"));
			request.getRequestDispatcher("WEB-INF/content/personalCenter.jsp").forward(request, response);
		}else {
			request.setAttribute("url", "personalCenter");
			request.setAttribute("modifymessage", "info");
			request.getRequestDispatcher("WEB-INF/content/modfiyPersonal.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: AddCustomer.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月30日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
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
 * Servlet implementation class AddCustomer
 */
@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerDaoImpl iCustomerDaoImpl=new ICustomerDaoImpl();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");		
		String uname = request.getParameter("uname");
		String option = request.getParameter("optionsRadiosinline");
		String phnumber = request.getParameter("phnumber");		
		String picture = request.getParameter("picture");
		if (account==null||account=="") {
			System.out.println("傻逼");
			request.setAttribute("url", "addCustomer");		
			request.getRequestDispatcher("WEB-INF/content/addCustomer.jsp").forward(request, response);
		}else if (iCustomerDaoImpl.isExist(new Customer(account, password))) {
			request.setAttribute("url", "addCustomer");	
			request.setAttribute("infoAdd", "Exist");	
			request.getRequestDispatcher("WEB-INF/content/addCustomer.jsp").forward(request, response);
		}else {
			int sex=new Integer(option.equals("option1")?1:0);
			Customer customer=new Customer(0, account, password, uname, phnumber, sex, picture);
			iCustomerDaoImpl.insert(customer);
			request.setAttribute("url", "addCustomer");	
			request.setAttribute("infoAdd", "Yes");	
			request.getRequestDispatcher("WEB-INF/content/addCustomer.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

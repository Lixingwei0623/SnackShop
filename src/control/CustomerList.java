/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: CustomerList.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年12月1日 </p>
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


import bean.Customer;
import dao.impl.ICustomerDaoImpl;

/**
 * Servlet implementation class CustomerList
 */
@WebServlet("/customerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICustomerDaoImpl iCustomerDaoImpl=new ICustomerDaoImpl();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wd = request.getParameter("wd");
		String uidString = request.getParameter("uid");
		if (uidString!=null) {
			int uid=new Integer(uidString);
			iCustomerDaoImpl.delete(uid);
		}		
		if (wd==null||wd=="") {
			ArrayList<Customer> customers=iCustomerDaoImpl.getAllCustomer();
			request.setAttribute("customers", customers);
			request.setAttribute("url", "customerList");		
			request.getRequestDispatcher("WEB-INF/content/customerList.jsp").forward(request, response);
		}else {
			ArrayList<Customer> customers=iCustomerDaoImpl.searchCustomers(wd);
			request.setAttribute("customers", customers);
			request.setAttribute("url", "customerList");
			request.getRequestDispatcher("WEB-INF/content/customerList.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: OrderManage.java </p> 
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

import bean.OrderForm;
import bean.Customer;
import dao.impl.IOrderFromDaoImpl;

/**
 * Servlet implementation class OrderManage
 */
@WebServlet("/orderManage")
public class OrderManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderFromDaoImpl iOrderFromDaoImpl=new IOrderFromDaoImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer r=(Customer)request.getSession().getAttribute("customer");
		String info = request.getParameter("info");
		String oidString = request.getParameter("oid");
//		String bridRString = request.getParameter("bridR");
//		String bridCString = request.getParameter("bridC");
		if (r==null) {
			request.setAttribute("url", "login");
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("login").forward(request, response);
		}else {
//			if (bridCString!=null&&bridCString!="") {
//				int bridC=new Integer(bridCString);
//				iOrderFromDaoImpl.continueBw(bridC);
//			}
//			if (bridRString!=null&&bridRString!="") {
//				System.out.println(Integer.valueOf(bridRString));
//				int bridR=Integer.valueOf(bridRString);
//				System.out.println("草泥马");
//				System.out.println(bridR);
//				iOrderFromDaoImpl.returnBw(bridR);
//			}
			if (info!=null&&info!=""&&oidString!=null) {
				int oid=new Integer(oidString);
				if (info.equals("1")) {
					iOrderFromDaoImpl.applyRefund(oid);
				}
				if (info.equals("2")) {
					iOrderFromDaoImpl.pay(oid);
				}
				if (info.equals("3")) {
					iOrderFromDaoImpl.refund(oid);	
				}
			}
			if (!r.isAdmin()) {
				ArrayList<OrderForm> orderForms=iOrderFromDaoImpl.serachByCustomer(r.getUid());
				request.setAttribute("orderForms", orderForms);
				request.setAttribute("url", "orderManage");
				request.getRequestDispatcher("WEB-INF/content/orderManage.jsp").forward(request, response);
			}else {
				ArrayList<OrderForm> orderForms=iOrderFromDaoImpl.getAll();
				request.setAttribute("orderForms", orderForms);
				request.setAttribute("url", "orderManage");
				request.getRequestDispatcher("WEB-INF/content/orderManage.jsp").forward(request, response);
			}		
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

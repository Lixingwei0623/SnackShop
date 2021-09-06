/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: Order.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月30日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderForm;
import bean.Customer;
import dao.impl.IOrderFromDaoImpl;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderFromDaoImpl iOrderFromDaoImpl=new IOrderFromDaoImpl();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidString = request.getParameter("sid");
		String numString = request.getParameter("num1");
		if (sidString!=null&&((Customer)request.getSession().getAttribute("customer"))!=null) {
			int sid=new Integer(sidString);
			int num=new Integer(numString);
			int uid=((Customer)request.getSession().getAttribute("customer")).getUid();
			java.util.Date date=new java.util.Date();
			System.out.println(date.getDate());
			Date ordertime=new Date(date.getYear(),date.getMonth(),date.getDate());
			Date retime=new Date(date.getYear()+1,date.getMonth(),date.getDate());
			iOrderFromDaoImpl.insert(new OrderForm(0, uid, sid, ordertime, 1,num));
			System.out.println(request.getRequestURL());
			request.getRequestDispatcher("orderManage").forward(request, response);
		}else if (((Customer)request.getSession().getAttribute("customer"))==null) {
			request.setAttribute("message", "请先登录");
			request.getRequestDispatcher("login").forward(request, response);
		}else {
			request.getRequestDispatcher("index").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
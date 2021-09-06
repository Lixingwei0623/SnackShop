/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: AddSnack.java </p> 
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

import bean.Snack;
import dao.impl.ISnackDaoImpl;

/**
 * Servlet implementation class AddSnack
 */
@WebServlet("/addSnack")
public class AddSnack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String number = request.getParameter("number");
		String sname = request.getParameter("sname");		
		String producers = request.getParameter("producers");
		String expirationdateString = request.getParameter("expirationdate");
		String category = request.getParameter("category");		
		String intro = request.getParameter("intro");
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		String numString=request.getParameter("num");
		String priceString=request.getParameter("price");
		
		String option= request.getParameter("optionsRadiosinline");
		System.out.println(sname);
		if (sname==null||sname=="") {
			System.out.println("傻逼");
			request.setAttribute("url", "addSnack");		
			request.getRequestDispatcher("WEB-INF/content/addSnack.jsp").forward(request, response);
		}else if (iSnackDaoImpl.isExist(sname)) {
			request.setAttribute("url", "addSnack");	
			request.setAttribute("infoAdd", "Exist");	
			request.getRequestDispatcher("WEB-INF/content/addSnack.jsp").forward(request, response);
		}else {
			Date date=new Date(new Integer(year)-1900, new Integer(month), 1);
			int num=new Integer(numString);
			Double price=new Double(priceString);
			int recommed=new Integer(option.equals("option1")?1:0);
			int expirationdate=new Integer(expirationdateString);
			Snack snack=new Snack(0, sname, producers, category, intro, date,expirationdate, recommed, num, "img/snacks/snack.png",price);
			iSnackDaoImpl.addSnack(snack);
			request.setAttribute("url", "addSnack");	
			request.setAttribute("infoAdd", "Yes");	
			request.getRequestDispatcher("WEB-INF/content/addSnack.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
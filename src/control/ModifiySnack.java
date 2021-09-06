/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: ModifiySnack.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年12月1日 </p>
 * @producers <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @producers: 86135li_xingwei 
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
 * Servlet implementation class ModifiySnack
 */
@WebServlet("/modifiySnack")
public class ModifiySnack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sidString = request.getParameter("sid");
		if (sidString==null||sidString=="") {
			String sname = request.getParameter("sname");
			System.out.println(sname+"好家伙");
			if (sname==null||sname=="") {
				request.getRequestDispatcher("index").forward(request, response);
			}else {
				sname = request.getParameter("sname");		
				String producers = request.getParameter("producers");
				String expirationdateString = request.getParameter("expirationdate");
				String category = request.getParameter("category");		
				String intro = request.getParameter("intro");
				String year=request.getParameter("year");
				String month=request.getParameter("month");
				String day=request.getParameter("date");
				String numString=request.getParameter("num");
				String priceString=request.getParameter("price");
				sidString=request.getParameter("sid2");
				String picture=request.getParameter("picture");
				String option=request.getParameter("optionsRadiosinline");
				
				Date date=new Date(new Integer(year)-1900, new Integer(month)-1, new Integer(day));
				int num=new Integer(numString);
				Double price=new Double(priceString);
				int expirationdate=new Integer(expirationdateString);
				int recommed=new Integer(option.equals("option1")?1:0);
				Snack snack=new Snack(new Integer(sidString), sname, producers, category, intro, date, expirationdate, recommed, num, picture, price);
				iSnackDaoImpl.updateSnack(snack);				
				request.setAttribute("infoUpdate", "Yes");	
				request.getRequestDispatcher("snackList").forward(request, response);
			}
			
			
		}else {
			int sid=new Integer(sidString);
			Snack snack=iSnackDaoImpl.getSnacksById(sid).get(0);
			request.setAttribute("snack", snack);
			request.getRequestDispatcher("WEB-INF/content/modifiySnack.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

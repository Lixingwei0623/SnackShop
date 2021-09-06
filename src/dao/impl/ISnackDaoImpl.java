/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: ISnackDaoImpl.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月30日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import bean.Snack;
import dao.ISnackDao;
import dbutil.DBConnUtil;

/**   
* 
* @ClassName: ISnackDaoImpl.java
* @Description: 该类的功能描述
*
*
*/
public class ISnackDaoImpl implements ISnackDao {
	
	private Connection conn = DBConnUtil.getConn();
	
	
	

	public ISnackDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**   
	* @Function: ISnackDaoImpl.java
	* @Title：main
	* @Description: 
	*
	* @param:@param args
	* @return： void
	*
	*
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Snack snack=(Snack)context.getBean("snack");
		snack.setSid(4);
		Snack snack1=(Snack)context.getBean("snack");
		System.out.println(snack.getSid());
		System.out.println(snack1.getSid());
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#getSnacksByCategory(java.lang.String)
	 */
	@Override
	public ArrayList<Snack> getSnacksByCategory(String cate) {
		String sql = "select sid,sname,producers,category,intro,dateinproduced,expirationdate,recommed,num,picture,price from snack where category=?;";
		PreparedStatement pstmt = null;
		ArrayList<Snack> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, cate);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Snack>();
			while(rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String producers = rs.getString("producers");				
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date dateinproduced = rs.getDate("dateinproduced");
				int expirationdate = rs.getInt("expirationdate");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				double price = rs.getDouble("price");
				Snack snack=new Snack(sid, sname, producers, category, intro, dateinproduced, expirationdate, recommed, num, picture,price);
				
				list.add(snack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#getSnacksByRecommed()
	 */
	@Override
	public ArrayList<Snack> getSnacksByRecommed() {
		String sql = "select sid,sname,producers,category,intro,dateinproduced,expirationdate,recommed,num,picture,price from snack where recommed=1;";
		PreparedStatement pstmt = null;
		ArrayList<Snack> list = null;
		try {
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery();			
			list = new ArrayList<Snack>();
			while(rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String producers = rs.getString("producers");				
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date dateinproduced = rs.getDate("dateinproduced");
				int expirationdate = rs.getInt("expirationdate");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				double price = rs.getDouble("price");
				Snack snack=new Snack(sid, sname, producers, category, intro, dateinproduced, expirationdate, recommed, num, picture,price);
				
				list.add(snack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#isExist(java.lang.String)
	 */
	@Override
	public boolean isExist(String number) {
		String sql = "select sid from snack where sname=?;";
		PreparedStatement pstmt = null;
		int id=-1;
		System.out.println("查询中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, number);			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				id = rs.getInt("bid");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		if (id==-1) {
			return false;
		}
		return true;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#addSnack(bean.Snack)
	 */
	@Override
	public int addSnack(Snack snack) {
		String sql = "insert into snack(sname,producers,category,intro,dateinproduced,expirationdate,recommed,num,picture,price) values(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("添加中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, snack.getSname());
			pstmt.setString(2, snack.getProducers());
			
			pstmt.setString(3, snack.getCategory());
			pstmt.setString(4, snack.getIntro());
			pstmt.setDate(5, snack.getDateinproduced());
			pstmt.setInt(6, snack.getExpirationdate());
			pstmt.setInt(7, snack.getRecommed());
			pstmt.setInt(8, snack.getNum());
			pstmt.setString(9, snack.getPicture());
			pstmt.setDouble(10, snack.getPrice());
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#updateSnack(bean.Snack)
	 */
	@Override
	public int updateSnack(Snack snack) {
		String sql = "update snack set sname=?,producers=?,category=?,intro=?,dateinproduced=?,expirationdate=?,recommed=?,num=?,picture=?,price=? where sid=?;";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("修改中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, snack.getSname());
			pstmt.setString(2, snack.getProducers());
			
			pstmt.setString(3, snack.getCategory());
			pstmt.setString(4, snack.getIntro());
			pstmt.setDate(5, snack.getDateinproduced());
			pstmt.setInt(6, snack.getExpirationdate());
			pstmt.setInt(7, snack.getRecommed());
			pstmt.setInt(8, snack.getNum());
			pstmt.setString(9, snack.getPicture());
			pstmt.setDouble(10, snack.getPrice());
			pstmt.setInt(11, snack.getSid());
			
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#deleteSnack(int)
	 */
	@Override
	public int deleteSnack(int sid) {
		String sql = "delete from snack where sid=?;";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("删除中");
		try {
			pstmt = conn.prepareStatement(sql); 			
			pstmt.setInt(1, sid);			
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#getSnacksById(int)
	 */
	@Override
	public ArrayList<Snack> getSnacksById(int sid) {
		String sql = "select sid,sname,producers,category,intro,dateinproduced,expirationdate,recommed,num,picture,price from snack where sid=?;";
		PreparedStatement pstmt = null;
		ArrayList<Snack> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, sid);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Snack>();
			while(rs.next()) {
				
				String sname = rs.getString("sname");
				String producers = rs.getString("producers");				
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date dateinproduced = rs.getDate("dateinproduced");
				int expirationdate = rs.getInt("expirationdate");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				Double price = rs.getDouble("price");
				
				Snack snack=new Snack(sid, sname, producers, category, intro, dateinproduced, expirationdate, recommed, num, picture,price);
				
				list.add(snack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#getAllSnacks()
	 */
	@Override
	public ArrayList<Snack> getAllSnacks() {
		String sql = "select sid,sname,producers,category,intro,dateinproduced,expirationdate,recommed,num,picture,price from snack;";
		PreparedStatement pstmt = null;
		ArrayList<Snack> list = null;
		try {
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery();			
			list = new ArrayList<Snack>();
			while(rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String producers = rs.getString("producers");				
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date dateinproduced = rs.getDate("dateinproduced");
				int expirationdate = rs.getInt("expirationdate");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				Double price = rs.getDouble("price");
				Snack snack=new Snack(sid, sname, producers, category, intro, dateinproduced, expirationdate, recommed, num, picture, price);
				
				list.add(snack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}




	/* (non-Javadoc)
	 * @see dao.ISnackDao#searchSnacks(java.lang.String)
	 */
	@Override
	public ArrayList<Snack> searchSnacks(String wd) {
		String sql = "select sid,sname,producers,category,intro,dateinproduced,expirationdate,recommed,num,picture,price from snack where sname like ? or producers like ?;";
		PreparedStatement pstmt = null;
		ArrayList<Snack> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, "%"+wd+"%");
			pstmt.setString(2, wd+"%");
			
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Snack>();
			while(rs.next()) {
				int sid = rs.getInt("sid");
				String sname = rs.getString("sname");
				String producers = rs.getString("producers");				
				String category = rs.getString("category");
				String intro = rs.getString("intro");
				Date dateinproduced = rs.getDate("dateinproduced");
				int expirationdate = rs.getInt("expirationdate");
				int recommed = rs.getInt("recommed");
				int num = rs.getInt("num");				
				String picture = rs.getString("picture");
				Double price = rs.getDouble("price");
				Snack snack=new Snack(sid, sname, producers, category, intro, dateinproduced, expirationdate, recommed, num, picture,price);
				
				list.add(snack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}
	

}

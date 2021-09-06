/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: IOrderFromDaoImpl.java </p> 
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


import bean.OrderForm;
import dao.IOrderFromDao;
import dbutil.DBConnUtil;

/**   
* 
* @ClassName: IOrderFromDaoImpl.java
* @Description: 该类的功能描述
*
*
*/
public class IOrderFromDaoImpl implements IOrderFromDao {

	private Connection conn = DBConnUtil.getConn();
	private ISnackDaoImpl iSnackDaoImpl=new ISnackDaoImpl();
	
	public IOrderFromDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#insert(bean.OrderForm)
	 */
	@Override
	public int insert(OrderForm orderForm) {
		String sql = "insert into orderform(uid,sid,ordertime,flag,num) values(?,?,?,?,?);";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("借阅中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, orderForm.getCid());
			pstmt.setInt(2, orderForm.getSid());
			pstmt.setDate(3, orderForm.getOrdertime());
			pstmt.setInt(4, orderForm.getFlag());
			pstmt.setInt(5, orderForm.getNum());
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		String sql2 = "update snack set num=num-? where sid=?;";		
		System.out.println("购买zhong");
		try {
			pstmt = conn.prepareStatement(sql2); 
			pstmt.setInt(1, orderForm.getNum());
			pstmt.setInt(2, orderForm.getSid());
			i = i+pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#serachByCustomer(int)
	 */
	@Override
	public ArrayList<OrderForm> serachByCustomer(int uid) {
		String sql = "select sname,uname,category, oid,orderform.sid,orderform.uid, ordertime, flag,orderform.num from orderform,snack,customer where orderform.sid=snack.sid&&orderform.uid=customer.uid&&orderform.uid=?;";
		PreparedStatement pstmt = null;
		ArrayList<OrderForm> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<OrderForm>();
			while(rs.next()) {
				
				String sname = rs.getString("sname");
				String uname = rs.getString("uname");
							
				String category = rs.getString("category");
				int oid = rs.getInt("oid");
				int sid = rs.getInt("sid");
				int num = rs.getInt("num");
				Date ordertime = rs.getDate("ordertime");
						
				int flag = rs.getInt("flag");				
				
				Double price=iSnackDaoImpl.getSnacksById(sid).get(0).getPrice();
				OrderForm orderForm=new OrderForm(oid, uid, sid, ordertime, flag, uname, sname, category, num, price);
				
				list.add(orderForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#serachBySnack(int)
	 */
	@Override
	public ArrayList<OrderForm> serachBySnack(int sid) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#getAll()
	 */
	@Override
	public ArrayList<OrderForm> getAll() {
		String sql = "select sname,uname,category, oid,orderform.sid,orderform.uid, ordertime, flag, orderform.num from orderform,snack,customer where orderform.sid=snack.sid&&orderform.uid=customer.uid;";
		PreparedStatement pstmt = null;
		ArrayList<OrderForm> list = null;
		try {
			pstmt = conn.prepareStatement(sql); 			
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<OrderForm>();
			while(rs.next()) {
				
				String sname = rs.getString("sname");
				String uname = rs.getString("uname");
							
				String category = rs.getString("category");
				int oid = rs.getInt("oid");
				int sid = rs.getInt("sid");
				int uid = rs.getInt("uid");
				int num = rs.getInt("num");
				Date ordertime = rs.getDate("ordertime");
						
				int flag = rs.getInt("flag");				
				
				Double price=iSnackDaoImpl.getSnacksById(sid).get(0).getPrice();
				System.out.println("price:"+price);
				OrderForm orderForm=new OrderForm(oid, uid, sid, ordertime, flag, uname, sname, category, num, price);
				
				list.add(orderForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#pay(int)
	 */
	@Override
	public int pay(int oid) {
		String sql2 = "update orderform set flag=? where oid=?;";
		PreparedStatement pstmt = null;			
		int i=0;	
		System.out.println("支付");	
		
		try {			
			pstmt = conn.prepareStatement(sql2); 				
			pstmt.setInt(1, 0);				
			pstmt.setInt(2, oid);
			i = i+pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#refund(int)
	 */
	@Override
	public int refund(int oid) {
		String sql2 = "update orderform set flag=? where oid=?;";
		PreparedStatement pstmt = null;			
		int i=0;	
		System.out.println("退款");	
		
		try {			
			pstmt = conn.prepareStatement(sql2); 				
			pstmt.setInt(1, 3);				
			pstmt.setInt(2, oid);
			i = i+pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		String sql3 = "update snack set num=num+? where sid=?;";		
		System.out.println("购买zhong");
		OrderForm orderForm=getOFById(oid);
		try {
			pstmt = conn.prepareStatement(sql3); 
			pstmt.setInt(1, orderForm.getNum());
			pstmt.setInt(2, orderForm.getSid());
			i = i+pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}
	
	public OrderForm getOFById(int oid) {
		String sql = "select sname,uname,category, oid,orderform.sid,orderform.uid, ordertime, flag from orderform,snack,customer where orderform.sid=snack.sid&&orderform.uid=customer.uid;";
		PreparedStatement pstmt = null;
		OrderForm orderForm = null;
		try {
			pstmt = conn.prepareStatement(sql); 			
			ResultSet rs = pstmt.executeQuery();	
			
			
			while(rs.next()) {
				
				String sname = rs.getString("sname");
				String uname = rs.getString("uname");
							
				String category = rs.getString("category");
				
				int sid = rs.getInt("sid");
				int uid = rs.getInt("uid");
				Date ordertime = rs.getDate("ordertime");
						
				int flag = rs.getInt("flag");				
				
				
				orderForm=new OrderForm(oid, uid, sid, ordertime, flag, uname, sname, category);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return orderForm;
	}

	/* (non-Javadoc)
	 * @see dao.IOrderFromDao#applyRefund(int)
	 */
	@Override
	public int applyRefund(int oid) {
		String sql2 = "update orderform set flag=? where oid=?;";
		PreparedStatement pstmt = null;			
		int i=0;	
		System.out.println("申请退款");	
		
		try {			
			pstmt = conn.prepareStatement(sql2); 				
			pstmt.setInt(1, 2);				
			pstmt.setInt(2, oid);
			i = i+pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}
	

}

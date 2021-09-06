/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: ICustomerDaoImpl.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月30日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Customer;

import dao.ICustomerDao;
import dbutil.DBConnUtil;

/**   
* 
* @ClassName: ICustomerDaoImpl.java
* @Description: 该类的功能描述
*
*
*/
public class ICustomerDaoImpl implements ICustomerDao {
	
	private Connection conn = DBConnUtil.getConn();
	
	

	
	public ICustomerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#login(bean.Customer)
	 */
	@Override
	public ArrayList<Customer> login(Customer customer) {
		String sql = "select uid,account,password,uname,phnumber,sex,picture from customer where account=? and password=? and isAdmin=?;";
		PreparedStatement pstmt = null;
		ArrayList<Customer> list = null;
		System.out.println("登录中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, customer.getAccount());
			pstmt.setString(2, customer.getPassword());
			pstmt.setInt(3, customer.isAdmin()?1:0);
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Customer>();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String account=rs.getString("account");
				String password = rs.getString("password");
				String uname = rs.getString("uname");
				String phnumber = rs.getString("phnumber");				
				int sex = rs.getInt("sex");					
				String picture = rs.getString("picture");
				
				Customer customer2=new Customer(uid, account, password, uname, phnumber, sex, picture,customer.isAdmin());
				
				list.add(customer2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#adminLogin(bean.Customer)
	 */
	@Override
	public ArrayList<Customer> adminLogin(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#update(bean.Customer)
	 */
	@Override
	public int update(Customer customer) {
		if (customer==null) {
			return 0;
		}else if (customer.isAdmin()) {
			String sql = "update customer set password=? where account=?;";
			PreparedStatement pstmt = null;			
			System.out.println("修改中admin用户");
			int i=0;
			try {
				pstmt = conn.prepareStatement(sql); 				
				pstmt.setString(1, customer.getPassword());				
				pstmt.setString(2, customer.getAccount());
				i = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnUtil.closeConn(null, null, pstmt, null);
			}
			return i;
		}else {
			String sql = "update customer set password=?,uname=?,sex=?,phnumber=?,picture=? where account=?;";
			PreparedStatement pstmt = null;			
			System.out.println("修改中普通用户");
			int i=0;
			try {
				pstmt = conn.prepareStatement(sql); 
				
				pstmt.setString(1, customer.getPassword());
				pstmt.setString(2, customer.getUname());
				pstmt.setInt(3, customer.getSex());
				pstmt.setString(4, customer.getPhnumber());
				pstmt.setString(5, customer.getPicture());
				pstmt.setString(6, customer.getAccount());
				i = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnUtil.closeConn(null, null, pstmt, null);
			}
			return i;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#isExist(bean.Customer)
	 */
	@Override
	public boolean isExist(Customer customer) {
		String sql = "select uid from customer where account=?;";
		PreparedStatement pstmt = null;
		int id=-1;
		System.out.println("查询中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, customer.getAccount());			
			ResultSet rs = pstmt.executeQuery();	
			
			while(rs.next()) {
				id = rs.getInt("uid");				
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
	 * @see dao.ICustomerDao#insert(bean.Customer)
	 */
	@Override
	public int insert(Customer customer) {
		String sql = "insert into customer(account,password,uname,sex,phnumber,picture,isAdmin) values(?,?,?,?,?,?,0);";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("注册中");
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, customer.getAccount());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getUname());
			pstmt.setInt(4, customer.getSex());
			pstmt.setString(5, customer.getPhnumber());
			pstmt.setString(6, customer.getPicture());
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#getAllCustomer()
	 */
	@Override
	public ArrayList<Customer> getAllCustomer() {
		String sql = "select uid,account,password,uname,phnumber,sex,picture from customer";
		PreparedStatement pstmt = null;
		ArrayList<Customer> list = null;		
		try {
			pstmt = conn.prepareStatement(sql); 			
			ResultSet rs = pstmt.executeQuery();	
			
			list = new ArrayList<Customer>();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String account=rs.getString("account");
				String password = rs.getString("password");
				String uname = rs.getString("uname");
				String phnumber = rs.getString("phnumber");				
				int sex = rs.getInt("sex");					
				String picture = rs.getString("picture");
				
				Customer customer2=new Customer(uid, account, password, uname, phnumber, sex, picture,false);
				
				list.add(customer2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#searchCustomers(java.lang.String)
	 */
	@Override
	public ArrayList<Customer> searchCustomers(String wd) {
		String sql = "select uid,account,password,uname,phnumber,sex,picture from customer where uname like ? or account=?";
		PreparedStatement pstmt = null;
		ArrayList<Customer> list = null;		
		try {
			pstmt = conn.prepareStatement(sql); 	
			pstmt.setString(1, "%"+wd+"%");
			pstmt.setString(2, wd);
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<Customer>();
			while(rs.next()) {
				int uid = rs.getInt("uid");
				String account=rs.getString("account");
				String password = rs.getString("password");
				String uname = rs.getString("uname");
				String phnumber = rs.getString("phnumber");				
				int sex = rs.getInt("sex");					
				String picture = rs.getString("picture");
				
				Customer customer2=new Customer(uid, account, password, uname, phnumber, sex, picture,false);
				
				list.add(customer2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.ICustomerDao#delete(int)
	 */
	@Override
	public int delete(int uid) {
		String sql = "delete from customer where uid=?;";
		PreparedStatement pstmt = null;
		int i=0;
		System.out.println("删除中");
		try {
			pstmt = conn.prepareStatement(sql); 			
			pstmt.setInt(1, uid);			
			i = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnUtil.closeConn(null, null, pstmt, null);
		}
		return i;
	}

}

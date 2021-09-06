/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: ICustomerDao.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月26日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao;

import java.util.ArrayList;

import bean.Customer;

/**   
* 
* @ClassName: ICustomerDao.java
* @Description: 从数据库获取顾客信息
*
*
*/
public interface ICustomerDao {
	ArrayList<Customer> login(Customer customer);
	ArrayList<Customer> adminLogin(Customer customer);
	int update(Customer customer);
	boolean isExist(Customer customer);
	int insert(Customer customer);
	ArrayList<Customer> getAllCustomer();
	
	ArrayList<Customer> searchCustomers(String wd);
	int delete(int uid);

}

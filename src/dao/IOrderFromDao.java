/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: IOrderFromDao.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月26日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao;

import java.util.ArrayList;

import bean.OrderForm;

/**   
* 
* @ClassName: IOrderFromDao.java
* @Description: 从数据库获取订单信息
*
*
*/
public interface IOrderFromDao {
	int insert(OrderForm orderForm);
	ArrayList<OrderForm> serachByCustomer(int uid);
	ArrayList<OrderForm> serachBySnack(int sid);
	ArrayList<OrderForm> getAll();
	int pay(int oid);
	int applyRefund(int oid);
	int refund(int oid);

}

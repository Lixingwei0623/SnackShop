/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: OrderForm.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月26日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package bean;

import java.sql.Date;

/**   
* 
* @ClassName: OrderForm.java
* @Description: 该类的功能描述
*
*
*/
public class OrderForm {
	int oid;
	int cid;
	int sid;
	Date ordertime;
	int flag;
	String cname;
	String sname;
	String category;
	int num;
	Double price;
	
	/**   
	* @Function: OrderForm.java
	* @Description: 该函数的功能描述
	*
	* @param:@param oid
	* @param:@param cid
	* @param:@param sid
	* @param:@param ordertime
	* @param:@param flag
	* @param:@param cname
	* @param:@param sname
	* @param:@param category
	*/
	public OrderForm(int oid, int cid, int sid, Date ordertime, int flag, String cname, String sname,
			String category) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.sid = sid;
		this.ordertime = ordertime;
		this.flag = flag;
		this.cname = cname;
		this.sname = sname;
		this.category = category;
	}
	
	/**   
	* @Function: OrderForm.java
	* @Description: 该函数的功能描述
	*
	* @param:@param oid
	* @param:@param cid
	* @param:@param sid
	* @param:@param ordertime
	* @param:@param flag
	* @param:@param category
	* @param:@param num
	*/
	public OrderForm(int oid, int cid, int sid, Date ordertime, int flag, int num) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.sid = sid;
		this.ordertime = ordertime;
		this.flag = flag;
		this.num = num;
	}

	/**   
	* @Function: OrderForm.java
	* @Description: 该函数的功能描述
	*
	* @param:@param oid
	* @param:@param cid
	* @param:@param sid
	* @param:@param ordertime
	* @param:@param flag
	* @param:@param cname
	* @param:@param sname
	* @param:@param category
	* @param:@param num
	*/
	public OrderForm(int oid, int cid, int sid, Date ordertime, int flag, String cname, String sname, String category,
			int num) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.sid = sid;
		this.ordertime = ordertime;
		this.flag = flag;
		this.cname = cname;
		this.sname = sname;
		this.category = category;
		this.num = num;
	}
	

	/**   
	* @Function: OrderForm.java
	* @Description: 该函数的功能描述
	*
	* @param:@param oid
	* @param:@param cid
	* @param:@param sid
	* @param:@param ordertime
	* @param:@param flag
	* @param:@param cname
	* @param:@param sname
	* @param:@param category
	* @param:@param num
	* @param:@param price
	*/
	public OrderForm(int oid, int cid, int sid, Date ordertime, int flag, String cname, String sname, String category,
			int num, Double price) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.sid = sid;
		this.ordertime = ordertime;
		this.flag = flag;
		this.cname = cname;
		this.sname = sname;
		this.category = category;
		this.num = num;
		this.price = price;
	}

	/**   
	* @Function: OrderForm.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public OrderForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

}

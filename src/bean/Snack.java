/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: Snack.java </p> 
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
* @ClassName: Snack.java
* @Description: 该类的功能描述
*
*
*/
public class Snack {
	private int sid;//Id
	private String sname;//零食名
	private String producers;//产家
	private String category;//分类
	private String intro;//简介
	private Date dateinproduced;//生产日期
	private int expirationdate;//保质期（月）
	private int recommed;//是否推荐  0为不推荐，1为推荐
	private int num;//数量
	private String picture;//封面图片路径
	private double price;//价格
	
	
	/**   
	* @Function: Snack.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public Snack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**   
	* @Function: Snack.java
	* @Description: 该函数的功能描述
	*
	* @param:@param sid
	* @param:@param sname
	* @param:@param producers
	* @param:@param category
	* @param:@param intro
	* @param:@param dateinproduced
	* @param:@param expirationdate
	* @param:@param recommed
	* @param:@param num
	* @param:@param picture
	*/
	public Snack(int sid, String sname, String producers, String category, String intro, Date dateinproduced,
			int expirationdate, int recommed, int num, String picture) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.producers = producers;
		this.category = category;
		this.intro = intro;
		this.dateinproduced = dateinproduced;
		this.expirationdate = expirationdate;
		this.recommed = recommed;
		this.num = num;
		this.picture = picture;
	}
	

	/**   
	* @Function: Snack.java
	* @Description: 该函数的功能描述
	*
	* @param:@param sid
	* @param:@param sname
	* @param:@param producers
	* @param:@param category
	* @param:@param intro
	* @param:@param dateinproduced
	* @param:@param expirationdate
	* @param:@param recommed
	* @param:@param num
	* @param:@param picture
	* @param:@param price
	*/
	public Snack(int sid, String sname, String producers, String category, String intro, Date dateinproduced,
			int expirationdate, int recommed, int num, String picture, double price) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.producers = producers;
		this.category = category;
		this.intro = intro;
		this.dateinproduced = dateinproduced;
		this.expirationdate = expirationdate;
		this.recommed = recommed;
		this.num = num;
		this.picture = picture;
		this.price = price;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getProducers() {
		return producers;
	}
	public void setProducers(String producers) {
		this.producers = producers;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getDateinproduced() {
		return dateinproduced;
	}
	public void setDateinproduced(Date dateinproduced) {
		this.dateinproduced = dateinproduced;
	}
	public int getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(int expirationdate) {
		this.expirationdate = expirationdate;
	}
	public int getRecommed() {
		return recommed;
	}
	public void setRecommed(int recommed) {
		this.recommed = recommed;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

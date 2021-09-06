/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: deviceService.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年12月25日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package beanexp;

/**   
* 
* @ClassName: deviceService.java
* @Description: 该类的功能描述
*
*
*/
public class deviceService {
	public int se=2;
	deviceDao dao;
	public int getSe() {
		return se;
	}
	public void setSe(int se) {
		this.se = se;
	}
	public deviceDao getDao() {
		return dao;
	}
	public void setDao(deviceDao dao) {
		this.dao = dao;
	}
	/**   
	* @Function: deviceService.java
	* @Description: 该函数的功能描述
	*
	* @param:@param se
	* @param:@param dao
	*/
	public deviceService(int se, deviceDao dao) {
		super();
		this.se = se;
		this.dao = dao;
	}
	/**   
	* @Function: deviceService.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public deviceService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: deviceWeb.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年12月25日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package beanexp;

/**   
* 
* @ClassName: deviceWeb.java
* @Description: 该类的功能描述
*
*
*/
public class deviceWeb {
	public int we=3;
	
	deviceService service;
	
	public int getWe() {
		return we;
	}
	public void setWe(int we) {
		this.we = we;
	}
	public deviceService getService() {
		return service;
	}
	public void setService(deviceService service) {
		this.service = service;
	}
	/**   
	* @Function: deviceWeb.java
	* @Description: 该函数的功能描述
	*
	* @param:@param we
	* @param:@param service
	*/
	public deviceWeb(int we, deviceService service) {
		super();
		this.we = we;
		this.service = service;
	}
	/**   
	* @Function: deviceWeb.java
	* @Description: 该函数的功能描述
	*
	* @param:
	*/
	public deviceWeb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

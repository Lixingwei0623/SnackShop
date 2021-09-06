/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: expforspring.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年12月25日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package exp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beanexp.deviceWeb;

/**   
* 
* @ClassName: expforspring.java
* @Description: 该类的功能描述
*
*
*/
public class expforspring {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		deviceWeb web=(deviceWeb)context.getBean("web");
		System.out.println(web.getService().getDao().getA());
	}

}

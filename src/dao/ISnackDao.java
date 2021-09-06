/**   
 * 
 * <p>NameOfProject: SnackShop </p> 
 * <p>NameOfFile: ISnackDao.java </p> 
 * <p>descripsion:  </p>
 * <p>date: 2020年11月26日 </p>
 * @author <a href="mail to: li_xing_wei@qq.com.com" rel="nofollow">lxw</a>
 * @version: v1.0.0
 * @author: 86135li_xingwei 
 */
package dao;

import java.util.ArrayList;

import bean.Snack;

/**   
* 
* @ClassName: ISnackDao.java
* @Description: 从数据库获取零食信息
*
*
*/
public interface ISnackDao {
	ArrayList<Snack> getSnacksByCategory(String cate);
	ArrayList<Snack> getSnacksByRecommed();
	boolean isExist(String number);
	int addSnack(Snack snack);
	int updateSnack(Snack snack);
	int deleteSnack(int sid);
	ArrayList<Snack> getSnacksById(int sid);
	ArrayList<Snack> getAllSnacks();
	ArrayList<Snack> searchSnacks(String wd);

}

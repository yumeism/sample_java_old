package etudes;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ページを表示させるだけのアクションクラス
 * 
 * @author k
 */
public class Hello extends ActionSupport {

	public String showPage(){
		
		return ActionSupport.SUCCESS;
	}
}
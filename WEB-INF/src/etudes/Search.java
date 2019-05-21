package etudes;

import java.util.LinkedHashMap;

import com.opensymphony.xwork2.ActionSupport;

import etudes.common.Dao;
import etudes.common.Message;

/**
 * 入力されたキーワードで部分一致検索を行うクラス
 * 
 * @author k
 */
public class Search {

	private String word;
	private String addr;
	private boolean flg;
	
	private String msg;
	private LinkedHashMap<String, String> list;

	/**
	 * 
	 * @return
	 */
	public String searchLandMark(){
		
		flg = false;
		list = null;
		
	//入力値のチェック
		if( word == null || word.equals("")){
			setMsg("Message_02"); 
			return ActionSupport.SUCCESS;
		}

		Dao dao = new Dao();

		try{
			list = dao.findLandMark(word);
			
		
		} catch(Exception e){
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
		
	//検索後の表示
		if(list == null){
			setMsg("Message_01"); 
			
		} else{
			flg = true;
		}
		return ActionSupport.SUCCESS;
	}


	/**
	 * @return word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word セットする word
	 */
	public void setWord(String word) {
		this.word = word;
	}	

	/**
	 * @return addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr セットする addr
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return flg
	 */
	public boolean getFlg() {
		return flg;
	}

	/**
	 * @param flg セットする flg
	 */
	public void setFlg(boolean flg) {
		this.flg = flg;
	}

	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg セットする msg
	 */
	public void setMsg(String str) {
		Message msg = new Message();
		this.msg = msg.loadMsg(str);
	}
	
	/**
	 * @return list
	 */
	public LinkedHashMap<String, String> getList() {
		return list;
	}

	/**
	 * @param landmark セットする list
	 */
	public void setList(LinkedHashMap<String, String> list) {
		this.list = list;
	}
	/**
	 * @return error
	 */

}

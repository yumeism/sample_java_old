package etudes;

import java.util.LinkedHashMap;

import com.opensymphony.xwork2.ActionSupport;

import etudes.common.Dao;

/**
 * ランドマーク一覧を取得するクラス
 * 
 * @author k
 */
public class ShowList {

	private LinkedHashMap<Integer, String[]> list;
	
	/**
	 * ランドマーク一覧を取得
	 * 
	 * @return
	 */
	public String showLandMarkList(){
		
		Dao dao = new Dao();
		
		try{
			list = dao.getLandMarkList();
		
		} catch(Exception e){
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	/**
	 * @return list
	 */
	public LinkedHashMap<Integer, String[]> getList() {
		return list;
	}

	/**
	 * @param list セットする list
	 */
	public void setList(LinkedHashMap<Integer, String[]> list) {
		this.list = list;
	}


}

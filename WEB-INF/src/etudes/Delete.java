package etudes;

import com.opensymphony.xwork2.ActionSupport;

import etudes.common.Dao;

public class Delete {

	private int id = 0;

	public String delData(){
		
		if( id == 0 ){
			return ActionSupport.ERROR;
		}
		
		Dao dao = new Dao();
		
		try{
			dao.delData("landmark", id);
		
		} catch(Exception e){
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
}

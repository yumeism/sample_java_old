package etudes;

import com.opensymphony.xwork2.ActionSupport;

import etudes.common.Dao;
import etudes.common.Message;


public class RegLandMark {

	private String[] data;

	private String name;
	private String addr;
	private String lat;
	private String lng;

	private String err;
	private String error;
	
	public String regLandMark(){
		
		data = new String[4];

		
	//入力値のチェック
		String errMsg = "";

		if( name == null || name.equals("")){
			setErr("ErrMessage_05"); 
			errMsg += err + "<br />";
		}
		
		if( addr == null || addr.equals("")){
			setErr("ErrMessage_03"); 
			errMsg += err + "<br />";
			
		} else if( lat == null || lat.equals("")){
			setErr("ErrMessage_04"); 
			errMsg += err + "<br />";
		}
		
		if(!errMsg.equals("")){
			error = errMsg;
			return ActionSupport.ERROR;
		}
		
		
		data[0] = name;
		data[1] = addr;
		data[2] = lat;
		data[3] = lng;
		
		Dao dao = new Dao();
		
		try{
			dao.addLandMark(data);
		
		} catch(Exception e){
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}


	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat セットする lat
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng セットする lng
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return error
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * @param error セットする err
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @param err セットする err
	 */
	public void setErr(String err) {
		Message msg = new Message();
		this.err = msg.loadMsg(err);
	}

	
}

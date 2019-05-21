package etudes.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;


/**
 * クエリ生成、実行クラス
 * 
 * @author k
 */
public class Dao {

	private String sql;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	/**
	 * ランドマークデータ取得
	 * @return list
	 * @throws SQLException
	 * @throws Exception
	 */
	public LinkedHashMap<Integer, String[]> getLandMarkList() throws SQLException, Exception {

		ConnectDB db = new ConnectDB();

		LinkedHashMap<Integer, String[]> list = new LinkedHashMap<Integer, String[]>();
		int key;
		String[] val;
		
		sql  = "";
		sql += "SELECT";
		sql += " id";
		sql += ",name";
		sql += ",addr";
		sql += " FROM etudes.landmark";
		sql += ";";

		try {
			db.open();
			db.preparedStatement(sql);
			db.executeQuery();
			rs = db.getResultset();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		while(rs.next()){
			
			val = new String[2];

			key = rs.getInt("id");
			val[0] = rs.getString("name");
			val[1] = rs.getString("addr");
			list.put(key, val);
		}

		
		try {
			db.closeResultSet();
			db.closePreparedStatement();
			db.close();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	
	
	/**
	 * ランドマークを登録する
	 * 
	 * @param data
	 * @throws SQLException
	 * @throws Exception
	 */
	public void addLandMark(String[] data) throws SQLException, Exception {
		
		ConnectDB db = new ConnectDB();
		int chk = 0;
		
		sql  = "";
		sql += "INSERT INTO";
		sql += " etudes.landmark";
		sql += "(";
		sql += " id";
		sql += ",name";
		sql += ",addr";
		sql += ",lat";
		sql += ",lng";
		sql += ")";
		sql += "VALUES";
		sql += "(";
		sql += " null" ;
		sql += ",?" ;
		sql += ",?" ;
		sql += ",?" ;
		sql += ",?" ;
		sql += ")";
		sql += ";";

		try {
			db.open();
			db.preparedStatement(sql);
			ps = db.getPreparedStatement();

			ps.setString(1, data[0]);
			ps.setString(2, data[1]);
			ps.setString(3, data[2]);
			ps.setString(4, data[3]);
			
			chk = db.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		
		if(chk == 1){
			try {
				db.dbCommit();
				
			} catch (Exception e) {
				db.dbRollback();
				e.printStackTrace();
				throw e;
			}
		}


		try {
			db.closePreparedStatement();
			db.close();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	/**
	 * 登録データの削除
	 * 
	 * @param table
	 * @param id
	 * @throws SQLException
	 * @throws Exception
	 */
	public void delData(String table, int id) throws SQLException, Exception{

		ConnectDB db = new ConnectDB();
		int chk = 0;
		
		sql  = "";
		sql += "DELETE";
		sql += " FROM etudes." + table;
		sql += " WHERE id= ?";
		sql += ";";


		try {
			db.open();
			db.preparedStatement(sql);
			ps = db.getPreparedStatement();
			ps.setInt(1, id);

			chk = db.executeUpdate();

  		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		if(chk == 1){
			try {
				db.dbCommit();

			} catch (Exception e) {
				db.dbRollback();
				e.printStackTrace();
				throw e;
			}
		}

		try {
			db.closePreparedStatement();
			db.close();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * ランドマークを都道府県、市町村区で住所検索
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public LinkedHashMap<String, String> findLandMark(String word) throws SQLException, Exception {

		ConnectDB db = new ConnectDB();

		LinkedHashMap<String, String> list = new LinkedHashMap<String, String>();
		String key;
		String val;
		
		sql  = "";
		sql += "SELECT";
		sql += " name";
		sql += ",addr";
		sql += " FROM etudes.landmark";
		sql += " WHERE name LIKE ?";
		sql += " OR addr LIKE ?";
		sql += ";";
		
		
		try {
			db.open();
			db.preparedStatement(sql);
			ps = db.getPreparedStatement();
			ps.setString(1, "%"+word+"%");
			ps.setString(2, "%"+word+"%");
			db.executeQuery();
			rs = db.getResultset();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		int cnt = 0;
		boolean flg = true;
		
		while(rs.next()){
			
			if(cnt != 0) flg = false;

			key = rs.getString("name");
			val = rs.getString("addr");
			list.put(key, val);
			cnt++;
		}
		
		try {
			db.closeResultSet();
			db.closePreparedStatement();
			db.close();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		if(flg) return null;
		
		return list;
	}


}

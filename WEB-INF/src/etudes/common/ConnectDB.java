package etudes.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * データベース操作クラス
 * 
 * @author kato
 * @since 2013.07.26
 */
public class ConnectDB {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private String FILE_NAME = "etudes.properties";

    
    /**
     * コネクション生成
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void open() throws SQLException, ClassNotFoundException {

    // プロパティファイル読み込み
    	final Properties prop = new Properties();
    	InputStream inStream = null;
    	
    	try {
    		inStream = ConnectDB.class.getClassLoader().getResourceAsStream( FILE_NAME );
    		
    		if (inStream == null) {
                throw new IllegalArgumentException( FILE_NAME + "読み込み失敗");
            }
            
            prop.load(inStream);
            
            final String db_url  = prop.getProperty("db_url");
            final String db_user = prop.getProperty("db_user");
            final String db_pass = prop.getProperty("db_pass");

            
         // コネクション生成
    	    try {
    	    	Class.forName("com.mysql.jdbc.Driver");
    	    	con = DriverManager.getConnection(db_url,db_user,db_pass);

    	    } catch (ClassNotFoundException ce) {
		    	
    	    	try {
		    		if(con != null){
		    			con.close();
		    		}		    		
    		    } catch (Exception e) {}
		    	ce.printStackTrace();

    	    } catch (SQLException se) {
		    	try {
		    		if(con != null){
		    			con.close();
		    		}
    		    } catch (Exception e) {}
		    	se.printStackTrace();
            	throw se;
            	
    	    } catch (Exception e) {
		    	try {
		    		if(con != null){
		    			con.close();
		    		}
    		    } catch (Exception ee) {}
		    	e.printStackTrace();
    	    }

    	    
    	 // オートコミット解除
    	    try {
    	      con.setAutoCommit(false);
    	      
    	    } catch (Exception e) {
		    	e.printStackTrace();
    	    }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {}
        }

    } // ここまでプロパティファイル読み込み

    
    
    /**
     * 
     * @return Connection
     */
    public Connection getConnection(){
    	return con;
    }

    
    /**
     * コネクションクローズ
     * @throws Exception
     */
    public void close() throws Exception {
     	
    	try{
 		    if ( con != null ){
 		    	con.close();
 		    }

     	} catch (Exception e) {
 			e.printStackTrace();
	    	throw e;
 		}
     }


    
    /**
     * 
     * @param sql
     * @throws SQLException
     */
    public void preparedStatement(String sql) throws SQLException {
    	ps =  con.prepareStatement(sql);
    }

    /**
     * 
     * @return ps
     */
    public PreparedStatement getPreparedStatement() {
    	return ps;
    }

    /**
     * 
     * @throws Exception
     */
    public void closePreparedStatement() throws Exception {
    
    	try {
    		if ( ps != null ){
    			ps.close();
    		}

    	} catch (Exception e) {
			e.printStackTrace();
	    	throw e;
    	}
     }


    
    /**
     * 検索クエリ実行
     * 
     * @throws SQLException
     */
    public void executeQuery() throws SQLException {
        rs = ps.executeQuery();
    }

    /**
     * ResultSetの取得
     * 
     * @return rs
     */
    public ResultSet getResultset() {
        return rs;
    }

    /**
     * 
     * @throws Exception
     */
    public void closeResultSet() throws Exception {
    	
    	try {
    		if ( rs != null ){
    			rs.close();
    		}
    		
    	} catch (Exception e) {
			e.printStackTrace();
			throw e;
    	}
     }

    
    
    /**
     * 更新系クエリ実行
     * 
     * @return 実行数
     * @throws SQLException
     */
    public int executeUpdate() throws SQLException {

    	return ps.executeUpdate();
    }

    /**
     * コミット
	 * @throws SQLException
     */
	public void dbCommit() throws SQLException {

		try {
			con.commit();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
	}

	/**
	 * ロールバック
	 * @throws SQLException
	 */
	public void dbRollback() throws SQLException {

		try {
			con.rollback();

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
	}


}


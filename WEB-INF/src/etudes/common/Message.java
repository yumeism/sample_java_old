package etudes.common;

import java.io.InputStream;
import java.util.Properties;

/**
 * プロパティファイルからエラーメッセージを読み込み、返却するクラス
 * 
 * @author k
 */
public class Message {

	private String msg;
	private final String FILE_NAME = "etudes.properties";


	/**
	 * エラーメッセージの読み込み
	 * 
	 * @param errCode
	 * @return msg
	 */
	public String loadMsg(String errCode){

		// プロパティファイル読み込み
		final Properties prop = new Properties();
		InputStream inStream = null;

		try {
			// プロパティファイルをロードする
			inStream = Message.class.getClassLoader().getResourceAsStream( FILE_NAME );

			// プロパティフィル読み込みチェック
			if (inStream == null) {
				throw new IllegalArgumentException( FILE_NAME + "の読み込みに失敗");
			}
			prop.load(inStream);

			// message 取得
			msg = prop.getProperty( errCode );

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}

}

/**
 * 
 */
package net.l8nk.data;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.l8nk.common.Constants;

/**
 * @author thuc.le
 *
 */
public class DataConnection {

	public static Connection getConnection() {
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context.lookup(Constants.DATA_SOURCE_JNDI);
			Connection connection = source.getConnection();
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}

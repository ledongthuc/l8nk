/**
 * 
 */
package net.l8nk.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



/**
 * @author ledongthuc
 *
 */
public class LinkService {
	
	public static String getLinksByUserId() {
		try {
			InitialContext cxt = new InitialContext();
			DataSource ds = (DataSource) cxt.lookup( "java:comp/env/jdbc/l8nkDb" );
			Connection connection = ds.getConnection();
			PreparedStatement statmement = connection.prepareStatement("");
			ResultSet rs = statmement.executeQuery("select * from `link`");
			String longLink = "";
			while(rs.next()) {
				longLink = rs.getString("longLink");
			}
			
			return longLink;
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
		//return "";
	}
	
}

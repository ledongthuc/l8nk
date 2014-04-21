/**
 * 
 */
package net.l8nk.data;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author thuc.le
 *
 */
public class ContactData {
	
	public void createContact(String name, String email, String content) {
		try {
			Connection connection = DataConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `contact` (`name`,`email`,`content`) VALUES (?, ?, ?);");
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, content);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}

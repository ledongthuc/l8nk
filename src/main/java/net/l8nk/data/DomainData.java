/**
 * 
 */
package net.l8nk.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.l8nk.entity.Domain;

/**
 * @author thuc.le
 *
 */
public class DomainData extends DataProviderBase<Domain> {
	private final String INSERT_IF_NOT_EXIST = "INSERT IGNORE INTO `domain` SET `value` = ?; "
											 + "SELECT * FROM `domain` WHERE `value` = ?";
	
	public Domain insertIfNotExist(Domain domain) {
		
		try {
			Connection connection = DataConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(INSERT_IF_NOT_EXIST);
			statement.setString(1, domain.getValue());
			statement.setString(2, domain.getValue());
			
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Domain> domains = fillData(resultSet);
			
			if(domains.isEmpty()) {
				domain.setDomainId(NULL_ID);
			} else {
				domain = domains.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			domain.setDomainId(NULL_ID);
		}
		
		return domain;
	}
	
	@Override
	protected ArrayList<Domain> fillData(ResultSet resultSet) throws SQLException {
		ArrayList<Domain> domains = new ArrayList<Domain>();
		while(resultSet.next()) {
			try {
				Domain domain = new Domain();
				
				int domainId = resultSet.getInt("domainId");
				domain.setDomainId(domainId);
				String value = resultSet.getString("value");
				domain.setValue(value);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return domains;
	}
	
}

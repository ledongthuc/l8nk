/**
 * 
 */
package net.l8nk.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.l8nk.entity.Domain;

/**
 * @author thuc.le
 *
 */
public class DomainData extends DataProviderBase<Domain> {
	
	public Domain insertIfNotExist(Domain domain) {
		
		try {
			Connection connection = DataConnection.getConnection();
			
			CallableStatement statement = connection.prepareCall("call Domain_InsertIfNotExist(?)");
			statement.setString(1, domain.getValue());
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<Domain> domains = fillData(resultSet);
			System.out.println("Thuc domains length: " + domains.size());
			
			if(domains.isEmpty()) {
				domain.setDomainId(NULL_ID);
			} else {
				domain = domains.get(0);
			}
			
			System.out.println("Thuc domains id: " + domain.getDomainId());
			System.out.println("Thuc domains value: " + domain.getValue());
			
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
				
				System.out.println("Thuc id result: " + domainId);
				System.out.println("Thuc value result: " + value);
				
				domains.add(domain);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return domains;
	}
	
}

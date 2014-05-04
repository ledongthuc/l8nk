/**
 * 
 */
package net.l8nk.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import net.l8nk.controller.FeedbackController;
import net.l8nk.entity.Domain;

/**
 * @author thuc.le
 *
 */
public class DomainData extends DataProviderBase<Domain> {
	
	static Logger logger = Logger.getLogger(DomainData.class);
	
	public Domain insertIfNotExist(Domain domain) throws SQLException {
		Connection connection = null;
		
		try {
			connection = DataConnection.getConnection();
			
			CallableStatement statement = connection.prepareCall("call Domain_InsertIfNotExist(?)");
			statement.setString(1, domain.getValue());
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<Domain> domains = fillData(resultSet);
			logger.info("Thuc domains length: " + domains.size());
			
			if(domains.isEmpty()) {
				domain.setDomainId(NULL_ID);
			} else {
				domain = domains.get(0);
			}
			
			logger.info("Thuc domains id: " + domain.getDomainId());
			logger.info("Thuc domains value: " + domain.getValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			domain.setDomainId(NULL_ID);
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
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
				
				logger.info("Thuc id result: " + domainId);
				logger.info("Thuc value result: " + value);
				
				domains.add(domain);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return domains;
	}
	
}

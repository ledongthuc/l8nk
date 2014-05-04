/**
 * 
 */
package net.l8nk.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import net.l8nk.common.L8nkEncoding;
import net.l8nk.entity.Link;



/**
 * @author ledongthuc
 *
 */
public class LinkData extends DataProviderBase<Link> {
	
	static Logger logger = Logger.getLogger(LinkData.class);
	
	public Link insertIfNotExist(Link link) throws SQLException {
		Connection connection = null;
		
		try {
			connection = DataConnection.getConnection();
			
			CallableStatement statement = connection.prepareCall("call Link_InsertIfNotExist(?, ?, ?, ?, ?, ?)");
			statement.setString(1, link.getLongLink());
			statement.setInt(2, link.getDomainId());
			statement.setInt(3, link.getClicks());
			statement.setDate(4, link.getCreatedDate());
			statement.setString(5, link.getDescription());
			statement.setString(6, link.getHashLink());
			
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Link> links = fillData(resultSet);
			
			logger.info("Thuc links length: " + links.size());
			
			if(links.isEmpty()) {
				link.setLinkId(NULL_ID);
			} else {
				link = links.get(0);
			}
			
			logger.info("Thuc links link id: " + link.getLinkId());
			logger.info("Thuc links getLongLink: " + link.getLongLink());
			
		} catch (Exception e) {
			e.printStackTrace();
			link.setLinkId(NULL_ID);
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
		return link;
	}
	
	@Override
	public ArrayList<Link> fillData(ResultSet resultSet) throws SQLException {
		ArrayList<Link> links = new ArrayList<Link>();
		while(resultSet.next()) {
			try {
				Link link = new Link();
				
				long linkId = resultSet.getLong("linkId");
				link.setLinkId(linkId);
				String longLink = resultSet.getString("longLink");
				link.setLongLink(longLink);
				int domainId = resultSet.getInt("domainId");
				link.setDomainId(domainId);
				int clicks = resultSet.getInt("clicks");
				link.setClicks(clicks);
				Date createdDate = resultSet.getDate("createdDate");
				link.setCreatedDate(createdDate);
				Date lastAccessed = resultSet.getDate("lastAccessed");
				link.setLastAccessed(lastAccessed);
				String description = resultSet.getString("description");
				link.setDescription(description);
				String encodedPart = L8nkEncoding.encode(linkId);
				link.setEncodedPart(encodedPart);
				
				
				links.add(link);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return links;
	}
	
	public Link getLinkById(long linkId) throws SQLException {
		Connection connection = null;
		try {
			connection = DataConnection.getConnection();
			
			CallableStatement statement = connection.prepareCall("call Link_GetById(?)");
			statement.setObject(1, linkId, Types.BIGINT);
			
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Link> links = fillData(resultSet);
			
			if(links != null && links.size() > 0) {
				return links.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
		return null;
	}
	
	public static String getLinksByUserId() throws SQLException {
		Connection connection = null;
		try {
			connection = DataConnection.getConnection();
			PreparedStatement statmement = connection.prepareStatement("");
			ResultSet rs = statmement.executeQuery("select * from `link`");
			String longLink = "";
			while(rs.next()) {
				longLink = rs.getString("longLink");
			}
			
			return longLink;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
		return "";
	}
	
	public ArrayList<Link> getByUserAgent(String userAgent) throws SQLException {
		Connection connection = null;
		try {
			connection = DataConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("select link.* from `link`, `linkowner` "
															+ "where link.linkId = linkowner.linkId "
															+ "and linkowner.userAgent = '" + userAgent + "'"
															+ "order by linkowner.id desc");
			ResultSet resultSet = statement.executeQuery();
			
			ArrayList<Link> links = fillData(resultSet);
			
			return links;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
		return null;
	}
	
	public void saveLinkToUser(long linkId, String userAgent) throws SQLException {
		Connection connection = null;
		try {
			connection = DataConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("INSERT IGNORE INTO `linkowner` SET `linkId` = ?, `userAgent` = ?;");
			statement.setObject(1, linkId, Types.BIGINT);
			statement.setString(2, userAgent);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}
	
	public void increaseCounter(long linkId) throws SQLException {
		Connection connection = null;
		try {
			connection = DataConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("UPDATE `link` SET `clicks` = `clicks` + 1 WHERE linkId = ?");
			statement.setObject(1, linkId, Types.BIGINT);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}
	
	public void logRequest(String userAgent, long linkId) throws SQLException {
		Connection connection = null;
		try {
			connection = DataConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO `request` (`userAgent`, `requestDate`, `linkId`) VALUES (?, NOW(), ?);");
			statement.setString(1, userAgent);
			statement.setObject(2, linkId, Types.BIGINT);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}
}

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
import java.util.ArrayList;

import net.l8nk.entity.Link;



/**
 * @author ledongthuc
 *
 */
public class LinkData extends DataProviderBase<Link> {
	
	public Link insertIfNotExist(Link link) {
		
		try {
			Connection connection = DataConnection.getConnection();
			
			CallableStatement statement = connection.prepareCall("call Link_InsertIfNotExist(?, ?, ?, ?, ?, ?)");
			statement.setString(1, link.getLongLink());
			statement.setInt(2, link.getDomainId());
			statement.setInt(3, link.getClicks());
			statement.setDate(4, link.getCreatedDate());
			statement.setString(5, link.getDescription());
			statement.setString(6, link.getHashLink());
			
			ResultSet resultSet = statement.executeQuery();
			ArrayList<Link> links = fillData(resultSet);
			
			System.out.println("Thuc links length: " + links.size());
			
			if(links.isEmpty()) {
				link.setLinkId(NULL_ID);
			} else {
				link = links.get(0);
			}
			
			System.out.println("Thuc links link id: " + link.getLinkId());
			System.out.println("Thuc links getLongLink: " + link.getLongLink());
			
		} catch (Exception e) {
			e.printStackTrace();
			link.setLinkId(NULL_ID);
		}
		
		return link;
	}
	
	@Override
	public ArrayList<Link> fillData(ResultSet resultSet) throws SQLException {
		ArrayList<Link> links = new ArrayList<Link>();
		while(resultSet.next()) {
			try {
				Link link = new Link();
				
				int linkId = resultSet.getInt("linkId");
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
				
				links.add(link);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return links;
	}
	
	public static String getLinksByUserId() {
		try {
			Connection connection = DataConnection.getConnection();
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
		}
		
		return "";
	}
	
}

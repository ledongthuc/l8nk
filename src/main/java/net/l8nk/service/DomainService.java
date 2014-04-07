/**
 * 
 */
package net.l8nk.service;

import java.net.URI;
import java.net.URISyntaxException;

import net.l8nk.data.DataRepository;
import net.l8nk.entity.Domain;

/**
 * @author thuc.le
 *
 */
public class DomainService {

	public static final String SCHEMA_SEPERATOR = "://";
	
	public static Domain createDomain(String domainValue) {
		Domain result = new Domain();
		result.setValue(domainValue);		
		result = DataRepository.getDomainData().insertIfNotExist(result);
		return result;
	}
	
	public static Domain createDomain(String schema, String host) {
		String domain = schema + SCHEMA_SEPERATOR + host;
		return createDomain(domain);
	}
	
	public static Domain createDomainFromLink(String longLink) {
		Domain domain = null;
		
		try {
			URI url = new URI(longLink);
			String schema = url.getScheme();
			String host = url.getAuthority();
			domain = DomainService.createDomain(schema, host);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			domain = createDomain(longLink);
		}
		
		return domain;
	}
}

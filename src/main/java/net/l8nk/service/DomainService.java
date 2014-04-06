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

	public static Domain createDomain(String domainValue) {
		Domain result = new Domain();
		result.setValue(domainValue);		
		result = DataRepository.getDomainData().insertIfNotExist(result);
		return result;
	}
	
	public static Domain createDomain(String schema, String authority) {
		String domain = schema + authority;
		return createDomain(domain);
	}
	
	public static Domain createDomainFromLink(String longLink) {
		Domain domain = null;
		
		try {
			URI url = new URI(longLink);
			String schema = url.getHost();
			String authority = url.getAuthority();
			domain = DomainService.createDomain(schema, authority);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			domain = createDomain(longLink);
		}
		
		return domain;
	}
}

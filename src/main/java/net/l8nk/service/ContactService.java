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
public class ContactService {

	public static void createFeedback(String name, String email, String content) {
		DataRepository.getFeedbackData().createFeedback(name, email, content);
	}
}

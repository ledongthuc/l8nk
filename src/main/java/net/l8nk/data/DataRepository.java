package net.l8nk.data;

public class DataRepository {
	
	private static LinkData linkData;
	public static LinkData getLinkData() {
		if(linkData == null) {
			linkData = new LinkData();
		}
		return linkData;
	}

	
	private static DomainData domainData;
	public static DomainData getDomainData() {
		if(domainData == null) {
			domainData = new DomainData();
		}
		return domainData;
	}
	
	private static ContactData contactData;
	public static ContactData getFeedbackData() {
		if(contactData == null) {
			contactData = new ContactData();
		}
		return contactData;
	}
}

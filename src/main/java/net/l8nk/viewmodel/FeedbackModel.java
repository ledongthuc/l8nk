/**
 * 
 */
package net.l8nk.viewmodel;

/**
 * @author thuc.le
 *
 */
public class FeedbackModel {
	private String name;
	
	private String email;
	
	private String content;
	
	private String message;
	
	private boolean isSuccess;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean hasError() {
		return !isSuccess && message != null && !message.isEmpty();
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %s, Email: %s, Content: %s",  this.getName(), this.getEmail(), this.getContent());
	}
}

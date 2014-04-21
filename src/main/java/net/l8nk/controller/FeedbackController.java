package net.l8nk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.l8nk.common.Constants;
import net.l8nk.entity.Link;
import net.l8nk.service.ContactService;
import net.l8nk.viewmodel.FeedbackModel;
import net.l8nk.viewmodel.HomeModel;

@WebServlet(name="FeedbackController", urlPatterns="/App/Feedback")
public class FeedbackController extends HttpServlet  {

	public static final String VIEW = "/jsp/feedback.jsp";
	private final String NAME_IS_EMPTY = "Please fill your name";
	private final String MAX_NAME_LENGTH = "Your name is too long, we only support 50 characters";
	private final String EMAIL_IS_EMPTY = "Please fill your email";
	private final String MAX_EMAIL_LENGTH = "Your email is too long, we only support 200 characters";
	private final String CONTENT_IS_EMPTY = "Please fill your contact's content";
	private final String MAX_CONTENT_LENGTH = "Your content is too long, we only support 500 characters";
	private final String ERROR_MESSAGE = "Some problem occurs, please try again";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6461154124222688385L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ContactController process");
		this.handleView(VIEW, request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		FeedbackModel model = this.composeFeedbackData(request, name, email, content);
		
		try {
			String errorMessage = "";
			boolean isValid = validateContact(model, errorMessage);
			model.setErrorMessage(errorMessage);
			
			if(isValid) {
				ContactService.createContact(name, email, content);
				model.setSuccess(true);
			} else {
				model.setSuccess(false);
			}
			
		} catch(Exception ex) {
			model.setSuccess(false);
			model.setErrorMessage(ERROR_MESSAGE);
		}
		
		request.setAttribute(Constants.PARAM_MODEL, model);
		this.doGet(request, response);
	}
	
	private void handleView(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}
	
	private boolean validateContact(FeedbackModel model, String errorMessage) {
		if(model.getName() == null || model.getName().isEmpty()) {
			errorMessage = NAME_IS_EMPTY;
			return false;
		} else if (model.getName().length() > 50) {
			errorMessage = MAX_NAME_LENGTH;
			return false;
		}
		
		if(model.getEmail() == null || model.getEmail().isEmpty()) {
			errorMessage = EMAIL_IS_EMPTY;
			return false;
		} else if (model.getEmail().length() > 200) {
			errorMessage = MAX_EMAIL_LENGTH;
			return false;
		}
		
		if(model.getContent() == null || model.getContent().isEmpty()) {
			errorMessage = CONTENT_IS_EMPTY;
			return false;
		} else if (model.getContent().length() > 500) {
			errorMessage = MAX_CONTENT_LENGTH;
			return false;
		}
		
		return true;
	}
	
	private FeedbackModel composeFeedbackData(HttpServletRequest request, String name, String email, String content) {
		FeedbackModel model = new FeedbackModel();
		model.setName(name);
		model.setEmail(email);
		model.setContent(content);
		
		return model;
	}
	
}

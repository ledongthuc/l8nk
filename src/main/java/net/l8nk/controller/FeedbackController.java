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
	private final String CONTENT_IS_EMPTY = "Please fill your feedback";
	private final String MAX_CONTENT_LENGTH = "Your content is too long, we only support 500 characters";
	private final String ERROR_MESSAGE = "Some problem occurs, please try again";
	private final String SUCESSFUL_MESSAGE = "We received your feedback!!! Thank you.";
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6461154124222688385L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FeedbackController GET process");
		this.handleView(VIEW, request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FeedbackController POST process");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		FeedbackModel model = this.composeFeedbackData(request, name, email, content);
		
		System.out.println("FeedbackController.doPost, model: " + model.toString() );
		
		try {
			boolean isValid = validateContact(model);
			
			System.out.println("FeedbackController.doPost, isValid: " + isValid );
			System.out.println("FeedbackController.doPost, errorMessage: " + model.getMessage() );
			
			if(isValid) {
				ContactService.createFeedback(name, email, content);
				model.setSuccess(true);
				model.setMessage("");
			} else {
				model.setSuccess(false);
			}
			
		} catch(Exception ex) {
			model.setSuccess(false);
			model.setMessage(ERROR_MESSAGE);
		}
		
		request.setAttribute(Constants.PARAM_MODEL, model);
		this.doGet(request, response);
	}
	
	private void handleView(String viewName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}
	
	private boolean validateContact(FeedbackModel model) {
		if(model.getName() == null || model.getName().isEmpty()) {
			model.setMessage(NAME_IS_EMPTY);
			return false;
		} else if (model.getName().length() > 50) {
			model.setMessage(MAX_NAME_LENGTH);
			return false;
		}
		
		if(model.getEmail() == null || model.getEmail().isEmpty()) {
			model.setMessage(EMAIL_IS_EMPTY);
			return false;
		} else if (model.getEmail().length() > 200) {
			model.setMessage(MAX_EMAIL_LENGTH);
			return false;
		}
		
		if(model.getContent() == null || model.getContent().isEmpty()) {
			model.setMessage(CONTENT_IS_EMPTY);
			return false;
		} else if (model.getContent().length() > 500) {
			model.setMessage(MAX_CONTENT_LENGTH);
			return false;
		}
		
		model.setMessage(SUCESSFUL_MESSAGE);
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

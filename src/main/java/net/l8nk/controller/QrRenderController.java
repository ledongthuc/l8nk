package net.l8nk.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.glxn.qrgen.QRCode;
import net.l8nk.common.Constants;
import net.l8nk.common.Utility;

@WebServlet(name="QrRenderController", urlPatterns="/api/QrRender")
public class QrRenderController extends HttpServlet  {

	static Logger logger = Logger.getLogger(QrRenderController.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2917966778827406024L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HashMap<String, Object> params = this.composeParameters(request, response);
		if(!params.containsKey(Constants.PARAM_U)) {
			logger.info("QrRenderController.doGet, url is not exist");
			response.sendError(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		
		String rawUrl = (String) params.get(Constants.PARAM_U);
		ServletOutputStream servOutputStream = null;
		
		try {
			
			String url = URLDecoder.decode(rawUrl, Constants.CHARSET_UTF8);
			
			logger.info("QrRenderController.doGet, raw url = " + rawUrl);
			logger.info("QrRenderController.doGet, url = " + url);
			
			response.setContentType("image/png");
			servOutputStream = response.getOutputStream();
			QRCode qrCode = QRCode.from(url);
			setParametersToQr(params, qrCode);
			
			qrCode.writeTo(servOutputStream);
			
	        
		} catch (Exception e) {
			logger.error("QrRenderController.doGet", e);
			response.sendError(HttpServletResponse.SC_NO_CONTENT);
			return;
		} finally {
			if(servOutputStream != null) {
				servOutputStream.close();
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	private HashMap<String, Object> composeParameters(HttpServletRequest request, HttpServletResponse response) {
		HashMap<String, Object> params = new HashMap<>();
		
		String url = request.getParameter(Constants.PARAM_U);
		if(url != null && !url.isEmpty()) {
			params.put(Constants.PARAM_U, url);
		}
		
		String width = request.getParameter(Constants.PARAM_WIDTH);
		
		if(width != null && !width.isEmpty() && Utility.isNumeric(width)) {
			params.put(Constants.PARAM_WIDTH, Integer.parseInt(width));
		}
		
		String height = request.getParameter(Constants.PARAM_HEIGHT);
		if(height != null && !height.isEmpty() && Utility.isNumeric(height)) {
			params.put(Constants.PARAM_HEIGHT, Integer.parseInt(height));
		}
		
		return params;
	}
	
	private void setParametersToQr(HashMap<String, Object> params, QRCode qrCode) {
		
		if(params.containsKey(Constants.PARAM_WIDTH) &&
		   params.containsKey(Constants.PARAM_HEIGHT)) {
			int width = (int) params.get(Constants.PARAM_WIDTH);
			int height = (int) params.get(Constants.PARAM_HEIGHT);
			
			qrCode.withSize(width, height);
		}
		
		
	}
}

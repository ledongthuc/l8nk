<%@page import="net.l8nk.viewmodel.FeedbackModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.l8nk.common.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%
	FeedbackModel model = (FeedbackModel) request.getAttribute(Constants.PARAM_MODEL);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="partial/header.jsp"></jsp:include>
  </head>
  <body>
    <jsp:include page="partial/banner.jsp"></jsp:include>
    

    <div class="content">
        <div class="container">
        	Feedback
        </div>
    </div>
   
   <jsp:include page="partial/footer.jsp"></jsp:include>
	
  </body>
</html>
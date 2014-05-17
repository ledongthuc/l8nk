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
        	<div class="row">
        		<div class="col-md-2"></div>
        		<div class="col-md-8">
		        	<% if(model != null && model.isSuccess()) { %>
		        		<div class="alert alert-success"><%=model.getMessage()%></div>
		        	<%
		        		}
		        	%>
		        		
		        	<%
		        		if(model != null && model.hasError()) {
		        	%>
		        		<div class="alert alert-danger"><%=model.getMessage()%></div>
		        	<% } %>
		        
		        	<form role="form" method="post">
					  
					  <div class="form-group">
					    <input type="text" class="form-control" id="name" name="name" placeholder="Your name" value="<%= model != null ? model.getName() : ""%>">
					  </div>
					  
					  <div class="form-group">
					    <input type="email" class="form-control" id="email" name="email" placeholder="Email address" value="<%= model != null ? model.getEmail() : ""%>">
					  </div>
					  
					  <div class="form-group">
					  	<textarea class="form-control" id="content" name="content" rows="4" placeholder="Your feedback"><%= model != null ? model.getContent() : ""%></textarea>
					  </div>
					  
					  <div class="pull-right">
						  <button type="reset" class="btn btn-info">Reset</button>
						  <button type="submit" class="btn btn-primary">Send feedback</button>
					  </div>
					</form>
				</div>
			</div>
			        	
        </div>
    </div>
   
   <jsp:include page="partial/footer.jsp">
   	<jsp:param value="selected" name="feedback"/>
   </jsp:include>
	
	<script type="text/javascript">
		$("#name").select();
	</script>
	
  </body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="net.l8nk.common.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="partial/header.jsp"></jsp:include>
    <link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet">
  </head>
  <body>
    <jsp:include page="partial/banner.jsp"></jsp:include>
    

    <div class="content">
        <div class="container">
        	<div class="row">
        		<div class="col-md-2">
        		
        			
        		
        		</div>
        		<div class="col-md-8 donation-panel" >
		        	
		        	<img src="<%=request.getContextPath()%>/img/donation-thanks.jpg" width="90%" alt="Thanks for your Donation">
					
				</div>
				
				<div class="col-md-2">
		        	
				</div>
			</div>
			        	
        </div>
    </div>
   
   <jsp:include page="partial/footer.jsp">
   	<jsp:param value="selected" name="donation"/>
   </jsp:include>
   
  </body>
</html>
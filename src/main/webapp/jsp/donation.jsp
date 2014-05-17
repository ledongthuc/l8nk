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
        		<div class="col-md-8 donation-panel">
		        	
		        	<h2>Donate $5 by Paypal</h2>
		        	
		        	<p>
		        		In case the site is helpful, you can make a donation. <br/>
		        		The money's going to use to maintain the server and improve the site. 
		        	</p>
		        	
		        	<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
						<input type="hidden" name="cmd" value="_s-xclick">
						<input type="hidden" name="hosted_button_id" value="367WXAAHTND2S">
						<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
						<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
					</form>
					
					<br/><br/><br/>
					
					<h2>Personal donate</h2>
					
					<p>If you would prefer to pay by personal check, please contact with us through email <a href="mailto://ledongthuc@gmail.com">ledongthuc@gmail.com</a></p>
					
					<br/><br/><br/>
					<img src="<%=request.getContextPath()%>/img/donation.jpg" width="90%" alt="Donate L8nk.net">
					
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
<%@page import="net.l8nk.viewmodel.HomeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ page import = "net.l8nk.common.Constants" %>
<%@ page import = "net.l8nk.entity.Link" %>
<%
	HomeModel model = (HomeModel) request.getAttribute(Constants.PARAM_MODEL);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="<%=Constants.META_VIEW_PORT%>">
	<meta name="keywords" content="<%=Constants.META_KEYWORDS%>">
	<meta name="author" content="<%=Constants.META_AUTHOR%>">
	<meta name="description" content="Shorten your long link to compact one. You can use it easier and quicker.">
    
    <title>L8nk ! Simpler</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico">    

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>
    
    
        
    <!--<h1>Hello, world!</h1>-->
    <div class="header">
        <div class="container">
            <a href="<%=request.getContextPath()%>/Home">
                <img src="<%=request.getContextPath()%>/img/logo.png" class="img-responsive logo" alt="L8nk">
            </a>
        </div>
    </div>
    

    <div class="content">
        <div class="container">
        	<% if(model.isHasError()) { %>
        	<div class="alert alert-danger"><%= model.getErrorMessage() %></div>
        	<% } %>
        
            <div class="row">
                <div class="col-md-8">
                    
                    <div class="well">
                    	<form method="post" action="<%=request.getContextPath()%>/Home" onsubmit="return validate()">
							<label>Paste your long link here:</label>
	                        <div class="input-group">
	                            <input type="text" class="form-control" id="longLinkInput" 
	                            	   name="longLinkInput" placeholder="http://" value="<%=model.isGeneratedLink() ? model.getLink().getLongLink() : ""%>">
	                            <span class="input-group-btn">
	                                <button id="longLinkButton" name="action" value="<%=Constants.ACTION_CREATE_LINK%>" class="btn btn-primary" type="submit">Shorten it</button>
	                            </span>
	                        </div><!-- /input-group -->
                        </form>
                    </div>
                    
                </div>
                <div class="col-md-4">
                	<% if(model.isGeneratedLink()) { %>
						<div class="well result-panel">
							<input id="shortLinkResult" class="result-input" readonly 
									   value="<%=model.getLink().getShortLink()%>" onclick="this.select()"/>
							<br/>
							<small class="help-block">press <kbd>CTRL</kbd>+<kbd>C</kbd> to copy.</small>
						</div>
					<% } %>
                </div>
            </div>
            
            <div class="row your-links">
                <div class="col-md-12">
                    
                    <table class="table table-hover">
                        <tr>
                            <th>
                                Long link
                            </th>
                            <th>
                                Created
                            </th>
                            <th>
                                Short link
                            </th>
                            <th>
                                
                            </th>
                            <th>
                                Viewed
                            </th>
                        </tr>
                        
                        <tr class="success">
                            <td>
                                <a href="http://thuc.com.vn">http://thuc.com.vn</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="http://l8nk.net/ee8k">http://l8nk.net/ee8k</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                13
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <a href="#">http://thuc.com.vn/test</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="#">http://l8nk.net/Sjc72</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                3
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="#">http://thuc.com.vn/test</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="#">http://l8nk.net/Sjc72</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                3
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href="#">http://thuc.com.vn/test</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="#">http://l8nk.net/Sjc72</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                3
                            </td>
                        </tr>
						<tr>
                            <td>
                                <a href="#">http://thuc.com.vn/test</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="#">http://l8nk.net/Sjc72</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                3
                            </td>
                        </tr>
						<tr>
                            <td>
                                <a href="#">http://thuc.com.vn/test</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="#">http://l8nk.net/Sjc72</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                3
                            </td>
                        </tr>
						<tr>
                            <td>
                                <a href="#">http://thuc.com.vn/test</a>
                            </td>
                            <td>
                                3 days
                            </td>
                            <td>
                                <a href="#">http://l8nk.net/Sjc72</a>
                            </td>
                            <td>
                                <a href="#">Details</a>
                            </td>
                            <td>
                                3
                            </td>
                        </tr>
                    </table>
                    <!-- <button type="button" class="btn btn-primary btn-lg btn-block">Show more</button> -->
                    
                </div>
				
            </div>
			
			
			
        </div>
    </div>
    
    <hr class="footer-line"/>
	
	<div class="footer">
		<div class="container">
			<ul class="nav nav-pills pull-right">
			
				<li class="disabled"><a href="<%=request.getContextPath()%>">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/Donation">Donation</a></li>
				<li><a href="<%=request.getContextPath()%>/Develop">Develop</a></li>
				<li><a href="<%=request.getContextPath()%>/Feedback">Feedback</a></li>
			</ul>
		</div>
		    
	</div>		

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
    <script src="<%=request.getContextPath()%>/js/script.js"></script>
    
    <% if(model.isGeneratedLink()) { %>
    <script >
    	$("#shortLinkResult").select();
    	
    	function validate() {
    		
    	}
    </script>
    <% } %>
  </body>
</html>
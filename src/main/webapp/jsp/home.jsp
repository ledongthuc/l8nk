<%@page import="java.util.ArrayList"%>
<%@page import="net.l8nk.common.*"%>
<%@page import="net.l8nk.viewmodel.HomeModel"%>
<%@ page import = "net.l8nk.entity.Link" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%
	HomeModel model = (HomeModel) request.getAttribute(Constants.PARAM_MODEL);
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
        	<% if(model.isHasError()) { %>
        	<div class="alert alert-danger"><%= model.getErrorMessage() %></div>
        	<% } %>
        
            <div class="row">
                <div class="col-md-8">
                    
                    <div class="well">
                    	<form method="post" action="<%=request.getContextPath()%>/" onsubmit="return validate()">
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
                    
                     <% 
            ArrayList<Link> recents = model.getRecentLinks();
            
            %>
                    
                    <% if(model.isHasQr()) { %>
            	<div id="recentLinks" class="hidden-xs hidden-sm">
            	<% } else { %>
                <div id="recentLinks" class="hidden-xs hidden-sm">
                <% } %>
                    
                    <% if(recents != null && recents.size() > 0) { %>
                    
                    <table class="table table-hover">
                        <tr>
                            <th>
                                Long link
                            </th>
                            <!-- <th>
                                Created
                            </th> -->
                            <th>
                                Short link
                            </th>
                            <th>
                                Viewer
                            </th>
                        </tr>
                        
                        <% 
                            boolean isFirstRow = true;
                            for(Link recentLink : recents) {
                            	if(isFirstRow) {
                                 isFirstRow = false;
                        %>
                                 <tr class="success">
                        <%
                            	} else {
                        %>
                                 <tr>
                        <%
                            	}
                        %>
                            <td>
                                <a href="<%= recentLink.getShortLink() %>"><%= recentLink.getLongLink() %></a>
                            </td>
                            <%-- <td>
                                <%= Utility.formatDateDisplay(recentLink.getCreatedDate()) %>
                            </td> --%>
                            <td>
                                <a href="<%= recentLink.getShortLink() %>"><%= recentLink.getShortLink() %></a>
                            </td>
                            <td>
                               <%= recentLink.getClicks() %>
                            </td>
                            
                        </tr>
                        
                        <% } %>
                        </table>
                         <%
			            }
			            %>
                        </div>
                    
                </div>
                <div id="result-panel-wrapper" class="col-md-4">
                	<% if(model.isGeneratedLink()) { %>
						<div id="result-panel" class="well result-panel">
							<input id="shortLinkResult" class="result-input" readonly 
									   value="<%= model.getLink().getShortLink() %>" onclick="this.select()"/>
							<br/>
							<small class="help-block">press <kbd>CTRL</kbd>+<kbd>C</kbd> to copy.</small>
						</div>
					<% } %>
					
					
					<% if(model.isHasQr()) { %>
					<div id="qrImageWrapper" class="well result-panel">
                    	<img id="qrImage" alt="Generating..." width="100%" title="QR Image" src="<%= model.getQrUrl() %>"/>
                    <% } else { %>
                    <div id="qrImageWrapper">
                    <% } %>
                    </div>
					
                </div>
            </div>
            
			
        </div>
    </div>
   
   <jsp:include page="partial/footer.jsp">
   	<jsp:param value="selected" name="home"/>
   </jsp:include>
	
	  <% if(model.isGeneratedLink()) { %>
	    <script >
	      $("#shortLinkResult").select();
	    </script>
      <% } %>
      <script>
      	var hostName = "<%=request.getContextPath()%>";
      </script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/genQr.js"></script>
	
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="footer">
  <hr class="footer-line"/>
  <div class="container">
     <ul class="nav nav-pills pull-right">
     
        <li class="disabled"><a href="<%=request.getContextPath()%>">Home</a></li>
        <li><a href="<%=request.getContextPath()%>/App/Donation">Donation</a></li>
        <%-- <li><a href="<%=request.getContextPath()%>/App/Develop">Develop</a></li> --%>
        <li><a href="<%=request.getContextPath()%>/App/Feedback">Feedback</a></li>
      </ul>
   </div>
       
</div>      

 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
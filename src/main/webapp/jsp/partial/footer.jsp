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

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-50646475-1', 'l8nk.net');
  ga('send', 'pageview');

</script>
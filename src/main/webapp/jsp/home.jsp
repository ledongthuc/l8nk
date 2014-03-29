<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="L8nk">
	<meta name="keywords" content="l8nk, short, save, share, shorten">
	<meta name="author" content="http://thuc.com.vn">
    
    <title>L8nk ! Simpler</title>
    <link rel="shortcut icon" href="favicon.ico">    

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

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
            <a href="#">
                <img src="img/logo.png" class="img-responsive logo" alt="L8nk">
            </a>
        </div>
    </div>
    

    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    
                    <div class="well">
						<label>Paste your long link here:</label>
                        <div class="input-group">
                            <input type="url" class="form-control" id="longLinkInput" name="longLinkInput" placeholder="http://">
                            <span class="input-group-btn">
                                <button id="longLinkButton" class="btn btn-primary" type="button">Shorten it</button>
                            </span>
                        </div><!-- /input-group -->
                    </div>
                    
                </div>
                <div class="col-md-4">
					<div class="well result-panel">
						<h3>
							<input class="result-input" readonly value="http://l8nk.net/Sjc72" onclick="this.select()"/>
						</h3>
					</div>
                </div>
            </div>
            
            <div class="row">
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
                    <button type="button" class="btn btn-primary btn-lg btn-block">Show more</button>
                    
                </div>
				
            </div>
			
			
			
        </div>
    </div>
    
    <hr class="footer-line"/>
	
	<div class="footer">
		<div class="container">
			<ul class="nav nav-pills pull-right">
			
				<li class="disabled"><a href="#">Home</a></li>
				<li><a href="#">Donation</a></li>
				<li><a href="#">Develop</a></li>
				<li><a href="#">Feedback</a></li>
			</ul>
		</div>
		    
	</div>		

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/script.js"></script>
  </body>
</html>
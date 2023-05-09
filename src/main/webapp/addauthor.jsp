<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="stylecss.jsp"%>
<%@include file="scriptjs.jsp"%>
<title>Add author</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<div class="container">
	
	<form action="AddAuthorServlet" method="POST">
  	<div class="form-group">
    <label for="author-title">Enter author name</label>
    <input type="text" required
     class="form-control"
      id="author-title"  
      name ="author-title" 
      placeholder="Enter author...">
      
      </div>
      
      <div class="form-group">
    <label for="passcode">Enter passcode</label>
    <input type="password" required
     class="form-control"
      id="passcode"  
      name ="passcode" 
      placeholder="Enter passcode...">
      
      </div>
    
   <span><input type="text" style="color:red;" value="<%= session.getAttribute("error_passcode") %>" /></span>

  <div class="form-group text-center">
  <button type="submit" class="btn btn-primary">Add</button>
 
  </div>
</form>
	</div>


</body>
</html>
</html>
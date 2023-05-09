<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="stylecss.jsp"%>
<%@include file="scriptjs.jsp"%>
<title>Add notes</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<div class="container">
	
	<form action="addServlet" method="POST">
  <div class="form-group">
    <label for="note-title">Note title</label>
    <input type="text" required
     class="form-control"
      id="note-title"  
      name ="note-title" 
      placeholder="Enter title..">
    
  </div>
  <div class="form-group">
    <label for="note-content">Note content</label>
    <textarea
    class="form-control" required
    id="note-content" 
    name = "note-content" 
    placeholder="Enter the content..."></textarea>
  </div>

  <div class="form-group text-center">
  <button type="submit" class="btn btn-primary">Add</button>
 
  </div>
</form>
	</div>


</body>
</html>
</html>
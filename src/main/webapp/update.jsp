<!doctype html>
<%@page import="com.notetaker.helpers.FactoryProvider"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.notetaker.entities.*"%>
<%@page import="com.notetaker.helpers.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@include file="stylecss.jsp"%>
<%@include file="scriptjs.jsp"%>
<title>Update notes</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	
	<% int noteid = Integer.parseInt(request.getParameter("note_id").trim());
	Session cs = FactoryProvider.getFactory().openSession();

	Note note = (Note)cs.get(Note.class, noteid);
	%>
	

	<div class="container">
	<form action="UpdateServlet" method="POST">
	
	
	<div class="form-group">
	<input type="text"
     class="form-control text-danger"
      id="note-id"  
      name ="note-id-show" 
      value=" This note <%=note.getNoteId()%> is to be updated" readonly>
	</div>
	
	<div class="form-group">
	<input type="text"
     class="form-control text-danger"
      id="note-id"  
      name ="note-id" hidden
      value="<%=note.getNoteId()%>" readonly>
	</div>
	
	
	
  	<div class="form-group">
    <label for="note-title">Note title new</label>
    <input type="text"
     class="form-control"
      id="note-title"  
      name ="note-title" 
     value="<%=note.getNoteTitle() %>">
    
  </div>
  <div class="form-group">
    <label for="note-content">Note content new</label>
    <textarea
    class="form-control"
    id="note-content" 
    name = "note-content" >
    
    <%=note.getNoteContent() %></textarea>
  </div>

  <div class="form-group text-center">
  <button type="submit" class="btn btn-success">update</button>
 
  </div>
</form>
	</div>


</body>
</html>
</html>
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
  
		
<div class="form-group">
<label for="author">select author</label>


<% Session cs = FactoryProvider.getFactory().getCurrentSession();
Transaction txt = cs.beginTransaction();
Query query = cs.createQuery("from Author");
List<Author> resultList = query.list();
%>

	<select class="form-control" name="author" id="author">
<% 
for(Author author : resultList){
%>	
 <option value=<%=author.getAuthorName()  %>><%=author.getAuthorName() %></option>
<% };txt.commit();cs.close();%>

  </select>


</div>

  <div class="form-group text-center">
  <button type="submit" class="btn btn-primary">Add</button>
 
  </div>
</form>
	</div>


</body>
</html>
</html>
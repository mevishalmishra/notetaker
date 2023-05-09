<!doctype html>
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
<title>Home</title>
</head>
<body>

	<%@include file="navbar.jsp"%>
	<% Session cs =  FactoryProvider.getFactory().getCurrentSession(); 
	Transaction txt = cs.beginTransaction();
		Query query = cs.createQuery("FROM com.notetaker.entities.Note");
		List<Note> resultList = query.list();
		for(Note note : resultList){
	%>

	
	
		<div class="container">
		
		<div class="card mt-2 text-center">
		
		<div class="card-body">
			<h5 class="card-title"><%= note.getNoteTitle() %></h5>
			<p class="card-text"><%= note.getNoteContent() %></p>
			<a class="btn btn-danger" href="DeleteServlet?note_id=<%=note.getNoteId()%>">delete</a>
			<a class="btn btn-warning" href="update.jsp?note_id=<%=note.getNoteId() %>">update</a>
			
		</div>
	</div>
	
	</div>
	<%} txt.commit();cs.close();%>
	


</body>
</html>
</html>
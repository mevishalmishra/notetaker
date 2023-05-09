package com.notetaker.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetaker.entities.Note;
import com.notetaker.helpers.FactoryProvider;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int noteid = Integer.parseInt(request.getParameter("note-id"));
			String noteTitle = request.getParameter("note-title");
			String noteContent = request.getParameter("note-content");
			
			Session session = FactoryProvider.getFactory().getCurrentSession();
			Transaction txt = session.beginTransaction();
			
			Note note = (Note)session.get(Note.class, noteid);
			
			note.setNoteId(noteid);
			note.setNoteTitle(noteTitle);
			note.setNoteContent(noteContent);
			note.setAddeDate(new Date());
			
			session.update(note);
			
			txt.commit();
			session.close();
			
			response.sendRedirect("allnotes.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

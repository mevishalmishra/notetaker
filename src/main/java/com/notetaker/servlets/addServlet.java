package com.notetaker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetaker.entities.Note;
import com.notetaker.helpers.FactoryProvider;

/**
 * Servlet implementation class addServlet
 */
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			String noteTitle = request.getParameter("note-title");
			String noteContent = request.getParameter("note-content");
		
			Note note = new Note();
			note.setNoteId(new Random().nextInt(10000));
			note.setNoteTitle(noteTitle);
			note.setNoteContent(noteContent);
			note.setAddeDate(new Date());
			
			Session session = FactoryProvider.getFactory().getCurrentSession();
			Transaction txt = session.beginTransaction();
			session.save(note);
			txt.commit();
			session.close();
			
			response.setContentType("text/html");
			
			PrintWriter pw = response.getWriter();
			pw.println("<h3 style='text-align:center;color: red'>Note has been added successfully. " + note.getNoteId() +  " is id <br />" );
			pw.println("<button><a href='allnotes.jsp' style='text-align:center;color: green'>view all notes</a></button>" );
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

}

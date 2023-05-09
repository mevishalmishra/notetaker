package com.notetaker.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.notetaker.entities.Note;
import com.notetaker.helpers.FactoryProvider;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int noteid = Integer.parseInt(request.getParameter("note_id").trim());
			Session cs = FactoryProvider.getFactory().getCurrentSession();
			
			Transaction txt = cs.beginTransaction();
			Note note = (Note)cs.get(Note.class, noteid);
			cs.delete(note);
			
			txt.commit();
			cs.close();
			response.sendRedirect("allnotes.jsp");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

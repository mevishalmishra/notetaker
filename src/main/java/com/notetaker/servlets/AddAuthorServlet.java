package com.notetaker.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetaker.entities.Author;
import com.notetaker.helpers.FactoryProvider;

/**
 * Servlet implementation class AddAuthorServlet
 */
public class AddAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int passcode = Integer.parseInt(request.getParameter("passcode").trim());
			String authorName = request.getParameter("author-title");
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("error_passcode", "Please enter correct passcode.");
			
			if(passcode != 12345) {
				
				response.sendRedirect("addauthor.jsp");
			}else {
				Author author = new Author();
				author.setAuthorName(authorName);
				Session cs = FactoryProvider.getFactory().getCurrentSession();
				Transaction txt = cs.beginTransaction();
				cs.save(author);
				txt.commit();
				cs.close();
				response.sendRedirect("addauthor.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

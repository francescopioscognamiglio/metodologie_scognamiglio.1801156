package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di gestire il logout dell'utente
 * @author francescopioscognamiglio
 */
@WebServlet(name="LogoutServlet", urlPatterns="/logout.jsp")
public class LogoutServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("username");
		response.sendRedirect("home.html");
	}
}

package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che controlla se un utente é loggato o meno
 * @author francescopioscognamiglio
 */
@WebServlet(name="AuthenticationServiceServlet", urlPatterns="/isLoggedIn.jsp")
public class AuthenticationServiceServlet extends BaseServlet {

	private static final long serialVersionUID = 8484501789787L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(
				(request.getSession().getAttribute("username") != null) + "");
	}
}

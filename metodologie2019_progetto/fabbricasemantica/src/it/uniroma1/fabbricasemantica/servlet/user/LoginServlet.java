package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.model.User;
import it.uniroma1.fabbricasemantica.service.ApplicationService;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di gestire l'autenticazione dell'utente
 * @author francescopioscognamiglio
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email == null || password == null) return;

		User user = ApplicationService.getInstance().getProfile(email);
		if (user != null && password.equals(user.getPassword())) {
			request.getSession().setAttribute("username", email);
			response.getWriter().write("true");
		}
		else {
			response.getWriter().write("Indirizzo email o password errata.");
		}
	}
}

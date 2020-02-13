package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.model.Language;
import it.uniroma1.fabbricasemantica.model.User;
import it.uniroma1.fabbricasemantica.service.ApplicationService;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che permette di gestire la registrazione dell'utente
 * @author francescopioscognamiglio
 */
@WebServlet(name="RegisterServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String[] sLanguages = request.getParameterValues("language");

		if (ApplicationService.getInstance().getProfile(email) != null) {
			response.getWriter().write("L'email e' gia' in uso da un altro utente.");
			return;
		}

		List<Language> languages = new ArrayList<>();
		for (String language : sLanguages) {
			languages.add(new Language(language));
		}

		User user = new User(firstName, lastName, email, password, languages);

		ApplicationService.getInstance().insertProfile(user);

		request.getSession().setAttribute("username", email);
		response.getWriter().write("true");
	}
}

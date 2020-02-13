package it.uniroma1.fabbricasemantica.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filtro che intercetta l'accesso ai task per verificare che l'utente sia autenticato
 * @author francescopioscognamiglio
 */
@WebFilter(filterName="TaskAuthenticationFilter", urlPatterns={"/translationAnnotation.html", "/wordAnnotation.html",
		"/definitionAnnotation.html", "/senseAnnotation.html", "/translationValidation.html", "/senseValidation.html", "/myTextAnnotation.html"})
public class AuthenticatedOnlyFilter implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (httpRequest.getSession().getAttribute("username") == null)
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}

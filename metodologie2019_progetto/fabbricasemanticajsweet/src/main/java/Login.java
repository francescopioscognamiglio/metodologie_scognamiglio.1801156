import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.dom.Event;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina di Login
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class Login extends Entry {

	public static final String LOGIN_TITLE = "Sign In";
	public static final String LOGIN_TYPE = "login";
	public static final String LOGIN_ACTION = "login.jsp";
	public static final String LOGIN_ACTION_LABEL = "Sign In";

	public static final String REGISTER_LABEL = "Sei un nuovo utente? ";
	public static final String REGISTER_LINK = "signup.html";
	public static final String REGISTER_LINK_LABEL = "Sign Up";

	public static void main(String[] args) {
		Login login = new Login();
		login.create();
	}

	public Login() {
		super(LOGIN_TITLE, LOGIN_TYPE, LOGIN_ACTION, LOGIN_ACTION_LABEL, REGISTER_LABEL, REGISTER_LINK, REGISTER_LINK_LABEL);
	}

	public HTMLElement[] getCustomComponents() {
		HTMLDivElement divFormGroupEmail = document.createElement(StringTypes.div);
		divFormGroupEmail.className = "form-group";

		HTMLLabelElement labelEmail = document.createElement(StringTypes.label);
		labelEmail.textContent = "Indirizzo email";
		$(labelEmail).css("font-weight", "bold");

		HTMLInputElement inputEmail = document.createElement(StringTypes.input);
		inputEmail.className = "form-control";
		inputEmail.name = "email";
		inputEmail.type = "email";
		inputEmail.placeholder = "Inserire l'email";
		inputEmail.required = true;

		HTMLDivElement divFormGroupPassword = document.createElement(StringTypes.div);
		divFormGroupPassword.className = "form-group";

		HTMLLabelElement labelPassword = document.createElement(StringTypes.label);
		labelPassword.textContent = "Password";
		$(labelPassword).css("font-weight", "bold");

		HTMLInputElement inputPassword = document.createElement(StringTypes.input);
		inputPassword.className = "form-control";
		inputPassword.name = "password";
		inputPassword.type = "password";
		inputPassword.placeholder = "Inserire la password";
		inputPassword.required = true;

		$(divFormGroupEmail).append(labelEmail, inputEmail);
		$(divFormGroupPassword).append(labelPassword, inputPassword);

		return new HTMLElement[] {
				divFormGroupEmail,
				divFormGroupPassword
		};
	}

	@Override
	public boolean onSubmit(Event e) {
		String email = ((HTMLInputElement) document.querySelector("[name='email']")).value;
		String password = ((HTMLInputElement) document.querySelector("[name='password']")).value;
		$.get(LOGIN_ACTION, "email=" + email + "&password=" + password, (Object result, String a, JQueryXHR ctx) -> {
			console.log(result.toString());
			if (!"true".equals(result.toString())) {
				console.log("Utente non esiste");
				$(".alert-danger").removeAttr("hidden");
				$(".alert-danger").text(result.toString());
			}
			else {
				console.log("Utente corretto");
				window.location.href = "home.html";
			}
			return null;
		});

		return false;
	}
}

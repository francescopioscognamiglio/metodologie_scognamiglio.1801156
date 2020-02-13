import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.dom.Element;
import def.dom.Event;
import def.dom.HTMLBRElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.NodeListOf;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina di Signup
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class Signup extends Entry {

	public static final String REGISTER_TITLE = "Sign Up";
	public static final String REGISTER_TYPE = "signup";
	public static final String REGISTER_ACTION = "signup.jsp";
	public static final String REGISTER_ACTION_LABEL = "Sign Up";

	public static final String LOGIN_LABEL = "Hai già un account? ";
	public static final String LOGIN_LINK = "login.html";
	public static final String LOGIN_LINK_LABEL = "Sign in";

	public static void main(String[] args) {
		Signup register = new Signup();
		register.create();
	}

	public Signup() {
		super(REGISTER_TITLE, REGISTER_TYPE, REGISTER_ACTION, REGISTER_ACTION_LABEL, LOGIN_LABEL, LOGIN_LINK, LOGIN_LINK_LABEL);
	}

	public HTMLElement[] getCustomComponents() {
		HTMLDivElement divFormGroupFullName = document.createElement(StringTypes.div);
		divFormGroupFullName.className = "form-group";

		HTMLDivElement rowName = document.createElement(StringTypes.div);
		rowName.className = "row";

		HTMLDivElement colFirstName = document.createElement(StringTypes.div);
		colFirstName.className = "col";

		HTMLLabelElement labelFirstName = document.createElement(StringTypes.label);
		labelFirstName.textContent = "Nome";
		$(labelFirstName).css("font-weight", "bold");

		HTMLInputElement inputFirstName = document.createElement(StringTypes.input);
		inputFirstName.className = "form-control";
		inputFirstName.name = "firstname";
		inputFirstName.type = "text";
		inputFirstName.placeholder = "Inserire il nome";
		inputFirstName.required = true;

		HTMLDivElement colLastName = document.createElement(StringTypes.div);
		colLastName.className = "col";

		HTMLLabelElement labelLastName = document.createElement(StringTypes.label);
		labelLastName.textContent = "Cognome";
		$(labelLastName).css("font-weight", "bold");

		HTMLInputElement inputLastName = document.createElement(StringTypes.input);
		inputLastName.className = "form-control";
		inputLastName.name = "lastname";
		inputLastName.type = "text";
		inputLastName.placeholder = "Inserire il cognome";
		inputLastName.required = true;

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

		HTMLDivElement divFormGroupConfirmPassword = document.createElement(StringTypes.div);
		divFormGroupConfirmPassword.className = "form-group";

		HTMLLabelElement labelConfirmPassword = document.createElement(StringTypes.label);
		labelConfirmPassword.textContent = "Conferma password";
		$(labelConfirmPassword).css("font-weight", "bold");

		HTMLInputElement inputConfirmPassword = document.createElement(StringTypes.input);
		inputConfirmPassword.className = "form-control";
		inputConfirmPassword.name = "confirmpassword";
		inputConfirmPassword.type = "password";
		inputConfirmPassword.placeholder = "Ripetere la password";
		inputConfirmPassword.required = true;

		HTMLDivElement divFormGroupLanguage = document.createElement(StringTypes.div);
		divFormGroupLanguage.className = "form-group";

		HTMLLabelElement labelLanguage = document.createElement(StringTypes.label);
		labelLanguage.textContent = "Scegliere una o più lingue madre";
		$(labelLanguage).css("font-weight", "bold");

		HTMLBRElement brLanguage = document.createElement(StringTypes.br);

		HTMLDivElement divFormCheckLanguageIt = document.createElement(StringTypes.div);
		divFormCheckLanguageIt.className = "col-3 form-check form-check-inline";

		HTMLInputElement divFormCheckInputLanguageIt = document.createElement(StringTypes.input);
		divFormCheckInputLanguageIt.className = "form-check-input";
		divFormCheckInputLanguageIt.id = "languagecheck";
		divFormCheckInputLanguageIt.name = "language";
		divFormCheckInputLanguageIt.type = "checkbox";
		divFormCheckInputLanguageIt.value = "it";

		HTMLLabelElement divFormCheckLabelLanguageIt = document.createElement(StringTypes.label);
		divFormCheckLabelLanguageIt.className = "form-check-label";
		divFormCheckLabelLanguageIt.textContent = "Italiano";

		HTMLDivElement divFormCheckLanguageEn = document.createElement(StringTypes.div);
		divFormCheckLanguageEn.className = "col-3 form-check form-check-inline";

		HTMLInputElement divFormCheckInputLanguageEn = document.createElement(StringTypes.input);
		divFormCheckInputLanguageEn.className = "form-check-input";
		divFormCheckInputLanguageEn.id = "languagecheck";
		divFormCheckInputLanguageEn.name = "language";
		divFormCheckInputLanguageEn.type = "checkbox";
		divFormCheckInputLanguageEn.value = "en";

		HTMLLabelElement divFormCheckLabelLanguageEn = document.createElement(StringTypes.label);
		divFormCheckLabelLanguageEn.className = "form-check-label";
		divFormCheckLabelLanguageEn.textContent = "Inglese";

		HTMLDivElement divFormCheckLanguageFr = document.createElement(StringTypes.div);
		divFormCheckLanguageFr.className = "col-3 form-check form-check-inline";

		HTMLInputElement divFormCheckInputLanguageFr = document.createElement(StringTypes.input);
		divFormCheckInputLanguageFr.className = "form-check-input";
		divFormCheckInputLanguageFr.id = "languagecheck";
		divFormCheckInputLanguageFr.name = "language";
		divFormCheckInputLanguageFr.type = "checkbox";
		divFormCheckInputLanguageFr.value = "fr";

		HTMLLabelElement divFormCheckLabelLanguageFr = document.createElement(StringTypes.label);
		divFormCheckLabelLanguageFr.className = "form-check-label";
		divFormCheckLabelLanguageFr.textContent = "Francese";

		HTMLBRElement brLanguage2 = document.createElement(StringTypes.br);

		HTMLDivElement divFormCheckLanguageDe = document.createElement(StringTypes.div);
		divFormCheckLanguageDe.className = "col-3 form-check form-check-inline";

		HTMLInputElement divFormCheckInputLanguageDe = document.createElement(StringTypes.input);
		divFormCheckInputLanguageDe.className = "form-check-input";
		divFormCheckInputLanguageDe.id = "languagecheck";
		divFormCheckInputLanguageDe.name = "language";
		divFormCheckInputLanguageDe.type = "checkbox";
		divFormCheckInputLanguageDe.value = "de";

		HTMLLabelElement divFormCheckLabelLanguageDe = document.createElement(StringTypes.label);
		divFormCheckLabelLanguageDe.className = "form-check-label";
		divFormCheckLabelLanguageDe.textContent = "Tedesco";

		HTMLDivElement divFormCheckLanguageEs = document.createElement(StringTypes.div);
		divFormCheckLanguageEs.className = "col-3 form-check form-check-inline";

		HTMLInputElement divFormCheckInputLanguageEs = document.createElement(StringTypes.input);
		divFormCheckInputLanguageEs.className = "form-check-input";
		divFormCheckInputLanguageEs.id = "languagecheck";
		divFormCheckInputLanguageEs.name = "language";
		divFormCheckInputLanguageEs.type = "checkbox";
		divFormCheckInputLanguageEs.value = "es";

		HTMLLabelElement divFormCheckLabelLanguageEs = document.createElement(StringTypes.label);
		divFormCheckLabelLanguageEs.className = "form-check-label";
		divFormCheckLabelLanguageEs.textContent = "Spagnolo";

		HTMLDivElement divFormCheckLanguageJa = document.createElement(StringTypes.div);
		divFormCheckLanguageJa.className = "col-3 form-check form-check-inline";

		HTMLInputElement divFormCheckInputLanguageJa = document.createElement(StringTypes.input);
		divFormCheckInputLanguageJa.className = "form-check-input";
		divFormCheckInputLanguageJa.id = "languagecheck";
		divFormCheckInputLanguageJa.name = "language";
		divFormCheckInputLanguageJa.type = "checkbox";
		divFormCheckInputLanguageJa.value = "ja";

		HTMLLabelElement divFormCheckLabelLanguageJa = document.createElement(StringTypes.label);
		divFormCheckLabelLanguageJa.className = "form-check-label";
		divFormCheckLabelLanguageJa.textContent = "Giapponese";

		$(divFormCheckLanguageIt).append(divFormCheckInputLanguageIt, divFormCheckLabelLanguageIt);
		$(divFormCheckLanguageEn).append(divFormCheckInputLanguageEn, divFormCheckLabelLanguageEn);
		$(divFormCheckLanguageFr).append(divFormCheckInputLanguageFr, divFormCheckLabelLanguageFr);
		$(divFormCheckLanguageDe).append(divFormCheckInputLanguageDe, divFormCheckLabelLanguageDe);
		$(divFormCheckLanguageEs).append(divFormCheckInputLanguageEs, divFormCheckLabelLanguageEs);
		$(divFormCheckLanguageJa).append(divFormCheckInputLanguageJa, divFormCheckLabelLanguageJa);

		$(divFormGroupFullName).append(rowName);
		$(rowName).append(colFirstName, colLastName);
		$(colFirstName).append(labelFirstName, inputFirstName);
		$(colLastName).append(labelLastName, inputLastName);
		$(divFormGroupEmail).append(labelEmail, inputEmail);
		$(divFormGroupPassword).append(labelPassword, inputPassword);
		$(divFormGroupConfirmPassword).append(labelConfirmPassword, inputConfirmPassword);
		$(divFormGroupLanguage).append(labelLanguage, brLanguage, divFormCheckLanguageIt, divFormCheckLanguageEn, divFormCheckLanguageFr,
				brLanguage2, divFormCheckLanguageDe, divFormCheckLanguageEs, divFormCheckLanguageJa);

		return new HTMLElement[] {
				divFormGroupFullName,
				divFormGroupEmail,
				divFormGroupPassword,
				divFormGroupConfirmPassword,
				divFormGroupLanguage
		};
	}

	@Override
	public boolean onSubmit(Event e) {
		if ($("input[type=checkbox]:checked").length == 0) {
			console.log("you must to choose at least one checkbox");
			$(".alert-danger").removeAttr("hidden");
			$(".alert-danger").text("Scegliere almeno una lingua madre.");
			return false;
		}
		if (!$("input[name=password]").val().equals($("input[name=confirmpassword]").val())) {
			console.log("password and confirm password mismatching");
			$("confirmpassword").text("");
			$("confirmpassword").attr("required", "true");
			$(".alert-danger").removeAttr("hidden");
			$(".alert-danger").text("La password e la sua conferma non corrispondono.");
			return false;
		}

		String email = ((HTMLInputElement) document.querySelector("[name='email']")).value;
		String password = ((HTMLInputElement) document.querySelector("[name='password']")).value;
		String firstname = ((HTMLInputElement) document.querySelector("[name='firstname']")).value;
		String lastname = ((HTMLInputElement) document.querySelector("[name='lastname']")).value;
		NodeListOf<Element> eLanguage = document.querySelectorAll("[name='language']");
		String language = "";
		for (Element l : eLanguage) language += (((HTMLInputElement)l).checked ? "language=" + ((HTMLInputElement)l).value + "&" : "");
		language = language.substring(0, language.length()-1);

		$.get(REGISTER_ACTION, "email=" + email + "&password=" + password + "&firstname=" + firstname + "&lastname=" + lastname + "&" + language, (Object result, String a, JQueryXHR ctx) -> {
			console.log(result.toString());
			if (!"true".equals(result.toString())) {
				console.log("L'email e' gia' in uso da un altro utente.");
				$(".alert-danger").removeAttr("hidden");
				$(".alert-danger").text(result.toString());
			}
			else {
				console.log("Utente creato con successo");
				window.location.href = "home.html";
			}
			return null;
		});

		return false;
	}
}

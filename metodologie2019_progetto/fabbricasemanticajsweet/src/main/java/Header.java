import static def.dom.Globals.console;	
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLButtonElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.jquery.JQueryXHR;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta l'header
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class Header {

	public static final String ISLOGGEDIN_URL = "isLoggedIn.jsp";
	public static final String LOGIN_URL = "login.html";

	public static HTMLElement createHeader() {
		console.log("Creating header");

		HTMLElement navbar = document.createElement("nav");
		navbar.className = "navbar navbar-expand-lg bg-dark text-light sticky-top";

		HTMLAnchorElement homeLink = document.createElement(StringTypes.a);
		homeLink.id = "header-home";
		homeLink.title = "Home";
		homeLink.href = "home.html";
		homeLink.className = "fas fa-home fa-2x";

		HTMLDivElement div = document.createElement(StringTypes.div);
		div.className = "collapse navbar-collapse";

		$.get(ISLOGGEDIN_URL, (Object result, String a, JQueryXHR ctx) -> {
			if ("true".equals(result.toString())) {
				HTMLDivElement divDropdown = document.createElement(StringTypes.div);
				divDropdown.className = "btn-group";

				HTMLButtonElement buttonDropdown = document.createElement(StringTypes.button);
				buttonDropdown.type = "button";
				buttonDropdown.className = "btn btn-secondary dropdown-toggle";
				buttonDropdown.setAttribute("data-toggle", "dropdown");
				buttonDropdown.textContent = "Logged in";

				HTMLDivElement divDropdownMenu = document.createElement(StringTypes.div);
				divDropdownMenu.className = "dropdown-menu dropdown-menu-right";
				HTMLAnchorElement anchorDropdownItemTask = document.createElement(StringTypes.a);
				anchorDropdownItemTask.className = "dropdown-item";
				anchorDropdownItemTask.href = "translationAnnotation.html";
				anchorDropdownItemTask.textContent = "Task";
				HTMLDivElement divDropdownItemDivider = document.createElement(StringTypes.div);
				divDropdownItemDivider.className = "dropdown-divider";
				HTMLAnchorElement anchorDropdownItemLogout = document.createElement(StringTypes.a);
				anchorDropdownItemLogout.className = "dropdown-item";
				anchorDropdownItemLogout.href = "logout.jsp";
				anchorDropdownItemLogout.textContent = "Logout";

				$(divDropdownMenu).append(anchorDropdownItemTask, divDropdownItemDivider, anchorDropdownItemLogout);
				$(divDropdown).append(buttonDropdown, divDropdownMenu);
				$(navbar).append(homeLink, div, divDropdown);
			}
			else {
				HTMLAnchorElement userLink = document.createElement(StringTypes.a);
				userLink.id = "header-user";
				userLink.title = "Login";
				userLink.className = "fas fa-user-circle fa-2x";
				userLink.id = "header-user-undefined";
				userLink.href = LOGIN_URL;

				$(navbar).append(homeLink, div, userLink);
			}

			return null;
		});

		console.log("Header done");

		return navbar;
	}
}

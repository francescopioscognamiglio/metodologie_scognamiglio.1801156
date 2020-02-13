import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta il footer
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class Footer {

	public static final String AUTHOR_FULLNAME = "Francesco Pio Scognamiglio ";
	public static final String AUTHOR_FACEBOOK_LINK = "https://www.facebook.com/francescopioscognamiglio.dev";
	public static final String AUTHOR_LINKEDIN_LINK = "https://www.linkedin.com/in/francescopioscognamiglio";
	public static final String AUTHOR_EMAIL_LINK = "mailto:scognamiglio.1801156@studenti.uniroma1.it";

	public static HTMLElement createFooter() {
		console.log("Creating footer");

		HTMLElement footer = document.createElement("footer");
		footer.className = "page-footer font-small bg-dark text-light fixed-bottom";

		HTMLDivElement principalDiv = document.createElement(StringTypes.div);
		principalDiv.className = "row mt-2 py-3";

		HTMLDivElement copyrightDiv = document.createElement(StringTypes.div);
		copyrightDiv.className = "col-md-4 offset-md-4 text-center";
		copyrightDiv.textContent = "© 2020 Author: ";

		HTMLElement authorName = document.createElement("b");
		authorName.textContent = AUTHOR_FULLNAME;

		HTMLElement studyPhrase = document.createElement("i");
		studyPhrase.className = "fas fa-graduation-cap white-text";

		HTMLDivElement linksDiv = document.createElement(StringTypes.div);
		linksDiv.className = "col-md-4 text-right";

		HTMLAnchorElement facebookLink = document.createElement(StringTypes.a);
		facebookLink.className = "fb-ic mr-4";
		facebookLink.href = AUTHOR_FACEBOOK_LINK;
		$(facebookLink).css("color", "white");

		HTMLElement facebookPhrase = document.createElement("i");
		facebookPhrase.className = "fab fa-facebook-f fa-lg white-text";

		HTMLAnchorElement linkedinLink = document.createElement(StringTypes.a);
		linkedinLink.className = "li-ic mr-4";
		linkedinLink.href = AUTHOR_LINKEDIN_LINK;
		$(linkedinLink).css("color", "white");

		HTMLElement linkedinPhrase = document.createElement("i");
		linkedinPhrase.className = "fab fa-linkedin-in fa-lg white-text";

		HTMLAnchorElement emailLink = document.createElement(StringTypes.a);
		emailLink.className = "gplus-ic mr-4";
		emailLink.href = AUTHOR_EMAIL_LINK;
		$(emailLink).css("color", "white");

		HTMLElement emailPhrase = document.createElement("i");
		emailPhrase.className = "fas fa-envelope fa-lg white-text";

		$(footer).append(principalDiv);
		$(principalDiv).append(copyrightDiv, linksDiv);
		$(copyrightDiv).append(authorName, studyPhrase);
		$(linksDiv).append(facebookLink, linkedinLink, emailLink);
		$(facebookLink).append(facebookPhrase);
		$(emailLink).append(emailPhrase);
		$(linkedinLink).append(linkedinPhrase);

		console.log("Footer done");

		return footer;
	}
}

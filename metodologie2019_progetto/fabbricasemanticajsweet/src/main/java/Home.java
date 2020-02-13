import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLParagraphElement;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina home
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class Home extends Page {

	public static void main(String[] args) {
		new Home().create();
	}

	@Override
	public void create() {
		super.create();

		console.log("Creating home");

		HTMLDivElement div = document.createElement(StringTypes.div);
		$(div).css("margin-left", "7%");
		$(div).css("margin-right", "7%");
		$(div).css("margin-top", "70px");
		$(div).css("margin-bottom", "40px");
		HTMLDivElement rowDiv = document.createElement(StringTypes.div);
		rowDiv.className = "row";
		$(rowDiv).css("width", "100%");
		$(rowDiv).css("height", "100%");

		HTMLDivElement boxCard1 = document.createElement(StringTypes.div);
		boxCard1.className = "col-md-4 boxcard";
		$(boxCard1).css("margin-bottom", "70px");
		HTMLAnchorElement a1 = document.createElement(StringTypes.a);
		a1.className = "block";
		a1.href = "translationAnnotation.html";
		HTMLDivElement card1 = document.createElement(StringTypes.div);
		card1.className = "card mb-4 box-shadow";
		HTMLDivElement cardBody1 = document.createElement(StringTypes.div);
		cardBody1.className = "card-body card-body-container";
		$(cardBody1).css("background-color", "rgba(113, 72, 72, 0.9)");
		HTMLHeadingElement h1 = document.createElement(StringTypes.h3);
		h1.className = "card-header text-center";
		h1.textContent = "Translation Annotation";
		HTMLParagraphElement p1 = document.createElement(StringTypes.p);
		p1.className = "card-text text-center";
		p1.innerHTML = "<b>Data una parola e una sua definizione in inglese, l’utente deve fornire una traduzione nella sua lingua madre.</b>";

		HTMLDivElement boxCard2 = document.createElement(StringTypes.div);
		boxCard2.className = "col-md-4 boxcard";
		$(boxCard2).css("margin-bottom", "70px");
		HTMLAnchorElement a2 = document.createElement(StringTypes.a);
		a2.className = "block";
		a2.href = "wordAnnotation.html";
		HTMLDivElement card2 = document.createElement(StringTypes.div);
		card2.className = "card mb-4 box-shadow";
		HTMLDivElement cardBody2 = document.createElement(StringTypes.div);
		cardBody2.className = "card-body card-body-container";
		$(cardBody2).css("background-color", "rgba(157, 146, 51, 0.9)");
		HTMLHeadingElement h2 = document.createElement(StringTypes.h3);
		h2.className = "card-header text-center";
		h2.textContent = "Word Annotation";
		HTMLParagraphElement p2 = document.createElement(StringTypes.p);
		p2.className = "card-text text-center";
		p2.innerHTML = "<b>Data una definizione in inglese, l’utente deve provare a indovinare la parola definita.</b>";

		HTMLDivElement boxCard3 = document.createElement(StringTypes.div);
		boxCard3.className = "col-md-4 boxcard";
		$(boxCard3).css("margin-bottom", "70px");
		HTMLAnchorElement a3 = document.createElement(StringTypes.a);
		a3.className = "block";
		a3.href = "definitionAnnotation.html";
		HTMLDivElement card3 = document.createElement(StringTypes.div);
		card3.className = "card mb-4 box-shadow";
		HTMLDivElement cardBody3 = document.createElement(StringTypes.div);
		cardBody3.className = "card-body card-body-container";
		$(cardBody3).css("background-color", "rgba(42, 72, 152, 0.9)");
		HTMLHeadingElement h3 = document.createElement(StringTypes.h3);
		h3.className = "card-header text-center";
		h3.textContent = "Definition Annotation";
		HTMLParagraphElement p3 = document.createElement(StringTypes.p);
		p3.className = "card-text text-center";
		p3.innerHTML = "<b>Data una parola e un suo iperonimo, l’utente deve fornire una definizione nella sua lingua madre.</b>";

		HTMLDivElement boxCardCentral = document.createElement(StringTypes.div);
		boxCardCentral.className = "col-md-12 boxcard";
		$(boxCardCentral).css("margin-bottom", "70px");
		$(boxCardCentral).css("padding-left", "150px");
		$(boxCardCentral).css("padding-right", "150px");
		HTMLAnchorElement aCentral = document.createElement(StringTypes.a);
		aCentral.className = "block";
		aCentral.href = "myTextAnnotation.html";
		HTMLDivElement cardCentral = document.createElement(StringTypes.div);
		cardCentral.className = "card mb-4 box-shadow";
		HTMLDivElement cardBodyCentral = document.createElement(StringTypes.div);
		cardBodyCentral.className = "card-body card-body-container";
		$(cardBodyCentral).css("background-color", "rgba(157, 146, 51, 0.9)");
		HTMLHeadingElement hCentral = document.createElement(StringTypes.h3);
		hCentral.className = "card-header text-center";
		hCentral.textContent = "My Text Annotation";
		HTMLParagraphElement pCentral = document.createElement(StringTypes.p);
		pCentral.className = "card-text text-center";
		pCentral.innerHTML = "<b>Dato un testo, inserire le parole negli appositi spazi.</b>";

		HTMLDivElement boxCard4 = document.createElement(StringTypes.div);
		boxCard4.className = "col-md-4 boxcard";
		$(boxCard4).css("margin-bottom", "70px");
		HTMLAnchorElement a4 = document.createElement(StringTypes.a);
		a4.className = "block";
		a4.href = "senseAnnotation.html";
		HTMLDivElement card4 = document.createElement(StringTypes.div);
		card4.className = "card mb-4 box-shadow";
		HTMLDivElement cardBody4 = document.createElement(StringTypes.div);
		cardBody4.className = "card-body card-body-container";
		$(cardBody4).css("background-color", "rgba(42, 72, 152, 0.9)");
		HTMLHeadingElement h4 = document.createElement(StringTypes.h3);
		h4.className = "card-header text-center";
		h4.textContent = "Sense Annotation";
		HTMLParagraphElement p4 = document.createElement(StringTypes.p);
		p4.className = "card-text text-center";
		p4.innerHTML = "<b>Data una parola e una frase in cui la parola appare, l’utente deve selezionare il senso appropriato.</b>";

		HTMLDivElement boxCard5 = document.createElement(StringTypes.div);
		boxCard5.className = "col-md-4 boxcard";
		$(boxCard5).css("margin-bottom", "70px");
		HTMLAnchorElement a5 = document.createElement(StringTypes.a);
		a5.className = "block";
		a5.href = "translationValidation.html";
		HTMLDivElement card5 = document.createElement(StringTypes.div);
		card5.className = "card mb-4 box-shadow";
		HTMLDivElement cardBody5 = document.createElement(StringTypes.div);
		cardBody5.className = "card-body card-body-container";
		$(cardBody5).css("background-color", "rgba(157, 146, 51, 0.9)");
		HTMLHeadingElement h5 = document.createElement(StringTypes.h3);
		h5.className = "card-header text-center";
		h5.textContent = "Translation Validation";
		HTMLParagraphElement p5 = document.createElement(StringTypes.p);
		p5.className = "card-text text-center";
		p5.innerHTML = "<b>Data una parola e una sua definizione in inglese, l’utente deve scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.</b>";

		HTMLDivElement boxCard6 = document.createElement(StringTypes.div);
		boxCard6.className = "col-md-4 boxcard";
		$(boxCard6).css("margin-bottom", "70px");
		HTMLAnchorElement a6 = document.createElement(StringTypes.a);
		a6.className = "block";
		a6.href = "senseValidation.html";
		HTMLDivElement card6 = document.createElement(StringTypes.div);
		card6.className = "card mb-4 box-shadow";
		HTMLDivElement cardBody6 = document.createElement(StringTypes.div);
		cardBody6.className = "card-body card-body-container";
		$(cardBody6).css("background-color", "rgba(113, 72, 72, 0.9)");
		HTMLHeadingElement h6 = document.createElement(StringTypes.h3);
		h6.className = "card-header text-center";
		h6.textContent = "Sense Validation";
		HTMLParagraphElement p6 = document.createElement(StringTypes.p);
		p6.className = "card-text text-center";
		p6.innerHTML = "<b>Data una parola e una frase in cui appare, l’utente deve verificare se il senso fornito dal sistema è appropriato.</b>";

		$(div).append(rowDiv);
		$(rowDiv).append(boxCard1, boxCard2, boxCard3, boxCardCentral, boxCard4, boxCard5, boxCard6);

		$(boxCard1).append(a1);
		$(a1).append(card1);
		$(card1).append(cardBody1);
		$(cardBody1).append(h1, p1);

		$(boxCard2).append(a2);
		$(a2).append(card2);
		$(card2).append(cardBody2);
		$(cardBody2).append(h2, p2);

		$(boxCard3).append(a3);
		$(a3).append(card3);
		$(card3).append(cardBody3);
		$(cardBody3).append(h3, p3);

		$(boxCard4).append(a4);
		$(a4).append(card4);
		$(card4).append(cardBody4);
		$(cardBody4).append(h4, p4);

		$(boxCard5).append(a5);
		$(a5).append(card5);
		$(card5).append(cardBody5);
		$(cardBody5).append(h5, p5);

		$(boxCard6).append(a6);
		$(a6).append(card6);
		$(card6).append(cardBody6);
		$(cardBody6).append(h6, p6);

		$(boxCardCentral).append(aCentral);
		$(aCentral).append(cardCentral);
		$(cardCentral).append(cardBodyCentral);
		$(cardBodyCentral).append(hCentral, pCentral);

		$("body").append(div);

		console.log("Home done");
	}
}

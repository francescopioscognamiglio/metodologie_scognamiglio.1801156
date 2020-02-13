/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina home
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Page
 */
class Home extends Page {
    public static main(args : string[]) {
        new Home().create();
    }

    /**
     * 
     */
    public create() {
        super.create();
        console.log("Creating home");
        let div : HTMLDivElement = document.createElement("div");
        $(div).css("margin-left", "7%");
        $(div).css("margin-right", "7%");
        $(div).css("margin-top", "70px");
        $(div).css("margin-bottom", "40px");
        let rowDiv : HTMLDivElement = document.createElement("div");
        rowDiv.className = "row";
        $(rowDiv).css("width", "100%");
        $(rowDiv).css("height", "100%");
        let boxCard1 : HTMLDivElement = document.createElement("div");
        boxCard1.className = "col-md-4 boxcard";
        $(boxCard1).css("margin-bottom", "70px");
        let a1 : HTMLAnchorElement = document.createElement("a");
        a1.className = "block";
        a1.href = "translationAnnotation.html";
        let card1 : HTMLDivElement = document.createElement("div");
        card1.className = "card mb-4 box-shadow";
        let cardBody1 : HTMLDivElement = document.createElement("div");
        cardBody1.className = "card-body card-body-container";
        $(cardBody1).css("background-color", "rgba(113, 72, 72, 0.9)");
        let h1 : HTMLHeadingElement = document.createElement("h3");
        h1.className = "card-header text-center";
        h1.textContent = "Translation Annotation";
        let p1 : HTMLParagraphElement = document.createElement("p");
        p1.className = "card-text text-center";
        p1.innerHTML = "<b>Data una parola e una sua definizione in inglese, l\u2019utente deve fornire una traduzione nella sua lingua madre.</b>";
        let boxCard2 : HTMLDivElement = document.createElement("div");
        boxCard2.className = "col-md-4 boxcard";
        $(boxCard2).css("margin-bottom", "70px");
        let a2 : HTMLAnchorElement = document.createElement("a");
        a2.className = "block";
        a2.href = "wordAnnotation.html";
        let card2 : HTMLDivElement = document.createElement("div");
        card2.className = "card mb-4 box-shadow";
        let cardBody2 : HTMLDivElement = document.createElement("div");
        cardBody2.className = "card-body card-body-container";
        $(cardBody2).css("background-color", "rgba(157, 146, 51, 0.9)");
        let h2 : HTMLHeadingElement = document.createElement("h3");
        h2.className = "card-header text-center";
        h2.textContent = "Word Annotation";
        let p2 : HTMLParagraphElement = document.createElement("p");
        p2.className = "card-text text-center";
        p2.innerHTML = "<b>Data una definizione in inglese, l\u2019utente deve provare a indovinare la parola definita.</b>";
        let boxCard3 : HTMLDivElement = document.createElement("div");
        boxCard3.className = "col-md-4 boxcard";
        $(boxCard3).css("margin-bottom", "70px");
        let a3 : HTMLAnchorElement = document.createElement("a");
        a3.className = "block";
        a3.href = "definitionAnnotation.html";
        let card3 : HTMLDivElement = document.createElement("div");
        card3.className = "card mb-4 box-shadow";
        let cardBody3 : HTMLDivElement = document.createElement("div");
        cardBody3.className = "card-body card-body-container";
        $(cardBody3).css("background-color", "rgba(42, 72, 152, 0.9)");
        let h3 : HTMLHeadingElement = document.createElement("h3");
        h3.className = "card-header text-center";
        h3.textContent = "Definition Annotation";
        let p3 : HTMLParagraphElement = document.createElement("p");
        p3.className = "card-text text-center";
        p3.innerHTML = "<b>Data una parola e un suo iperonimo, l\u2019utente deve fornire una definizione nella sua lingua madre.</b>";
        let boxCardCentral : HTMLDivElement = document.createElement("div");
        boxCardCentral.className = "col-md-12 boxcard";
        $(boxCardCentral).css("margin-bottom", "70px");
        $(boxCardCentral).css("padding-left", "150px");
        $(boxCardCentral).css("padding-right", "150px");
        let aCentral : HTMLAnchorElement = document.createElement("a");
        aCentral.className = "block";
        aCentral.href = "myTextAnnotation.html";
        let cardCentral : HTMLDivElement = document.createElement("div");
        cardCentral.className = "card mb-4 box-shadow";
        let cardBodyCentral : HTMLDivElement = document.createElement("div");
        cardBodyCentral.className = "card-body card-body-container";
        $(cardBodyCentral).css("background-color", "rgba(157, 146, 51, 0.9)");
        let hCentral : HTMLHeadingElement = document.createElement("h3");
        hCentral.className = "card-header text-center";
        hCentral.textContent = "My Text Annotation";
        let pCentral : HTMLParagraphElement = document.createElement("p");
        pCentral.className = "card-text text-center";
        pCentral.innerHTML = "<b>Dato un testo, inserire le parole negli appositi spazi.</b>";
        let boxCard4 : HTMLDivElement = document.createElement("div");
        boxCard4.className = "col-md-4 boxcard";
        $(boxCard4).css("margin-bottom", "70px");
        let a4 : HTMLAnchorElement = document.createElement("a");
        a4.className = "block";
        a4.href = "senseAnnotation.html";
        let card4 : HTMLDivElement = document.createElement("div");
        card4.className = "card mb-4 box-shadow";
        let cardBody4 : HTMLDivElement = document.createElement("div");
        cardBody4.className = "card-body card-body-container";
        $(cardBody4).css("background-color", "rgba(42, 72, 152, 0.9)");
        let h4 : HTMLHeadingElement = document.createElement("h3");
        h4.className = "card-header text-center";
        h4.textContent = "Sense Annotation";
        let p4 : HTMLParagraphElement = document.createElement("p");
        p4.className = "card-text text-center";
        p4.innerHTML = "<b>Data una parola e una frase in cui la parola appare, l\u2019utente deve selezionare il senso appropriato.</b>";
        let boxCard5 : HTMLDivElement = document.createElement("div");
        boxCard5.className = "col-md-4 boxcard";
        $(boxCard5).css("margin-bottom", "70px");
        let a5 : HTMLAnchorElement = document.createElement("a");
        a5.className = "block";
        a5.href = "translationValidation.html";
        let card5 : HTMLDivElement = document.createElement("div");
        card5.className = "card mb-4 box-shadow";
        let cardBody5 : HTMLDivElement = document.createElement("div");
        cardBody5.className = "card-body card-body-container";
        $(cardBody5).css("background-color", "rgba(157, 146, 51, 0.9)");
        let h5 : HTMLHeadingElement = document.createElement("h3");
        h5.className = "card-header text-center";
        h5.textContent = "Translation Validation";
        let p5 : HTMLParagraphElement = document.createElement("p");
        p5.className = "card-text text-center";
        p5.innerHTML = "<b>Data una parola e una sua definizione in inglese, l\u2019utente deve scegliere la miglior traduzione tra quelle fornite o specificare <nessuna>.</b>";
        let boxCard6 : HTMLDivElement = document.createElement("div");
        boxCard6.className = "col-md-4 boxcard";
        $(boxCard6).css("margin-bottom", "70px");
        let a6 : HTMLAnchorElement = document.createElement("a");
        a6.className = "block";
        a6.href = "senseValidation.html";
        let card6 : HTMLDivElement = document.createElement("div");
        card6.className = "card mb-4 box-shadow";
        let cardBody6 : HTMLDivElement = document.createElement("div");
        cardBody6.className = "card-body card-body-container";
        $(cardBody6).css("background-color", "rgba(113, 72, 72, 0.9)");
        let h6 : HTMLHeadingElement = document.createElement("h3");
        h6.className = "card-header text-center";
        h6.textContent = "Sense Validation";
        let p6 : HTMLParagraphElement = document.createElement("p");
        p6.className = "card-text text-center";
        p6.innerHTML = "<b>Data una parola e una frase in cui appare, l\u2019utente deve verificare se il senso fornito dal sistema \u00e8 appropriato.</b>";
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
Home["__class"] = "Home";




Home.main(null);

/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta il footer
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 */
class Footer {
    public static AUTHOR_FULLNAME : string = "Francesco Pio Scognamiglio ";

    public static AUTHOR_FACEBOOK_LINK : string = "https://www.facebook.com/francescopioscognamiglio.dev";

    public static AUTHOR_LINKEDIN_LINK : string = "https://www.linkedin.com/in/francescopioscognamiglio";

    public static AUTHOR_EMAIL_LINK : string = "mailto:scognamiglio.1801156@studenti.uniroma1.it";

    public static createFooter() : HTMLElement {
        console.log("Creating footer");
        let footer : HTMLElement = document.createElement("footer");
        footer.className = "page-footer font-small bg-dark text-light fixed-bottom";
        let principalDiv : HTMLDivElement = document.createElement("div");
        principalDiv.className = "row mt-2 py-3";
        let copyrightDiv : HTMLDivElement = document.createElement("div");
        copyrightDiv.className = "col-md-4 offset-md-4 text-center";
        copyrightDiv.textContent = "\u00a9 2020 Author: ";
        let authorName : HTMLElement = document.createElement("b");
        authorName.textContent = Footer.AUTHOR_FULLNAME;
        let studyPhrase : HTMLElement = document.createElement("i");
        studyPhrase.className = "fas fa-graduation-cap white-text";
        let linksDiv : HTMLDivElement = document.createElement("div");
        linksDiv.className = "col-md-4 text-right";
        let facebookLink : HTMLAnchorElement = document.createElement("a");
        facebookLink.className = "fb-ic mr-4";
        facebookLink.href = Footer.AUTHOR_FACEBOOK_LINK;
        $(facebookLink).css("color", "white");
        let facebookPhrase : HTMLElement = document.createElement("i");
        facebookPhrase.className = "fab fa-facebook-f fa-lg white-text";
        let linkedinLink : HTMLAnchorElement = document.createElement("a");
        linkedinLink.className = "li-ic mr-4";
        linkedinLink.href = Footer.AUTHOR_LINKEDIN_LINK;
        $(linkedinLink).css("color", "white");
        let linkedinPhrase : HTMLElement = document.createElement("i");
        linkedinPhrase.className = "fab fa-linkedin-in fa-lg white-text";
        let emailLink : HTMLAnchorElement = document.createElement("a");
        emailLink.className = "gplus-ic mr-4";
        emailLink.href = Footer.AUTHOR_EMAIL_LINK;
        $(emailLink).css("color", "white");
        let emailPhrase : HTMLElement = document.createElement("i");
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
Footer["__class"] = "Footer";




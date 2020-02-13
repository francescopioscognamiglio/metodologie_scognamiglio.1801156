/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta il footer
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 */
class Footer {
    static createFooter() {
        console.log("Creating footer");
        let footer = document.createElement("footer");
        footer.className = "page-footer font-small bg-dark text-light fixed-bottom";
        let principalDiv = document.createElement("div");
        principalDiv.className = "row mt-2 py-3";
        let copyrightDiv = document.createElement("div");
        copyrightDiv.className = "col-md-4 offset-md-4 text-center";
        copyrightDiv.textContent = "\u00a9 2020 Author: ";
        let authorName = document.createElement("b");
        authorName.textContent = Footer.AUTHOR_FULLNAME;
        let studyPhrase = document.createElement("i");
        studyPhrase.className = "fas fa-graduation-cap white-text";
        let linksDiv = document.createElement("div");
        linksDiv.className = "col-md-4 text-right";
        let facebookLink = document.createElement("a");
        facebookLink.className = "fb-ic mr-4";
        facebookLink.href = Footer.AUTHOR_FACEBOOK_LINK;
        $(facebookLink).css("color", "white");
        let facebookPhrase = document.createElement("i");
        facebookPhrase.className = "fab fa-facebook-f fa-lg white-text";
        let linkedinLink = document.createElement("a");
        linkedinLink.className = "li-ic mr-4";
        linkedinLink.href = Footer.AUTHOR_LINKEDIN_LINK;
        $(linkedinLink).css("color", "white");
        let linkedinPhrase = document.createElement("i");
        linkedinPhrase.className = "fab fa-linkedin-in fa-lg white-text";
        let emailLink = document.createElement("a");
        emailLink.className = "gplus-ic mr-4";
        emailLink.href = Footer.AUTHOR_EMAIL_LINK;
        $(emailLink).css("color", "white");
        let emailPhrase = document.createElement("i");
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
Footer.AUTHOR_FULLNAME = "Francesco Pio Scognamiglio ";
Footer.AUTHOR_FACEBOOK_LINK = "https://www.facebook.com/francescopioscognamiglio.dev";
Footer.AUTHOR_LINKEDIN_LINK = "https://www.linkedin.com/in/francescopioscognamiglio";
Footer.AUTHOR_EMAIL_LINK = "mailto:scognamiglio.1801156@studenti.uniroma1.it";
Footer["__class"] = "Footer";

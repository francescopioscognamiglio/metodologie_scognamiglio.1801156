/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe contiene il codice in comune tra le pagine di Login e di Signup
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @param {string} title
 * @param {string} type
 * @param {string} action
 * @param {string} actionLabel
 * @param {string} alternativeLabel
 * @param {string} alternativeLink
 * @param {string} alternativeLinkLabel
 * @class
 * @extends Page
 */
class Entry extends Page {
    constructor(title, type, action, actionLabel, alternativeLabel, alternativeLink, alternativeLinkLabel) {
        super();
        if (this.title === undefined)
            this.title = null;
        if (this.type === undefined)
            this.type = null;
        if (this.action === undefined)
            this.action = null;
        if (this.actionLabel === undefined)
            this.actionLabel = null;
        if (this.alternativeLabel === undefined)
            this.alternativeLabel = null;
        if (this.alternativeLink === undefined)
            this.alternativeLink = null;
        if (this.alternativeLinkLabel === undefined)
            this.alternativeLinkLabel = null;
        this.type = type;
        this.title = title;
        this.action = action;
        this.actionLabel = actionLabel;
        this.alternativeLabel = alternativeLabel;
        this.alternativeLink = alternativeLink;
        this.alternativeLinkLabel = alternativeLinkLabel;
    }
    /**
     *
     */
    create() {
        super.create();
        $("body").addClass("body-entry");
        let divContainer = document.createElement("div");
        divContainer.className = "container container-entry-" + this.getType();
        let divRow = document.createElement("div");
        divRow.className = "row";
        let divCol1 = document.createElement("div");
        divCol1.className = "col-sm-9 col-md-7 col-lg-5 mx-auto";
        let divCard = document.createElement("div");
        divCard.className = "card";
        let divCardBody1 = document.createElement("div");
        divCardBody1.className = "card-body";
        let divHeading = document.createElement("h5");
        divHeading.className = "text-center";
        divHeading.textContent = this.getTitle();
        let divCardMy4 = document.createElement("div");
        divCardMy4.className = "card my-4";
        let divCardBody2 = document.createElement("div");
        divCardBody2.className = "card-body";
        let form = document.createElement("form");
        form.id = "form-entry";
        form.action = this.getAction();
        form.method = "post";
        form.onsubmit = (e) => { return this.onSubmit(e); };
        let incorrectData = document.createElement("div");
        incorrectData.className = "alert alert-danger text-center";
        incorrectData.setAttribute("hidden", "");
        let br = document.createElement("br");
        let divFormGroupSubmit = document.createElement("div");
        divFormGroupSubmit.className = "form-group";
        let inputSubmit = document.createElement("input");
        inputSubmit.className = "btn btn-lg btn-primary btn-block";
        inputSubmit.type = "submit";
        inputSubmit.value = this.getActionLabel();
        let hrLast = document.createElement("hr");
        hrLast.className = "my-1";
        let divCardAlternative = document.createElement("div");
        divCardAlternative.className = "card my-4";
        let divCardSubAlternative = document.createElement("div");
        divCardSubAlternative.className = "card-body";
        let divCardSubSubAlternative = document.createElement("div");
        divCardSubSubAlternative.className = "text-center";
        divCardSubSubAlternative.textContent = this.getAlternativeLabel();
        let aRegister = document.createElement("a");
        aRegister.href = this.getAlternativeLink();
        aRegister.textContent = this.getAlternativeLinkLabel();
        $(divContainer).append(divRow);
        $(divRow).append(divCol1);
        $(divCol1).append(divCard, divCardMy4, divCardAlternative);
        $(divCard).append(divCardBody1);
        $(divCardBody1).append(divHeading);
        $(divCardMy4).append(divCardBody2);
        $(divCardBody2).append(form);
        $(form).append(incorrectData, this.getCustomComponents(), br, divFormGroupSubmit, hrLast);
        $(divFormGroupSubmit).append(inputSubmit);
        $(divCardAlternative).append(divCardSubAlternative);
        $(divCardSubAlternative).append(divCardSubSubAlternative);
        $(divCardSubSubAlternative).append(aRegister);
        $("body").append(divContainer);
    }
    setType(type) {
        this.type = type;
    }
    getTitle() {
        return this.title;
    }
    getType() {
        return this.type;
    }
    setTitle(title) {
        this.title = title;
    }
    getAction() {
        return this.action;
    }
    setAction(action) {
        this.action = action;
    }
    getActionLabel() {
        return this.actionLabel;
    }
    setActionLabel(actionLabel) {
        this.actionLabel = actionLabel;
    }
    getAlternativeLabel() {
        return this.alternativeLabel;
    }
    setAlternativeLabel(alternativeLabel) {
        this.alternativeLabel = alternativeLabel;
    }
    getAlternativeLink() {
        return this.alternativeLink;
    }
    setAlternativeLink(alternativeLink) {
        this.alternativeLink = alternativeLink;
    }
    getAlternativeLinkLabel() {
        return this.alternativeLinkLabel;
    }
    setAlternativeLinkLabel(alternativeLinkLabel) {
        this.alternativeLinkLabel = alternativeLinkLabel;
    }
}
Entry["__class"] = "Entry";

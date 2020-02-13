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
abstract class Entry extends Page {
    /*private*/ title : string;

    /*private*/ type : string;

    /*private*/ action : string;

    /*private*/ actionLabel : string;

    /*private*/ alternativeLabel : string;

    /*private*/ alternativeLink : string;

    /*private*/ alternativeLinkLabel : string;

    public constructor(title : string, type : string, action : string, actionLabel : string, alternativeLabel : string, alternativeLink : string, alternativeLinkLabel : string) {
        super();
        if(this.title===undefined) this.title = null;
        if(this.type===undefined) this.type = null;
        if(this.action===undefined) this.action = null;
        if(this.actionLabel===undefined) this.actionLabel = null;
        if(this.alternativeLabel===undefined) this.alternativeLabel = null;
        if(this.alternativeLink===undefined) this.alternativeLink = null;
        if(this.alternativeLinkLabel===undefined) this.alternativeLinkLabel = null;
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
    public create() {
        super.create();
        $("body").addClass("body-entry");
        let divContainer : HTMLDivElement = document.createElement("div");
        divContainer.className = "container container-entry-" + this.getType();
        let divRow : HTMLDivElement = document.createElement("div");
        divRow.className = "row";
        let divCol1 : HTMLDivElement = document.createElement("div");
        divCol1.className = "col-sm-9 col-md-7 col-lg-5 mx-auto";
        let divCard : HTMLDivElement = document.createElement("div");
        divCard.className = "card";
        let divCardBody1 : HTMLDivElement = document.createElement("div");
        divCardBody1.className = "card-body";
        let divHeading : HTMLHeadingElement = document.createElement("h5");
        divHeading.className = "text-center";
        divHeading.textContent = this.getTitle();
        let divCardMy4 : HTMLDivElement = document.createElement("div");
        divCardMy4.className = "card my-4";
        let divCardBody2 : HTMLDivElement = document.createElement("div");
        divCardBody2.className = "card-body";
        let form : HTMLFormElement = document.createElement("form");
        form.id = "form-entry";
        form.action = this.getAction();
        form.method = "post";
        form.onsubmit = (e) => { return this.onSubmit(e) };
        let incorrectData : HTMLDivElement = document.createElement("div");
        incorrectData.className = "alert alert-danger text-center";
        incorrectData.setAttribute("hidden", "");
        let br : HTMLBRElement = document.createElement("br");
        let divFormGroupSubmit : HTMLDivElement = document.createElement("div");
        divFormGroupSubmit.className = "form-group";
        let inputSubmit : HTMLInputElement = document.createElement("input");
        inputSubmit.className = "btn btn-lg btn-primary btn-block";
        inputSubmit.type = "submit";
        inputSubmit.value = this.getActionLabel();
        let hrLast : HTMLHRElement = document.createElement("hr");
        hrLast.className = "my-1";
        let divCardAlternative : HTMLDivElement = document.createElement("div");
        divCardAlternative.className = "card my-4";
        let divCardSubAlternative : HTMLDivElement = document.createElement("div");
        divCardSubAlternative.className = "card-body";
        let divCardSubSubAlternative : HTMLDivElement = document.createElement("div");
        divCardSubSubAlternative.className = "text-center";
        divCardSubSubAlternative.textContent = this.getAlternativeLabel();
        let aRegister : HTMLAnchorElement = document.createElement("a");
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

    public abstract getCustomComponents() : HTMLElement[];

    public abstract onSubmit(e : Event) : boolean;

    public setType(type : string) {
        this.type = type;
    }

    public getTitle() : string {
        return this.title;
    }

    public getType() : string {
        return this.type;
    }

    public setTitle(title : string) {
        this.title = title;
    }

    public getAction() : string {
        return this.action;
    }

    public setAction(action : string) {
        this.action = action;
    }

    public getActionLabel() : string {
        return this.actionLabel;
    }

    public setActionLabel(actionLabel : string) {
        this.actionLabel = actionLabel;
    }

    public getAlternativeLabel() : string {
        return this.alternativeLabel;
    }

    public setAlternativeLabel(alternativeLabel : string) {
        this.alternativeLabel = alternativeLabel;
    }

    public getAlternativeLink() : string {
        return this.alternativeLink;
    }

    public setAlternativeLink(alternativeLink : string) {
        this.alternativeLink = alternativeLink;
    }

    public getAlternativeLinkLabel() : string {
        return this.alternativeLinkLabel;
    }

    public setAlternativeLinkLabel(alternativeLinkLabel : string) {
        this.alternativeLinkLabel = alternativeLinkLabel;
    }
}
Entry["__class"] = "Entry";




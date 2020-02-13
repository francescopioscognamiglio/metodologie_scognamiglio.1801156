/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta un task generico
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @param {string} taskURL
 * @class
 * @extends Page
 */
abstract class Task extends Page {
    /*private*/ taskURL : string;

    public constructor(taskURL : string) {
        super();
        if(this.taskURL===undefined) this.taskURL = null;
        this.taskURL = taskURL;
    }

    /**
     * 
     */
    public create() {
        super.create();
        console.log("Creating form");
        let form : HTMLFormElement = document.createElement("form");
        form.action = this.taskURL;
        form.method = "POST";
        form.className = "container";
        $(form).css("margin-top", "100px");
        $(form).css("margin-bottom", "100px");
        console.log("Form Done");
        let navBreadcrumb : HTMLElement = document.createElement("nav");
        navBreadcrumb.setAttribute("aria-label", "breadcrumb");
        let olBreadcrumb : HTMLOListElement = document.createElement("ol");
        olBreadcrumb.className = "breadcrumb";
        let liBreadcrumb1 : HTMLLIElement = document.createElement("li");
        liBreadcrumb1.className = "breadcrumb-item";
        let aBreadcrumb1 : HTMLAnchorElement = document.createElement("a");
        aBreadcrumb1.href = "home.html";
        aBreadcrumb1.textContent = "Home";
        let liBreadcrumb2 : HTMLLIElement = document.createElement("li");
        liBreadcrumb2.className = "breadcrumb-item active";
        liBreadcrumb2.setAttribute("aria-current", "page");
        liBreadcrumb2.textContent = "Task";
        $(navBreadcrumb).append(olBreadcrumb);
        $(olBreadcrumb).append(liBreadcrumb1, liBreadcrumb2);
        $(liBreadcrumb1).append(aBreadcrumb1);
        let taskTitle : HTMLLabelElement = document.createElement("label");
        taskTitle.id = "title";
        taskTitle.className = "form-control-plaintext text-center";
        taskTitle.setAttribute("style", "font-weight:bold; font-size:17px;");
        let hr : HTMLHRElement = document.createElement("hr");
        let br : HTMLBRElement = document.createElement("br");
        let skip : HTMLInputElement = document.createElement("input");
        skip.type = "submit";
        skip.name = "skip_button";
        skip.className = "btn btn-outline-dark col-md-3";
        skip.value = "Skip";
        skip.formNoValidate = "true";
        $(skip).css("float", "left");
        let submit : HTMLInputElement = document.createElement("input");
        submit.type = "submit";
        submit.name = "submit_button";
        submit.className = "btn btn-outline-primary col-md-3";
        submit.value = "Next";
        $(submit).css("float", "right");
        let divDescription : HTMLDivElement = document.createElement("div");
        divDescription.className = "form-group";
        $(divDescription).append(taskTitle, hr.cloneNode(), this.createData());
        let divAnswer : HTMLDivElement = document.createElement("div");
        divAnswer.className = "form-group";
        $(divAnswer).append(this.createAnswer());
        let divButtons : HTMLDivElement = document.createElement("div");
        divButtons.className = "form-group";
        $(divButtons).append(submit, skip);
        console.log("adding to form");
        $(form).append(navBreadcrumb, br.cloneNode(), divDescription, divAnswer, br.cloneNode(), divButtons);
        console.log("adding to body");
        $("body").append(form);
        this.extra();
    }

    public abstract createData() : HTMLElement[];

    public abstract createAnswer() : HTMLElement[];

    public abstract extra();
}
Task["__class"] = "Task";




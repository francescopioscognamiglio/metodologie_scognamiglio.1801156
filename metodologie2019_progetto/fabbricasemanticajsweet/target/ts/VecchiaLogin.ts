/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * This class is used within the webapp/index.html file.
 * @class
 */
class VecchiaLogin {
    public static SERVLET_URL : string = "login.jsp";

    public static HOME_URL : string = "home.html";

    public static REGISTER_LINK : string = "signup.html";

    public static main(args : string[]) {
        console.log("Creating form");
        let container : HTMLDivElement = document.createElement("div");
        container.className = "container";
        $(container).css("margin-top", "150px");
        $(container).css("margin-bottom", "150px");
        let row : HTMLDivElement = document.createElement("div");
        row.className = "row";
        let center : HTMLDivElement = document.createElement("div");
        center.className = "col-sm-9 col-md-7 col-lg-5 mx-auto";
        let incorrectData : HTMLDivElement = document.createElement("div");
        incorrectData.className = "alert alert-danger text-center";
        incorrectData.setAttribute("hidden", "");
        incorrectData.textContent = "Indirizzo email o password errata.";
        let cardTitle : HTMLDivElement = document.createElement("div");
        cardTitle.className = "card";
        let cardBodyTitle : HTMLDivElement = document.createElement("div");
        cardBodyTitle.className = "card-body";
        let cardHeading : HTMLHeadingElement = document.createElement("h5");
        cardHeading.className = "text-center";
        cardHeading.textContent = "Sign In";
        let cardForm : HTMLDivElement = document.createElement("div");
        cardForm.className = "card my-4";
        let cardBodyForm : HTMLDivElement = document.createElement("div");
        cardBodyForm.className = "card-body";
        let formLogin : HTMLFormElement = document.createElement("form");
        formLogin.action = "home.html";
        formLogin.method = "post";
        formLogin.onsubmit = (e) => { return VecchiaLogin.onSubmit(e) };
        let divEmail : HTMLDivElement = document.createElement("div");
        divEmail.className = "form-group";
        let labelEmail : HTMLLabelElement = document.createElement("label");
        labelEmail.textContent = "Indirizzo email";
        let inputEmail : HTMLInputElement = document.createElement("input");
        inputEmail.className = "form-control";
        inputEmail.name = "email";
        inputEmail.type = "email";
        inputEmail.placeholder = "Inserire l\'email";
        inputEmail.required = true;
        let divPassword : HTMLDivElement = document.createElement("div");
        divPassword.className = "form-group";
        let labelPassword : HTMLLabelElement = document.createElement("label");
        labelPassword.textContent = "Password";
        let inputPassword : HTMLInputElement = document.createElement("input");
        inputPassword.className = "form-control";
        inputPassword.name = "password";
        inputPassword.type = "password";
        inputPassword.placeholder = "Inserire la password";
        inputPassword.required = true;
        let br : HTMLBRElement = document.createElement("br");
        let divButton : HTMLDivElement = document.createElement("div");
        divButton.className = "form-group";
        let submitButton : HTMLInputElement = document.createElement("input");
        submitButton.className = "btn btn-lg btn-primary btn-block";
        submitButton.type = "submit";
        submitButton.value = "Sign in";
        let hr : HTMLHRElement = document.createElement("hr");
        hr.className = "my-1";
        let cardChange : HTMLDivElement = document.createElement("div");
        cardChange.className = "card my-4";
        let cardBodyChange : HTMLDivElement = document.createElement("div");
        cardBodyChange.className = "card-body";
        let cardCenter : HTMLDivElement = document.createElement("div");
        cardCenter.className = "text-center";
        cardCenter.textContent = "Sei un nuovo utente? ";
        let cardLink : HTMLAnchorElement = document.createElement("a");
        cardLink.href = VecchiaLogin.REGISTER_LINK;
        cardLink.textContent = "Sign up";
        console.log("adding to form");
        $(container).append(row);
        $(row).append(center);
        $(center).append(incorrectData, cardTitle, cardForm, cardChange);
        $(cardTitle).append(cardBodyTitle);
        $(cardBodyTitle).append(cardHeading);
        $(cardForm).append(cardBodyForm);
        $(cardBodyForm).append(formLogin);
        $(formLogin).append(divEmail, divPassword, br, divButton, hr);
        $(divEmail).append(labelEmail, inputEmail);
        $(divPassword).append(labelPassword, inputPassword);
        $(divButton).append(submitButton);
        $(cardChange).append(cardBodyChange);
        $(cardBodyChange).append(cardCenter);
        $(cardCenter).append(cardLink);
        console.log("adding to body");
        $("body").css("background-color", "rgba(55,68,74,0.9)");
        $("body").append(Header.createHeader(), container, Footer.createFooter());
    }

    /*private*/ static onSubmit(e : Event) : boolean {
        let email : string = (<HTMLInputElement>document.querySelector("[name=\'email\']")).value;
        let password : string = (<HTMLInputElement>document.querySelector("[name=\'password\']")).value;
        $.get(VecchiaLogin.SERVLET_URL, "email=" + email + "&password=" + password, (result, a, ctx) => {
            console.log(result.toString());
            if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })("false",result.toString()))) {
                console.log("Utente non esiste");
                $(".alert-danger").removeAttr("hidden");
            } else {
                console.log("Utente corretto");
                window.location.href = VecchiaLogin.HOME_URL;
            }
            return null;
        });
        return false;
    }
}
VecchiaLogin["__class"] = "VecchiaLogin";




VecchiaLogin.main(null);

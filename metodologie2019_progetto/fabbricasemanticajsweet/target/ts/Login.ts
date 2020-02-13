/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina di Login
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Entry
 */
class Login extends Entry {
    public static LOGIN_TITLE : string = "Sign In";

    public static LOGIN_TYPE : string = "login";

    public static LOGIN_ACTION : string = "login.jsp";

    public static LOGIN_ACTION_LABEL : string = "Sign In";

    public static REGISTER_LABEL : string = "Sei un nuovo utente? ";

    public static REGISTER_LINK : string = "signup.html";

    public static REGISTER_LINK_LABEL : string = "Sign Up";

    public static main(args : string[]) {
        let login : Login = new Login();
        login.create();
    }

    public constructor() {
        super(Login.LOGIN_TITLE, Login.LOGIN_TYPE, Login.LOGIN_ACTION, Login.LOGIN_ACTION_LABEL, Login.REGISTER_LABEL, Login.REGISTER_LINK, Login.REGISTER_LINK_LABEL);
    }

    public getCustomComponents() : HTMLElement[] {
        let divFormGroupEmail : HTMLDivElement = document.createElement("div");
        divFormGroupEmail.className = "form-group";
        let labelEmail : HTMLLabelElement = document.createElement("label");
        labelEmail.textContent = "Indirizzo email";
        $(labelEmail).css("font-weight", "bold");
        let inputEmail : HTMLInputElement = document.createElement("input");
        inputEmail.className = "form-control";
        inputEmail.name = "email";
        inputEmail.type = "email";
        inputEmail.placeholder = "Inserire l\'email";
        inputEmail.required = true;
        let divFormGroupPassword : HTMLDivElement = document.createElement("div");
        divFormGroupPassword.className = "form-group";
        let labelPassword : HTMLLabelElement = document.createElement("label");
        labelPassword.textContent = "Password";
        $(labelPassword).css("font-weight", "bold");
        let inputPassword : HTMLInputElement = document.createElement("input");
        inputPassword.className = "form-control";
        inputPassword.name = "password";
        inputPassword.type = "password";
        inputPassword.placeholder = "Inserire la password";
        inputPassword.required = true;
        $(divFormGroupEmail).append(labelEmail, inputEmail);
        $(divFormGroupPassword).append(labelPassword, inputPassword);
        return [divFormGroupEmail, divFormGroupPassword];
    }

    /**
     * 
     * @param {Event} e
     * @return {boolean}
     */
    public onSubmit(e : Event) : boolean {
        let email : string = (<HTMLInputElement>document.querySelector("[name=\'email\']")).value;
        let password : string = (<HTMLInputElement>document.querySelector("[name=\'password\']")).value;
        $.get(Login.LOGIN_ACTION, "email=" + email + "&password=" + password, (result, a, ctx) => {
            console.log(result.toString());
            if(!/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })("true",result.toString()))) {
                console.log("Utente non esiste");
                $(".alert-danger").removeAttr("hidden");
                $(".alert-danger").text(result.toString());
            } else {
                console.log("Utente corretto");
                window.location.href = "home.html";
            }
            return null;
        });
        return false;
    }
}
Login["__class"] = "Login";




Login.main(null);

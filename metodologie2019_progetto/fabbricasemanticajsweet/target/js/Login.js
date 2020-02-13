/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina di Login
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Entry
 */
class Login extends Entry {
    constructor() {
        super(Login.LOGIN_TITLE, Login.LOGIN_TYPE, Login.LOGIN_ACTION, Login.LOGIN_ACTION_LABEL, Login.REGISTER_LABEL, Login.REGISTER_LINK, Login.REGISTER_LINK_LABEL);
    }
    static main(args) {
        let login = new Login();
        login.create();
    }
    getCustomComponents() {
        let divFormGroupEmail = document.createElement("div");
        divFormGroupEmail.className = "form-group";
        let labelEmail = document.createElement("label");
        labelEmail.textContent = "Indirizzo email";
        $(labelEmail).css("font-weight", "bold");
        let inputEmail = document.createElement("input");
        inputEmail.className = "form-control";
        inputEmail.name = "email";
        inputEmail.type = "email";
        inputEmail.placeholder = "Inserire l\'email";
        inputEmail.required = true;
        let divFormGroupPassword = document.createElement("div");
        divFormGroupPassword.className = "form-group";
        let labelPassword = document.createElement("label");
        labelPassword.textContent = "Password";
        $(labelPassword).css("font-weight", "bold");
        let inputPassword = document.createElement("input");
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
    onSubmit(e) {
        let email = document.querySelector("[name=\'email\']").value;
        let password = document.querySelector("[name=\'password\']").value;
        $.get(Login.LOGIN_ACTION, "email=" + email + "&password=" + password, (result, a, ctx) => {
            console.log(result.toString());
            if (!((o1, o2) => { if (o1 && o1.equals) {
                return o1.equals(o2);
            }
            else {
                return o1 === o2;
            } })("true", result.toString())) {
                console.log("Utente non esiste");
                $(".alert-danger").removeAttr("hidden");
                $(".alert-danger").text(result.toString());
            }
            else {
                console.log("Utente corretto");
                window.location.href = "home.html";
            }
            return null;
        });
        return false;
    }
}
Login.LOGIN_TITLE = "Sign In";
Login.LOGIN_TYPE = "login";
Login.LOGIN_ACTION = "login.jsp";
Login.LOGIN_ACTION_LABEL = "Sign In";
Login.REGISTER_LABEL = "Sei un nuovo utente? ";
Login.REGISTER_LINK = "signup.html";
Login.REGISTER_LINK_LABEL = "Sign Up";
Login["__class"] = "Login";
Login.main(null);

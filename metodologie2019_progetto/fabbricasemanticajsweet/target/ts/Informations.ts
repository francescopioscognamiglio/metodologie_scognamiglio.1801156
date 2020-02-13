/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * This class is used within the webapp/index.html file.
 * @class
 * @extends Page
 */
class Informations extends Page {
    /**
     * FIXME: CREARE UNA PAGINA DI RIEPILOGO DELLE INFORMAZIONI INSERITE NEL PROFILO.
     * @param {Array} args
     */
    public static main(args : string[]) {
        let informations : Informations = new Informations();
        informations.create();
    }

    /**
     * 
     */
    public create() {
        super.create();
        let divFormGroupEmail : HTMLDivElement = document.createElement("div");
        divFormGroupEmail.className = "form-group";
        let labelEmail : HTMLLabelElement = document.createElement("label");
        labelEmail.textContent = "Indirizzo email";
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
        let inputPassword : HTMLInputElement = document.createElement("input");
        inputPassword.className = "form-control";
        inputPassword.name = "password";
        inputPassword.type = "password";
        inputPassword.placeholder = "Inserire la password";
        inputPassword.required = true;
        $(divFormGroupEmail).append(labelEmail, inputEmail);
        $(divFormGroupPassword).append(labelPassword, inputPassword);
    }
}
Informations["__class"] = "Informations";




Informations.main(null);

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
    static main(args) {
        let informations = new Informations();
        informations.create();
    }
    /**
     *
     */
    create() {
        super.create();
        let divFormGroupEmail = document.createElement("div");
        divFormGroupEmail.className = "form-group";
        let labelEmail = document.createElement("label");
        labelEmail.textContent = "Indirizzo email";
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
        let inputPassword = document.createElement("input");
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

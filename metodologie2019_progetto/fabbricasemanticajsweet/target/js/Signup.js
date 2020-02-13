/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina di Signup
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Entry
 */
class Signup extends Entry {
    constructor() {
        super(Signup.REGISTER_TITLE, Signup.REGISTER_TYPE, Signup.REGISTER_ACTION, Signup.REGISTER_ACTION_LABEL, Signup.LOGIN_LABEL, Signup.LOGIN_LINK, Signup.LOGIN_LINK_LABEL);
    }
    static main(args) {
        let register = new Signup();
        register.create();
    }
    getCustomComponents() {
        let divFormGroupFullName = document.createElement("div");
        divFormGroupFullName.className = "form-group";
        let rowName = document.createElement("div");
        rowName.className = "row";
        let colFirstName = document.createElement("div");
        colFirstName.className = "col";
        let labelFirstName = document.createElement("label");
        labelFirstName.textContent = "Nome";
        $(labelFirstName).css("font-weight", "bold");
        let inputFirstName = document.createElement("input");
        inputFirstName.className = "form-control";
        inputFirstName.name = "firstname";
        inputFirstName.type = "text";
        inputFirstName.placeholder = "Inserire il nome";
        inputFirstName.required = true;
        let colLastName = document.createElement("div");
        colLastName.className = "col";
        let labelLastName = document.createElement("label");
        labelLastName.textContent = "Cognome";
        $(labelLastName).css("font-weight", "bold");
        let inputLastName = document.createElement("input");
        inputLastName.className = "form-control";
        inputLastName.name = "lastname";
        inputLastName.type = "text";
        inputLastName.placeholder = "Inserire il cognome";
        inputLastName.required = true;
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
        let divFormGroupConfirmPassword = document.createElement("div");
        divFormGroupConfirmPassword.className = "form-group";
        let labelConfirmPassword = document.createElement("label");
        labelConfirmPassword.textContent = "Conferma password";
        $(labelConfirmPassword).css("font-weight", "bold");
        let inputConfirmPassword = document.createElement("input");
        inputConfirmPassword.className = "form-control";
        inputConfirmPassword.name = "confirmpassword";
        inputConfirmPassword.type = "password";
        inputConfirmPassword.placeholder = "Ripetere la password";
        inputConfirmPassword.required = true;
        let divFormGroupLanguage = document.createElement("div");
        divFormGroupLanguage.className = "form-group";
        let labelLanguage = document.createElement("label");
        labelLanguage.textContent = "Scegliere una o pi\u00f9 lingue madre";
        $(labelLanguage).css("font-weight", "bold");
        let brLanguage = document.createElement("br");
        let divFormCheckLanguageIt = document.createElement("div");
        divFormCheckLanguageIt.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageIt = document.createElement("input");
        divFormCheckInputLanguageIt.className = "form-check-input";
        divFormCheckInputLanguageIt.id = "languagecheck";
        divFormCheckInputLanguageIt.name = "language";
        divFormCheckInputLanguageIt.type = "checkbox";
        divFormCheckInputLanguageIt.value = "it";
        let divFormCheckLabelLanguageIt = document.createElement("label");
        divFormCheckLabelLanguageIt.className = "form-check-label";
        divFormCheckLabelLanguageIt.textContent = "Italiano";
        let divFormCheckLanguageEn = document.createElement("div");
        divFormCheckLanguageEn.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageEn = document.createElement("input");
        divFormCheckInputLanguageEn.className = "form-check-input";
        divFormCheckInputLanguageEn.id = "languagecheck";
        divFormCheckInputLanguageEn.name = "language";
        divFormCheckInputLanguageEn.type = "checkbox";
        divFormCheckInputLanguageEn.value = "en";
        let divFormCheckLabelLanguageEn = document.createElement("label");
        divFormCheckLabelLanguageEn.className = "form-check-label";
        divFormCheckLabelLanguageEn.textContent = "Inglese";
        let divFormCheckLanguageFr = document.createElement("div");
        divFormCheckLanguageFr.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageFr = document.createElement("input");
        divFormCheckInputLanguageFr.className = "form-check-input";
        divFormCheckInputLanguageFr.id = "languagecheck";
        divFormCheckInputLanguageFr.name = "language";
        divFormCheckInputLanguageFr.type = "checkbox";
        divFormCheckInputLanguageFr.value = "fr";
        let divFormCheckLabelLanguageFr = document.createElement("label");
        divFormCheckLabelLanguageFr.className = "form-check-label";
        divFormCheckLabelLanguageFr.textContent = "Francese";
        let brLanguage2 = document.createElement("br");
        let divFormCheckLanguageDe = document.createElement("div");
        divFormCheckLanguageDe.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageDe = document.createElement("input");
        divFormCheckInputLanguageDe.className = "form-check-input";
        divFormCheckInputLanguageDe.id = "languagecheck";
        divFormCheckInputLanguageDe.name = "language";
        divFormCheckInputLanguageDe.type = "checkbox";
        divFormCheckInputLanguageDe.value = "de";
        let divFormCheckLabelLanguageDe = document.createElement("label");
        divFormCheckLabelLanguageDe.className = "form-check-label";
        divFormCheckLabelLanguageDe.textContent = "Tedesco";
        let divFormCheckLanguageEs = document.createElement("div");
        divFormCheckLanguageEs.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageEs = document.createElement("input");
        divFormCheckInputLanguageEs.className = "form-check-input";
        divFormCheckInputLanguageEs.id = "languagecheck";
        divFormCheckInputLanguageEs.name = "language";
        divFormCheckInputLanguageEs.type = "checkbox";
        divFormCheckInputLanguageEs.value = "es";
        let divFormCheckLabelLanguageEs = document.createElement("label");
        divFormCheckLabelLanguageEs.className = "form-check-label";
        divFormCheckLabelLanguageEs.textContent = "Spagnolo";
        let divFormCheckLanguageJa = document.createElement("div");
        divFormCheckLanguageJa.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageJa = document.createElement("input");
        divFormCheckInputLanguageJa.className = "form-check-input";
        divFormCheckInputLanguageJa.id = "languagecheck";
        divFormCheckInputLanguageJa.name = "language";
        divFormCheckInputLanguageJa.type = "checkbox";
        divFormCheckInputLanguageJa.value = "ja";
        let divFormCheckLabelLanguageJa = document.createElement("label");
        divFormCheckLabelLanguageJa.className = "form-check-label";
        divFormCheckLabelLanguageJa.textContent = "Giapponese";
        $(divFormCheckLanguageIt).append(divFormCheckInputLanguageIt, divFormCheckLabelLanguageIt);
        $(divFormCheckLanguageEn).append(divFormCheckInputLanguageEn, divFormCheckLabelLanguageEn);
        $(divFormCheckLanguageFr).append(divFormCheckInputLanguageFr, divFormCheckLabelLanguageFr);
        $(divFormCheckLanguageDe).append(divFormCheckInputLanguageDe, divFormCheckLabelLanguageDe);
        $(divFormCheckLanguageEs).append(divFormCheckInputLanguageEs, divFormCheckLabelLanguageEs);
        $(divFormCheckLanguageJa).append(divFormCheckInputLanguageJa, divFormCheckLabelLanguageJa);
        $(divFormGroupFullName).append(rowName);
        $(rowName).append(colFirstName, colLastName);
        $(colFirstName).append(labelFirstName, inputFirstName);
        $(colLastName).append(labelLastName, inputLastName);
        $(divFormGroupEmail).append(labelEmail, inputEmail);
        $(divFormGroupPassword).append(labelPassword, inputPassword);
        $(divFormGroupConfirmPassword).append(labelConfirmPassword, inputConfirmPassword);
        $(divFormGroupLanguage).append(labelLanguage, brLanguage, divFormCheckLanguageIt, divFormCheckLanguageEn, divFormCheckLanguageFr, brLanguage2, divFormCheckLanguageDe, divFormCheckLanguageEs, divFormCheckLanguageJa);
        return [divFormGroupFullName, divFormGroupEmail, divFormGroupPassword, divFormGroupConfirmPassword, divFormGroupLanguage];
    }
    /**
     *
     * @param {Event} e
     * @return {boolean}
     */
    onSubmit(e) {
        if ($("input[type=checkbox]:checked").length === 0) {
            console.log("you must to choose at least one checkbox");
            $(".alert-danger").removeAttr("hidden");
            $(".alert-danger").text("Scegliere almeno una lingua madre.");
            return false;
        }
        if (!((o1, o2) => { if (o1 && o1.equals) {
            return o1.equals(o2);
        }
        else {
            return o1 === o2;
        } })($("input[name=password]").val(), $("input[name=confirmpassword]").val())) {
            console.log("password and confirm password mismatching");
            $("confirmpassword").text("");
            $("confirmpassword").attr("required", "true");
            $(".alert-danger").removeAttr("hidden");
            $(".alert-danger").text("La password e la sua conferma non corrispondono.");
            return false;
        }
        let email = document.querySelector("[name=\'email\']").value;
        let password = document.querySelector("[name=\'password\']").value;
        let firstname = document.querySelector("[name=\'firstname\']").value;
        let lastname = document.querySelector("[name=\'lastname\']").value;
        let eLanguage = document.querySelectorAll("[name=\'language\']");
        let language = "";
        for (let index125 = 0; index125 < eLanguage.length; index125++) {
            let l = eLanguage[index125];
            language += (l.checked ? "language=" + l.value + "&" : "");
        }
        language = language.substring(0, language.length - 1);
        $.get(Signup.REGISTER_ACTION, "email=" + email + "&password=" + password + "&firstname=" + firstname + "&lastname=" + lastname + "&" + language, (result, a, ctx) => {
            console.log(result.toString());
            if (!((o1, o2) => { if (o1 && o1.equals) {
                return o1.equals(o2);
            }
            else {
                return o1 === o2;
            } })("true", result.toString())) {
                console.log("L\'email e\' gia\' in uso da un altro utente.");
                $(".alert-danger").removeAttr("hidden");
                $(".alert-danger").text(result.toString());
            }
            else {
                console.log("Utente creato con successo");
                window.location.href = "home.html";
            }
            return null;
        });
        return false;
    }
}
Signup.REGISTER_TITLE = "Sign Up";
Signup.REGISTER_TYPE = "signup";
Signup.REGISTER_ACTION = "signup.jsp";
Signup.REGISTER_ACTION_LABEL = "Sign Up";
Signup.LOGIN_LABEL = "Hai gi\u00e0 un account? ";
Signup.LOGIN_LINK = "login.html";
Signup.LOGIN_LINK_LABEL = "Sign in";
Signup["__class"] = "Signup";
Signup.main(null);

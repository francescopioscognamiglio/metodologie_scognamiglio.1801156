/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina di Signup
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Entry
 */
class Signup extends Entry {
    public static REGISTER_TITLE : string = "Sign Up";

    public static REGISTER_TYPE : string = "signup";

    public static REGISTER_ACTION : string = "signup.jsp";

    public static REGISTER_ACTION_LABEL : string = "Sign Up";

    public static LOGIN_LABEL : string = "Hai gi\u00e0 un account? ";

    public static LOGIN_LINK : string = "login.html";

    public static LOGIN_LINK_LABEL : string = "Sign in";

    public static main(args : string[]) {
        let register : Signup = new Signup();
        register.create();
    }

    public constructor() {
        super(Signup.REGISTER_TITLE, Signup.REGISTER_TYPE, Signup.REGISTER_ACTION, Signup.REGISTER_ACTION_LABEL, Signup.LOGIN_LABEL, Signup.LOGIN_LINK, Signup.LOGIN_LINK_LABEL);
    }

    public getCustomComponents() : HTMLElement[] {
        let divFormGroupFullName : HTMLDivElement = document.createElement("div");
        divFormGroupFullName.className = "form-group";
        let rowName : HTMLDivElement = document.createElement("div");
        rowName.className = "row";
        let colFirstName : HTMLDivElement = document.createElement("div");
        colFirstName.className = "col";
        let labelFirstName : HTMLLabelElement = document.createElement("label");
        labelFirstName.textContent = "Nome";
        $(labelFirstName).css("font-weight", "bold");
        let inputFirstName : HTMLInputElement = document.createElement("input");
        inputFirstName.className = "form-control";
        inputFirstName.name = "firstname";
        inputFirstName.type = "text";
        inputFirstName.placeholder = "Inserire il nome";
        inputFirstName.required = true;
        let colLastName : HTMLDivElement = document.createElement("div");
        colLastName.className = "col";
        let labelLastName : HTMLLabelElement = document.createElement("label");
        labelLastName.textContent = "Cognome";
        $(labelLastName).css("font-weight", "bold");
        let inputLastName : HTMLInputElement = document.createElement("input");
        inputLastName.className = "form-control";
        inputLastName.name = "lastname";
        inputLastName.type = "text";
        inputLastName.placeholder = "Inserire il cognome";
        inputLastName.required = true;
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
        let divFormGroupConfirmPassword : HTMLDivElement = document.createElement("div");
        divFormGroupConfirmPassword.className = "form-group";
        let labelConfirmPassword : HTMLLabelElement = document.createElement("label");
        labelConfirmPassword.textContent = "Conferma password";
        $(labelConfirmPassword).css("font-weight", "bold");
        let inputConfirmPassword : HTMLInputElement = document.createElement("input");
        inputConfirmPassword.className = "form-control";
        inputConfirmPassword.name = "confirmpassword";
        inputConfirmPassword.type = "password";
        inputConfirmPassword.placeholder = "Ripetere la password";
        inputConfirmPassword.required = true;
        let divFormGroupLanguage : HTMLDivElement = document.createElement("div");
        divFormGroupLanguage.className = "form-group";
        let labelLanguage : HTMLLabelElement = document.createElement("label");
        labelLanguage.textContent = "Scegliere una o pi\u00f9 lingue madre";
        $(labelLanguage).css("font-weight", "bold");
        let brLanguage : HTMLBRElement = document.createElement("br");
        let divFormCheckLanguageIt : HTMLDivElement = document.createElement("div");
        divFormCheckLanguageIt.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageIt : HTMLInputElement = document.createElement("input");
        divFormCheckInputLanguageIt.className = "form-check-input";
        divFormCheckInputLanguageIt.id = "languagecheck";
        divFormCheckInputLanguageIt.name = "language";
        divFormCheckInputLanguageIt.type = "checkbox";
        divFormCheckInputLanguageIt.value = "it";
        let divFormCheckLabelLanguageIt : HTMLLabelElement = document.createElement("label");
        divFormCheckLabelLanguageIt.className = "form-check-label";
        divFormCheckLabelLanguageIt.textContent = "Italiano";
        let divFormCheckLanguageEn : HTMLDivElement = document.createElement("div");
        divFormCheckLanguageEn.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageEn : HTMLInputElement = document.createElement("input");
        divFormCheckInputLanguageEn.className = "form-check-input";
        divFormCheckInputLanguageEn.id = "languagecheck";
        divFormCheckInputLanguageEn.name = "language";
        divFormCheckInputLanguageEn.type = "checkbox";
        divFormCheckInputLanguageEn.value = "en";
        let divFormCheckLabelLanguageEn : HTMLLabelElement = document.createElement("label");
        divFormCheckLabelLanguageEn.className = "form-check-label";
        divFormCheckLabelLanguageEn.textContent = "Inglese";
        let divFormCheckLanguageFr : HTMLDivElement = document.createElement("div");
        divFormCheckLanguageFr.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageFr : HTMLInputElement = document.createElement("input");
        divFormCheckInputLanguageFr.className = "form-check-input";
        divFormCheckInputLanguageFr.id = "languagecheck";
        divFormCheckInputLanguageFr.name = "language";
        divFormCheckInputLanguageFr.type = "checkbox";
        divFormCheckInputLanguageFr.value = "fr";
        let divFormCheckLabelLanguageFr : HTMLLabelElement = document.createElement("label");
        divFormCheckLabelLanguageFr.className = "form-check-label";
        divFormCheckLabelLanguageFr.textContent = "Francese";
        let brLanguage2 : HTMLBRElement = document.createElement("br");
        let divFormCheckLanguageDe : HTMLDivElement = document.createElement("div");
        divFormCheckLanguageDe.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageDe : HTMLInputElement = document.createElement("input");
        divFormCheckInputLanguageDe.className = "form-check-input";
        divFormCheckInputLanguageDe.id = "languagecheck";
        divFormCheckInputLanguageDe.name = "language";
        divFormCheckInputLanguageDe.type = "checkbox";
        divFormCheckInputLanguageDe.value = "de";
        let divFormCheckLabelLanguageDe : HTMLLabelElement = document.createElement("label");
        divFormCheckLabelLanguageDe.className = "form-check-label";
        divFormCheckLabelLanguageDe.textContent = "Tedesco";
        let divFormCheckLanguageEs : HTMLDivElement = document.createElement("div");
        divFormCheckLanguageEs.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageEs : HTMLInputElement = document.createElement("input");
        divFormCheckInputLanguageEs.className = "form-check-input";
        divFormCheckInputLanguageEs.id = "languagecheck";
        divFormCheckInputLanguageEs.name = "language";
        divFormCheckInputLanguageEs.type = "checkbox";
        divFormCheckInputLanguageEs.value = "es";
        let divFormCheckLabelLanguageEs : HTMLLabelElement = document.createElement("label");
        divFormCheckLabelLanguageEs.className = "form-check-label";
        divFormCheckLabelLanguageEs.textContent = "Spagnolo";
        let divFormCheckLanguageJa : HTMLDivElement = document.createElement("div");
        divFormCheckLanguageJa.className = "col-3 form-check form-check-inline";
        let divFormCheckInputLanguageJa : HTMLInputElement = document.createElement("input");
        divFormCheckInputLanguageJa.className = "form-check-input";
        divFormCheckInputLanguageJa.id = "languagecheck";
        divFormCheckInputLanguageJa.name = "language";
        divFormCheckInputLanguageJa.type = "checkbox";
        divFormCheckInputLanguageJa.value = "ja";
        let divFormCheckLabelLanguageJa : HTMLLabelElement = document.createElement("label");
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
    public onSubmit(e : Event) : boolean {
        if($("input[type=checkbox]:checked").length === 0) {
            console.log("you must to choose at least one checkbox");
            $(".alert-danger").removeAttr("hidden");
            $(".alert-danger").text("Scegliere almeno una lingua madre.");
            return false;
        }
        if(!/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })($("input[name=password]").val(),$("input[name=confirmpassword]").val()))) {
            console.log("password and confirm password mismatching");
            $("confirmpassword").text("");
            $("confirmpassword").attr("required", "true");
            $(".alert-danger").removeAttr("hidden");
            $(".alert-danger").text("La password e la sua conferma non corrispondono.");
            return false;
        }
        let email : string = (<HTMLInputElement>document.querySelector("[name=\'email\']")).value;
        let password : string = (<HTMLInputElement>document.querySelector("[name=\'password\']")).value;
        let firstname : string = (<HTMLInputElement>document.querySelector("[name=\'firstname\']")).value;
        let lastname : string = (<HTMLInputElement>document.querySelector("[name=\'lastname\']")).value;
        let eLanguage : NodeListOf<Element> = document.querySelectorAll("[name=\'language\']");
        let language : string = "";
        for(let index125=0; index125 < eLanguage.length; index125++) {
            let l = eLanguage[index125];
            language += ((<HTMLInputElement>l).checked?"language=" + (<HTMLInputElement>l).value + "&":"")
        }
        language = language.substring(0, language.length - 1);
        $.get(Signup.REGISTER_ACTION, "email=" + email + "&password=" + password + "&firstname=" + firstname + "&lastname=" + lastname + "&" + language, (result, a, ctx) => {
            console.log(result.toString());
            if(!/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })("true",result.toString()))) {
                console.log("L\'email e\' gia\' in uso da un altro utente.");
                $(".alert-danger").removeAttr("hidden");
                $(".alert-danger").text(result.toString());
            } else {
                console.log("Utente creato con successo");
                window.location.href = "home.html";
            }
            return null;
        });
        return false;
    }
}
Signup["__class"] = "Signup";




Signup.main(null);

/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Translation Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class TranslationAnnotation extends Task {
    constructor() {
        super(TranslationAnnotation.TASK_URL);
    }
    static main(args) {
        let translationAnnotation = new TranslationAnnotation();
        translationAnnotation.create();
    }
    /**
     *
     * @return {Array}
     */
    createData() {
        let word = document.createElement("span");
        word.id = "word";
        let wordI = document.createElement("input");
        wordI.name = "word";
        wordI.id = "wordInput";
        wordI.hidden = true;
        let description = document.createElement("span");
        description.id = "description";
        let descriptionI = document.createElement("input");
        descriptionI.name = "description";
        descriptionI.id = "descriptionInput";
        descriptionI.hidden = true;
        return [word, wordI, description, descriptionI];
    }
    /**
     *
     * @return {Array}
     */
    createAnswer() {
        let answer = document.createElement("textarea");
        answer.name = "answer";
        answer.className = "form-control";
        answer.placeholder = "Scrivi la tua risposta qui...";
        answer.required = true;
        $(answer).css("height", "180px");
        return [answer];
    }
    /**
     *
     */
    extra() {
        this.generateData();
    }
    /**
     *
     */
    generateData() {
        $.getJSON(TranslationAnnotation.TASK_URL, "task=" + TranslationAnnotation.TASK_TYPE, (result, status, ctx) => {
            if (result.toString().length > 0) {
                let json = result;
                let sWord = (json["word"]).replace(new RegExp("_", 'g'), " ");
                let sDescription = (json["description"]).replace(new RegExp("_", 'g'), " ");
                sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
                sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);
                $("#title").text("Data la seguente parola e definizione in inglese, fornire una traduzione nella tua lingua madre.");
                $("#word").html("<b>" + sWord + "</b><br>");
                $("#wordInput").attr("value", sWord);
                $("#description").html(sDescription);
                $("#descriptionInput").attr("value", sDescription);
            }
            return null;
        });
    }
}
TranslationAnnotation.TASK_URL = "translationAnnotation.jsp";
TranslationAnnotation.TASK_TYPE = "TRANSLATION_ANNOTATION";
TranslationAnnotation["__class"] = "TranslationAnnotation";
TranslationAnnotation["__interfaces"] = ["CustomData"];
TranslationAnnotation.main(null);

/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Word Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class WordAnnotation extends Task {
    constructor() {
        super(WordAnnotation.TASK_URL);
    }
    static main(args) {
        let wordAnnotation = new WordAnnotation();
        wordAnnotation.create();
    }
    /**
     *
     * @return {Array}
     */
    createData() {
        let description = document.createElement("span");
        description.id = "description";
        let descriptionI = document.createElement("input");
        descriptionI.name = "description";
        descriptionI.id = "descriptionInput";
        descriptionI.hidden = true;
        return [description, descriptionI];
    }
    /**
     *
     * @return {Array}
     */
    createAnswer() {
        let answer = document.createElement("input");
        answer.className = "form-control";
        answer.name = "answer";
        answer.type = "text";
        answer.required = true;
        answer.placeholder = "Scrivi la tua risposta qui...";
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
        $.getJSON(WordAnnotation.TASK_URL, "task=" + WordAnnotation.TASK_TYPE, (result, status, ctx) => {
            if (result.toString().length > 0) {
                let json = result;
                let sDescription = (json["description"]).replace(new RegExp("_", 'g'), " ");
                sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);
                $("#title").text("Data la seguente definizione, provare ad indovinare il termine definito.");
                $("#description").html(sDescription);
                $("#descriptionInput").attr("value", sDescription);
            }
            return null;
        });
    }
}
WordAnnotation.TASK_URL = "wordAnnotation.jsp";
WordAnnotation.TASK_TYPE = "WORD_ANNOTATION";
WordAnnotation["__class"] = "WordAnnotation";
WordAnnotation["__interfaces"] = ["CustomData"];
WordAnnotation.main(null);

/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Definition Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class DefinitionAnnotation extends Task {
    constructor() {
        super(DefinitionAnnotation.TASK_URL);
    }
    static main(args) {
        new DefinitionAnnotation().create();
    }
    /**
     *
     * @return {Array}
     */
    createData() {
        let wordAndHypernym = document.createElement("span");
        wordAndHypernym.id = "wordAndHypernym";
        let wordI = document.createElement("input");
        wordI.name = "word";
        wordI.id = "wordInput";
        wordI.hidden = true;
        let hypernymI = document.createElement("input");
        hypernymI.name = "hypernym";
        hypernymI.id = "hypernymInput";
        hypernymI.hidden = true;
        return [wordAndHypernym, wordI, hypernymI];
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
        $.getJSON(DefinitionAnnotation.TASK_URL, "task=" + DefinitionAnnotation.TASK_TYPE, (result, status, ctx) => {
            if (result.toString().length > 0) {
                let json = result;
                let sWord = (json["word"]).replace(new RegExp("_", 'g'), " ");
                let sHypernym = (json["hypernym"]).replace(new RegExp("_", 'g'), " ");
                sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
                sHypernym = sHypernym.substring(0, 1).toUpperCase() + sHypernym.substring(1);
                $("#title").text("Data la seguente parola e un suo iperonimo, fornire una definizione nella tua lingua madre.");
                $("#wordAndHypernym").html("<b>" + sWord + "</b> - " + sHypernym);
                $("#wordInput").attr("value", sWord);
                $("#hypernymInput").attr("value", sHypernym);
            }
            return null;
        });
    }
}
DefinitionAnnotation.TASK_URL = "definitionAnnotation.jsp";
DefinitionAnnotation.TASK_TYPE = "DEFINITION_ANNOTATION";
DefinitionAnnotation["__class"] = "DefinitionAnnotation";
DefinitionAnnotation["__interfaces"] = ["CustomData"];
DefinitionAnnotation.main(null);

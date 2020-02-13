/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Definition Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class DefinitionAnnotation extends Task implements CustomData {
    public static TASK_URL : string = "definitionAnnotation.jsp";

    public static TASK_TYPE : string = "DEFINITION_ANNOTATION";

    public constructor() {
        super(DefinitionAnnotation.TASK_URL);
    }

    public static main(args : string[]) {
        new DefinitionAnnotation().create();
    }

    /**
     * 
     * @return {Array}
     */
    public createData() : HTMLElement[] {
        let wordAndHypernym : HTMLSpanElement = document.createElement("span");
        wordAndHypernym.id = "wordAndHypernym";
        let wordI : HTMLInputElement = document.createElement("input");
        wordI.name = "word";
        wordI.id = "wordInput";
        wordI.hidden = true;
        let hypernymI : HTMLInputElement = document.createElement("input");
        hypernymI.name = "hypernym";
        hypernymI.id = "hypernymInput";
        hypernymI.hidden = true;
        return [wordAndHypernym, wordI, hypernymI];
    }

    /**
     * 
     * @return {Array}
     */
    public createAnswer() : HTMLElement[] {
        let answer : HTMLTextAreaElement = document.createElement("textarea");
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
    public extra() {
        this.generateData();
    }

    /**
     * 
     */
    public generateData() {
        $.getJSON(DefinitionAnnotation.TASK_URL, "task=" + DefinitionAnnotation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let sWord : string = /* replaceAll */(<any>(json["word"])).replace(new RegExp("_", 'g')," ");
                let sHypernym : string = /* replaceAll */(<any>(json["hypernym"])).replace(new RegExp("_", 'g')," ");
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
DefinitionAnnotation["__class"] = "DefinitionAnnotation";
DefinitionAnnotation["__interfaces"] = ["CustomData"];





DefinitionAnnotation.main(null);

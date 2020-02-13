/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Word Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class WordAnnotation extends Task implements CustomData {
    public static TASK_URL : string = "wordAnnotation.jsp";

    public static TASK_TYPE : string = "WORD_ANNOTATION";

    public constructor() {
        super(WordAnnotation.TASK_URL);
    }

    public static main(args : string[]) {
        let wordAnnotation : WordAnnotation = new WordAnnotation();
        wordAnnotation.create();
    }

    /**
     * 
     * @return {Array}
     */
    public createData() : HTMLElement[] {
        let description : HTMLSpanElement = document.createElement("span");
        description.id = "description";
        let descriptionI : HTMLInputElement = document.createElement("input");
        descriptionI.name = "description";
        descriptionI.id = "descriptionInput";
        descriptionI.hidden = true;
        return [description, descriptionI];
    }

    /**
     * 
     * @return {Array}
     */
    public createAnswer() : HTMLElement[] {
        let answer : HTMLInputElement = document.createElement("input");
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
    public extra() {
        this.generateData();
    }

    /**
     * 
     */
    public generateData() {
        $.getJSON(WordAnnotation.TASK_URL, "task=" + WordAnnotation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let sDescription : string = /* replaceAll */(<any>(json["description"])).replace(new RegExp("_", 'g')," ");
                sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);
                $("#title").text("Data la seguente definizione, provare ad indovinare il termine definito.");
                $("#description").html(sDescription);
                $("#descriptionInput").attr("value", sDescription);
            }
            return null;
        });
    }
}
WordAnnotation["__class"] = "WordAnnotation";
WordAnnotation["__interfaces"] = ["CustomData"];





WordAnnotation.main(null);

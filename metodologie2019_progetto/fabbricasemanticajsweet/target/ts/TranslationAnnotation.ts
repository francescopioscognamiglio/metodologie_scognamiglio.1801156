/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Translation Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class TranslationAnnotation extends Task implements CustomData {
    public static TASK_URL : string = "translationAnnotation.jsp";

    public static TASK_TYPE : string = "TRANSLATION_ANNOTATION";

    public constructor() {
        super(TranslationAnnotation.TASK_URL);
    }

    public static main(args : string[]) {
        let translationAnnotation : TranslationAnnotation = new TranslationAnnotation();
        translationAnnotation.create();
    }

    /**
     * 
     * @return {Array}
     */
    public createData() : HTMLElement[] {
        let word : HTMLSpanElement = document.createElement("span");
        word.id = "word";
        let wordI : HTMLInputElement = document.createElement("input");
        wordI.name = "word";
        wordI.id = "wordInput";
        wordI.hidden = true;
        let description : HTMLSpanElement = document.createElement("span");
        description.id = "description";
        let descriptionI : HTMLInputElement = document.createElement("input");
        descriptionI.name = "description";
        descriptionI.id = "descriptionInput";
        descriptionI.hidden = true;
        return [word, wordI, description, descriptionI];
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
        $.getJSON(TranslationAnnotation.TASK_URL, "task=" + TranslationAnnotation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let sWord : string = /* replaceAll */(<any>(json["word"])).replace(new RegExp("_", 'g')," ");
                let sDescription : string = /* replaceAll */(<any>(json["description"])).replace(new RegExp("_", 'g')," ");
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
TranslationAnnotation["__class"] = "TranslationAnnotation";
TranslationAnnotation["__interfaces"] = ["CustomData"];





TranslationAnnotation.main(null);

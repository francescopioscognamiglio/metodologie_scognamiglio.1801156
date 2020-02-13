/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Translation Validation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class TranslationValidation extends Task implements CustomData {
    public static TASK_URL : string = "translationValidation.jsp";

    public static TASK_TYPE : string = "TRANSLATION_VALIDATION";

    public constructor() {
        super(TranslationValidation.TASK_URL);
    }

    public static main(args : string[]) {
        let translationValidation : TranslationValidation = new TranslationValidation();
        translationValidation.create();
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
        let formCheck1 : HTMLDivElement = document.createElement("div");
        formCheck1.className = "form-check";
        let formCheckInput1 : HTMLInputElement = document.createElement("input");
        formCheckInput1.className = "form-check-input";
        formCheckInput1.name = "answer";
        formCheckInput1.id = "answer1";
        formCheckInput1.type = "radio";
        formCheckInput1.required = true;
        let formCheckLabel1 : HTMLDivElement = document.createElement("div");
        formCheckLabel1.className = "form-check-label";
        formCheckLabel1.id = "answerLabel1";
        let formCheck2 : HTMLDivElement = document.createElement("div");
        formCheck2.className = "form-check";
        let formCheckInput2 : HTMLInputElement = document.createElement("input");
        formCheckInput2.className = "form-check-input";
        formCheckInput2.name = "answer";
        formCheckInput2.id = "answer2";
        formCheckInput2.type = "radio";
        let formCheckLabel2 : HTMLDivElement = document.createElement("div");
        formCheckLabel2.className = "form-check-label";
        formCheckLabel2.id = "answerLabel2";
        let formCheck3 : HTMLDivElement = document.createElement("div");
        formCheck3.className = "form-check";
        let formCheckInput3 : HTMLInputElement = document.createElement("input");
        formCheckInput3.className = "form-check-input";
        formCheckInput3.name = "answer";
        formCheckInput3.id = "answer3";
        formCheckInput3.type = "radio";
        let formCheckLabel3 : HTMLDivElement = document.createElement("div");
        formCheckLabel3.className = "form-check-label";
        formCheckLabel3.id = "answerLabel3";
        let formCheck4 : HTMLDivElement = document.createElement("div");
        formCheck4.className = "form-check";
        let formCheckInput4 : HTMLInputElement = document.createElement("input");
        formCheckInput4.className = "form-check-input";
        formCheckInput4.name = "answer";
        formCheckInput4.id = "answer4";
        formCheckInput4.type = "radio";
        formCheckInput4.value = "nessuna";
        let formCheckLabel4 : HTMLDivElement = document.createElement("div");
        formCheckLabel4.className = "form-check-label";
        formCheckLabel4.id = "answerLabel4";
        formCheckLabel4.textContent = "nessuna";
        $(formCheck1).append(formCheckInput1, formCheckLabel1);
        $(formCheck2).append(formCheckInput2, formCheckLabel2);
        $(formCheck3).append(formCheckInput3, formCheckLabel3);
        $(formCheck4).append(formCheckInput4, formCheckLabel4);
        return [formCheck1, formCheck2, formCheck3, formCheck4];
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
        $.getJSON(TranslationValidation.TASK_URL, "task=" + TranslationValidation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let sWord : string = /* replaceAll */(<any>(json["word"])).replace(new RegExp("_", 'g')," ");
                let sDescription : string = /* replaceAll */(<any>(json["description"])).replace(new RegExp("_", 'g')," ");
                let lTranslations : Array<string> = <any>(json["translations"]);
                sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
                sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);
                $("#title").text("Data la seguente parola e definizione in inglese, scegliere la miglior traduzione tra quelle fornite o specificare nessuna.");
                $("#word").html("<b>" + sWord + "</b><br>");
                $("#wordInput").attr("value", sWord);
                $("#description").html(sDescription);
                $("#descriptionInput").attr("value", sDescription);
                for(let i : number = 0; i < /* size */(<number>lTranslations.length); i++) {{
                    $("#answer" + (i + 1)).attr("value", /* get */lTranslations[i]);
                    $("#answerLabel" + (i + 1)).text(/* get */lTranslations[i]);
                };}
            }
            return null;
        });
    }
}
TranslationValidation["__class"] = "TranslationValidation";
TranslationValidation["__interfaces"] = ["CustomData"];





TranslationValidation.main(null);

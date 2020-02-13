/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Sense Validation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class SenseValidation extends Task implements CustomData {
    public static TASK_URL : string = "senseValidation.jsp";

    public static TASK_TYPE : string = "SENSE_VALIDATION";

    public constructor() {
        super(SenseValidation.TASK_URL);
    }

    public static main(args : string[]) {
        let senseAnnotation : SenseValidation = new SenseValidation();
        senseAnnotation.create();
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
        let example : HTMLSpanElement = document.createElement("span");
        example.id = "example";
        let exampleI : HTMLInputElement = document.createElement("input");
        exampleI.name = "example";
        exampleI.id = "exampleInput";
        exampleI.hidden = true;
        let br1 : HTMLBRElement = document.createElement("br");
        let br2 : HTMLBRElement = document.createElement("br");
        let senseIDisabled : HTMLInputElement = document.createElement("input");
        senseIDisabled.id = "senseInputDisabled";
        senseIDisabled.className = "form-control";
        senseIDisabled.disabled = true;
        let senseI : HTMLInputElement = document.createElement("input");
        senseI.name = "sense";
        senseI.id = "senseInput";
        senseI.className = "form-control";
        senseI.hidden = true;
        return [word, wordI, example, exampleI, br1, br2, senseIDisabled, senseI];
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
        formCheckInput1.value = "si";
        formCheckInput1.required = true;
        let formCheckLabel1 : HTMLDivElement = document.createElement("div");
        formCheckLabel1.className = "form-check-label";
        formCheckLabel1.id = "answerLabel1";
        formCheckLabel1.textContent = "s\u00ec";
        let formCheck2 : HTMLDivElement = document.createElement("div");
        formCheck2.className = "form-check";
        let formCheckInput2 : HTMLInputElement = document.createElement("input");
        formCheckInput2.className = "form-check-input";
        formCheckInput2.name = "answer";
        formCheckInput2.id = "answer2";
        formCheckInput2.type = "radio";
        formCheckInput2.value = "no";
        let formCheckLabel2 : HTMLDivElement = document.createElement("div");
        formCheckLabel2.className = "form-check-label";
        formCheckLabel2.id = "answerLabel2";
        formCheckLabel2.textContent = "no";
        $(formCheck1).append(formCheckInput1, formCheckLabel1);
        $(formCheck2).append(formCheckInput2, formCheckLabel2);
        return [formCheck1, formCheck2];
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
        $.getJSON(SenseValidation.TASK_URL, "task=" + SenseValidation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let sWord : string = /* replaceAll */(<any>(json["word"])).replace(new RegExp("_", 'g')," ");
                let sExample : string = /* replaceAll */(<any>(json["example"])).replace(new RegExp("_", 'g')," ");
                let sSense : string = <any>(json["sense"]);
                sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
                sExample = sExample.substring(0, 1).toUpperCase() + sExample.substring(1);
                let sExampleModified : string = "";
                {
                    let array122 = /* replaceAll */(<any>(json["example"])).replace(new RegExp("_", 'g')," ").split(" ");
                    for(let index121=0; index121 < array122.length; index121++) {
                        let substring = array122[index121];
                        {
                            sExampleModified += (/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(substring.toLowerCase(),sWord.toLowerCase())) || /* startsWith */((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(substring.toLowerCase(), sWord.toLowerCase()) || /* startsWith */((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(sWord.toLowerCase(), substring.toLowerCase())?sExampleModified += "<b>" + substring + "</b>":substring) + " ";
                        }
                    }
                }
                sExampleModified = sExampleModified.substring(0, 1).toUpperCase() + sExampleModified.substring(1);
                $("#title").text("Data la seguente parola e un esempio in inglese, verificare se il senso fornito dal sistema \u00e9 appropriato.");
                $("#word").html("<b>" + sWord + "</b><br>");
                $("#wordInput").attr("value", sWord);
                $("#example").html(sExample);
                $("#exampleInput").attr("value", sExample);
                $("#senseInputDisabled").attr("value", sSense);
                $("#senseInput").attr("value", sSense);
            }
            return null;
        });
    }
}
SenseValidation["__class"] = "SenseValidation";
SenseValidation["__interfaces"] = ["CustomData"];





SenseValidation.main(null);

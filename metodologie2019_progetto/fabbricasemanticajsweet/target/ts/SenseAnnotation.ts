/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Sense Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class SenseAnnotation extends Task implements CustomData {
    public static TASK_URL : string = "senseAnnotation.jsp";

    public static TASK_TYPE : string = "SENSE_ANNOTATION";

    public constructor() {
        super(SenseAnnotation.TASK_URL);
    }

    public static main(args : string[]) {
        let senseAnnotation : SenseAnnotation = new SenseAnnotation();
        senseAnnotation.create();
    }

    /**
     * 
     * @return {Array}
     */
    public createData() : HTMLElement[] {
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
        return [wordI, example, exampleI];
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
        let formCheckLabel4 : HTMLDivElement = document.createElement("div");
        formCheckLabel4.className = "form-check-label";
        formCheckLabel4.id = "answerLabel4";
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
        $.getJSON(SenseAnnotation.TASK_URL, "task=" + SenseAnnotation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let sWord : string = /* replaceAll */(<any>(json["word"])).replace(new RegExp("_", 'g')," ");
                let sExample : string = /* replaceAll */(<any>(json["example"])).replace(new RegExp("_", 'g')," ");
                let lSenses : Array<string> = <any>(json["senses"]);
                sExample = sExample.substring(0, 1).toUpperCase() + sExample.substring(1);
                $("#title").text("Dato un esempio, selezionare il corretto significato della parola \"" + sWord + "\" tra le seguenti opzioni.");
                let sExampleModified : string = "";
                {
                    let array124 = /* replaceAll */(<any>(json["example"])).replace(new RegExp("_", 'g')," ").split(" ");
                    for(let index123=0; index123 < array124.length; index123++) {
                        let substring = array124[index123];
                        {
                            sExampleModified += (/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(substring.toLowerCase(),sWord.toLowerCase())) || /* startsWith */((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(substring.toLowerCase(), sWord.toLowerCase()) || /* startsWith */((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(sWord.toLowerCase(), substring.toLowerCase()) || /* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(substring.toLowerCase().substring(0, substring.length - 1),sWord.toLowerCase())) || /* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(sWord.toLowerCase().substring(0, sWord.length - 1),substring.toLowerCase()))?"<b>" + substring + "</b>":substring) + " ";
                        }
                    }
                }
                sExampleModified = sExampleModified.substring(0, 1).toUpperCase() + sExampleModified.substring(1);
                $("#wordInput").attr("value", sWord);
                $("#example").html(sExampleModified);
                $("#exampleInput").attr("value", sExample);
                for(let i : number = 0; i < /* size */(<number>lSenses.length); i++) {{
                    $("#answer" + (i + 1)).attr("value", /* get */lSenses[i]);
                    $("#answerLabel" + (i + 1)).text(/* get */lSenses[i]);
                };}
            }
            return null;
        });
    }
}
SenseAnnotation["__class"] = "SenseAnnotation";
SenseAnnotation["__interfaces"] = ["CustomData"];





SenseAnnotation.main(null);

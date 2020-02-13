/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del custom task My Text Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class MyTextAnnotation extends Task implements CustomData {
    public static TASK_URL : string = "myTextAnnotation.jsp";

    public static TASK_TYPE : string = "MY_TEXT_ANNOTATION";

    public constructor() {
        super(MyTextAnnotation.TASK_URL);
    }

    public static main(args : string[]) {
        new MyTextAnnotation().create();
    }

    /**
     * 
     * @return {Array}
     */
    public createData() : HTMLElement[] {
        return [];
    }

    /**
     * 
     * @return {Array}
     */
    public createAnswer() : HTMLElement[] {
        let p : HTMLParagraphElement = document.createElement("p");
        p.className = "text-justify";
        p.id = "p";
        return [p];
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
        $.getJSON(MyTextAnnotation.TASK_URL, "task=" + MyTextAnnotation.TASK_TYPE, (result, status, ctx) => {
            if(result.toString().length > 0) {
                let json : JSON = <JSON>result;
                let lWordAnswers : Array<string> = <any>(json["wordAnswers"]);
                let lWords : Array<Array<string>> = <any>(json["words"]);
                let lExamples : Array<string> = <any>(json["examples"]);
                $("#title").text("Dato il seguente testo, inserire le parole negli appositi spazi.");
                for(let i : number = 0; i < /* size */(<number>lExamples.length); i++) {{
                    let lWordOption : Array<string> = /* get */lWords[i];
                    let sSpan1 : string = "";
                    let sSpan2 : string = "";
                    let optionFounded : boolean = false;
                    {
                        let array127 = /* replaceAll *//* get */lExamples[i].replace(new RegExp("_", 'g')," ").split(" ");
                        for(let index126=0; index126 < array127.length; index126++) {
                            let substring = array127[index126];
                            {
                                if(/* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(substring.toLowerCase(),/* get */lWordAnswers[i].toLowerCase())) || /* startsWith */((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(substring.toLowerCase(), /* get */lWordAnswers[i].toLowerCase()) || /* startsWith */((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(/* get */lWordAnswers[i].toLowerCase(), substring.toLowerCase()) || /* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(substring.toLowerCase().substring(0, substring.length - 1),/* get */lWordAnswers[i].toLowerCase())) || /* equals */(<any>((o1: any, o2: any) => { if(o1 && o1.equals) { return o1.equals(o2); } else { return o1 === o2; } })(/* get */lWordAnswers[i].toLowerCase().substring(0, /* get */lWordAnswers[i].length - 1),substring.toLowerCase()))) {
                                    optionFounded = true;
                                    continue;
                                }
                                if(!optionFounded) sSpan1 += substring + " "; else sSpan2 += substring + " ";
                            }
                        }
                    }
                    sSpan1 = sSpan1.substring(0, 1).toUpperCase() + sSpan1.substring(1);
                    sSpan1 = i > 0?" " + sSpan1:sSpan1;
                    sSpan2 = " " + sSpan2.substring(0, sSpan2.length - 1) + (!/* endsWith */((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(sSpan2, ".")?".":"");
                    let span1 : HTMLSpanElement = document.createElement("span");
                    span1.textContent = sSpan1;
                    let span2 : HTMLSpanElement = document.createElement("span");
                    span2.textContent = sSpan2;
                    let exampleI : HTMLInputElement = document.createElement("input");
                    exampleI.name = "example";
                    exampleI.id = "exampleInput";
                    exampleI.hidden = true;
                    exampleI.value = /* get */lExamples[i];
                    let select : HTMLSelectElement = document.createElement("select");
                    select.name = "answer";
                    select.required = true;
                    $(select).css("max-width", "100px");
                    let option1 : HTMLOptionElement = document.createElement("option");
                    option1.textContent = "Choose...";
                    option1.value = "";
                    let option2 : HTMLOptionElement = document.createElement("option");
                    option2.textContent = /* replaceAll *//* get */lWordOption[0].replace(new RegExp("_", 'g')," ").toLowerCase();
                    option2.value = /* replaceAll *//* get */lWordOption[0].replace(new RegExp("_", 'g')," ").toLowerCase();
                    let option3 : HTMLOptionElement = document.createElement("option");
                    option3.textContent = /* replaceAll *//* get */lWordOption[1].replace(new RegExp("_", 'g')," ").toLowerCase();
                    option3.value = /* replaceAll *//* get */lWordOption[1].replace(new RegExp("_", 'g')," ").toLowerCase();
                    let option4 : HTMLOptionElement = document.createElement("option");
                    option4.textContent = /* replaceAll *//* get */lWordOption[2].replace(new RegExp("_", 'g')," ").toLowerCase();
                    option4.value = /* replaceAll *//* get */lWordOption[2].replace(new RegExp("_", 'g')," ").toLowerCase();
                    $(select).append(option1, option2, option3, option4);
                    $("#p").append(span1, exampleI, select, span2);
                };}
            }
            return null;
        });
    }
}
MyTextAnnotation["__class"] = "MyTextAnnotation";
MyTextAnnotation["__interfaces"] = ["CustomData"];





MyTextAnnotation.main(null);

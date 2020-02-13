/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del custom task My Text Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class MyTextAnnotation extends Task {
    constructor() {
        super(MyTextAnnotation.TASK_URL);
    }
    static main(args) {
        new MyTextAnnotation().create();
    }
    /**
     *
     * @return {Array}
     */
    createData() {
        return [];
    }
    /**
     *
     * @return {Array}
     */
    createAnswer() {
        let p = document.createElement("p");
        p.className = "text-justify";
        p.id = "p";
        return [p];
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
        $.getJSON(MyTextAnnotation.TASK_URL, "task=" + MyTextAnnotation.TASK_TYPE, (result, status, ctx) => {
            if (result.toString().length > 0) {
                let json = result;
                let lWordAnswers = (json["wordAnswers"]);
                let lWords = (json["words"]);
                let lExamples = (json["examples"]);
                $("#title").text("Dato il seguente testo, inserire le parole negli appositi spazi.");
                for (let i = 0; i < lExamples.length; i++) {
                    {
                        let lWordOption = lWords[i];
                        let sSpan1 = "";
                        let sSpan2 = "";
                        let optionFounded = false;
                        {
                            let array127 = lExamples[i].replace(new RegExp("_", 'g'), " ").split(" ");
                            for (let index126 = 0; index126 < array127.length; index126++) {
                                let substring = array127[index126];
                                {
                                    if (((o1, o2) => { if (o1 && o1.equals) {
                                        return o1.equals(o2);
                                    }
                                    else {
                                        return o1 === o2;
                                    } })(substring.toLowerCase(), /* get */ lWordAnswers[i].toLowerCase()) || ((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(substring.toLowerCase(), /* get */ lWordAnswers[i].toLowerCase()) || ((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(/* get */ lWordAnswers[i].toLowerCase(), substring.toLowerCase()) || ((o1, o2) => { if (o1 && o1.equals) {
                                        return o1.equals(o2);
                                    }
                                    else {
                                        return o1 === o2;
                                    } })(substring.toLowerCase().substring(0, substring.length - 1), /* get */ lWordAnswers[i].toLowerCase()) || ((o1, o2) => { if (o1 && o1.equals) {
                                        return o1.equals(o2);
                                    }
                                    else {
                                        return o1 === o2;
                                    } })(/* get */ lWordAnswers[i].toLowerCase().substring(0, /* get */ lWordAnswers[i].length - 1), substring.toLowerCase())) {
                                        optionFounded = true;
                                        continue;
                                    }
                                    if (!optionFounded)
                                        sSpan1 += substring + " ";
                                    else
                                        sSpan2 += substring + " ";
                                }
                            }
                        }
                        sSpan1 = sSpan1.substring(0, 1).toUpperCase() + sSpan1.substring(1);
                        sSpan1 = i > 0 ? " " + sSpan1 : sSpan1;
                        sSpan2 = " " + sSpan2.substring(0, sSpan2.length - 1) + (!((str, searchString) => { let pos = str.length - searchString.length; let lastIndex = str.indexOf(searchString, pos); return lastIndex !== -1 && lastIndex === pos; })(sSpan2, ".") ? "." : "");
                        let span1 = document.createElement("span");
                        span1.textContent = sSpan1;
                        let span2 = document.createElement("span");
                        span2.textContent = sSpan2;
                        let exampleI = document.createElement("input");
                        exampleI.name = "example";
                        exampleI.id = "exampleInput";
                        exampleI.hidden = true;
                        exampleI.value = lExamples[i];
                        let select = document.createElement("select");
                        select.name = "answer";
                        select.required = true;
                        $(select).css("max-width", "100px");
                        let option1 = document.createElement("option");
                        option1.textContent = "Choose...";
                        option1.value = "";
                        let option2 = document.createElement("option");
                        option2.textContent = lWordOption[0].replace(new RegExp("_", 'g'), " ").toLowerCase();
                        option2.value = lWordOption[0].replace(new RegExp("_", 'g'), " ").toLowerCase();
                        let option3 = document.createElement("option");
                        option3.textContent = lWordOption[1].replace(new RegExp("_", 'g'), " ").toLowerCase();
                        option3.value = lWordOption[1].replace(new RegExp("_", 'g'), " ").toLowerCase();
                        let option4 = document.createElement("option");
                        option4.textContent = lWordOption[2].replace(new RegExp("_", 'g'), " ").toLowerCase();
                        option4.value = lWordOption[2].replace(new RegExp("_", 'g'), " ").toLowerCase();
                        $(select).append(option1, option2, option3, option4);
                        $("#p").append(span1, exampleI, select, span2);
                    }
                    ;
                }
            }
            return null;
        });
    }
}
MyTextAnnotation.TASK_URL = "myTextAnnotation.jsp";
MyTextAnnotation.TASK_TYPE = "MY_TEXT_ANNOTATION";
MyTextAnnotation["__class"] = "MyTextAnnotation";
MyTextAnnotation["__interfaces"] = ["CustomData"];
MyTextAnnotation.main(null);

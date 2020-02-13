/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta la pagina del task Sense Validation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 * @extends Task
 */
class SenseValidation extends Task {
    constructor() {
        super(SenseValidation.TASK_URL);
    }
    static main(args) {
        let senseAnnotation = new SenseValidation();
        senseAnnotation.create();
    }
    /**
     *
     * @return {Array}
     */
    createData() {
        let word = document.createElement("span");
        word.id = "word";
        let wordI = document.createElement("input");
        wordI.name = "word";
        wordI.id = "wordInput";
        wordI.hidden = true;
        let example = document.createElement("span");
        example.id = "example";
        let exampleI = document.createElement("input");
        exampleI.name = "example";
        exampleI.id = "exampleInput";
        exampleI.hidden = true;
        let br1 = document.createElement("br");
        let br2 = document.createElement("br");
        let senseIDisabled = document.createElement("input");
        senseIDisabled.id = "senseInputDisabled";
        senseIDisabled.className = "form-control";
        senseIDisabled.disabled = true;
        let senseI = document.createElement("input");
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
    createAnswer() {
        let formCheck1 = document.createElement("div");
        formCheck1.className = "form-check";
        let formCheckInput1 = document.createElement("input");
        formCheckInput1.className = "form-check-input";
        formCheckInput1.name = "answer";
        formCheckInput1.id = "answer1";
        formCheckInput1.type = "radio";
        formCheckInput1.value = "si";
        formCheckInput1.required = true;
        let formCheckLabel1 = document.createElement("div");
        formCheckLabel1.className = "form-check-label";
        formCheckLabel1.id = "answerLabel1";
        formCheckLabel1.textContent = "s\u00ec";
        let formCheck2 = document.createElement("div");
        formCheck2.className = "form-check";
        let formCheckInput2 = document.createElement("input");
        formCheckInput2.className = "form-check-input";
        formCheckInput2.name = "answer";
        formCheckInput2.id = "answer2";
        formCheckInput2.type = "radio";
        formCheckInput2.value = "no";
        let formCheckLabel2 = document.createElement("div");
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
    extra() {
        this.generateData();
    }
    /**
     *
     */
    generateData() {
        $.getJSON(SenseValidation.TASK_URL, "task=" + SenseValidation.TASK_TYPE, (result, status, ctx) => {
            if (result.toString().length > 0) {
                let json = result;
                let sWord = (json["word"]).replace(new RegExp("_", 'g'), " ");
                let sExample = (json["example"]).replace(new RegExp("_", 'g'), " ");
                let sSense = (json["sense"]);
                sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
                sExample = sExample.substring(0, 1).toUpperCase() + sExample.substring(1);
                let sExampleModified = "";
                {
                    let array122 = (json["example"]).replace(new RegExp("_", 'g'), " ").split(" ");
                    for (let index121 = 0; index121 < array122.length; index121++) {
                        let substring = array122[index121];
                        {
                            sExampleModified += (((o1, o2) => { if (o1 && o1.equals) {
                                return o1.equals(o2);
                            }
                            else {
                                return o1 === o2;
                            } })(substring.toLowerCase(), sWord.toLowerCase()) || ((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(substring.toLowerCase(), sWord.toLowerCase()) || ((str, searchString, position = 0) => str.substr(position, searchString.length) === searchString)(sWord.toLowerCase(), substring.toLowerCase()) ? sExampleModified += "<b>" + substring + "</b>" : substring) + " ";
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
SenseValidation.TASK_URL = "senseValidation.jsp";
SenseValidation.TASK_TYPE = "SENSE_VALIDATION";
SenseValidation["__class"] = "SenseValidation";
SenseValidation["__interfaces"] = ["CustomData"];
SenseValidation.main(null);

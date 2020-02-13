import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLBRElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina del task Sense Validation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class SenseValidation extends Task implements CustomData {

	public static final String TASK_URL = "senseValidation.jsp";
	public static final String TASK_TYPE = "SENSE_VALIDATION";

	public SenseValidation() {
		super(TASK_URL);
	}

	public static void main(String[] args) {
		SenseValidation senseAnnotation = new SenseValidation();
		senseAnnotation.create();
	}

	@Override
	public HTMLElement[] createData() {
		HTMLSpanElement word = document.createElement(StringTypes.span);
		word.id = "word";

		HTMLInputElement wordI = document.createElement(StringTypes.input);
		wordI.name = "word";
		wordI.id = "wordInput";
		wordI.hidden = true;

		HTMLSpanElement example = document.createElement(StringTypes.span);
		example.id = "example";
		
		HTMLInputElement exampleI = document.createElement(StringTypes.input);
		exampleI.name = "example";
		exampleI.id = "exampleInput";
		exampleI.hidden = true;

		HTMLBRElement br1 = document.createElement(StringTypes.br);
		HTMLBRElement br2 = document.createElement(StringTypes.br);

		HTMLInputElement senseIDisabled = document.createElement(StringTypes.input);
		senseIDisabled.id = "senseInputDisabled";
		senseIDisabled.className = "form-control";
		senseIDisabled.disabled = true;

		HTMLInputElement senseI = document.createElement(StringTypes.input);
		senseI.name = "sense";
		senseI.id = "senseInput";
		senseI.className = "form-control";
		senseI.hidden = true;

		return new HTMLElement[] { word, wordI, example, exampleI, br1, br2, senseIDisabled, senseI };
	}

	@Override
	public HTMLElement[] createAnswer() {
		HTMLDivElement formCheck1 = document.createElement(StringTypes.div);
		formCheck1.className = "form-check";
		HTMLInputElement formCheckInput1 = document.createElement(StringTypes.input);
		formCheckInput1.className = "form-check-input";
		formCheckInput1.name = "answer";
		formCheckInput1.id = "answer1";
		formCheckInput1.type = "radio";
		formCheckInput1.value = "si";
		formCheckInput1.required = true;
		HTMLDivElement formCheckLabel1 = document.createElement(StringTypes.div);
		formCheckLabel1.className = "form-check-label";
		formCheckLabel1.id = "answerLabel1";
		formCheckLabel1.textContent = "sì";

		HTMLDivElement formCheck2 = document.createElement(StringTypes.div);
		formCheck2.className = "form-check";
		HTMLInputElement formCheckInput2 = document.createElement(StringTypes.input);
		formCheckInput2.className = "form-check-input";
		formCheckInput2.name = "answer";
		formCheckInput2.id = "answer2";
		formCheckInput2.type = "radio";
		formCheckInput2.value = "no";
		HTMLDivElement formCheckLabel2 = document.createElement(StringTypes.div);
		formCheckLabel2.className = "form-check-label";
		formCheckLabel2.id = "answerLabel2";
		formCheckLabel2.textContent = "no";

		$(formCheck1).append(formCheckInput1, formCheckLabel1);
		$(formCheck2).append(formCheckInput2, formCheckLabel2);

		return new HTMLElement[] { formCheck1, formCheck2 };
	}

	@Override
	public void extra() {
		generateData();
	}

	@Override
	public void generateData() {
		$.getJSON(TASK_URL, "task=" + TASK_TYPE, (Object result, String status, JQueryXHR ctx) -> {
			if (result.toString().length() > 0) {
				JSON json = (JSON) result;
				String sWord = ((String)json.$get("word")).replaceAll("_", " ");
				String sExample = ((String)json.$get("example")).replaceAll("_", " ");
				String sSense = (String)json.$get("sense");
				sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
				sExample = sExample.substring(0, 1).toUpperCase() + sExample.substring(1);

				String sExampleModified = "";
				for (String substring : ((String)json.$get("example")).replaceAll("_", " ").split(" ")) {
					sExampleModified += (substring.toLowerCase().equals(sWord.toLowerCase()) || substring.toLowerCase().startsWith(sWord.toLowerCase()) || sWord.toLowerCase().startsWith(substring.toLowerCase()) ? sExampleModified += "<b>" + substring + "</b>" : substring) + " ";
				}
				sExampleModified = sExampleModified.substring(0, 1).toUpperCase() + sExampleModified.substring(1);

				$("#title").text("Data la seguente parola e un esempio in inglese, verificare se il senso fornito dal sistema é appropriato.");
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

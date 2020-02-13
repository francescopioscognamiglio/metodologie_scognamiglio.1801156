import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.List;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina del task Sense Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class SenseAnnotation extends Task implements CustomData {

	public static final String TASK_URL = "senseAnnotation.jsp";
	public static final String TASK_TYPE = "SENSE_ANNOTATION";

	public SenseAnnotation() {
		super(TASK_URL);
	}

	public static void main(String[] args) {
		SenseAnnotation senseAnnotation = new SenseAnnotation();
		senseAnnotation.create();
	}

	@Override
	public HTMLElement[] createData() {
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

		return new HTMLElement[] { wordI, example, exampleI };
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
		formCheckInput1.required = true;
		HTMLDivElement formCheckLabel1 = document.createElement(StringTypes.div);
		formCheckLabel1.className = "form-check-label";
		formCheckLabel1.id = "answerLabel1";

		HTMLDivElement formCheck2 = document.createElement(StringTypes.div);
		formCheck2.className = "form-check";
		HTMLInputElement formCheckInput2 = document.createElement(StringTypes.input);
		formCheckInput2.className = "form-check-input";
		formCheckInput2.name = "answer";
		formCheckInput2.id = "answer2";
		formCheckInput2.type = "radio";
		HTMLDivElement formCheckLabel2 = document.createElement(StringTypes.div);
		formCheckLabel2.className = "form-check-label";
		formCheckLabel2.id = "answerLabel2";

		HTMLDivElement formCheck3 = document.createElement(StringTypes.div);
		formCheck3.className = "form-check";
		HTMLInputElement formCheckInput3 = document.createElement(StringTypes.input);
		formCheckInput3.className = "form-check-input";
		formCheckInput3.name = "answer";
		formCheckInput3.id = "answer3";
		formCheckInput3.type = "radio";
		HTMLDivElement formCheckLabel3 = document.createElement(StringTypes.div);
		formCheckLabel3.className = "form-check-label";
		formCheckLabel3.id = "answerLabel3";

		HTMLDivElement formCheck4 = document.createElement(StringTypes.div);
		formCheck4.className = "form-check";
		HTMLInputElement formCheckInput4 = document.createElement(StringTypes.input);
		formCheckInput4.className = "form-check-input";
		formCheckInput4.name = "answer";
		formCheckInput4.id = "answer4";
		formCheckInput4.type = "radio";
		HTMLDivElement formCheckLabel4 = document.createElement(StringTypes.div);
		formCheckLabel4.className = "form-check-label";
		formCheckLabel4.id = "answerLabel4";

		$(formCheck1).append(formCheckInput1, formCheckLabel1);
		$(formCheck2).append(formCheckInput2, formCheckLabel2);
		$(formCheck3).append(formCheckInput3, formCheckLabel3);
		$(formCheck4).append(formCheckInput4, formCheckLabel4);

		return new HTMLElement[] { formCheck1, formCheck2, formCheck3, formCheck4 };
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
				List<String> lSenses = (List<String>)json.$get("senses");
				sExample = sExample.substring(0, 1).toUpperCase() + sExample.substring(1);

				$("#title").text("Dato un esempio, selezionare il corretto significato della parola \"" + sWord + "\" tra le seguenti opzioni.");
				String sExampleModified = "";
				for (String substring : ((String)json.$get("example")).replaceAll("_", " ").split(" ")) {
					sExampleModified += (substring.toLowerCase().equals(sWord.toLowerCase())
							|| substring.toLowerCase().startsWith(sWord.toLowerCase())
							|| sWord.toLowerCase().startsWith(substring.toLowerCase())
							|| substring.toLowerCase().substring(0, substring.length()-1).equals(sWord.toLowerCase())
							|| sWord.toLowerCase().substring(0, sWord.length()-1).equals(substring.toLowerCase())
							? "<b>" + substring + "</b>" : substring) + " ";
				}
				sExampleModified = sExampleModified.substring(0, 1).toUpperCase() + sExampleModified.substring(1);

				$("#wordInput").attr("value", sWord);
				$("#example").html(sExampleModified);
				$("#exampleInput").attr("value", sExample);
				for (int i = 0; i < lSenses.size(); i++) {
					$("#answer" + (i+1)).attr("value", lSenses.get(i));
					$("#answerLabel" + (i+1)).text(lSenses.get(i));
				}
			}

			return null;
		});
	}
}

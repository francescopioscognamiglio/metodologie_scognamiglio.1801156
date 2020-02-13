import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLSpanElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina del task Definition Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class DefinitionAnnotation extends Task implements CustomData {

	public static final String TASK_URL = "definitionAnnotation.jsp";
	public static final String TASK_TYPE = "DEFINITION_ANNOTATION";

	public DefinitionAnnotation() {
		super(TASK_URL);
	}

	public static void main(String[] args) {
		new DefinitionAnnotation().create();
	}

	@Override
	public HTMLElement[] createData() {
		HTMLSpanElement wordAndHypernym = document.createElement(StringTypes.span);
		wordAndHypernym.id = "wordAndHypernym";

		HTMLInputElement wordI = document.createElement(StringTypes.input);
		wordI.name = "word";
		wordI.id = "wordInput";
		wordI.hidden = true;

		HTMLInputElement hypernymI = document.createElement(StringTypes.input);
		hypernymI.name = "hypernym";
		hypernymI.id = "hypernymInput";
		hypernymI.hidden = true;

		return new HTMLElement[] { wordAndHypernym, wordI, hypernymI };
	}

	@Override
	public HTMLElement[] createAnswer() {
		HTMLTextAreaElement answer = document.createElement(StringTypes.textarea);
		answer.name = "answer";
		answer.className =  "form-control";
		answer.placeholder = "Scrivi la tua risposta qui...";
		answer.required = true;
		$(answer).css("height", "180px");

		return new HTMLElement[] { answer };
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
				String sHypernym = ((String)json.$get("hypernym")).replaceAll("_", " ");
				sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
				sHypernym = sHypernym.substring(0, 1).toUpperCase() + sHypernym.substring(1);

				$("#title").text("Data la seguente parola e un suo iperonimo, fornire una definizione nella tua lingua madre.");
				$("#wordAndHypernym").html("<b>" + sWord + "</b>" + " - " + sHypernym);
				$("#wordInput").attr("value", sWord);
				$("#hypernymInput").attr("value", sHypernym);
			}

			return null;
		});
	}
}

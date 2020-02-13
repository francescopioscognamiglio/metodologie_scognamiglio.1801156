import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina del task Word Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class WordAnnotation extends Task implements CustomData {

	public static final String TASK_URL = "wordAnnotation.jsp";
	public static final String TASK_TYPE = "WORD_ANNOTATION";

	public WordAnnotation() {
		super(TASK_URL);
	}
	
	public static void main(String[] args) {
		WordAnnotation wordAnnotation = new WordAnnotation();
		wordAnnotation.create();
	}

	@Override
	public HTMLElement[] createData() {
		HTMLSpanElement description = document.createElement(StringTypes.span);
		description.id = "description";

		HTMLInputElement descriptionI = document.createElement(StringTypes.input);
		descriptionI.name = "description";
		descriptionI.id = "descriptionInput";
		descriptionI.hidden = true;

		return new HTMLElement[] { description, descriptionI };
	}

	@Override
	public HTMLElement[] createAnswer() {
		HTMLInputElement answer = document.createElement(StringTypes.input);
		answer.className =  "form-control";
		answer.name = "answer";
		answer.type = "text";
		answer.required = true;
		answer.placeholder = "Scrivi la tua risposta qui...";

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
				String sDescription = ((String)json.$get("description")).replaceAll("_", " ");
				sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);

				$("#title").text("Data la seguente definizione, provare ad indovinare il termine definito.");
				$("#description").html(sDescription);
				$("#descriptionInput").attr("value", sDescription);
			}

			return null;
		});
	}
}

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
 * Questa classe rappresenta la pagina del task Translation Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class TranslationAnnotation extends Task implements CustomData {

	public static final String TASK_URL = "translationAnnotation.jsp";
	public static final String TASK_TYPE = "TRANSLATION_ANNOTATION";

	public TranslationAnnotation() {
		super(TASK_URL);
	}

	public static void main(String[] args) {
		TranslationAnnotation translationAnnotation = new TranslationAnnotation();
		translationAnnotation.create();
	}

	@Override
	public HTMLElement[] createData() {
		HTMLSpanElement word = document.createElement(StringTypes.span);
		word.id = "word";

		HTMLInputElement wordI = document.createElement(StringTypes.input);
		wordI.name = "word";
		wordI.id = "wordInput";
		wordI.hidden = true;

		HTMLSpanElement description = document.createElement(StringTypes.span);
		description.id = "description";

		HTMLInputElement descriptionI = document.createElement(StringTypes.input);
		descriptionI.name = "description";
		descriptionI.id = "descriptionInput";
		descriptionI.hidden = true;

		return new HTMLElement[] { word, wordI, description, descriptionI };
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
				String sDescription = ((String)json.$get("description")).replaceAll("_", " ");
				sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
				sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);

				$("#title").text("Data la seguente parola e definizione in inglese, fornire una traduzione nella tua lingua madre.");
				$("#word").html("<b>" + sWord + "</b><br>");
				$("#wordInput").attr("value", sWord);
				$("#description").html(sDescription);
				$("#descriptionInput").attr("value", sDescription);
			}

			return null;
		});
	}
}

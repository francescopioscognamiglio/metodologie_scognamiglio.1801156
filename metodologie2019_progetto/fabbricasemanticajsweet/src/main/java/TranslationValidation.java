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
 * Questa classe rappresenta la pagina del task Translation Validation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class TranslationValidation extends Task implements CustomData {

	public static final String TASK_URL = "translationValidation.jsp";
	public static final String TASK_TYPE = "TRANSLATION_VALIDATION";

	public TranslationValidation() {
		super(TASK_URL);
	}

	public static void main(String[] args) {
		TranslationValidation translationValidation = new TranslationValidation();
		translationValidation.create();
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
		formCheckInput4.value = "nessuna";
		HTMLDivElement formCheckLabel4 = document.createElement(StringTypes.div);
		formCheckLabel4.className = "form-check-label";
		formCheckLabel4.id = "answerLabel4";
		formCheckLabel4.textContent = "nessuna";

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
				String sDescription = ((String)json.$get("description")).replaceAll("_", " ");
				List<String> lTranslations = (List<String>)json.$get("translations");
				sWord = sWord.substring(0, 1).toUpperCase() + sWord.substring(1);
				sDescription = sDescription.substring(0, 1).toUpperCase() + sDescription.substring(1);

				$("#title").text("Data la seguente parola e definizione in inglese, scegliere la miglior traduzione tra quelle fornite o specificare nessuna.");
				$("#word").html("<b>" + sWord + "</b><br>");
				$("#wordInput").attr("value", sWord);
				$("#description").html(sDescription);
				$("#descriptionInput").attr("value", sDescription);
				for (int i = 0; i < lTranslations.size(); i++) {
					$("#answer" + (i+1)).attr("value", lTranslations.get(i));
					$("#answerLabel" + (i+1)).text(lTranslations.get(i));
				}
			}

			return null;
		});
	}
}

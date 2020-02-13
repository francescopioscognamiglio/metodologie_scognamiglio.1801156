import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import java.util.ArrayList;
import java.util.List;

import def.dom.HTMLElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLOptionElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLSelectElement;
import def.dom.HTMLSpanElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta la pagina del custom task My Text Annotation
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public class MyTextAnnotation extends Task implements CustomData {

	public static final String TASK_URL = "myTextAnnotation.jsp";
	public static final String TASK_TYPE = "MY_TEXT_ANNOTATION";

	public MyTextAnnotation() {
		super(TASK_URL);
	}

	public static void main(String[] args) {
		new MyTextAnnotation().create();
	}

	@Override
	public HTMLElement[] createData() {
		return new HTMLElement[] {};
	}

	@Override
	public HTMLElement[] createAnswer() {
		HTMLParagraphElement p = document.createElement(StringTypes.p);
		p.className = "text-justify";
		p.id = "p";

		return new HTMLElement[] { p };
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
				List<String> lWordAnswers = (List<String>)json.$get("wordAnswers");
				List<ArrayList<String>> lWords = (List<ArrayList<String>>)json.$get("words");
				List<String> lExamples = (List<String>)json.$get("examples");

				$("#title").text("Dato il seguente testo, inserire le parole negli appositi spazi.");
				for (int i = 0; i < lExamples.size(); i++) {
					List<String> lWordOption = lWords.get(i);

					String sSpan1 = "";
					String sSpan2 = "";
					boolean optionFounded = false;
					for (String substring : lExamples.get(i).replaceAll("_", " ").split(" ")) {
						if (substring.toLowerCase().equals(lWordAnswers.get(i).toLowerCase())
								|| substring.toLowerCase().startsWith(lWordAnswers.get(i).toLowerCase())
								|| lWordAnswers.get(i).toLowerCase().startsWith(substring.toLowerCase())
								|| substring.toLowerCase().substring(0, substring.length()-1).equals(lWordAnswers.get(i).toLowerCase())
								|| lWordAnswers.get(i).toLowerCase().substring(0, lWordAnswers.get(i).length()-1).equals(substring.toLowerCase())) {
							optionFounded = true;
							continue;
						}
						if (!optionFounded) sSpan1 += substring + " ";
						else sSpan2 += substring + " ";
					}
					sSpan1 = sSpan1.substring(0, 1).toUpperCase() + sSpan1.substring(1);
					sSpan1 = i > 0 ? " " + sSpan1 : sSpan1;
					sSpan2 = " " + sSpan2.substring(0, sSpan2.length()-1) + (!sSpan2.endsWith(".") ? "." : "");

					HTMLSpanElement span1 = document.createElement(StringTypes.span);
					span1.textContent = sSpan1;
					HTMLSpanElement span2 = document.createElement(StringTypes.span);
					span2.textContent = sSpan2;
					HTMLInputElement exampleI = document.createElement(StringTypes.input);
					exampleI.name = "example";
					exampleI.id = "exampleInput";
					exampleI.hidden = true;
					exampleI.value = lExamples.get(i);
					HTMLSelectElement select = document.createElement(StringTypes.select);
					select.name = "answer";
					select.required = true;
					$(select).css("max-width", "100px");
					HTMLOptionElement option1 = document.createElement(StringTypes.option);
					option1.textContent = "Choose...";
					option1.value = "";
					HTMLOptionElement option2 = document.createElement(StringTypes.option);
					option2.textContent = lWordOption.get(0).replaceAll("_", " ").toLowerCase();
					option2.value = lWordOption.get(0).replaceAll("_", " ").toLowerCase();
					HTMLOptionElement option3 = document.createElement(StringTypes.option);
					option3.textContent = lWordOption.get(1).replaceAll("_", " ").toLowerCase();
					option3.value = lWordOption.get(1).replaceAll("_", " ").toLowerCase();
					HTMLOptionElement option4 = document.createElement(StringTypes.option);
					option4.textContent = lWordOption.get(2).replaceAll("_", " ").toLowerCase();
					option4.value = lWordOption.get(2).replaceAll("_", " ").toLowerCase();
					$(select).append(option1, option2, option3, option4);
					$("#p").append(span1, exampleI, select, span2);
				}
			}

			return null;
		});
	}
}

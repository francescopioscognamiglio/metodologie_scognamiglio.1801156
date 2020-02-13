import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLBRElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHRElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLIElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLOListElement;
import jsweet.util.StringTypes;

/**
 * Questa classe rappresenta un task generico
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public abstract class Task extends Page {

	private String taskURL;

	public Task(String taskURL) {
		this.taskURL = taskURL;
	}

	@Override
	public void create() {
		super.create();
		console.log("Creating form");

		HTMLFormElement form = document.createElement(StringTypes.form);
		form.action = taskURL;
		form.method = "POST";
		form.className = "container";
		$(form).css("margin-top", "100px");
		$(form).css("margin-bottom", "100px");
		console.log("Form Done");

		HTMLElement navBreadcrumb = document.createElement("nav");
		navBreadcrumb.setAttribute("aria-label", "breadcrumb");
		HTMLOListElement olBreadcrumb = document.createElement(StringTypes.ol);
		olBreadcrumb.className="breadcrumb";
		HTMLLIElement liBreadcrumb1 = document.createElement(StringTypes.li);
		liBreadcrumb1.className = "breadcrumb-item";
		HTMLAnchorElement aBreadcrumb1 = document.createElement(StringTypes.a);
		aBreadcrumb1.href = "home.html";
		aBreadcrumb1.textContent = "Home";
		HTMLLIElement liBreadcrumb2 = document.createElement(StringTypes.li);
		liBreadcrumb2.className = "breadcrumb-item active";
		liBreadcrumb2.setAttribute("aria-current", "page");
		liBreadcrumb2.textContent = "Task";
		$(navBreadcrumb).append(olBreadcrumb);
		$(olBreadcrumb).append(liBreadcrumb1, liBreadcrumb2);
		$(liBreadcrumb1).append(aBreadcrumb1);

		HTMLLabelElement taskTitle = document.createElement(StringTypes.label);
		taskTitle.id = "title";
		taskTitle.className =  "form-control-plaintext text-center";
		taskTitle.setAttribute("style", "font-weight:bold; font-size:17px;");

		HTMLHRElement hr = document.createElement(StringTypes.hr);
		HTMLBRElement br = document.createElement(StringTypes.br);

		HTMLInputElement skip = document.createElement(StringTypes.input);
		skip.type = "submit";
		skip.name = "skip_button";
		skip.className =  "btn btn-outline-dark col-md-3";
		skip.value = "Skip";
		skip.formNoValidate = "true";
		$(skip).css("float", "left");

		HTMLInputElement submit = document.createElement(StringTypes.input);
		submit.type = "submit";
		submit.name = "submit_button";
		submit.className =  "btn btn-outline-primary col-md-3";
		submit.value = "Next";
		$(submit).css("float", "right");

		HTMLDivElement divDescription = document.createElement(StringTypes.div);
		divDescription.className = "form-group";
		$(divDescription).append(taskTitle, hr.cloneNode(), createData());

		HTMLDivElement divAnswer = document.createElement(StringTypes.div);
		divAnswer.className = "form-group";
		$(divAnswer).append(createAnswer());

		HTMLDivElement divButtons = document.createElement(StringTypes.div);
		divButtons.className = "form-group";
		$(divButtons).append(submit, skip);

		console.log("adding to form");
		$(form).append(navBreadcrumb, br.cloneNode(), divDescription, divAnswer, br.cloneNode(), divButtons);
		console.log("adding to body");

		$("body").append(form);

		extra();
	}

	public abstract HTMLElement[] createData();

	public abstract HTMLElement[] createAnswer();

	public abstract void extra();
}

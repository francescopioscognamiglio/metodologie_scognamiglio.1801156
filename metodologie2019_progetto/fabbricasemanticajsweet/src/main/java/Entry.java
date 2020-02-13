import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.Event;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLBRElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHRElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import jsweet.util.StringTypes;

/**
 * Questa classe contiene il codice in comune tra le pagine di Login e di Signup
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public abstract class Entry extends Page {

	private String title;
	private String type;
	private String action;
	private String actionLabel;

	private String alternativeLabel;
	private String alternativeLink;
	private String alternativeLinkLabel;

	public Entry(String title, String type, String action, String actionLabel,
			String alternativeLabel, String alternativeLink, String alternativeLinkLabel) {
		this.type = type;
		this.title = title;
		this.action = action;
		this.actionLabel = actionLabel;
		this.alternativeLabel = alternativeLabel;
		this.alternativeLink = alternativeLink;
		this.alternativeLinkLabel = alternativeLinkLabel;
	}

	@Override
	public void create() {
		super.create();

		$("body").addClass("body-entry");

		HTMLDivElement divContainer = document.createElement(StringTypes.div);
		divContainer.className = "container container-entry-" + getType();

		HTMLDivElement divRow = document.createElement(StringTypes.div);
		divRow.className = "row";

		HTMLDivElement divCol1 = document.createElement(StringTypes.div);
		divCol1.className = "col-sm-9 col-md-7 col-lg-5 mx-auto";

		HTMLDivElement divCard = document.createElement(StringTypes.div);
		divCard.className = "card";

		HTMLDivElement divCardBody1 = document.createElement(StringTypes.div);
		divCardBody1.className = "card-body";

		HTMLHeadingElement divHeading = document.createElement(StringTypes.h5);
		divHeading.className = "text-center";
		divHeading.textContent = getTitle();

		HTMLDivElement divCardMy4 = document.createElement(StringTypes.div);
		divCardMy4.className = "card my-4";

		HTMLDivElement divCardBody2 = document.createElement(StringTypes.div);
		divCardBody2.className = "card-body";

		HTMLFormElement form = document.createElement(StringTypes.form);
		form.id = "form-entry";
		form.action = getAction();
		form.method = "post";
		form.onsubmit = this::onSubmit;

		HTMLDivElement incorrectData = document.createElement(StringTypes.div);
		incorrectData.className = "alert alert-danger text-center";
		incorrectData.setAttribute("hidden", "");

		HTMLBRElement br = document.createElement(StringTypes.br);

		HTMLDivElement divFormGroupSubmit = document.createElement(StringTypes.div);
		divFormGroupSubmit.className = "form-group";

		HTMLInputElement inputSubmit = document.createElement(StringTypes.input);
		inputSubmit.className = "btn btn-lg btn-primary btn-block";
		inputSubmit.type = "submit";
		inputSubmit.value = getActionLabel();

		HTMLHRElement hrLast = document.createElement(StringTypes.hr);
		hrLast.className = "my-1";

		HTMLDivElement divCardAlternative = document.createElement(StringTypes.div);
		divCardAlternative.className = "card my-4";

		HTMLDivElement divCardSubAlternative = document.createElement(StringTypes.div);
		divCardSubAlternative.className = "card-body";

		HTMLDivElement divCardSubSubAlternative = document.createElement(StringTypes.div);
		divCardSubSubAlternative.className = "text-center";
		divCardSubSubAlternative.textContent = getAlternativeLabel();

		HTMLAnchorElement aRegister = document.createElement(StringTypes.a);
		aRegister.href = getAlternativeLink();
		aRegister.textContent = getAlternativeLinkLabel();

		$(divContainer).append(divRow);
		$(divRow).append(divCol1);
		$(divCol1).append(divCard, divCardMy4, divCardAlternative);

		$(divCard).append(divCardBody1);
		$(divCardBody1).append(divHeading);

		$(divCardMy4).append(divCardBody2);
		$(divCardBody2).append(form);
		$(form).append(incorrectData, getCustomComponents(), br, divFormGroupSubmit, hrLast);

		$(divFormGroupSubmit).append(inputSubmit);

		$(divCardAlternative).append(divCardSubAlternative);
		$(divCardSubAlternative).append(divCardSubSubAlternative);
		$(divCardSubSubAlternative).append(aRegister);

		$("body").append(divContainer);
	}

	public abstract HTMLElement[] getCustomComponents();

	public abstract boolean onSubmit(Event e);

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public String getAlternativeLabel() {
		return alternativeLabel;
	}

	public void setAlternativeLabel(String alternativeLabel) {
		this.alternativeLabel = alternativeLabel;
	}

	public String getAlternativeLink() {
		return alternativeLink;
	}

	public void setAlternativeLink(String alternativeLink) {
		this.alternativeLink = alternativeLink;
	}

	public String getAlternativeLinkLabel() {
		return alternativeLinkLabel;
	}

	public void setAlternativeLinkLabel(String alternativeLinkLabel) {
		this.alternativeLinkLabel = alternativeLinkLabel;
	}
}

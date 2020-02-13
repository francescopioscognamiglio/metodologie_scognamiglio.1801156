/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * TODO: IL BUILDER É FUNZIONANTE, MA POTREI MIGLIORARLO ED UTILIZZARLO PER SCRIVERE TUTTE LE PAGINE HTML.
 * @param {HTMLElement} element
 * @class
 */
class HTMLBuilder {
    constructor(element) {
        if (this.node === undefined)
            this.node = null;
        this.node = (new HTMLNode(element));
    }
    addElement(element) {
        this.node = this.node.addChild((new HTMLNode(element)));
        return this;
    }
    closeElement() {
        this.node = this.node.getParent();
        return this;
    }
    addCSS(property, value) {
        $(this.node.getElement()).css(property, value);
        return this;
    }
    build$() {
        this.build$HTMLNode$java_util_List(this.node, this.node.getChildren());
    }
    build$HTMLNode$java_util_List(parent, children) {
        if ((children.length == 0))
            return;
        for (let index125 = 0; index125 < children.length; index125++) {
            let child = children[index125];
            {
                $(parent.getElement()).append(child.getElement());
                this.build$HTMLNode$java_util_List(child, child.getChildren());
            }
        }
    }
    build(parent, children) {
        if (((parent != null && parent instanceof HTMLNode) || parent === null) && ((children != null && (children instanceof Array)) || children === null)) {
            return this.build$HTMLNode$java_util_List(parent, children);
        }
        else if (parent === undefined && children === undefined) {
            return this.build$();
        }
        else
            throw new Error('invalid overload');
    }
    static main() {
        let body = document.getElementsByTagName("body")[0];
        let builder = new HTMLBuilder(body);
        let form = document.createElement("form");
        form.action = "prova";
        form.method = "POST";
        form.className = "container";
        builder.addElement(form).addCSS("margin-top", "100px").addCSS("margin-bottom", "100px");
        let divDescription = document.createElement("div");
        divDescription.className = "form-group";
        let description = document.createElement("label");
        description.className = "form-control-plaintext";
        description.setAttribute("style", "font-weight:bold");
        description.textContent = "Benvenuto!";
        builder.addElement(divDescription).addElement(description).closeElement().closeElement();
        let divTranslation = document.createElement("div");
        divTranslation.className = "form-group";
        let name = document.createElement("textarea");
        name.name = "name";
        name.className = "form-control";
        name.placeholder = "Scrivi il tuo nome qui...";
        builder.addElement(divTranslation).addElement(name).closeElement().closeElement();
        let divButtons = document.createElement("div");
        divButtons.className = "form-group";
        let submit = document.createElement("input");
        submit.type = "submit";
        submit.name = "submit_button";
        submit.className = "btn btn-primary";
        submit.value = "Avanti";
        builder.addElement(divButtons).addElement(submit).closeElement();
        let skip = document.createElement("input");
        skip.type = "submit";
        skip.name = "skip_button";
        skip.className = "btn btn-primary";
        skip.value = "Skip";
        builder.addElement(skip).addCSS("float", "right").closeElement().closeElement().closeElement();
        builder.build();
    }
}
HTMLBuilder["__class"] = "HTMLBuilder";
HTMLBuilder.main();

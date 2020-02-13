/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * TODO: IL BUILDER É FUNZIONANTE, MA POTREI MIGLIORARLO ED UTILIZZARLO PER SCRIVERE TUTTE LE PAGINE HTML.
 * @param {HTMLElement} element
 * @class
 */
class HTMLBuilder {
    node : HTMLNode<HTMLElement>;

    public constructor(element : HTMLElement) {
        if(this.node===undefined) this.node = null;
        this.node = <any>(new HTMLNode<HTMLElement>(element));
    }

    public addElement(element : HTMLElement) : HTMLBuilder {
        this.node = this.node.addChild(<any>(new HTMLNode<HTMLElement>(element)));
        return this;
    }

    public closeElement() : HTMLBuilder {
        this.node = this.node.getParent();
        return this;
    }

    public addCSS(property : string, value : string) : HTMLBuilder {
        $(this.node.getElement()).css(property, value);
        return this;
    }

    public build$() {
        this.build$HTMLNode$java_util_List(this.node, this.node.getChildren());
    }

    public build$HTMLNode$java_util_List(parent : HTMLNode<HTMLElement>, children : Array<HTMLNode<HTMLElement>>) {
        if(/* isEmpty */(children.length == 0)) return;
        for(let index125=0; index125 < children.length; index125++) {
            let child = children[index125];
            {
                $(parent.getElement()).append(child.getElement());
                this.build$HTMLNode$java_util_List(child, child.getChildren());
            }
        }
    }

    public build(parent? : any, children? : any) : any {
        if(((parent != null && parent instanceof <any>HTMLNode) || parent === null) && ((children != null && (children instanceof Array)) || children === null)) {
            return <any>this.build$HTMLNode$java_util_List(parent, children);
        } else if(parent === undefined && children === undefined) {
            return <any>this.build$();
        } else throw new Error('invalid overload');
    }

    public static main() {
        let body : HTMLBodyElement = document.getElementsByTagName("body")[0];
        let builder : HTMLBuilder = new HTMLBuilder(body);
        let form : HTMLFormElement = document.createElement("form");
        form.action = "prova";
        form.method = "POST";
        form.className = "container";
        builder.addElement(form).addCSS("margin-top", "100px").addCSS("margin-bottom", "100px");
        let divDescription : HTMLDivElement = document.createElement("div");
        divDescription.className = "form-group";
        let description : HTMLLabelElement = document.createElement("label");
        description.className = "form-control-plaintext";
        description.setAttribute("style", "font-weight:bold");
        description.textContent = "Benvenuto!";
        builder.addElement(divDescription).addElement(description).closeElement().closeElement();
        let divTranslation : HTMLDivElement = document.createElement("div");
        divTranslation.className = "form-group";
        let name : HTMLTextAreaElement = document.createElement("textarea");
        name.name = "name";
        name.className = "form-control";
        name.placeholder = "Scrivi il tuo nome qui...";
        builder.addElement(divTranslation).addElement(name).closeElement().closeElement();
        let divButtons : HTMLDivElement = document.createElement("div");
        divButtons.className = "form-group";
        let submit : HTMLInputElement = document.createElement("input");
        submit.type = "submit";
        submit.name = "submit_button";
        submit.className = "btn btn-primary";
        submit.value = "Avanti";
        builder.addElement(divButtons).addElement(submit).closeElement();
        let skip : HTMLInputElement = document.createElement("input");
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

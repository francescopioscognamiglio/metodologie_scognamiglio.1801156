/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
class HTMLNode {
    constructor(element) {
        /*private*/ this.children = ([]);
        if (this.parent === undefined)
            this.parent = null;
        if (this.element === undefined)
            this.element = null;
        this.element = element;
    }
    addChild(child) {
        child.setParent(this);
        /* add */ (this.children.push(child) > 0);
        return child;
    }
    setParent(parent) {
        this.parent = parent;
    }
    getParent() {
        return this.parent;
    }
    getChildren() {
        return this.children;
    }
    getElement() {
        return this.element;
    }
}
HTMLNode["__class"] = "HTMLNode";

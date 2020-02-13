/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
class HTMLNode<T extends HTMLElement> {
    /*private*/ parent : HTMLNode<T>;

    /*private*/ children : Array<HTMLNode<T>> = <any>([]);

    /*private*/ element : T;

    public constructor(element : T) {
        if(this.parent===undefined) this.parent = null;
        if(this.element===undefined) this.element = null;
        this.element = element;
    }

    public addChild(child : HTMLNode<T>) : HTMLNode<T> {
        child.setParent(this);
        /* add */(this.children.push(child)>0);
        return child;
    }

    public setParent(parent : HTMLNode<T>) {
        this.parent = parent;
    }

    public getParent() : HTMLNode<T> {
        return this.parent;
    }

    public getChildren() : Array<HTMLNode<T>> {
        return this.children;
    }

    public getElement() : T {
        return this.element;
    }
}
HTMLNode["__class"] = "HTMLNode";




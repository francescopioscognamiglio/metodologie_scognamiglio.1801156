/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
/**
 * Questa classe rappresenta una pagina generica
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 * @class
 */
abstract class Page {
    public create() {
        $("body").append(Header.createHeader(), Footer.createFooter());
    }
}
Page["__class"] = "Page";




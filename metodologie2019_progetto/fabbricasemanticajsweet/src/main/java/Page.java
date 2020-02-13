import static def.jquery.Globals.$;

/**
 * Questa classe rappresenta una pagina generica
 * e contiene il codice che verra' transpilato in JavaScript da JSWeet
 * @author francescopioscognamiglio
 */
public abstract class Page {

	public void create() {
		$("body").append(Header.createHeader(), Footer.createFooter());
	}
}

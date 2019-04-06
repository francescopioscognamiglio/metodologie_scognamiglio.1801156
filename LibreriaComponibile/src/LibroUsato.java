
/**
 * Esercizio: la LibreriaComponibile
 * 
 * Un libro è rappresentato dal titolo e dall’autore e dispone di un metodo letto
 * che restituisce un booleano relativo all'avvenuta lettura del libro
 * – Un libro può essere usato (si modelli con una nuova classe),
 * 	 nel qual caso il libro è già stato letto in passato
 * 
 * @author francescopioscognamiglio
 *
 */
public class LibroUsato extends Libro
{
	
	/**
	 * costruttore che imposta il nome e l'autore del libro usato
	 * @param nome il nome del libro usato
	 * @param autore l'autore del libro usato
	 */
	public LibroUsato(String nome, String autore)
	{
		super(nome, autore, true);
	}
	
}

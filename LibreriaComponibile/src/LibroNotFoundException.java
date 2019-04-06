
/**
 * Esercizio: la LibreriaComponibile
 * 
 * Un libro è rappresentato dal titolo e dall’autore e dispone di un metodo letto
 * che restituisce un booleano relativo all'avvenuta lettura del libro
 * – Un libro può essere usato (si modelli con una nuova classe),
 * 	 nel qual caso il libro è già stato letto in passato
 * 
 * Progettare un'eccezione che venga invocata se il libro non viene trovato
 * 
 * @author francescopioscognamiglio
 *
 */

public class LibroNotFoundException extends Exception
{
	public LibroNotFoundException(String titolo)
	{
		super("Libro con titolo \"" + titolo + "\" non trovato");
	}
}

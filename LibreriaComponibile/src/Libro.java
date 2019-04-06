
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
public class Libro
{
	
	/**
	 * il titolo del libro
	 */
	private String titolo;
	/**
	 * l'autore del libro
	 */
	private String autore;
	/**
	 * se il libro é stato letto
	 */
	private boolean letto;
	
	/**
	 * costruttore che imposta il titolo, l'autore e se il libro é stato letto
	 * @param titolo il titolo del libro
	 * @param autore l'autore del libro
	 * @param letto se il libro é stato letto
	 */
	public Libro(String titolo, String autore, boolean letto)
	{
		this.titolo = titolo;
		this.autore = autore;
		this.letto = letto;
	}
	
	/**
	 * metodo getter che restituisce il titolo del libro
	 * @return il titolo del libro
	 */
	public String getTitolo() { return titolo; }
	/**
	 * metodo getter che restituisce l'autore del libro
	 * @return l'autore del libro
	 */
	public String getAutore() { return autore; }
	/**
	 * metodo getter che restituisce se il libro é stato letto
	 * @return se il libro é stato letto
	 */
	public boolean isLetto() { return letto; }
	
}

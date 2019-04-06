import java.util.ArrayList;
import java.util.List;

/**
 * Esercizio: la LibreriaComponibile
 * 
 * Progettare una libreria componibile, costituita da una serie di scaffali
 * 
 * Ogni scaffale contiene una sequenza di libri e prevede una capienza massima
 * 
 * Un libro è rappresentato dal titolo e dall’autore e dispone di un metodo letto
 * che restituisce un booleano relativo all'avvenuta lettura del libro
 * – Un libro può essere usato (si modelli con una nuova classe),
 * 	 nel qual caso il libro è già stato letto in passato
 * 
 * Una libreria permette di aggiungere ed eliminare scaffali, di accedere al k-esimo scaffale
 * e di ottenere il numero di scaffali
 * 
 * Uno scaffale permette di aggiungere libri, eliminare libri per titolo
 * e cercare libri per titolo e/o libri non ancora letti
 * 
 * La libreria inoltre permette di aggiungere un libro nel primo scaffale libero
 * 
 * @author francescopioscognamiglio
 *
 */
public class LibreriaComponibile
{
	
	/**
	 * scaffali contenuti nella libreria componibile
	 */
	private List<Scaffale> scaffali;
	
	/**
	 * costruttore che inizializza gli scaffali
	 */
	public LibreriaComponibile()
	{
		scaffali = new ArrayList<Scaffale>();
	}
	
	/**
	 * metodo che aggiunge un nuovo scaffale
	 * @param scaffale il nuovo scaffale
	 */
	public void aggiungiScaffale(Scaffale scaffale)
	{
		scaffali.add(scaffale);
	}
	
	/**
	 * metodo che elimina lo scaffale in posizione index
	 * @param index la posizione dello scaffale
	 * @throws ScaffaleNotFoundException se la posizione non esiste
	 */
	public void eliminaScaffale(int index) throws ScaffaleNotFoundException
	{
		if (index < 0 || index >= scaffali.size()) throw new ScaffaleNotFoundException(index);
		
		scaffali.remove(index);
	}
	
	/**
	 * metodo che elimina un preciso scaffale
	 * @param scaffale lo scaffale da eliminare
	 */
	public void eliminaScaffale(Scaffale scaffale)
	{
		scaffali.remove(scaffale);
	}
	
	/**
	 * metodo che restituisce lo scaffale in posizione index
	 * @param index la posizione dello scaffale
	 * @return lo scaffale in posizione index
	 * @throws ScaffaleNotFoundException se la posizione non esiste
	 */
	public Scaffale getScaffale(int index) throws ScaffaleNotFoundException
	{
		if (index < 0 || index >= scaffali.size()) throw new ScaffaleNotFoundException(index);
		
		return scaffali.get(index);
	}
	
	/**
	 * metodo che restituisce il numero di scaffali presenti nella libreria componibile
	 * @return il numero di scaffali presenti nella libreria componibile
	 */
	public int numeroScaffali()
	{
		return scaffali.size();
	}
	
	/**
	 * metodo che aggiunge un libro nel primo scaffale con spazio
	 * @param libro il libro da aggiungere
	 * @return la posizione in cui il libro é stato aggiunto
	 */
	public int aggiungiLibro(Libro libro)
	{
		for (int i = 0; i < scaffali.size(); i++)
		{
			Scaffale scaffale = scaffali.get(i);
			if (scaffale.aggiungiLibro(libro))
				return i;
		}
		return -1;
	}
	
}

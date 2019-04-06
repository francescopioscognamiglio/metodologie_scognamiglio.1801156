import java.util.ArrayList;
import java.util.List;

/**
 * Esercizio: la LibreriaComponibile
 * 
 * Ogni scaffale contiene una sequenza di libri e prevede una capienza massima
 * 
 * Uno scaffale permette di aggiungere libri, eliminare libri per titolo
 * e cercare libri per titolo e/o libri non ancora letti
 * 
 * @author francescopioscognamiglio
 *
 */
public class Scaffale
{
	
	/**
	 * i libri presenti nello scaffale
	 */
	private List<Libro> libri;
	/**
	 * la capienza massima dello scaffale
	 */
	private final int capienzaMassima;
	
	/**
	 * costruttore che imposta la capienza massima dello scaffale
	 * @param capienzaMassima la capienza massima dello scaffale
	 */
	public Scaffale(int capienzaMassima)
	{
		libri = new ArrayList<Libro>();
		this.capienzaMassima = capienzaMassima;
	}
	
	/**
	 * metodo che aggiunge il libro nello scaffale
	 * @param libro il libro da aggiungere
	 * @return true se il libro é stato aggiunto
	 */
	public boolean aggiungiLibro(Libro libro)
	{
		if (libri.size() > capienzaMassima) return false;
		return libri.add(libro);
	}
	
	/**
	 * metodo che restituisce la posizione del libro nello scaffale avente lo stesso titolo di quello passato in input 
	 * @param titolo il titolo passato in input
	 * @return la posizione del libro; -1 se il libro non é stato trovato
	 */
	private int indexOf(String titolo)
	{
		for (int i = 0; i < libri.size(); i++)
			if (libri.get(i).getTitolo().equals(titolo)) return i;
		return -1;
	}
	
	/**
	 * metodo che elimina il libro nello scaffale avente lo stesso titolo di quello passato in input
	 * @param titolo il titolo passato in input
	 * @return il libro eliminato
	 * @throws LibroNotFoundException se il libro non é stato trovato
	 */
	public Libro eliminaLibro(String titolo) throws LibroNotFoundException
	{
		int index = indexOf(titolo);
		if (index >= 0)
			return libri.remove(index);
		throw new LibroNotFoundException(titolo);
	}
	
	/**
	 * metodo che cerca un libro nello scaffale in base al titolo
	 * @param titolo il titolo da cercare
	 * @return il libro avente lo stesso titolo
	 * @throws LibroNotFoundException se il libro non é stato trovato
	 */
	public Libro cercareLibro(String titolo) throws LibroNotFoundException
	{
		int index = indexOf(titolo);
		if (index >= 0)
			return libri.get(index);
		throw new LibroNotFoundException(titolo);
	}
	
	/**
	 * metodo che cerca tutti i libri non letti nello scaffale
	 * @return una lista contenente tutti i libri non letti nello scaffale
	 */
	public List<Libro> cercareLibriNonLetti()
	{
		List<Libro> libriNonLetti = new ArrayList<Libro>();
		for (int i = 0; i < libri.size(); i++)
			if (libri.get(i) instanceof LibroUsato)
				libriNonLetti.add(libri.get(i));
		return libriNonLetti;
	}
	
	/**
	 * metodo che restituisce il numero di libri presenti nello scaffale
	 * @return il numero di libri presenti nello scaffale
	 */
	public int numeroLibri()
	{
		return libri.size();
	}
	
}

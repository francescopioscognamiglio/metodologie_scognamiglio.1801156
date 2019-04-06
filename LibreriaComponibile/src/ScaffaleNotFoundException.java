
/**
 * Esercizio: la LibreriaComponibile
 * 
 * Ogni scaffale contiene una sequenza di libri e prevede una capienza massima
 * 
 * Uno scaffale permette di aggiungere libri, eliminare libri per titolo
 * e cercare libri per titolo e/o libri non ancora letti
 * 
 * Progettare un'eccezione che venga invocata se lo scaffale non viene trovato
 * 
 * @author francescopioscognamiglio
 *
 */
public class ScaffaleNotFoundException extends Exception
{
	public ScaffaleNotFoundException(int index)
	{
		super("Scaffale alla posizione " + index + " non trovato");
	}
}

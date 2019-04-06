
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Progettare una classe RiproduttoreMusicale che rappresenti un generico riproduttore
 * 
 * La classe deve realizzare i seguenti metodi:
 * - inserisciSupporto(): permette di inserire un supporto musicale (es. CD, nastro, ecc.)
 * - espelliSupporto(): espelle il supporto
 * - getBrano(): restituisce l’attuale brano in esecuzione (null se non sta eseguendo)
 * - play(): esegue il brano attualmente selezionato
 * - stop(): interrompe l’esecuzione
 * - next(): seleziona il prossimo brano
 * - prev(): seleziona il brano precedente
 * - toString(): visualizza le informazioni del brano attualmente in esecuzione
 * 
 * 
 * Realizzare quindi i seguenti riproduttori
 * - Giradischi
 * - Mangianastri
 * - Lettore CD
 * - Lettore Mp3
 * 
 * 
 * Realizzare inoltre diversi tipi di supporto:
 * - Disco a 33 giri (14 brani)
 * - Disco a 45 giri (2 brani)
 * - Compact Disc (20 brani)
 * - Nastro (con un numero specificato di minuti, numero di brani pari al numero di minuti / 5)
 * - Memoria USB (1024 brani)
 * * Gli ultimi due supporti permettono di registrare/inserire brani nella posizione specificata
 * * Ciascun supporto può contenere il numero massimo di brani specificati tra parentesi nella precedente diapositiva
 * 	 e viene costruito con una data sequenza (eventualmente vuota) di brani
 * 
 * Modellare inoltre la classe Brano che contenga l’informazione sul nome del brano e il cantante
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class RiproduttoreMusicale
{
	/**
	 * il supporto utilizzato dal riproduttore musicale
	 */
	protected Supporto supporto;
	/**
	 * il brano eseguito dal riproduttore musicale
	 */
	protected Brano brano;
	/**
	 * la posizione del riproduttore musicale
	 */
	private int posizione = 0;
	/**
	 * se il riproduttore musicale é in esecuzione
	 */
	private boolean inEsecuzione = false;
	
	/**
	 * metodo che inserisce il supporto utilizzato dal riproduttore musicale
	 * @param supporto il supporto utilizzato dal riproduttore musicale
	 */
	abstract public void inserisciSupporto(Supporto supporto) throws SupportoNonSupportatoException;
	
	/**
	 * metodo che espelle il supporto utilizzato dal riproduttore musicale
	 */
	public void espelliSupporto()
	{
		supporto = null;
		brano = null;
		posizione = 0;
		inEsecuzione = false;
	}
	
	private void setBrano(int posizione)
	{
		brano = supporto.getBrano(posizione);
	}
	
	/**
	 * metodo getter che restituisce il brano attualmente in esecuzione
	 * @return il brano attualmente in esecuzione
	 */
	public Brano getBrano()
	{
		if (!inEsecuzione) return null;
		return brano;
	}
	
	/**
	 * metodo che esegue il brano attualmente selezionato
	 */
	public void play()
	{
		inEsecuzione = true;
	}
	
	/**
	 * metodo che interrompe l'esecuzione del brano
	 */
	public void stop()
	{
		inEsecuzione = false;
	}
	
	/**
	 * metodo che seleziona il prossimo brano
	 */
	public void next()
	{
		if (posizione >= supporto.getNumeroBrani()-1) return;
		setBrano(++posizione);
	}
	
	/**
	 * metodo che seleziona il brano precedente
	 */
	public void prev()
	{
		if (posizione <= 0) return;
		setBrano(--posizione);
	}
	
	/**
	 * metodo che restituisce una stringa formata dalle informazioni del brano attualmente in esecuzione
	 * @return una stringa formata dalle informazioni del brano attualmente in esecuzione
	 */
	@Override
	public String toString()
	{
		if (brano == null) return null;
		return "\"" + brano.getTitolo() + "\" di " + brano.getCantante();
	}
}

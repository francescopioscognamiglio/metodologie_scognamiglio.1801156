
/**
 * Esercizio: mescolare e distribuire un mazzo di carte da gioco
 * 
 * Progettare una classe Carta che rappresenti una singola carta da gioco (con seme e valore)
 * - La classe deve restituire su richiesta la propria rappresentazione sotto forma di stringa
 * 
 * @author francescopioscognamiglio
 *
 */
public class Carta
{
	
	/**
	 * il seme della carta
	 */
	private SemeCarta seme;
	/**
	 * il valore della carta
	 */
	private ValoreCarta valore;
	
	/**
	 * costruttore che permette di definire il seme e il valore della carta
	 * @param seme il seme della carta
	 * @param valore il valore della carta
	 */
	public Carta(String seme, String valore)
	{
		this.seme = SemeCarta.valueOf(seme);
		this.valore = ValoreCarta.valueOf(valore);
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta la carta
	 * @return una stringa che rappresenta la carta
	 */
	public String toString()
	{
		return valore.toString() + " di " + seme.toString();
	}
	
}

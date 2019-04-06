
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Modellare inoltre la classe Brano che contenga l’informazione sul nome del brano e il cantante
 * 
 * @author francescopioscognamiglio
 *
 */
public class Brano
{
	/**
	 * titolo del brano
	 */
	private String titolo;
	/**
	 * cantante del brano
	 */
	private String cantante;
	
	/**
	 * costruttore che imposta il titolo e il cantante del brano
	 * @param titolo il titolo del brano
	 * @param cantante il cantante del brano
	 */
	public Brano(String titolo, String cantante)
	{
		this.titolo = titolo;
		this.cantante = cantante;
	}
	
	/**
	 * metodo getter che restituisce il titolo del brano
	 * @return il titolo del brano
	 */
	public String getTitolo() { return titolo; }
	/**
	 * metodo getter che restituisce il cantante del brano
	 * @return il cantante del brano
	 */
	public String getCantante() { return cantante; }
}

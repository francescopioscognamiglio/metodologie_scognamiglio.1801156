import java.util.List;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Progettare una classe EssereVivente dotata di età, sesso (M, F) e nome, con i seguenti metodi:
 * - getEta(): restituisce l’età dell’essere
 * - getSesso(): restituisce il sesso dell’essere
 * - getNome(): restituisce il nome
 * - cresce(): fa crescere l’essere vivente di 1 anno e con una certa probabilità lo fa morire
 * - mangia(): fa mangiare l’essere vivente
 * - siRiproduceCon(EssereVivente e): dato in ingresso un altro EssereVivente,
 * 	 se di sesso opposto fa riprodurre i due esseri e ne crea altri, altrimenti emette eccezione
 * - muore(): causa la morte dell’essere vivente; a seguito di questa operazione,
 * 	 l’essere non può eseguire nessun’altra operazione
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class EssereVivente
{
	
	/**
	 * enum che definisce il sesso dell'essere vivente
	 * @author francescopioscognamiglio
	 *
	 */
	public enum Sesso
	{
		MASCHIO, FEMMINA;
	}
	
	/**
	 * l'età dell'essere vivente
	 */
	private int eta;
	
	/**
	 * il sesso dell'essere vivente
	 */
	private Sesso sesso;
	
	/**
	 * il nome dell'essere vivente
	 */
	private String nome;
	
	/**
	 * contiene true se l'essere vivente é vivo; false altrimenti
	 */
	private boolean isVivo;
	
	/**
	 * costruttore che imposta il sesso e il nome dell'essere vivente
	 * @param sesso il sesso da impostare
	 * @param nome il nome da impostare
	 */
	public EssereVivente(Sesso sesso, String nome)
	{
		this.sesso = sesso;
		this.nome = nome;
		eta = 1;
		isVivo = true;
	}
	
	/**
	 * metodo getter che restituisce l'età dell'essere vivente
	 * @return l'età dell'essere vivente
	 */
	public int getEta() { return eta; }
	
	/**
	 * metodo getter che restituisce il sesso dell'essere vivente
	 * @return il sesso dell'essere vivente
	 */
	public Sesso getSesso() { return sesso; }
	
	/**
	 * metodo getter che restituisce il nome dell'essere vivente
	 * @return il nome dell'essere vivente
	 */
	public String getNome() { return nome; }
	
	/**
	 * metodo che restituisce true se l'essere vivente é vivo; false altrimenti
	 * @return true se l'essere vivente é vivo; false altrimenti
	 */
	protected boolean isVivo() { return isVivo; }
	
	/**
	 * metodo che imposta se l'essere vivente é vivo o no
	 * @param isVivo se l'essere vivente é vivo o no
	 */
	protected void setIsVivo(boolean isVivo)
	{
		this.isVivo = isVivo;
	}
	
	/**
	 * metodo che imposta il sesso dell'essere vivente
	 * @param sesso il sesso dell'essere vivente
	 */
	protected void setSesso(Sesso sesso)
	{
		this.sesso = sesso;
	}
	
	/**
	 * metodo che fa crescere l'essere vivente
	 */
	public void cresce()
	{
		if (isVivo())
		{
			eta++;
			if (new Random().nextBoolean()) muore();
		}
	}
	
	/**
	 * metodo che fa morire l'essere vivente
	 */
	public void muore()
	{
		isVivo = false;
	}
	
	/**
	 * metodo che fa mangiare l'essere vivente
	 */
	public void mangia()
	{
		if (isVivo())
		{
			System.out.println("Mangio...");
		}
	}
	
	/**
	 * metodo astratto che fa riprodurre l'essere vivente
	 * @param e un altro essere vivente
	 * @return una lista contenente gli esseri viventi creati
	 * @throws Exception se l'essere vivente e l'altro essere vivente sono dello stesso sesso
	 */
	abstract public List<EssereVivente> siRiproduceCon(EssereVivente e) throws Exception;
	
}

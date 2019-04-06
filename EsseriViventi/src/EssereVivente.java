import java.util.ArrayList;

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
	 * età dell'essere vivente
	 */
	private int eta;
	
	/**
	 * sesso dell'essere vivente
	 */
	private Sesso sesso;
	
	/**
	 * nome dell'essere vivente
	 */
	private String nome;
	
	/**
	 * contiene true se l'essere vivente é vivo; false altrimenti
	 */
	private boolean isVivo;
	
	/**
	 * numero minimo di figli che può generare l'essere vivente
	 */
	protected int minFigli = 0;
	
	/**
	 * numero massimo di figli che può generare l'essere vivente
	 */
	protected int maxFigli = 1;
	
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
	 * @throws EssereMortoException se l'essere vivente é morto
	 */
	public void cresce() throws EssereMortoException
	{
		if (!isVivo()) throw new EssereMortoException();
	
		eta++;
		if (new Random().nextBoolean()) muore();
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
	 * @throws EssereMortoException se l'essere vivente é morto
	 */
	public void mangia() throws EssereMortoException
	{
		if (!isVivo()) throw new EssereMortoException();
		
		System.out.println("Mangio...");
	}
	
	/**
	 * metodo che fa riprodurre l'essere vivente con l'essere vivente in input
	 * @param e l'essere vivente con il quale riprodursi
	 * @return una lista contenente gli esseri viventi creati
	 * @throws RiproduzioneException se l'essere vivente e l'essere vivente in input non sono della stessa specie
	 * @throws EssereMortoException se l'essere vivente é morto
	 * @throws StessoSessoException se l'essere vivente e l'essere vivente in input sono dello stesso sesso
	 * @throws PartorireException se l'essere vivente non é una femmina
	 */
	public ArrayList<EssereVivente> siRiproduceCon(EssereVivente e) throws RiproduzioneException, EssereMortoException
	{
		if (getClass() != e.getClass()) throw new RiproduzioneException();
		if (!isVivo()) throw new EssereMortoException();
		if (getSesso() == e.getSesso()) throw new StessoSessoException();
		if (getSesso().equals(Sesso.MASCHIO)) throw new PartorireException();
		
		return genera(new Random().nextInt(maxFigli - minFigli) + minFigli);
	}
	
	/**
	 * metodo astratto che genera una lista di esseri viventi creati
	 * @param numFigli il numero di figli da creare
	 * @return una lista di esseri viventi creati
	 */
	abstract protected ArrayList<EssereVivente> genera(int numFigli);
	
}

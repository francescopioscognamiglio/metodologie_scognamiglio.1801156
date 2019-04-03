
/**
 * Esercizio: Conto bancario
 * 
 * Modellare l'operazione Bonifico che preleva del denaro da un conto e lo versa su un altro
 * 
 * @author francescopioscognamiglio
 *
 */
public class Bonifico extends Operazione
{
	
	/**
	 * denaro da trasferire
	 */
	private double denaroDaTrasferire;
	
	/**
	 * conto bancario del beneficiario
	 */
	private ContoBancario contoBancarioBeneficiario;
	
	/**
	 * costruttore che imposta il conto bancario, il denaro da trasferire ed il conto bancario del beneficiario
	 * @param contoBancario il conto bancario
	 * @param denaroDaTrasferire il denaro da trasferire
	 * @param contoBancarioBeneficiario il conto bancario del beneficiario
	 */
	public Bonifico(ContoBancario contoBancario, double denaroDaTrasferire, ContoBancario contoBancarioBeneficiario)
	{
		super(contoBancario);
		this.denaroDaTrasferire = denaroDaTrasferire;
		this.contoBancarioBeneficiario = contoBancarioBeneficiario;
	}
	
	/**
	 * metodo che esegue l'operazione
	 */
	@Override
	public void esegui()
	{
		if (denaroDaTrasferire > contoBancario.getDenaro()) return;
		PrelevaDenaro p1 = new PrelevaDenaro(contoBancario, denaroDaTrasferire);
		VersaDenaro p2 = new VersaDenaro(contoBancarioBeneficiario, denaroDaTrasferire);
		p1.esegui();
		p2.esegui();
	}
	
	/**
	 * metodo che restituisce una rappresentazione sotto forma di stringa dell'operazione
	 * @return String una rappresentazione sotto forma di stringa dell'operazione
	 */
	@Override
	public String toString()
	{
		return "Bonifico dal conto " + contoBancario.getIban() + " al conto " + contoBancarioBeneficiario.getIban();
	}
	
}

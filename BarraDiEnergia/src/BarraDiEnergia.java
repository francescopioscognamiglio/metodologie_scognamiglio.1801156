
/**
 * Esercizio: BarraDiEnergia & BarraDiEnergiaConPercentuale
 * 
 * Creare una classe BarraDiEnergia costruita con un intero che ne determina la lunghezza massima.
 * Inizialmente la barra è vuota. La barra è dotata di un metodo per l’incremento unitario del suo livello di riempimento
 * e di un metodo toString che ne fornisca la rappresentazione sotto forma di stringa
 * (es. se il livello è 3 su 10, la stringa sarà “OOO=======”.
 * 
 * @author francescopioscognamiglio
 *
 */
public class BarraDiEnergia
{
	
	/**
	 * lunghezza massima della barra di energia
	 */
	private int lunghezza;
	
	/**
	 * energia attuale della barra di energia
	 */
	private int energia;
	
	/**
	 * costruttore che permette di definire la lunghezza della barra di energia
	 * @param lunghezza la lunghezza della barra di energia
	 */
	public BarraDiEnergia(int lunghezza)
	{
		this.lunghezza = lunghezza;
	}
	
	/**
	 * metodo getter che restituisce il valore dell'energia della barra di energia
	 * @return il valore dell'energia della barra di energia
	 */
	public double getEnergia()
	{
		return energia;
	}
	
	/**
	 * metodo getter che restituisce la lunghezza della barra di energia
	 * @return la lunghezza della barra di energia
	 */
	public int getLunghezza()
	{
		return lunghezza;
	}
	
	/**
	 * metodo che fornisce la rappresentazione sotto forma di stringa della barra di energia
	 * (es. se il livello è 3 su 10, la stringa sarà “OOO=======”)
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < energia; i++) sb.append("O");
		for (int i = energia; i < lunghezza; i++) sb.append("=");
		return sb.toString();
	}
	
	/**
	 * metodo per l’incremento unitario del livello di riempimento della barra di energia
	 */
	public void incrementoUnitario()
	{
		energia++;
	}
	
	public static void main(String[] args)
	{
		BarraDiEnergia b1 = new BarraDiEnergia(30);
		
		b1.incrementoUnitario();
		b1.incrementoUnitario();
		b1.incrementoUnitario();
		
		System.out.println(b1.toString());
	}
	
}

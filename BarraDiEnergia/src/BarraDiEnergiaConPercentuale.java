
/**
 * Esercizio: BarraDiEnergia & BarraDiEnergiaConPercentuale
 * 
 * Creare quindi una seconda classe BarraDiEnergiaConPercentuale
 * che fornisce una rappresentazione sotto forma di stringa come BarraDiEnergia
 * ma stampando in coda alla stringa la percentuale del livello di riempimento.
 * Per esempio, se il livello è 3 su 10, la stringa sarà “OOO======= 30%”
 * 
 * @author francescopioscognamiglio
 *
 */
public class BarraDiEnergiaConPercentuale extends BarraDiEnergia
{
	
	/**
	 * costruttore che permette di definire la lunghezza della barra di energia
	 * @param lunghezza la lunghezza della barra di energia
	 */
	public BarraDiEnergiaConPercentuale(int lunghezza)
	{
		super(lunghezza);
	}
	
	/**
	 * metodo che fornisce una rappresentazione sotto forma di stringa come BarraDiEnergia
	 * ma stampando in coda alla stringa la percentuale del livello di riempimento.
	 * Per esempio, se il livello è 3 su 10, la stringa sarà “OOO======= 30%”
	 */
	@Override
	public String toString()
	{
		return super.toString() + " " + (int)(getEnergia()*100/getLunghezza()) + "%";
	}
	
	public static void main(String[] args)
	{
		BarraDiEnergiaConPercentuale b1 = new BarraDiEnergiaConPercentuale(10);
		
		b1.incrementoUnitario();
		b1.incrementoUnitario();
		b1.incrementoUnitario();
		
		System.out.println(b1.toString());
	}
	
}

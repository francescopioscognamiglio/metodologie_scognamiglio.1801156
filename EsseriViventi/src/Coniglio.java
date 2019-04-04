import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Coniglio:
 * rappresenta un coniglio, che si riproduce in al più 10 esemplari
 * 
 * @author francescopioscognamiglio
 *
 */
public class Coniglio extends EssereVivente
{
	
	/**
	 * costruttore che imposta il sesso e il nome del coniglio
	 * @param sesso il sesso del coniglio
	 * @param nome il nome del coniglio
	 */
	public Coniglio(Sesso sesso, String nome)
	{
		super(sesso, nome);
	}
	
	/**
	 * metodo che fa riprodurre il coniglio
	 * @param e un altro coniglio
	 * @return una lista contenente i conigli creati
	 * @throws Exception se il coniglio e l'altro coniglio sono dello stesso sesso
	 */
	@Override
	public List<EssereVivente> siRiproduceCon(EssereVivente e) throws Exception
	{
		if (isVivo())
		{
			List<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
			
			if (!getSesso().equals(e.getSesso()))
			{
				Random random = new Random();
				int numeroEsemplari = random.nextInt(10) + 1;
				for (int i = 0; i < numeroEsemplari; i++)
					esemplariFigli.add(new Coniglio((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
				
				return esemplariFigli;
			}
			else throw new Exception("I due esseri viventi sono dello stesso sesso e non si possono riprodurre");
		}
		return null;
	}
	
}

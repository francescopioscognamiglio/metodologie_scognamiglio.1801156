import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Pesce:
 * rappresenta un pesce, che si riproduce tra 30 e 100 esemplari
 * 
 * @author francescopioscognamiglio
 *
 */
public class Pesce extends EssereVivente
{
	
	/**
	 * costruttore che imposta il sesso e il nome del pesce
	 * @param sesso il sesso del pesce
	 * @param nome il nome del pesce
	 */
	public Pesce(Sesso sesso, String nome)
	{
		super(sesso, nome);
	}
	
	/**
	 * metodo che fa riprodurre il pesce
	 * @param e un altro pesce
	 * @return una lista contenente i pesci creati
	 * @throws Exception se il pesce e l'altro pesce sono dello stesso sesso
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
				int numeroEsemplari = random.nextInt(71) + 30;
				for (int i = 0; i < numeroEsemplari; i++)
					esemplariFigli.add(new Pesce((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
				
				return esemplariFigli;
			}
			else throw new Exception("I due esseri viventi sono dello stesso sesso e non si possono riprodurre");
		}
		return null;
	}
	
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare EssereUmano:
 * rappresenta un essere umano: si riproduce in un numero di 1 o 2 esemplari
 * 
 * @author francescopioscognamiglio
 *
 */
public class EssereUmano extends EssereVivente
{
	
	/**
	 * costruttore che imposta il sesso e il nome dell'essere umano
	 * @param sesso il sesso dell'essere umano
	 * @param nome il nome dell'essere umano
	 */
	public EssereUmano(Sesso sesso, String nome)
	{
		super(sesso, nome);
	}
	
	/**
	 * metodo che fa riprodurre l'essere umano
	 * @param e un altro essere umano
	 * @return una lista contenente gli esseri umani creati
	 * @throws Exception se l'essere umano e l'altro essere umano sono dello stesso sesso
	 */
	@Override
	public List<EssereVivente> siRiproduceCon(EssereVivente e) throws Exception
	{
		if (isVivo())
		{
			List<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
			
			if (getSesso().equals(e.getSesso()))
			{
				Random random = new Random();
				int numeroEsemplari = random.nextInt(1) + 1;
				for (int i = 0; i < numeroEsemplari; i++)
					esemplariFigli.add(new EssereUmano((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
				
				return esemplariFigli;
			}
			else throw new Exception("I due esseri viventi sono dello stesso sesso e non si possono riprodurre");
		}
		return null;
	}
	
}

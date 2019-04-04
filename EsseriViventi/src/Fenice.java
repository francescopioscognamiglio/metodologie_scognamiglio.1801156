import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Fenice:
 * rappresenta l’uccello mitologico che resuscita dalle ceneri dopo la morte;
 * si preveda quindi un metodo risorgi() che ha l’effetto di far rinascere la fenice
 * 
 * @author francescopioscognamiglio
 *
 */
public class Fenice extends EssereVivente
{
	
	/**
	 * costruttore che imposta il sesso e il nome della fenice
	 * @param sesso il sesso della fenice
	 * @param nome il nome della fenice
	 */
	public Fenice(Sesso sesso, String nome)
	{
		super(sesso, nome);
	}
	
	/**
	 * metodo che fa riprodurre la fenice
	 * @param e un'altra fenice
	 * @return una lista contenente le fenici create
	 * @throws Exception se la fenice e l'altra fenice sono dello stesso sesso
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
				int numeroEsemplari = random.nextInt(1);
				for (int i = 0; i < numeroEsemplari; i++)
					esemplariFigli.add(new Fenice((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
				
				return esemplariFigli;
			}
			else throw new Exception("I due esseri viventi sono dello stesso sesso e non si possono riprodurre");
		}
		return null;
	}
	
	/**
	 * metodo che fa risorgere la fenice
	 */
	public void risorgi() { setIsVivo(true); }
	
	/**
	 * metodo che fa morire la fenice
	 */
	@Override
	public void muore()
	{
		super.muore();
		risorgi();
	}
	
	
}

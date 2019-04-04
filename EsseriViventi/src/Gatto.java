import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Gatto:
 * rappresenta un gatto, che si riproduce in al più 5 esemplari, e che possiede 7 vite
 * (ogni volta che muore, può accedere alla vita successiva)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Gatto extends EssereVivente
{
	
	/**
	 * il numero massimo di vite di un gatto
	 */
	private static final int NUMERO_MASSIMO_DI_VITE = 7;
	
	/**
	 * il numero di vite raggiunte dal gatto
	 */
	private int numeroVite;
	
	/**
	 * costruttore che imposta il sesso e il nome del gatto
	 * @param sesso il sesso del gatto
	 * @param nome il nome del gatto
	 */
	public Gatto(Sesso sesso, String nome)
	{
		super(sesso, nome);
		numeroVite = 1;
	}
	
	/**
	 * metodo che fa riprodurre il gatto
	 * @param e un altro gatto
	 * @return una lista contenente i gatti creati
	 * @throws Exception se il gatto e l'altro gatto sono dello stesso sesso
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
				int numeroEsemplari = random.nextInt(5);
				for (int i = 0; i < numeroEsemplari; i++)
					esemplariFigli.add(new EssereUmano((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
				
				return esemplariFigli;
			}
			else throw new Exception("I due esseri viventi sono dello stesso sesso e non si possono riprodurre");
		}
		return null;
	}
	
	/**
	 * metodo che fa morire il gatto
	 */
	@Override
	public void muore()
	{
		if (numeroVite <= NUMERO_MASSIMO_DI_VITE)
			numeroVite++;
		else
			super.muore();
	}
	
}

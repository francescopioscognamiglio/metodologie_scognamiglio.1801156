import java.util.List;

/**
 * Esercizio: Esseri viventi
 * 
 * Creare una classe di test e testare l'implementazione
 * 
 * @author francescopioscognamiglio
 *
 */
public class EssereViventeTest
{
	
	public static void main(String[] args) throws Exception
	{
		
		EssereVivente essereUmano1 = new EssereUmano(EssereVivente.Sesso.MASCHIO, "Francesco Pio");
		EssereVivente coniglio1 = new Coniglio(EssereVivente.Sesso.FEMMINA, "Alina");
		EssereVivente gatto1 = new Gatto(EssereVivente.Sesso.FEMMINA, "Nerina");
		PescePagliaccio pescePagliaccio1 = new PescePagliaccio(EssereVivente.Sesso.MASCHIO, "Nemo");
		EssereVivente fenice1 = new Fenice(EssereVivente.Sesso.MASCHIO, "RedFenix");
		
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		essereUmano1.cresce();
		System.out.println("L'essere umano é " + essereUmano1.getSesso() + " ed ha " + essereUmano1.getEta() + " anni");
		
		coniglio1.cresce();
		coniglio1.cresce();
		coniglio1.cresce();
		System.out.println("Il coniglio é " + coniglio1.getSesso() + " ed ha " + coniglio1.getEta() + " anni");
		List<EssereVivente> conigli = coniglio1.siRiproduceCon(new Coniglio(EssereVivente.Sesso.MASCHIO, "Raf"));
		if (conigli != null) System.out.println("Sono nati " + conigli.size() + " coniglietti");
		
		pescePagliaccio1.cresce();
		System.out.println("Il pesce pagliaccio é " + pescePagliaccio1.getSesso() + " ed ha " + pescePagliaccio1.getEta() + " anni");
		pescePagliaccio1.cambiaSesso();
		System.out.println("Il pesce pagliaccio é " + pescePagliaccio1.getSesso() + " ed ha " + pescePagliaccio1.getEta() + " anni");
		pescePagliaccio1.cresce();
		pescePagliaccio1.cresce();
		pescePagliaccio1.cresce();
		pescePagliaccio1.cresce();
		System.out.println("Il pesce pagliaccio é " + pescePagliaccio1.getSesso() + " ed ha " + pescePagliaccio1.getEta() + " anni");
		
		for (int i = 0; i < 10; i++)
		{
			fenice1.cresce();
			System.out.println("La fenice é " + fenice1.getSesso() + " ed ha " + fenice1.getEta() + " anni");
		}
		
	}
	
}

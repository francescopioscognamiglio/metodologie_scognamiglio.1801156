import java.util.ArrayList;

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
		//EssereVivente gatto1 = new Gatto(EssereVivente.Sesso.FEMMINA, "Nerina");
		PescePagliaccio pescePagliaccio1 = new PescePagliaccio(EssereVivente.Sesso.FEMMINA, "Nema");
		EssereVivente fenice1 = new Fenice(EssereVivente.Sesso.MASCHIO, "RedFenix");
		
		
		for (int i = 0; i < 4; i++)
		{
			ArrayList<EssereVivente> figli = new ArrayList<EssereVivente>();
			switch (i)
			{
			case 0:
				figli = new EssereUmano(EssereVivente.Sesso.FEMMINA, "Marta").siRiproduceCon(essereUmano1);
				break;
			case 1:
				figli = coniglio1.siRiproduceCon(new Coniglio(EssereVivente.Sesso.MASCHIO, "Cin"));
				break;
			case 2:
				figli = pescePagliaccio1.siRiproduceCon(new PescePagliaccio(EssereVivente.Sesso.MASCHIO, "Cari"));
				break;
			case 3:
				figli = new Fenice(EssereVivente.Sesso.FEMMINA, "Fen").siRiproduceCon(fenice1);
				break;
			}
			System.out.println("Sono nati " + figli.size() + " " + (figli.size() > 0 ? figli.get(0).getClass().getSimpleName() : "figli"));
		}
		
		try {
			pescePagliaccio1.cresce();
			pescePagliaccio1.cresce();
			pescePagliaccio1.cresce();
			System.out.println(pescePagliaccio1.getClass().getSimpleName() + " si chiama " + pescePagliaccio1.getNome() + " ed é " + pescePagliaccio1.getSesso());
		} catch (EssereMortoException em) {
			System.out.println(pescePagliaccio1.getClass().getSimpleName() + " é morto");
		}
	}
	
}

import java.util.Random;

/**
 * Esercizio: Disney vs. Marvel
 * 
 * • Modellare uno scontro su campo tra personaggi Disney e personaggi Marvel
 * 
 * • Squadra Disney = Paperinik, Ciccionik, Superpippo
 * 		– Paperinik, Ciccionik e Superpippo sono la versione supereroe dei corrispettivi personaggi (Paperino, Ciccio e Pippo)
 * 
 * • Squadra Marvel = Spiderman, La cosa, Magneto
 * 		– Notare che Spiderman è la versione supereroe di Peter Parker, noto fotografo del Daily Bugle;
 * 		  La cosa e Magneto invece sono supereroi 24h
 * 
 * I personaggi con una doppia vita devono esporre un’interfaccia DoppiaVita con i seguenti metodi:
 * 		– assumiIdentitaSegreta(): consente di trasformarsi in supereroe
 * 		– assumiIdentitaPubblica(): consente di assumere le sembianze ‘umane’
 * 
 * • Ogni supereroe implementa l’interfaccia Supereroe con:
 * 		– attacca(): sferra l’attacco specifico del supereroe
 * 
 * • Creare una partita su campo (ovvero una classe di test) in cui le due squadre si alternano in attacchi micidiali
 * 		– Il nemico viene scelto casualmente dalla lista dei supereroi avversari
 * 
 * @author francescopioscognamiglio
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		Paperino paperino = new Paperino();
		Supereroe paperinik = paperino.assumiIdentitaSegreta();
		Ciccio ciccio = new Ciccio();
		Supereroe ciccionik = ciccio.assumiIdentitaSegreta();
		Pippo pippo = new Pippo();
		Supereroe superpippo = pippo.assumiIdentitaSegreta();
		
		SquadraSupereroi squadraDisney = new SquadraSupereroi();
		squadraDisney.add(paperinik);
		squadraDisney.add(ciccionik);
		squadraDisney.add(superpippo);
		
		
		PeterParker peterParker = new PeterParker();
		Supereroe spiderman = peterParker.assumiIdentitaSegreta();
		Cosa cosa = new Cosa();
		Magneto magneto = new Magneto();
		
		SquadraSupereroi squadraMarvel = new SquadraSupereroi();
		squadraMarvel.add(spiderman);
		squadraMarvel.add(cosa);
		squadraMarvel.add(magneto);
		
		
		Random random = new Random();
		for (int i = 0; i < 10; i++)
		{
			Supereroe supereroeAttaccante;
			Supereroe supereroeRicevente;
			
			if (i % 2 == 0)
			{
				supereroeAttaccante = squadraDisney.get(random.nextInt(squadraDisney.size()));
				supereroeRicevente = squadraMarvel.get(random.nextInt(squadraMarvel.size()));
			}
			else
			{
				supereroeAttaccante = squadraMarvel.get(random.nextInt(squadraMarvel.size()));
				supereroeRicevente = squadraDisney.get(random.nextInt(squadraDisney.size()));
			}
			
			System.out.println(supereroeAttaccante.getClass().getSimpleName() + " sferra l'attacco \"" + supereroeAttaccante.attacca() + "\" contro " + supereroeRicevente.getClass().getSimpleName());
		}
	}
}

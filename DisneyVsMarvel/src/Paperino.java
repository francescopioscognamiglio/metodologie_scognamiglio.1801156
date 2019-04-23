
/**
 * Esercizio: Disney vs. Marvel
 * 
 * • Modellare uno scontro su campo tra personaggi Disney e personaggi Marvel
 * 
 * • Squadra Disney = Paperinik, Ciccionik, Superpippo
 * 		– Paperinik, Ciccionik e Superpippo sono la versione supereroe dei corrispettivi personaggi (Paperino, Ciccio e Pippo)
 * 
 * I personaggi con una doppia vita devono esporre un’interfaccia DoppiaVita con i seguenti metodi:
 * 		– assumiIdentitaSegreta(): consente di trasformarsi in supereroe
 * 		– assumiIdentitaPubblica(): consente di assumere le sembianze ‘umane’
 * 
 * • Ogni supereroe implementa l’interfaccia Supereroe con:
 * 		– attacca(): sferra l’attacco specifico del supereroe
 * 
 * @author francescopioscognamiglio
 *
 */
public class Paperino implements DoppiaVita
{
	@Override
	public Supereroe assumiIdentitaSegreta()
	{
		return new Paperinik();
	}
	
	@Override
	public Paperino assumiIdentitaPubblica()
	{
		return this;
	}
	
	private class Paperinik implements Supereroe
	{
		@Override
		public String attacca()
		{
			return "attacco potenziato";
		}
	}
}

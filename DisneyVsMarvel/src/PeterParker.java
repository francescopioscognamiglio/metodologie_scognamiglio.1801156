
/**
 * Esercizio: Disney vs. Marvel
 * 
 * • Modellare uno scontro su campo tra personaggi Disney e personaggi Marvel
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
 * @author francescopioscognamiglio
 *
 */
public class PeterParker implements DoppiaVita
{
	@Override
	public Supereroe assumiIdentitaSegreta()
	{
		return new Spiderman();
	}
	
	@Override
	public PeterParker assumiIdentitaPubblica()
	{
		return this;
	}
	
	private class Spiderman implements Supereroe
	{
		@Override
		public String attacca()
		{
			return "spara la ragnatela";
		}
	}
}

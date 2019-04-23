import java.util.Random;

/**
 * Esercizio: Disney vs. Marvel
 * 
 * • Modellare uno scontro su campo tra personaggi Disney e personaggi Marvel
 * 
 * • Squadra Marvel = Spiderman, La cosa, Magneto
 * 		– Notare che Spiderman è la versione supereroe di Peter Parker, noto fotografo del Daily Bugle;
 * 		  La cosa e Magneto invece sono supereroi 24h
 * 
 * • Ogni supereroe implementa l’interfaccia Supereroe con:
 * 		– attacca(): sferra l’attacco specifico del supereroe
 * 
 * @author francescopioscognamiglio
 *
 */
public class Magneto implements Supereroe
{
	private enum Attacco
	{
		LANCIA_OGGETTI() { public String toString() { return "lancia oggetti"; } },
		TIRA_MONETA() { public String toString() { return "tira moneta"; } };
	}
	
	@Override
	public String attacca()
	{
		return Attacco.values()[new Random().nextInt(2)].toString();
	}
}

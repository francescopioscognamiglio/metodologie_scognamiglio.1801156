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
public class Cosa implements Supereroe
{
	private enum Attacco
	{
		PUGNO_DURO() { public String toString() { return "pugno duro"; } },
		TESTATA() { public String toString() { return "testata"; } },
		TERREMOTO() { public String toString() { return "terremoto"; } };
	}
	
	@Override
	public String attacca()
	{
		return Attacco.values()[new Random().nextInt(3)].toString();
	}
}

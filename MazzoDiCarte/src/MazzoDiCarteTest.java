
/**
 * Esercizio: mescolare e distribuire un mazzo di carte da gioco
 * 
 *  Infine si progetti una classe di collaudo che crea un mazzo, mescoli le carte
 *  e ne distribuisca carte fino ad esaurimento del mazzo
 * 
 * @author francescopioscognamiglio
 *
 */
public class MazzoDiCarteTest
{
	
	public static void main(String[] args)
	{
		SemeCarta[] semeCartaValues = SemeCarta.values();
		ValoreCarta[] valoreCartaValues = ValoreCarta.values();
		Carta[] carte = new Carta[52];
		for (int i = 0, k = 0; i < semeCartaValues.length; i++)
			for (int j = 0; j < valoreCartaValues.length; j++)
				carte[k++] = new Carta(semeCartaValues[i].toString(), valoreCartaValues[j].toString());
		
		MazzoDiCarte mazzoCarte = new MazzoDiCarte(carte);
		
		mazzoCarte.mescola();
		for (int i = 0; i < MazzoDiCarte.dimensione; i++)
		{
			Carta carta = mazzoCarte.getProssimaCarta();
			System.out.println("La carta uscita e': " + carta.toString());
		}
	}
	
}

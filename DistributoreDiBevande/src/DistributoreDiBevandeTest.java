
/**
 * Esercizio: Distributore di bevande
 * 
 * Progettare la classe DistributoreDiBevandeTest e testare l'implementazione
 * 
 * @author francescopioscognamiglio
 *
 */
public class DistributoreDiBevandeTest
{
	
	public static void main(String[] args)
	{
		final int n = 20;
		
		DistributoreDiBevande db = new DistributoreDiBevande(n);
		db.carica();
		
		db.inserisciImporto(Math.random()*50);
		for (int i = 0; i < n; i++)
		{
			
			System.out.println("Il saldo attuale é: " + db.getSaldo());
			Prodotto p = db.getProdotto(i);
			if (p == null) System.out.println("Prodotto non trovato o saldo inferiore.");
			else System.out.println("Il prodotto richiesto é: " + p.getClass().getName());
		}
		System.out.println("Il resto attuale é: " + db.getResto());
	}
	
}

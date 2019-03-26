
/**
 * Esercizio: Cornice
 * 
 * Scrivere un metodo che, dato un intero N in ingresso, stampi una cornice NxN
 * 
 * Ad esempio: dato l’intero 5 in ingresso il metodo stampa:
 * 		*****
 * 		*   *
 * 		*   *
 * 		*   *
 * 		*****
 * 
 * @author francescopioscognamiglio
 *
 */
public class Cornice
{
	
	public void stampaCornice(int N)
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (j == 0 || j == N-1 || i == 0 || i == N-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
}

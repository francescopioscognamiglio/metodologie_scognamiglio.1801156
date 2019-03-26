
/**
 * Esercizio: CorniceAvanzata
 * 
 * Scrivere un metodo che, dato un intero N e una stringa in ingresso,
 * stampi una cornice NxN all’interno della quale venga visualizzata la stringa (eventualmente suddivisa per righe)
 * 
 * Ad esempio: dato l’intero 6 e la stringa “Cornici in Java” in ingresso il metodo stampa:
 * 		******
 * 		*Corn*
 * 		*ici *
 * 		*in J*
 * 		*ava *
 * 		******
 * 
 * @author francescopioscognamiglio
 *
 */
public class CorniceAvanzata
{
	
	/**
	 * metodo che stampa a video una cornice NxN con al suo intero la parola s
	 * @param N la grandezza della cornice
	 * @param s la parola contenuta nella cornice
	 */
	public void stampaCorniceAvanzata(int N, String s)
	{
		for (int i = 0, k = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				if (j == 0 || j == N-1 || i == 0 || i == N-1)
					System.out.print("*");
				else if (k < s.length())
				{
					System.out.print(s.charAt(k));
					k++;
				}
				else
					System.out.print(" ");
			System.out.println();
		}
	}
	
}

import java.util.Random;
import java.util.Scanner;

/**
 * Esercizio: Gioco del Quindici
 * 
 * Progettare la classe GiocoDelQuindici che realizzi il gioco del quindici (http://it.wikipedia.org/wiki/Gioco_del_quindici)
 * 
 * Il costruttore deve inizializzare una tabellina 4x4 in cui sono posizionate casualmente 15 tessere quadrate (da 1 a 15)
 * 
 * Implementare un metodo privato mischia che posiziona le caselle casualmente nella tabella (usato anche dal costruttore)
 * 
 * Implementare un metodo scorri che prende in ingresso la posizione x e y della casella e la direzione in cui spostare la casella
 * 
 * Implementare un metodo vinto che restituisce un booleano corrispondente alla vincita del giocatore
 * (ovvero se si è riuscito a posizionare le caselle esattamente nell’ordine da 1 a 15, come riportato in alto a destra in figura)
 * 
 * @author francescopioscognamiglio
 *
 */
public class GiocoDelQuindici
{
	
	/**
	 * enum che definisce la direzione
	 * @author francescopioscognamiglio
	 *
	 */
	public enum Direzione
	{
		SINISTRA,
		DESTRA,
		ALTO,
		BASSO
	}
	
	/**
	 * matriche che rappresenta la tabella del gioco
	 */
	private int[][] tabella;
	/**
	 * dimensione statica della matrice
	 */
	private static final int DIMENSIONE = 4;
	
	/**
	 * costruttore che inizializza una tabellina 4x4 in cui sono posizionate casualmente 15 tessere quadrate (da 1 a 15)
	 */
	public GiocoDelQuindici()
	{
		tabella = new int[DIMENSIONE][DIMENSIONE];
		mischia();
	}
	
	/**
	 * metodo privato che posiziona le caselle casualmente nella tabella (usato anche dal costruttore)
	 */
	private void mischia()
	{
		Random random = new Random();
		for (int numero = 1; numero < DIMENSIONE*DIMENSIONE; numero++)
		{
			int x = 0;
			int y = 0;
			do
			{
				x = random.nextInt(DIMENSIONE);
				y = random.nextInt(DIMENSIONE);
			}while (tabella[y][x] != 0);
			tabella[y][x] = numero;
		}
	}
	
	/**
	 * Implementare un metodo scorri che prende in ingresso la posizione x e y della casella e la direzione in cui spostare la casella
	 * @param x la posizione x
	 * @param y la posizione y
	 * @param d la direzione
	 */
	public void scorri(int x, int y, Direzione d)
	{
		switch(d)
		{
		case DESTRA:
			if (isLibera(x+1, y)) sostituisci(x, y, x+1, y);
			break;
		case SINISTRA:
			if (isLibera(x-1, y)) sostituisci(x, y, x-1, y);
			break;
		case ALTO:
			if (isLibera(x, y-1)) sostituisci(x, y, x, y-1);
			break;
		case BASSO:
			if (isLibera(x, y+1)) sostituisci(x, y, x, y+1);
			break;
		}
	}
	
	/**
	 * metodo che restituisce true se la cella é libera; false altrimenti
	 * @param x la posizione x
	 * @param y la posizione y
	 * @return true se la cella é libera; false altrimenti
	 */
	private boolean isLibera(int x, int y)
	{
		return x >= 0 && x < DIMENSIONE && y >= 0 && y < DIMENSIONE && tabella[y][x] == 0;
	}
	
	/**
	 * metodo che sostituisce due celle
	 * @param x1 la posizione x della prima cella
	 * @param y1 la posizione y della prima cella
	 * @param x2 la posizione x della seconda cella
	 * @param y2 la posizione y della seconda cella
	 */
	private void sostituisci(int x1, int y1, int x2, int y2)
	{
		int ap = tabella[y1][x1];
		tabella[y1][x1] = tabella[y2][x2];
		tabella[y2][x2] = ap; 
	}
	
	/**
	 * metodo che restituisce un booleano corrispondente alla vincita del giocatore
	 * (ovvero se si è riuscito a posizionare le caselle esattamente nell’ordine da 1 a 15)
	 * @return un booleano corrispondente alla vincita del giocatore
	 */
	public boolean vinto()
	{
		if (tabella[DIMENSIONE-1][DIMENSIONE-1] != 0) return false;
		int ultimoElemento = 0;
		for (int i = 0; i < DIMENSIONE; i++)
			for (int j = 0; j < DIMENSIONE; j++)
			{
				if (i == 0 && j == 0)
				{
					ultimoElemento = tabella[i][j];
					continue;
				}
				if (tabella[i][j] != ultimoElemento+1 && tabella[i][j] != 0) return false;
				ultimoElemento = tabella[i][j];
			}
		return true;
	}
	
	/**
	 * metodo che restituisce la situazione del gioco
	 * @return una stringa che rappresenta la situazione del gioco
	 */
	public String toString()
	{
		String ris = "";
		for (int j = 0; j < DIMENSIONE; j++)
			ris += (j == 0 ? "-" : "") + "----";
		ris += "\n";
		for (int i = 0; i < DIMENSIONE; i++)
		{
			for (int j = 0; j < DIMENSIONE; j++)
				ris += (j == 0 ? "|" : "") + (tabella[i][j] < 10 ? " " : "") + " " + (tabella[i][j] != 0 ? tabella[i][j] : " ") + "|";
			ris += "\n";
			for (int j = 0; j < DIMENSIONE; j++)
				ris += (j == 0 ? "-" : "") + "----";
			ris += "\n";
		}
		return ris;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		GiocoDelQuindici giocoDelQuindici = new GiocoDelQuindici();
		System.out.println(giocoDelQuindici.toString());
		
		while(!giocoDelQuindici.vinto())
		{
			System.out.println("Inserire posizione x: ");
			int x = Integer.parseInt(input.nextLine());
			System.out.println("Inserire posizione y: ");
			int y = Integer.parseInt(input.nextLine());
			System.out.println("Inserire la direzione: ");
			Direzione d = Direzione.valueOf(input.nextLine().toUpperCase());
			giocoDelQuindici.scorri(x, y, d);
			System.out.println(giocoDelQuindici.toString());
		}
		System.out.println("Complimenti! Hai vinto");
	}
	
}

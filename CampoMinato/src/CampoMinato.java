import java.util.Random;
import java.util.Scanner;

/**
 * Esercizio: Campo Minato
 * 
 * Progettare la classe CampoMinato che realizzi il gioco del campo minato
 * (http://it.wikipedia.org/wiki/Campo_minato_(videogioco))
 * 
 * Il costruttore deve inizializzare il campo NxM
 * (dove N e M sono interi forniti in ingresso al costruttore insieme al numero m di mine)
 * piazzando casualmente le m mine nel campo
 * 
 * Implementare un metodo scopri() che, dati x e y in ingresso, scopre la casella e restituisce un intero pari a:
 * 	- -1 se la casella contiene una mina
 * 	- La quantità di caselle adiacenti contenenti mine (incluse quelle in diagonale)
 * 	- 0 se la caselle adiacenti non contengono mine. In quest’ultimo caso, vengono scoperte anche
 * 	  le caselle adiacenti finché non si incontra un numero > 0 (richiede la ricorsione!)
 * 
 * Implementare un metodo toString() che restituisce la situazione attuale del gioco
 * 
 * Implementare un metodo vinto() che restituisce lo stato del gioco: perso, vinto, in gioco
 * 
 * @author francescopioscognamiglio
 *
 */
public class CampoMinato
{
	
	/**
	 * matrice che rappresenta il campo da gioco
	 */
	private int[][] campo;
	/**
	 * matrice che rappresenta il campo da gioco da visualizzare
	 */
	private char[][] campoShow;
	/**
	 * numero totale di mine
	 */
	private int numeroMine;
	/**
	 * stato della partita
	 */
	private StatoPartita stato;
	
	/**
	 * matrice che contiene le coordinate uscite
	 */
	private int[][] coordinateUscite;
	
	/**
	 * costruttore che inizializza il campo NxM e piazza casualmente le m mine nel campo
	 * @param N intero fornito in input
	 * @param M intero fornito in input
	 * @param m il numero di mine
	 */
	public CampoMinato(final int N, final int M, int m)
	{
		campo = new int[N][M];
		campoShow = new char[N][M];
		numeroMine = m;
		coordinateUscite = new int[][] {};
		stato = StatoPartita.IN_GIOCO;
		inizializzaCampo();
		piazzaMine(m);
	}
	
	/**
	 * metodo che inizializza il campo da gioco
	 */
	private void inizializzaCampo()
	{
		for (int i = 0; i < campo.length; i++)
			for (int j = 0; j < campo[0].length; j++)
			{
				campo[i][j] = 0;
				campoShow[i][j] = '-';
			}
	}
	
	/**
	 * metodo che piazza casualmente le mine nel campo da gioco
	 * @param m il numero di mine
	 */
	private void piazzaMine(int m)
	{
		for (int i = 0; i < m; i++)
		{
			Random random = new Random();
			int y = random.nextInt(campo.length);
			int x = random.nextInt(campo[0].length);
			if (campo[y][x] == -1)
			{
				i--;
				continue;
			}
			campo[y][x] = -1;
			int[][] caselleAdiacenti = getCaselleAdiacenti(x, y);
			for (int[] casellaAdiacente : caselleAdiacenti)
				if (casellaAdiacente[0] >= 0 && casellaAdiacente[0] < campo[0].length && casellaAdiacente[1] >=0 && casellaAdiacente[1] < campo.length)
					if (campo[casellaAdiacente[1]][casellaAdiacente[0]] != -1) campo[casellaAdiacente[1]][casellaAdiacente[0]]++;
		}
	}
	
	/**
	 * metodo che scopre la casella in posizione (x, y) e restituisce un intero pari a:
	 * 	- -1 se la casella contiene una mina
	 * 	- la quantità di caselle adiacenti contenenti mine (incluse quelle in diagonale)
	 * 	- 0 se le caselle adiacenti non contengono mine.
	 * 	  In quest’ultimo caso, vengono scoperte anche le caselle adiacenti finché non si incontra un numero > 0
	 * @param x la coordinata x
	 * @param y la coordinata y
	 * @return un intero pari a: -1 se la casella contiene una mina; la quantità di caselle adiacenti contenenti mine (incluse quelle in diagonale);
	 * 	  0 se le caselle adiacenti non contengono mine. In quest’ultimo caso, vengono scoperte anche le caselle adiacenti finché non si incontra un numero > 0
	 */
	public int scopri(int x, int y)
	{
		if (campo[y][x] == -1)
		{
			campoShow[y][x] = 'm';
			stato = StatoPartita.PERSO;
			return -1;
		}
		if (campo[y][x] > 0)
		{
			campoShow[y][x] = (char)(campo[y][x] + '0');
			for (int j = 0; j < coordinateUscite.length; j++)
				if (coordinateUscite[j][0] == x && coordinateUscite[j][1] == y)
					return 0;
			addCoordinataUscita(x, y);
			
			int contaCaselle = 0;
			for (int i = 0; i < campoShow.length; i++)
				for (int j = 0; j < campoShow[0].length; j++)
					if (campoShow[i][j] == '-') contaCaselle++;
			if (contaCaselle == numeroMine)
			{
				stato = StatoPartita.VINTO;
				return 0;
			}
			
			return 1;
		}
		
		int cont = 0;
		int[][] caselleAdiacenti = getCaselleAdiacenti(x, y);
		nextcasella: for (int[] casellaAdiacente : caselleAdiacenti)
		{
			for (int j = 0; j < coordinateUscite.length; j++)
				if (coordinateUscite[j][0] == casellaAdiacente[0] && coordinateUscite[j][1] == casellaAdiacente[1])
					continue nextcasella;
			if (campo[casellaAdiacente[1]][casellaAdiacente[0]] == 0)
			{
				campoShow[casellaAdiacente[1]][casellaAdiacente[0]] = ' ';
				addCoordinataUscita(casellaAdiacente[0], casellaAdiacente[1]);
			}
			cont += scopri(casellaAdiacente[0], casellaAdiacente[1]);
		}
		return cont;
	}
	
	/**
	 * metodo che aggiunge le coordinate (x, y) alla matrice che contiene le coordinate uscite
	 * @param x la coordinata x
	 * @param y la coordinata y
	 */
	private void addCoordinataUscita(int x, int y)
	{
		int[][] coordinateUsciteCopia = new int[coordinateUscite.length+1][2];
		for (int i = 0; i < coordinateUscite.length; i++)
			coordinateUsciteCopia[i] = coordinateUscite[i];
		coordinateUsciteCopia[coordinateUscite.length][0] = x;
		coordinateUsciteCopia[coordinateUscite.length][1] = y;
		coordinateUscite = coordinateUsciteCopia;
	}
	
	/**
	 * metodo che restituisce una matrice contenente tutte le caselle adiacenti presenti nel campo da gioco
	 * @param x la coordinata x
	 * @param y la coordinata y
	 * @return una matrice contenente tutte le caselle adiacenti presenti nel campo da gioco
	 */
	public int[][] getCaselleAdiacenti(int x, int y)
	{
		int[][] caselle = new int[][] { { x, y+1 },
			{ x+1, y },
			{ x, y-1 },
			{ x-1, y },
			{ x+1, y-1 },
			{ x-1, y+1 },
			{ x+1, y+1 },
			{ x-1, y-1 }, };
		
		for (int i = 0; i < caselle.length && i >= 0; i++)
			if (caselle[i][0] < 0 || caselle[i][0] >= campo[0].length || caselle[i][1] < 0 || caselle[i][1] >= campo.length)
			{
				int[][] caselleCopia = new int[caselle.length-1][2];
				for (int j = 0; j < i; j++)
					caselleCopia[j] = caselle[j];
				for (int j = i+1; j < caselle.length; j++)
					caselleCopia[j-1] = caselle[j];
				caselle = caselleCopia;
				i--;
			}
		return caselle;
	}
	
	/**
	 * metodo che restituisce la situazione attuale del gioco
	 * @return la situazione attuale del gioco
	 */
	public String toString()
	{
		String risultato = "";
		for (int i = 0; i < campoShow.length; i++)
			risultato += (i == 0 ? "-" : "") + "---";
		risultato += "\n";
		for (int i = 0; i < campoShow.length; i++)
		{
			for (int j = 0; j < campoShow[0].length; j++)
				risultato += (j == 0 ? "|" : "") + (campoShow[i][j] != -1 ? " " : "") + campoShow[i][j] + "|";
			risultato += "\n";
			for (int j = 0; j < campoShow.length; j++)
				risultato += (j == 0 ? "-" : "") + "---";
			risultato += "\n";
		}
		return risultato;
	}
	
	/**
	 * metodo che restituisce lo stato del gioco: perso, vinto, in gioco
	 * @return lo stato del gioco: perso, vinto, in gioco
	 */
	public StatoPartita vinto()
	{
		return stato;
	}
	
	/**
	 * simulazione di una partita
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		CampoMinato campoMinato = new CampoMinato(5, 5, 2);
		System.out.println(campoMinato.toString());
		System.out.println("-----------------------------------");
		while(campoMinato.vinto().equals(StatoPartita.IN_GIOCO))
		{
			System.out.println("Inserire coordinate: ");
			System.out.print("\tInserire x: ");
			int x = Integer.parseInt(input.nextLine());
			System.out.print("\tInserire y: ");
			int y = Integer.parseInt(input.nextLine());
			System.out.println("caselle con bombe adiacenti: " + campoMinato.scopri(x, y));
			System.out.println("Lo stato della partita e': " + campoMinato.vinto());
			System.out.println(campoMinato.toString());
			System.out.println("-----------------------------------");
		}
		
	}
}

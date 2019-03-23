
/**
 * Esercizio: la classe Rettangolo
 * 
 * Progettare una classe Rettangolo i cui oggetti rappresentano un rettangolo
 * e sono costruiti a partire dalle coordinate x, y e dalla lunghezza e altezza del rettangolo
 * 
 * La classe implementa i seguenti metodi:
 * - trasla che, dati in input due valori x e y, trasla le coordinate del rettangolo
 * dei valori orizzontali e verticali corrispondenti
 * - toString che restituisce una stringa del tipo “(x1, y1)->(x2, y2)”
 * con i punti degli angoli in alto a sinistra e in basso a destra del rettangolo
 * 
 * @author francescopioscognamiglio
 *
 */
public class Rettangolo
{
	
	/**
	 * campo di tipo double che definisce la coordinata x del rettangolo
	 */
	private double x;
	/**
	 * campo di tipo double che definisce la coordinata y del rettangolo
	 */
	private double y;
	/**
	 * campo di tipo double che definisce la lunghezza del rettangolo
	 */
	private double lunghezza;
	/**
	 * campo di tipo double che definisce l'altezza del rettangolo
	 */
	private double altezza;
	
	/**
	 * campo di tipo Colore che definisce il colore del rettangolo
	 */
	private Colore colore;
	
	/**
	 * costruttore della classe che permette di definire i dati del rettangolo
	 * @param x la coordinata x del rettangolo
	 * @param y la coordinata y del rettangolo
	 * @param lunghezza la lunghezza del rettangolo
	 * @param altezza l'altezza del rettangolo
	 */
	public Rettangolo(double x, double y, double lunghezza, double altezza)
	{
		this.x = x;
		this.y = y;
		this.lunghezza = lunghezza;
		this.altezza = altezza;
		colore = new Colore();
	}
	
	/**
	 * costruttore della classe che permette di definire i dati del rettangolo
	 * @param x la coordinata x del rettangolo
	 * @param y la coordinata y del rettangolo
	 * @param lunghezza la lunghezza del rettangolo
	 */
	public Rettangolo(double x, double y, double lunghezza)
	{
		this(x, y, lunghezza, 0);
	}
	
	/**
	 * costruttore della classe che permette di definire i dati del rettangolo
	 * @param x la coordinata x del rettangolo
	 * @param y la coordinata y del rettangolo
	 */
	public Rettangolo(double x, double y)
	{
		this(x, y, 0, 0);
	}
	
	/**
	 * metodo che, dati in input due valori x e y, trasla le coordinate del rettangolo
	 * dei valori orizzontali e verticali corrispondenti
	 * @param x la coordinata x
	 * @param y la coordinata y
	 */
	public void trasla(double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	
	/**
	 * metodo che restituisce una stringa del tipo “(x1, y1)->(x2, y2)”
	 * con i punti degli angoli in alto a sinistra e in basso a destra del rettangolo
	 */
	public String toString()
	{
		return "(" + x + ", " + y +") -> (" + (x+lunghezza) + ", " + (y+altezza) + ")";
	}
	
	/**
	 * metodo setter che permette di impostare il colore passando i valori RGB
	 * @param r il colore rosso
	 * @param g il colore verde
	 * @param b il colore blu
	 */
	public void setColore(int r, int g, int b)
	{
		colore.setColore(r, g, b);
	}
	
	/**
	 * metodo che restituisce un array che rappresenta il colore del rettangolo
	 * @return un array che rappresenta il colore del rettangolo
	 */
	public int[] getColore()
	{
		return colore.getColore();
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta il colore del rettangolo
	 * @return una stringa che rappresenta il colore del rettangolo
	 */
	public String toStringColore()
	{
		return colore.toString();
	}
	
}

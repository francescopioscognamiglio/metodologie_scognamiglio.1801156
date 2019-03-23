
/**
 * Esercizio: la classe Rettangolo
 * 
 * Implementare una classe di test TestRettangolo che verifichi
 * il funzionamento della classe Rettangolo sul rettangolo in posizione (0, 0)
 * e di lunghezza 20 e altezza 10, traslandolo di 10 verso destra e 5 in basso
 * 
 * @author francescopioscognamiglio
 *
 */
public class RettangoloTest
{
	
	public static void main(String[] args)
	{
		
		Rettangolo rettangolo = new Rettangolo(0, 0, 20, 10);
		
		System.out.println("Punti iniziali del rettangolo: " + rettangolo.toString());
		System.out.println("Il colore iniziale del rettangolo e': " + rettangolo.toStringColore());
		
		rettangolo.trasla(10, -5);
		rettangolo.setColore(5, 5, 10);
		
		System.out.println("+------------------------------------------------------+");
		
		System.out.println("Punti finali del rettangolo: " + rettangolo.toString());
		System.out.println("Il colore finale del rettangolo e': " + rettangolo.toStringColore());
		
	}
	
}


/**
 * Esercizio: Animali
 * 
 * Progettare la classe Chihuahua (taglia piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Chihuahua extends Canide
{
	
	/**
	 * costruttore vuoto
	 */
	public Chihuahua()
	{
		super(Taglia.PICCOLA);
	}
	
	/**
	 * metodo che stampa a video l'azione annusa effettuata dal chihuahua
	 */
	@Override
	public void annusa()
	{
		System.out.println("Non riesco ad arrivare al terreno per annusare...");
	}
	
	/**
	 * metodo che stampa a video il verso del chihuahua
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("wuf... (Quasi impercettibile, ma fastidioso)");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del chihuahua
	 * @return il numero di zampe del chihuahua
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 4;
	}
	
}

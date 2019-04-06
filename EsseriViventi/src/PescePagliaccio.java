import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare PescePagliaccio:
 * 
 * rappresenta una specie di pesce che ha la capacità di cambiare sesso spontaneamente:
 * si preveda quindi un metodo cambiaSesso() che provoca il cambio di sesso dell’oggetto;
 * il sesso viene cambiato casualmente all’interno del metodo cresce()
 * 
 * @author francescopioscognamiglio
 *
 */
public class PescePagliaccio extends Pesce
{
	
	/**
	 * costruttore che imposta il sesso e il nome del pesce pagliaccio
	 * @param sesso il sesso del pesce pagliaccio
	 * @param nome il nome del pesce pagliaccio
	 */
	public PescePagliaccio(Sesso sesso, String nome)
	{
		super(sesso, nome);
	}
	
	/**
	 * metodo che imposta se deve cambiare il sesso del pesce pagliaccio
	 */
	public void cambiaSesso()
	{
		setSesso(getSesso().equals(Sesso.MASCHIO) ? Sesso.FEMMINA : Sesso.MASCHIO);
	}
	
	/**
	 * metodo che fa crescere il pesce pagliaccio
	 */
	@Override
	public void cresce() throws EssereMortoException
	{
		super.cresce();
		if (isVivo() && new Random().nextBoolean()) cambiaSesso();
	}
	
}

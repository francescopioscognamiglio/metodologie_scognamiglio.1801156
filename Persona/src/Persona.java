
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esercizi di riscaldamento
 * 
 * Progettare una classe Persona i cui oggetti rappresentano una persona
 * e ne memorizzano il nome e il cognome
 * - La classe espone un metodo main che crea un’istanza della Persona
 * - La classe espone anche un metodo stampa che visualizza nome e cognome della persona
 * 
 * @author francescopioscognamiglio
 *
 */
public class Persona
{
	
	/**
	 * stringa che contiene il nome
	 */
	private String nome;
	/**
	 * stringa che contiene il cognome
	 */
	private String cognome;
	
	/**
	 * costruttore della classe che permette di definire i dati della persona
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 */
	public Persona(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}
	
	/**
	 * metodo che permette di definire il nome della persona
	 * @param nome il nome della persona
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * metodo che restituisce il nome della persona
	 * @return il nome della persona
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * metodo che permette di definire il cognome della persona
	 * @param cognome il cognome della persona
	 */
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
	/**
	 * metodo che restituisce il cognome della persona
	 * @return il cognome della persona
	 */
	public String getCognome()
	{
		return cognome;
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta i dati della persona
	 * @return una stringa che rappresenta i dati della persona
	 */
	public String stampa()
	{
		return nome + ", " + cognome;
	}
	
	public static void main(String args[])
	{
		Persona persona = new Persona("Francesco Pio", "Scognamiglio");
		System.out.print("La persona inserita contiene i seguenti dati: " + persona.stampa());
	}
	
}

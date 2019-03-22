
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esercizi di riscaldamento
 * Progettare una classe Persona
 * i cui oggetti rappresentano una persona
 * e ne memorizzano il nome, il cognome,
 * il codice fiscale e la data di nascita
 * 
 * - La classe espone un metodo main che crea un’istanza della Persona
 * - La classe espone anche un metodo stampa che visualizza i dati della persona
 * 
 * La classe infine memorizza il numero di persone create e l'ultima persona creata
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
	 * stringa che contiene il codice fiscale
	 */
	private String codiceFiscale;
	/**
	 * data che contiene la data di nascita
	 */
	private Date dataDiNascita;
	
	/**
	 * intero che contiene il numero delle persone create
	 */
	private static int numeroPersoneCreate;
	/**
	 * Persona che contiene l'ultimo oggetto Persona creato
	 */
	private static Persona ultimaPersonaCreata;
	
	/**
	 * costruttore della classe che permette di definire i dati della persona
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 * @param codiceFiscale il codice fiscale della persona
	 * @param dataDiNascita la data di nascita della persona
	 */
	public Persona(String nome, String cognome, String codiceFiscale, Date dataDiNascita)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		numeroPersoneCreate++;
		ultimaPersonaCreata = this;
	}
	
	/**
	 * costruttore della classe che permette di definire i dati della persona
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 * @param codiceFiscale il codice fiscale della persona
	 */
	public Persona(String nome, String cognome, String codiceFiscale)
	{
		this(nome, cognome, codiceFiscale, null);
	}
	
	/**
	 * costruttore della classe che permette di definire i dati della persona
	 * @param nome il nome della persona
	 * @param cognome il cognome della persona
	 */
	public Persona(String nome, String cognome)
	{
		this(nome, cognome, null, null);
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
	 * metodo che permette di definire il codice fiscale della persona
	 * @param codiceFiscale il codice fiscale della persona
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}
	
	/**
	 * metodo che restituisce il codice fiscale della persona
	 * @return il codice fiscale della persona
	 */
	public String getCodiceFiscale()
	{
		return codiceFiscale;
	}
	
	/**
	 * metodo che permette di definire la data di nascita della persona
	 * @param dataDiNascita la data di nascita della persona
	 */
	public void setDataDiNascita(Date dataDiNascita)
	{
		this.dataDiNascita = dataDiNascita;
	}
	
	/**
	 * metodo che restituisce la data di nascita della persona
	 * @return la data di nascita della persona
	 */
	public Date getDataDiNascita()
	{
		return dataDiNascita;
	}
	
	/**
	 * metodo che restituisce una rappresentazione sottoforma di stringa dei dati della persona
	 * @return una rappresentazione sottoforma di stringa dei dati della persona
	 */
	public String stampa()
	{
		return nome + ", " + cognome + (codiceFiscale != null ? ", " + codiceFiscale : "") + (dataDiNascita != null ? ", " + dataDiNascita : "");
	}
	
	public static void main(String args[])
	{
		Persona persona = new Persona("Francesco Pio", "Scognamiglio");
		persona.setCodiceFiscale("XXXXXXX");
		
		SimpleDateFormat simpleDateFormat = null;
		try {
			simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = simpleDateFormat.parse("09-03-2019");
			persona.setDataDiNascita(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.print("La persona inserita contiene i seguenti dati: " + persona.stampa());
	}
	
}


/**
 * Esercizio: la LibreriaComponibile
 * 
 * Progettare una classe di test
 * 
 * @author francescopioscognamiglio
 *
 */
public class LibreriaComponibileTest
{
	
	public static void main(String[] args) throws LibroNotFoundException
	{
		LibreriaComponibile libreria = new LibreriaComponibile();
		
		Scaffale scaffale1 = new Scaffale(3);
		Scaffale scaffale2 = new Scaffale(3);
		Scaffale scaffale3 = new Scaffale(2);
		
		libreria.aggiungiScaffale(scaffale1);
		libreria.aggiungiScaffale(scaffale2);
		libreria.aggiungiScaffale(scaffale3);
		
		Libro libro1 = new Libro("Se questo é un uomo", "Primo Levi", true);
		Libro libro2 = new Libro("Uno, nessuno e centomila", "Luigi Pirandello", false);
		Libro libro3 = new LibroUsato("Harry Potter", "J. K. Rowling");
		Libro libro4 = new LibroUsato("Decameron", "Giovanni Boccaccio");
		Libro libro5 = new Libro("La coscienza di Zeno", "Italo Svevo", false);
		Libro libro6 = new LibroUsato("Canti", "Giacomo Leopardi");
		Libro libro7 = new LibroUsato("I Malavoglia", "Giovanni Verga");
		Libro libro8 = new LibroUsato("Ultime lettere di Jacopo Ortis", "Ugo Foscolo");
		Libro libro9 = new LibroUsato("Il fu Mattia Pascal", "Luigi Pirandello");
		
		scaffale1.aggiungiLibro(libro1);
		scaffale1.aggiungiLibro(libro2);
		scaffale1.aggiungiLibro(libro3);
		scaffale1.eliminaLibro("Harry Potter");
		
		scaffale2.aggiungiLibro(libro4);
		scaffale2.aggiungiLibro(libro5);
		
		scaffale3.aggiungiLibro(libro6);
		scaffale3.aggiungiLibro(libro7);
		scaffale3.aggiungiLibro(libro8);
		scaffale3.aggiungiLibro(libro9);
		
		System.out.println("La libreria contiene " + libreria.numeroScaffali() + " scaffali");
		System.out.println("Il primo scaffale contiene " + scaffale1.numeroLibri() + " libri e ci sono " + scaffale1.cercareLibriNonLetti().size() + " libri non letti");
		System.out.println("Il secondo scaffale contiene " + scaffale2.numeroLibri() + " libri e ci sono " + scaffale2.cercareLibriNonLetti().size() + " libri non letti");
		System.out.println("Il terzo scaffale contiene " + scaffale3.numeroLibri() + " libri e ci sono " + scaffale3.cercareLibriNonLetti().size() + " libri non letti");
		
		String titolo1 = "Uno, nessuno e centomila";
		try {
			scaffale1.cercareLibro(titolo1);
			System.out.println("Il primo scaffale contiene il libro intitolato \"" + titolo1 + "\"");
		} catch (LibroNotFoundException e) {
			System.out.println("Il primo scaffale non contiene il libro intitolato \"" + titolo1 + "\"");
		}
		
		String titolo2 = "Orgoglio umano";
		try {
			scaffale3.cercareLibro(titolo2);
			System.out.println("Il terzo scaffale contiene il libro intitolato \"" + titolo2 + "\"");
		} catch (LibroNotFoundException e) {
			System.out.println("Il terzo scaffale non contiene il libro intitolato \"" + titolo2 + "\"");
		}
	}
	
}

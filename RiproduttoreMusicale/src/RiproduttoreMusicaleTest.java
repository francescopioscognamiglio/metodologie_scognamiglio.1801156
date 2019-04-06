
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare una classe di test
 * 
 * @author francescopioscognamiglio
 *
 */
public class RiproduttoreMusicaleTest
{
	public static void main(String[] args) throws SupportoNonSupportatoException
	{
		Brano brano1 = new Brano("Questa nostra stupida canzone d'amore", "The giornalisti");
		Brano brano2 = new Brano("It's my life", "Bon Jovi");
		Brano brano3 = new Brano("Napule é", "Pino Daniele");
		Brano brano4 = new Brano("Con te partirò", "Bocelli");
		Brano brano5 = new Brano("Questo piccolo grande amore", "Claudio Baglioni");
		Brano brano6 = new Brano("Se telefonando", "Mina");
		
		DiscoA33Giri discoA33Giri = new DiscoA33Giri(brano1, brano2);
		DiscoA45Giri discoA45Giri = new DiscoA45Giri(brano1, brano2, brano3, brano4);
		DiscoCompatto discoCompatto = new DiscoCompatto(brano1, brano2, brano3, brano4);
		Nastro nastro = new Nastro(100, brano1, brano2);
		MemoriaUSB memoriaUSB = new MemoriaUSB(brano1, brano2, brano3, brano4, brano5, brano6);
		
		Giradischi giradischi = new Giradischi();
		Mangianastri mangianastri = new Mangianastri();
		LettoreCD lettoreCD = new LettoreCD();
		LettoreMP3 lettoreMP3 = new LettoreMP3();
		
		giradischi.inserisciSupporto(discoA33Giri);
		giradischi.play();
		giradischi.stop();
		giradischi.next();
		giradischi.play();
		giradischi.espelliSupporto();
		giradischi.inserisciSupporto(discoA45Giri);
		giradischi.next();
		giradischi.next();
		giradischi.play();
		System.out.println("Il brano in esecuzione da " + giradischi.getClass().getSimpleName() + " é: " + giradischi.toString());
		
		mangianastri.inserisciSupporto(nastro);
		mangianastri.stop();
		mangianastri.next();
		System.out.println("Il brano in esecuzione da " + mangianastri.getClass().getSimpleName() + " é: " + mangianastri.toString());
		
		lettoreCD.inserisciSupporto(discoCompatto);
		lettoreCD.next();
		lettoreCD.next();
		lettoreCD.play();
		System.out.println("Il brano in esecuzione da " + lettoreCD.getClass().getSimpleName() + " é: " + lettoreCD.toString());
		
		lettoreMP3.inserisciSupporto(memoriaUSB);
		lettoreMP3.next();
		lettoreMP3.next();
		lettoreMP3.next();
		lettoreMP3.play();
		lettoreMP3.next();
		System.out.println("Il brano in esecuzione da " + lettoreMP3.getClass().getSimpleName() + " é: " + lettoreMP3.toString());
		
		lettoreMP3.espelliSupporto();
		lettoreMP3.inserisciSupporto(discoCompatto);
	}
}

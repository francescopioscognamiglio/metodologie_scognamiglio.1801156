
/**
 * Esercizio: Animali
 * 
 * Progettare la classe RegnoAnimaleTest per effettuate dei test
 * 
 * @author francescopioscognamiglio
 *
 */
public class RegnoAnimaleTest
{
	
	public static void main(String[] args)
	{
		Beagle beagle1 = new Beagle();
		Beagle beagle2 = new Beagle();
		Chihuahua chihuahua1 = new Chihuahua();
		Terranova terranova1 = new Terranova();
		Corvo corvo1 = new Corvo();
		Passero passero1 = new Passero();
		Gatto gatto1 = new Gatto();
		Tigre tigre1 = new Tigre();
		Millepiedi millepiedi1 = new Millepiedi();
		
		System.out.print("Il primo beagle dice: "); beagle1.allatta();
		System.out.print("Il primo beagle dice: "); beagle1.annusa();
		System.out.print("Il secondo beagle dice: "); beagle2.riproduci(30);
		System.out.println("Il secondo beagle ha " + beagle2.getNumeroFigli() + " cuccioli.");
		System.out.print("Il chihuahua dice: "); chihuahua1.annusa();
		System.out.print("Il terranova dice: "); terranova1.emettiVerso();
		
		System.out.println("--------------------------------");
		System.out.println("Il primo gatto ha " + gatto1.getNumeroDiZampe() + " zampe.");
		System.out.print("La prima tigre dice: "); tigre1.emettiVerso();
		
		System.out.println("--------------------------------");
		System.out.print("Il primo corvo dice: "); corvo1.emettiVerso();
		corvo1.generaUova(3);
		System.out.println("Il primo corvo ha " + corvo1.getNumeroPulcini() + " pulcini.");
		System.out.print("Il primo passero dice: "); passero1.emettiVerso();
		
		System.out.println("--------------------------------");
		millepiedi1.generaUova(20);
		System.out.println("Il millepiedi ha " + millepiedi1.getNumeroDiZampe() + " zampe.");
		System.out.println("Il millepiedi ha " + millepiedi1.getNumeroInsetti() + " insettini.");
		
		
	}
	
}

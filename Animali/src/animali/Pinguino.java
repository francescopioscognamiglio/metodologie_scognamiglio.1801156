package animali;

/**
 * Esercizio: Animali
 * 
 * Progettare una gerarchia di classi dei seguenti animali, ciascuno con determinate caratteristiche:
 * – Uccello (vola, becca)
 * 		• Pinguino (becca, nuota)
 * 		• Aquila (vola, becca)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Pinguino extends Uccello implements Nuotare
{
	@Override
	public void becca()
	{
		System.out.println("Il pinguino sta beccando...");
	}
	
	@Override
	public void nuota()
	{
		System.out.println("Il pinguino sta nuotando...");
	}
}

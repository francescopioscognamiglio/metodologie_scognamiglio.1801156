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
public class Aquila extends Uccello implements Volare
{
	@Override
	public void vola()
	{
		System.out.println("L'aquila sta volando...");
	}
	
	@Override
	public void becca()
	{
		System.out.println("L'aquila sta beccando...");
	}
}

package animali;

/**
 * Esercizio: Animali
 * 
 * Progettare una gerarchia di classi dei seguenti animali, ciascuno con determinate caratteristiche:
 * – Felino (salta, corre, fa le fusa)
 * 		• Gatto (salta, corre, fa le fusa, domestico)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Gatto extends Felino implements Domestico
{
	@Override
	public void salta()
	{
		System.out.println("Il gatto sta saltando...");
	}
	
	@Override
	public void corre()
	{
		System.out.println("Il gatto sta correndo...");
	}
	
	@Override
	public void faFusa()
	{
		System.out.println("Il gatto sta facendo le fusa...");
	}
	
	@Override
	public void domestico()
	{
		System.out.println("Il gatto é un animale domestico...");
	}
}

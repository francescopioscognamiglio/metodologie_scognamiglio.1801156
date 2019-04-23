package animali;

/**
 * Esercizio: Animali
 * 
 * Progettare una gerarchia di classi dei seguenti animali, ciascuno con determinate caratteristiche:
 * – Pesce (nuota)
 * 		• Pesce volante (nuota, vola)
 * 
 * @author francescopioscognamiglio
 *
 */
public class PesceVolante extends Pesce implements Volare
{
	@Override
	public void nuota()
	{
		System.out.println("Il pesce volante sta nuotando...");
	}
	
	@Override
	public void vola()
	{
		System.out.println("Il pesce volante sta volando...");
	}
}

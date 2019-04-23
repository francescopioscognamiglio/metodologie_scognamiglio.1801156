package animali;

/**
 * Esercizio: Animali
 * 
 * Progettare una gerarchia di classi dei seguenti animali, ciascuno con determinate caratteristiche:
 * – Uomo (salta, corre, pensa, nuota, vola?)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Uomo implements Saltare, Correre, Pensare, Nuotare, Volare
{
	@Override
	public void salta()
	{
		System.out.println("L'uomo sta saltando...");
	}
	
	@Override
	public void corre()
	{
		System.out.println("L'uomo sta correndo...");
	}
	
	@Override
	public void pensa()
	{
		System.out.println("L'uomo sta pensando...");
	}
	
	@Override
	public void nuota()
	{
		System.out.println("L'uomo sta nuotando...");
	}
	
	@Override
	public void vola()
	{
		System.out.println("L'uomo sta volando...");
	}
}

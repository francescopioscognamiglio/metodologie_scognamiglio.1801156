package animali;

/**
 * Esercizio: Animali
 * 
 * Progettare una gerarchia di classi dei seguenti animali, ciascuno con determinate caratteristiche:
 * – Cane (salta, corre, fedele a, domestico)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Cane implements Saltare, Correre, Domestico
{
	private String nomePadrone;
	
	@Override
	public void salta()
	{
		System.out.println("Il cane sta saltando...");
	}
	
	@Override
	public void corre()
	{
		System.out.println("Il cane sta correndo...");
	}
	
	@Override
	public void domestico()
	{
		System.out.println("Il cane é un animale domestico...");
	}
	
	public void setFedeleA(String nomePadrone)
	{
		this.nomePadrone = nomePadrone;
	}
	
	public String getFedeleA()
	{
		return nomePadrone;
	}
}

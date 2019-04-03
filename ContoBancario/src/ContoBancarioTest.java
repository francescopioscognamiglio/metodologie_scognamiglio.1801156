
public class ContoBancarioTest
{
	
	public static void main(String[] args) throws Exception
	{
		ContoBancario contoBancario = new ContoBancario("10112XADQ12", 200.0);
		
		contoBancario.eseguiOperazione(new PrelevaDenaro(contoBancario, 100.0));
		contoBancario.eseguiOperazione(new SvuotaConto(contoBancario));
		contoBancario.eseguiOperazione(new VersaDenaro(contoBancario, 200.0));
		contoBancario.eseguiOperazione(new SituazioneConto(contoBancario));
		contoBancario.eseguiOperazione(new Bonifico(contoBancario, 40.0, new ContoBancario("XXXX")));
		
		System.out.println(contoBancario.getStorico());
	}
	
}

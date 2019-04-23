
/**
 * Esercizio: Disney vs. Marvel
 * 
 * • Modellare uno scontro su campo tra personaggi Disney e personaggi Marvel
 * 
 * I personaggi con una doppia vita devono esporre un’interfaccia DoppiaVita con i seguenti metodi:
 * 		– assumiIdentitaSegreta(): consente di trasformarsi in supereroe
 * 		– assumiIdentitaPubblica(): consente di assumere le sembianze ‘umane’
 * 
 * @author francescopioscognamiglio
 *
 */
public interface DoppiaVita
{
	Supereroe assumiIdentitaSegreta();
	Object assumiIdentitaPubblica();
}

package it.uniroma1.fabbricasemantica.dao;

import java.util.List;

import it.uniroma1.fabbricasemantica.model.Data;

/**
 * DAO per la rappresentazione della tabella data
 * @author francescopioscognamiglio
 *
 */
public interface DataDao {

	/** Crea un dato e restituisce l'id assegnato */
	public int createData(Data data, Integer taskId);

	/** Recupera tutti i dati */
	public List<Data> getAllData();

	/** Recupera i dati del task a partire dall'id del task */
	public List<Data> getData(Integer taskId);

	/** Aggiorna un dato */
	public boolean updateData(Data data);

	/** Aggiorna un dato presente in un task a partire dall'id del task */
	public boolean updateData(Data data, Integer taskId);

	/** Cancella un dato */
	public boolean deleteData(Data data);

	/** Cancella un dato presente in un task a partire dall'id del task */
	public boolean deleteData(Data data, Integer taskId);
}

package it.uniroma1.fabbricasemantica.data;

/**
 * Interfaccia che rappresenta un Task
 * @author francescopioscognamiglio
 */
public interface Task {
	default String getTaskID() {
		return toString();
	}
}

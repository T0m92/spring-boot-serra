package it.agriBoot.utils;

import java.util.*;
//import java.util.function.Consumer;

import javax.persistence.*;
import javax.persistence.criteria.*;

/*  O = oggetto , K = chiave (per la ricerca)
 * La connesione ad un DB � rappresentata da un istanza dell'interfaccia EntityManager (em) la quale fornisce le funzionalit�
 * necessarie a compiere operazioni su di un DB.
 * EntityManagerFactory � probabilmente una implementazione di tale interfaccia secondo il pattern "factory"
 * tale pattern nella fatispecie ha il seguente scopo:
 * Offrire un modo efficiente di fornire istanze multiple di em per la connessione ad un database
 * */
public interface DataAccessObject<O, K> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgriSmartREST");
	// corporate-jpa � il nome associato a tale emf

	/*
	 * il metodo(?) default viene usato per permettere ad un interfaccia di avere
	 * non solo la dichiarazione ma anche l'implementazione di un metodo. Ci� non
	 * sarebbe possibile senza l'uso di tale metodo
	 * 
	 * A quale scopo viene fatto ci�? ---
	 * 
	 * 
	 * Il metodo execute crea una nuova transazione Questa viene acqusita a partire
	 * dall'em per tramite dell' interfaccia consumer tale interfaccia non ritorna
	 * alcunch� in conformit� con ci� che ci si aspetta dal commit di una
	 * trasazione. Tutt'al pi� si solleva un eccezione. Infatti il blocco di codice
	 * � racchiuso in un try-catch. Nel caso di transazione fallita infatti, esegue
	 * un rollback.
	 */

	// � un metodo statico, lo avranno tutte le classi che lo ereditano

	/*default void execute(Consumer<EntityManager> action) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			action.accept(em);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}*/
	 

	default void executeInsert(O obj) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // inizia una transazione
			em.persist(obj); // scrive l'operazione di INSERT all'interno della transazione
			em.getTransaction().commit();// esegue il commit con conseguente scrittura su DB
		} catch (Exception e) {
			em.getTransaction().rollback();// annulla la transazione in caso di errore
			throw e;
		}
	}

	default void executeUpdate(O obj) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(obj);// istruzione di UPDATE sull'oggetto passato come parametro
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	default void executeDelete(O obj) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(obj);// istruzione di DELETE dell'oggetto passato come paramtero
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	// canoniche dichiarazioni di metodi in conformit� con la sintassi stabilita per
	// un interfaccia
	EntityManager getEntityManager(); // fornire un entity manager

	O recupera(K id); // trovare una tupla tramite la PK

	List<O> recupera();// fornire un elenco di tutte le tuple, SELECT * in pratica (READ)

	List<O> recupera(CriteriaQuery<O> query);// fornire un elenco di tuple che corrispondono ad una data query (READ)

	void nuovo(O obj) throws Exception; // metodo per CREATE

	void salva(O obj) throws Exception; // metodo per UPDATE

	void elimina(O obj) throws Exception; // metodo per DELETE

	/*
	 * perch� creare "due tipi di metodi che fanno le stesse cose (?)" uno
	 * all'interno dell'interfaccia e altri verso l'esterno?
	 */
}

package it.agriBoot.utils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;


//la classe astratta AbstractDAO implementa l'interfaccia DataAccessObject con parametri O=oggetto K=chiave
public abstract class AbstractDAO<O, K>  implements DataAccessObject<O, K> {
	
	//istanzia un entity manager che verr� utilizzato internamente oltre che della classi che ereditano AbstractDAO
	protected EntityManager em;
	
	//questo metodo assegna all'em un istanza di emf (entity manager factory)
	public AbstractDAO() {
		em = emf.createEntityManager();
	}
	
	//il criteria builder viene utilizzato per la "costruzione di query" in JPA (JPA Criteria API)
	//necessario pe le operaz di READ
	public CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}
	
	/*override del metodo EntityManager di DataAccessObject.. 
	 *(era omissibile lasciando poi l'onere dell'implementazione di tali metodi alle classi che vanno ad ereditare AbstractDAO)
	 * restituisce l'istanza di em*/
	@Override
	public EntityManager getEntityManager() {
		return em;
	}	
	
	/* idem (override)
	 * l'operatore -> indica l'utilizzo di una LAMBDA FUNCTION
 	 * la cui sintassi �:
	 * (Lista degli argomenti) -> Espressione
	 *
	 *			oppure 
	 *
	 *	(Lista degli argomenti)->{ istruzioni; }  (� questo il caso in oggetto)
	 *
	 * Si tratta di un metodo senza una dichiarazione, una sorta di scorciatoia che consente di scrivere
	 * un metodo nello stesso posto dove ti serve.
	 * Le lambda expressions sono particolarmente utili nei casi in cui serve definire una breve funzione
	 * che ha poche linee di codice
	 * e che verr� utilizzata una sola volta:
 	 * In questi casi si risparmia la fatica di scrivere un metodo a parte con modificatore, nome, ecc..
	 * */
	
	/* "entityManager" ?? non viene dichiarato perch� 
	 * � un PARAMTERO DELLA FUNZIONE EXECUTE (e quindi il tipo � gi� noto)
	 * */
	//operazione di store (INSERT) di un nuovo oggetto, ovvero di una tupla nel DB
	@Override
	public void nuovo(O obj) throws Exception  {
		executeInsert(obj);
		/*
		 * Il comando di cui sopra, � cos� composto perch� executeInsert riceve come parametro
		 * ancora un TEMPLATE di tipo O obj, sar� poi compito delle classi di ciascun DAO es SerraDAO
		 * specificare il tipo dei parametri inseriti. Infatti vedere quale tipo di errore viene fuori
		 * se al comando originale:
		 * execute(entityManager -> entityManager.persist(obj)) (usato se nell'interfaccia lasciamo il metodo execute)
		 * sostituiamo beceramente executeInsert.. dir� che ci sono problemi con il tipo passato come paramtro
		 * */
	}
	
	//pure
	// UPDATE
	@Override
	public void salva(O obj) throws Exception  {
		executeUpdate(obj);
	}
	
	//lo stesso
	//DELETE
	@Override
	public void elimina(O obj) throws Exception  {
		executeDelete(obj);
	}
	
}

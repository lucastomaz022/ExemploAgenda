package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Contato;

public class ContatoDAO {
	
	private static ContatoDAO instancia;
	private EntityManager em;
	
	public ContatoDAO() {
		em = getEM();
	}
	
	private EntityManager getEM() {
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("ExemploAgenda");
		
		if(em == null){
			em = factory.createEntityManager();
		}
		
		return em;
		
	}
	
	public static ContatoDAO getInstancia() {
		if(instancia == null) {
			instancia = new ContatoDAO();
		}
		
		return instancia;
	}
	
	public boolean gravar(Contato c) {
		try{
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}











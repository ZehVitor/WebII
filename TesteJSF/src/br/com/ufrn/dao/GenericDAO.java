
package br.com.ufrn.dao;

import java.io.ObjectStreamClass;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.ufrn.dominio.ItemCardapio;


public class GenericDAO {
	@PersistenceContext(unitName="iOrderPU")
	protected EntityManager em;
	
	public void inserir (Object entidade){
		
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
	}
	
	public void alterar (Object entidade){
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
	}
	
	public void deletar (Object entidade){
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
	}
	
	public void inserirLog(Object log){
		try {
			em.getTransaction().begin();
			em.persist(log);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
	}
	
	public <T> Object findById (int id, Class<T> objClass) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		T obj = (T) Class.forName(objClass.getName()).newInstance();
		em.getTransaction().begin();
		Query q = em.createQuery("Select o from "+ objClass.getName() +" as o " + "where o.id = :param");
		q.setParameter("param", id);
		obj = (T) q.getSingleResult();
		
		return obj;
	}
	
	

	public void addNew(ItemCardapio item) {
		// TODO Auto-generated method stub
		
	}
}

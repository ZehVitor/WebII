package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.ItemCardapio;

public class ItemCardapioDAO extends GenericDAO {

	public List<ItemCardapio> findAll () throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		em.getTransaction().begin();
		Query q = em.createQuery("Select o from ItemCardapio as o");
		
		return q.getResultList();
	}
}

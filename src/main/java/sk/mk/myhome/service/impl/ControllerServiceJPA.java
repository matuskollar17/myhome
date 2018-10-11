package sk.mk.myhome.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sk.mk.myhome.entity.Boards;
import sk.mk.myhome.entity.Controller;

@Transactional
@Repository
public class ControllerServiceJPA implements ControllerService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see sk.mk.myhome.service.impl.ControllerService#addBoard(sk.mk.myhome.entity.Controller)
	 */
	@Override
	public void addBoard(Controller board) {
		entityManager.persist(board);
		
	}

	public void register(org.springframework.stereotype.Controller controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(Boards boards) {
		// TODO Auto-generated method stub
		entityManager.persist(boards);
		
	}
	
	public Boards label(String label, int numOfPins) {
		try {
			return (Boards) entityManager.createQuery(
					
					 /*"SELECT b FROM Boards b WHERE b.label =:label")
					.setParameter("label", label).getSingleResult();*/
					"SELECT b FROM Boards b").getSingleResult(); 
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Boards> getBoard() {
		return entityManager.createQuery("SELECT b FROM Boards b ").getResultList();
		
	}

/*	public Controller getState(int pin) {
		return (Controller) entityManager.createQuery("SELECT c.state FROM Controller c WHERE c.pin = :pin")
		.setParameter("pin", pin).getSingleResult();
	}*/
	
	public Controller getState() {
		return (Controller) entityManager.createQuery("SELECT c.state FROM Controller c where c.pin = :5")
		.getSingleResult();
	}

	

	
}

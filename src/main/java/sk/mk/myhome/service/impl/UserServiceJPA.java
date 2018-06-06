package sk.mk.myhome.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sk.mk.myhome.entity.ControllerUsers;



@Transactional
@Repository
public class UserServiceJPA implements UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see sk.mk.myhome.service.impl.UserService#register(sk.mk.myhome.entity.ControllerUsers)
	 */
	public void register(ControllerUsers user) {
		if (isValid(user.getPassword()))
			entityManager.persist(user);
	}
	
	
	private boolean isValid(String password) {
		return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,255})");
	}
	
	/* (non-Javadoc)
	 * @see sk.mk.myhome.service.impl.UserService#login(java.lang.String, java.lang.String)
	 */
	public ControllerUsers login(String login, String password) {
		try {
			return (ControllerUsers) entityManager.createQuery(
					//"SELECT cu FROM ControllerUsers cu WHERE cu.login =:login AND cu.password = crypt(:password, cu.password)")
					 "SELECT cu FROM ControllerUsers cu WHERE cu.login =:login AND cu.password =:password")
					.setParameter("login", login).setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<ControllerUsers> getControllerUsers() {
		return entityManager.createQuery("SELECT cu FROM ControllerUsers cu ").getResultList();
	}

}

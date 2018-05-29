package sk.mk.myhome.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sk.mk.myhome.entity.ControllerUsers;



@Transactional
@Repository
public class UserServiceJPA {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void register(ControllerUsers user) {
		if (isValid(user.getPassword()))
			entityManager.persist(user);
	}
	
	
	private boolean isValid(String password) {
		return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,255})");
	}
	
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

}

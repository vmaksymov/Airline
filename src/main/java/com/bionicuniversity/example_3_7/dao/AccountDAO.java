package com.bionicuniversity.example_3_7.dao;

import java.util.List;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionicuniversity.example_3_7.entity.*;

@Repository
public class AccountDAO extends GenericDaoImpl<Account> {
	
	public List<Account> getListAccount(){
		TypedQuery<Account> query = em.createQuery(
				"SELECT a FROM Account a WHERE a.del != true ORDER BY a.id, a.login", Account.class);
		return query.getResultList();
	}
	
	public List<Account> getRole(String login, String passwordHex){
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a "
				+ "WHERE (a.del != true AND a.login LIKE ?1 AND a.passwordHex LIKE ?2)", Account.class);
		query.setParameter(1, login);	
		query.setParameter(2, passwordHex);	
		return query.getResultList();
	}
}

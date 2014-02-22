package com.bionicuniversity.example_3_7.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import com.bionicuniversity.example_3_7.dao.AccountDAO;
import com.bionicuniversity.example_3_7.entity.Account;

@Named
@Scope("request")
public class AutorizationService {
	@Inject
    private AccountDAO accountDao;

	@Transactional
	public int getRole(String login, String passwordHex) {
		int result=-1;
		List<Account> listA=accountDao.getRole(login, passwordHex);
		if (listA != null && listA.size()>0){
			result=listA.get(0).getRole();
		}
		return result;
	    }
}

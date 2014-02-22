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
public class AccountService {
	@Inject
    private AccountDAO accountDAO;
	
	@Transactional
    public void createAccount(String login, String passwordHex, int role) {
        Account account = new Account();
        account.setLogin(login);
        account.setPasswordHex(passwordHex);
        account.setRole(role);
        account.setDel(false);
		accountDAO.create(account);
    }
	
	@Transactional
    public void updateAccount(int id, String login, String passwordHex, int role) {
		Account account=accountDAO.read(id);
		account.setLogin(login);
        account.setPasswordHex(passwordHex);
        account.setRole(role);
        accountDAO.update(account);
    }
	
	@Transactional
    public void deleteAccount(int id) {
		Account account=accountDAO.read(id);
		account.setDel(true);
		accountDAO.update(account);
    }

	@Transactional
    public List<Account> findAll() {
        return accountDAO.getListAccount();
    }

}

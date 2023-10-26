package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Email;

public interface IEmailDAO {

	void save(Email email);	
	void delete(Email email);
	
}

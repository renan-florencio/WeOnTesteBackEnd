package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Chat;

public interface IChatDAO {

	void save(Chat chat);	
	void delete(Chat chat);
	List<Chat> getAll();
	
}

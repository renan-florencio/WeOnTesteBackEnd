package br.com.weon.testeconhecimentobackend.dao;

import java.util.List;

import br.com.weon.testeconhecimentobackend.model.Voice;

public interface IVoiceDAO {

	void save(Voice voice);	
	void delete(Voice voice);
	List<Voice> getAll();
	
}

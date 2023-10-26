package br.com.weon.testeconhecimentobackend.dao;

import br.com.weon.testeconhecimentobackend.model.Voice;

public interface IVoiceDAO {

	void save(Voice voice);	
	void delete(Voice voice);
}

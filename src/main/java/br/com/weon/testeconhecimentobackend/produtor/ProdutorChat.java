package br.com.weon.testeconhecimentobackend.produtor;

import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.canal.Chat;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.dao.ChatDAOImpl;
import br.com.weon.testeconhecimentobackend.filadeobjetos.FilaDeObjetos;

/**
 * {@summary ProdutorChat}
 * Classe responsável por gerar objetos de Chat
 */
public class ProdutorChat implements IProdutor {
	
	private int numeroDoObjeto = 1;
	private ChatDAOImpl dao = new ChatDAOImpl();
	FilaDeObjetos fila = FilaDeObjetos.singleton();
	
	@Override
	public void produzir() {
		
		Chat chat = new Chat("username"+numeroDoObjeto,"username_"+numeroDoObjeto,LocalDateTime.now());
		dao.salvar(chat);
		fila.adicionar(chat);
		numeroDoObjeto ++;
	}

	@Override
	public void run() {
		
		Long timeout = System.currentTimeMillis() + Long.parseLong(Configuracao.obter().getProdutoresTimeout()) *1000;
		
		while (System.currentTimeMillis() < timeout) {
			produzir();
		}
	}

}

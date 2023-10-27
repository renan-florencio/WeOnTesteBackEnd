package br.com.weon.testeconhecimentobackend.produtor;

import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.canal.Email;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.dao.EmailDAOImpl;
import br.com.weon.testeconhecimentobackend.filadeobjetos.FilaDeObjetos;

/**
 * {@summary ProdutoEmail}
 * Classe responsável por gerar objetos de Email
 */
public class ProdutorEmail implements IProdutor {
	private int numeroDoObjeto = 1;
	private EmailDAOImpl dao = new EmailDAOImpl();
	FilaDeObjetos fila = FilaDeObjetos.singleton();
	
	@Override
	public void produzir() {
		
		Email email = new Email("email"+numeroDoObjeto+"@email.com",
				"email_"+numeroDoObjeto+"@email.com",LocalDateTime.now());
		fila.adicionar(email);
		dao.salvar(email);
		numeroDoObjeto++;

	}

	@Override
	public void run() {
		
		long timeout = System.currentTimeMillis() + Long.parseLong(Configuracao.obter().getProdutoresTimeout()) * 1000;
		
		while (System.currentTimeMillis() < timeout) {
			produzir();
		}
	}

}

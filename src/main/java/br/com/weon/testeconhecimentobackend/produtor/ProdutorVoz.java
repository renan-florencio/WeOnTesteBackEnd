package br.com.weon.testeconhecimentobackend.produtor;

import java.time.LocalDateTime;

import br.com.weon.testeconhecimentobackend.canal.Voz;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.dao.VozDAOImpl;
import br.com.weon.testeconhecimentobackend.filadeobjetos.FilaDeObjetos;

/**
 * {@summary ProdutorVoz}
 * Classe responsável por gerar objetos de Voz
 */
public class ProdutorVoz implements IProdutor {
	private int numeroDoObjeto = 1;
	private VozDAOImpl dao = new VozDAOImpl();
	FilaDeObjetos fila = FilaDeObjetos.singleton();
	
	@Override
	public void produzir() {
		Voz voz = new Voz("41 9 "+numeroDoObjeto,"11 9 "+numeroDoObjeto,LocalDateTime.now());
		dao.salvar(voz);
		fila.adicionar(voz);
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

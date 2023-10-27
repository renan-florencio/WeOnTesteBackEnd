package br.com.weon.testeconhecimentobackend;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import br.com.weon.testeconhecimentobackend.canal.Canal;
import br.com.weon.testeconhecimentobackend.configuracao.Configuracao;
import br.com.weon.testeconhecimentobackend.consumidor.IConsumidor;
import br.com.weon.testeconhecimentobackend.fabrica.FabricaConsumidor;
import br.com.weon.testeconhecimentobackend.fabrica.FabricaProdutor;
import br.com.weon.testeconhecimentobackend.filadeobjetos.FilaDeObjetos;
import br.com.weon.testeconhecimentobackend.persistencia.Persistencia;
import br.com.weon.testeconhecimentobackend.produtor.IProdutor;

/**
 * @author Renan Florencio de Oliveira
 * 
 * @version 2.0
 * 
 */
public class App {
	
	static URL path = App.class.getProtectionDomain().getCodeSource().getLocation();
	static String packagePath = App.class.getPackageName().toString();
	
	/**
	 * Método principal da classe
	 * @param args
	 */
	public static void main(String[] args) {
		
		String configPath = path.getPath()+
					packagePath.replace(".", "/")+
					"/config.yaml";
		try {
			Configuracao.configurar(configPath);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		Persistencia.criar();
		FilaDeObjetos.criar();
		
		List<? extends IProdutor> voz = FabricaProdutor.fabricarProdutor(Canal.VOZ, 
				Integer.parseInt(Configuracao.obter().getProdutoresVoz()));
		
		List<? extends IProdutor> email = FabricaProdutor.fabricarProdutor(Canal.EMAIL, 
				Integer.parseInt(Configuracao.obter().getProdutoresEmail()));
		
		List<? extends IProdutor> chat = FabricaProdutor.fabricarProdutor(Canal.CHAT, 
				Integer.parseInt(Configuracao.obter().getProdutoresChat()));
		
		List<? extends IConsumidor> consumidores = FabricaConsumidor.fabricarConsumidor(
				Integer.parseInt(Configuracao.obter().getConsumidores()));
		
		voz.forEach(x -> new Thread(x).start());
		email.forEach(x-> new Thread(x).start());
		chat.forEach(x -> new Thread(x).start());
		
		consumidores.forEach(x -> new Thread(x).start());
		
		Long timeout = System.currentTimeMillis() + Long.parseLong(Configuracao.obter().getProdutoresTimeout()) *1000;
		while(true) {
			if (FilaDeObjetos.singleton().tamanho() == 0 && FilaDeObjetos.singleton().totalDeObjetosConsumidos() > 0
					&& System.currentTimeMillis() > timeout) {
				System.out.println("------------------------------");
				System.out.println(FilaDeObjetos.singleton());
				break;
			}
		}
		
		Persistencia.fecharConexao();
	}
}

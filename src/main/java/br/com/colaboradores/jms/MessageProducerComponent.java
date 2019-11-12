package br.com.colaboradores.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerComponent implements ApplicationRunner {

	@Autowired 
	private JmsTemplate jmsTemplate;
	
    @Autowired 
    private JmsTemplate jmsTemplateTopic;
	
	public void incluirMensagemFila(String mensagem) {
		jmsTemplate.convertAndSend("queue.sample", mensagem);
	}
	
	public void incluirMensagemTopico(String mensagem) {
		jmsTemplateTopic.convertAndSend("topic.sample", mensagem);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.incluirMensagemFila("{usuario: 'Teste Fila', usando: 'fila'}");
		this.incluirMensagemTopico("{usuario: 'Teste Tópico', usando: 'tópico'}");
	}

}

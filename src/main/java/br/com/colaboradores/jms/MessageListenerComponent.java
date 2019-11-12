package br.com.colaboradores.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerComponent {

	@JmsListener(destination = "queue.sample")
    public void onReceiverQueue(String mensagem) {
    	System.out.println("Pegando da fila");
        System.out.println(mensagem);
    }

    @JmsListener(destination = "topic.sample", containerFactory = "jmsFactoryTopic")
    public void onReceiverTopic(String mensagem) {
    	System.out.println("Pegando do topico");
        System.out.println(mensagem);
    }
	
}

package ir.digixo.notification.rabbit;

import ir.digixo.notification.NoticationRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NotificationRabitProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    private final RabbitTemplate rabbitTemplate;

    public NotificationRabitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


//    public void sendMessage(String message){
//        log.info("Message sent -> {}", message);
//        rabbitTemplate.convertAndSend(exchange, routingKey, message);
//    }
    public void sendMessage(NoticationRequest message){
        log.info("Message sent client five -> {}", message.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}

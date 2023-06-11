package ir.digixo.notification.rabbit;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NotificationRabbitConsumerMQ {
//    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
//    public void consume(String message){
//
//        log.info("Received message in client5-> {}", message);
//    }
}

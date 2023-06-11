package ir.digixo.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RabbitMQConsumer {
    //this for test for the config of rabbitMQ
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){

        log.info("Received message notification ->{}", message);
    }
}

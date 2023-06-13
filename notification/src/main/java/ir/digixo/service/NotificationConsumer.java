package ir.digixo.service;

import ir.digixo.entity.NotificationEntity;
import ir.digixo.notification.NoticationRequest;
import ir.digixo.repository.NotificationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NotificationConsumer {
    private final NotificationRepository notificationRepository;

    public NotificationConsumer(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    //this for test for the config of rabbitMQ
//    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
//    public void consume(String message) {
//
//        log.info("Received message notification ->{}", message);
//    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(NoticationRequest message) throws InterruptedException {
        log.info("Received message notification");
        var entity = this.save(message);
        log.info("Received message notification ->{}", entity.toString());
    }
    public NotificationEntity save(NoticationRequest message) throws InterruptedException {
        Thread.sleep(5000);
        //make delay to clear block and nonBlock process for notification
        var model = new NotificationEntity().builder()
                .sender(message.getSender())
                .message(message.getMessage())
                .senderAt(message.getSenderAt()).build();
        return notificationRepository.save(model);
    }
}

package ir.digixo.controller;

import ir.digixo.entity.NotificationEntity;
import ir.digixo.notification.NoticationRequest;
import ir.digixo.repository.NotificationRepository;
import ir.digixo.service.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
public class NotificationController
{
    private final NotificationRepository repo;
    private final RabbitMQProducer producer;

    public NotificationController(NotificationRepository repo,
                                  RabbitMQProducer producer) {
        this.repo = repo;
        this.producer = producer;
    }
    @PostMapping("add")
    public String addNotification(@RequestBody NoticationRequest model){
        var entity = NotificationEntity
                .builder().
                message(model.getMessage()).
                sender(model.getSender()).
                senderAt(model.getSenderAt()).build();
        repo.save(entity);
        return "done";
    }
    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

}
